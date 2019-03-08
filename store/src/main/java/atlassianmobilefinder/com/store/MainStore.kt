package atlassianmobilefinder.com.store

import atlassianmobilefinder.com.store.reducer.*
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.LinkedBlockingDeque


interface Subscribers {

    val sideEffects: CopyOnWriteArrayList<SideEffect>
    val stateHandlers: CopyOnWriteArrayList<StateHandler>

    fun dispatch(action: Action)
    fun dispatch(state: State)

}

abstract class MainStore(
        override val sideEffects: CopyOnWriteArrayList<SideEffect> = CopyOnWriteArrayList(),
        override val stateHandlers: CopyOnWriteArrayList<StateHandler> = CopyOnWriteArrayList(),
        private val storeThread: ThreadExecutor? = null,
        private val logger: (String, String) -> Unit = { _, _ -> Unit }
) : Subscribers {

    private var actions = LinkedBlockingDeque<Action>()

    var state = State()
        protected set


    @Synchronized
    override fun dispatch(action: Action) {
        actions.offer(action)
        when {
            storeThread != null -> storeThread.execute { handle(actions.poll()) }
            else -> handle(actions.poll())
        }
    }

    private fun handle(action: Action) {
        val newState = reduce(action, state)
        dispatch(newState)
        sideEffects.dispatch(action)

    }

    override fun dispatch(state: State) {
        this.state = state
        stateHandlers.dispatch(state)
    }


    private fun reduce(action: Action, currentState: State): State {
        logger("action", action.toString())
        val newState = when (action) {
            is CreationAction -> CreationReducer.reduce(action, currentState)
            is UpdateAction -> UpdateReducer.reduce(action, currentState)
            is ReadAction -> ReadReducer.reduce(action, currentState)
            is DeleteAction -> DeleteReducer.reduce(action, currentState)
            is NavigationAction -> NavigationReducer.reduce(action, currentState)
        }

        logger("new state", newState.toString())
        return newState
    }


}