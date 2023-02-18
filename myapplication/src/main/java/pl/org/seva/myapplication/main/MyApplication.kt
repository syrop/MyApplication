package pl.org.seva.myapplication.main

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import pl.org.seva.myapplication.main.init.Bootstrap
import kotlin.coroutines.EmptyCoroutineContext

@Suppress("unused")
class MyApplication : Application() {

    private val bootstrap by instance<Bootstrap>()

    override fun onCreate() {
        super.onCreate()
        bootstrap.context = this
        CoroutineScope(EmptyCoroutineContext).launch { bootstrap.boot(this@MyApplication) }
    }
}
