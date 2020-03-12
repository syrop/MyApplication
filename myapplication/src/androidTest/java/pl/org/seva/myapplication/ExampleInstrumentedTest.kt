package pl.org.seva.myapplication


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.idling.CountingIdlingResource
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import pl.org.seva.myapplication.main.MainActivity
import kotlin.coroutines.resume

import pl.org.seva.myapplication.main.init.instance

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private val idlingRes by instance<CountingIdlingResource>()

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, true, true)

    private suspend fun CountingIdlingResource.await() = suspendCancellableCoroutine<Unit> { cont ->
        registerIdleTransitionCallback {
            cont.resume(Unit)
        }
    }

    @Test
    fun useAppContext() {
        runBlocking {
            onView(withId(R.id.splash)).check(matches(isDisplayed()))
            idlingRes.await()
            onView(withId(R.id.splash)).check(matches(not(isDisplayed())))
        }
    }
}
