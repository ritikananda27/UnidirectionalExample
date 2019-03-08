import atlassianmobilefinder.com.store.*

abstract class ControllerView(val store: MainStore, mainThread: ThreadExecutor? = null) : LifeCycleCallBacks, StateHandler(mainThread) {

    override var isActivityRunning = false

    val state: State
        get() = store.state

    val currentItem: Item
        get() = state.editItemScreen.currentItem


    override fun onStart() {
        isActivityRunning = true
        store.stateHandlers.add(this)
        handleState(state)
    }

    override fun onResume() {

    }

    override fun onStop() {
        isActivityRunning = false
    }

    override fun onPause() {
    }

    override fun onDestroy() {
        store.stateHandlers.remove(this)
    }

    override fun handle(data: State) {
        if (isActivityRunning) handleState(state)
    }

    abstract fun handleState(state: State)
}