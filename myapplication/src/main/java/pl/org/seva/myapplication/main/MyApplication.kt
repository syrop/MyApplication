package pl.org.seva.myapplication.main

import android.app.Application
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import pl.org.seva.myapplication.main.init.Bootstrap

@Suppress("unused")
class MyApplication : Application() {

    private val bootstrap by instance<Bootstrap>()

    override fun onCreate() {
        super.onCreate()
        GlobalScope.launch { bootstrap.boot(this@MyApplication) }
    }
}
