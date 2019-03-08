package atlassianmobilefinder.com.store

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

interface ThreadExecutor {
    fun execute(block: () -> Unit)
}


abstract class ThreadExecutorService(open val executorService: ExecutorService) : ThreadExecutor {
    override fun execute(block: () -> Unit) {
        executorService.execute(block)
    }

}

class StoreThreadService : ThreadExecutorService(ExecutorServices.store)

object ExecutorServices {

    private fun store(): ExecutorService = Executors.newSingleThreadExecutor()

    val store: ExecutorService by lazy {
        store()
    }

    val persistence: ExecutorService by lazy {
        persistence()
    }

    private fun persistence(): ExecutorService =
        Executors.newSingleThreadExecutor()

}

