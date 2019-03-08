package atlassianmobilefinder.com.store

import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.ExecutorService



abstract class Subscriber<in T>(private val executeOnThisThread: ThreadExecutor? =null){

    fun onNext(data:T){
        executeOnThisThread?.execute { handle(data) }?:handle(data)
    }

    abstract fun handle(data:T)
}


abstract class SideEffect(executeOnThisThread: ThreadExecutor? = null):Subscriber<Action>(executeOnThisThread)

abstract class StateHandler(executeOnThisThread: ThreadExecutor? = null):Subscriber<State>(executeOnThisThread)


fun CopyOnWriteArrayList<SideEffect>.dispatch(action: Action) {
    forEach { it.onNext(action) }
}

fun CopyOnWriteArrayList<StateHandler>.dispatch(state: State) {
    forEach { it.onNext(state) }
}