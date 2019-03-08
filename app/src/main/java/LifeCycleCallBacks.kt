interface LifeCycleCallBacks {

    var isActivityRunning: Boolean

    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
}