package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.test.espresso.idling.CountingIdlingResource
import io.reactivex.Single
import kotlinx.android.synthetic.main.fr_main.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.rx2.await
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.invoke
import pl.org.seva.myapplication.main.extension.nav
import pl.org.seva.myapplication.main.init.instance

class MainFragment : Fragment(R.layout.fr_main) {

    private val idlingRes by instance<CountingIdlingResource>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        next {
            nav(R.id.action_mainFragment_to_secondFragment)
        }

        lifecycleScope.launch {
            idlingRes.increment()
            delay(SPLASH_DURATION)
            splash.visibility = View.GONE
            idlingRes.decrement()
        }
    }

    companion object {
        private const val SPLASH_DURATION = 3500L
    }
}
