import java.lang.ref.WeakReference
import android.content.Context
import atlassianmobilefinder.com.store.ThreadExecutor
import org.jetbrains.anko.runOnUiThread

class MainThread(val context: WeakReference<Context>) :ThreadExecutor{
    override fun execute(block: () -> Unit) {
        context.get()?.runOnUiThread { block() }
    }


}