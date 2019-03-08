import android.support.v7.app.AppCompatActivity

abstract class ViewActivity<T : ControllerView> : AppCompatActivity() {
    lateinit var controllerView: T

    override fun onStart() {
        super.onStart()
        controllerView.onStart()
    }

    override fun onPause() {
        super.onPause()
        controllerView.onPause()
    }

    override fun onResume() {
        super.onResume()
        controllerView.onResume()
    }

    override fun onStop() {
        super.onStop()
        controllerView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        controllerView.onDestroy()
    }

    protected fun registerControllerViewForLifecycle(controllerView: T) {
        this.controllerView = controllerView
    }

    abstract fun setUpControllerView()

}