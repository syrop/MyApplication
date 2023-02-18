package pl.org.seva.myapplication.main

import androidx.test.espresso.idling.CountingIdlingResource
import org.kodein.di.*
import pl.org.seva.myapplication.main.init.Bootstrap

inline fun <reified T : Any> instance(tag: Any? = null) = kodein.instance<T>(tag)

val kodein = DI {
    bind<Bootstrap>() with singleton { Bootstrap() }
    bind<CountingIdlingResource>() with singleton { CountingIdlingResource("espresso") }
}
