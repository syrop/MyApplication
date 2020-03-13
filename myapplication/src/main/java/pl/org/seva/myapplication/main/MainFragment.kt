package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.test.espresso.idling.CountingIdlingResource
import io.reactivex.Single
import kotlinx.android.synthetic.main.fr_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.rx2.await
import kotlinx.coroutines.withContext
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.invoke
import pl.org.seva.myapplication.main.extension.nav
import pl.org.seva.myapplication.main.init.instance

class MainFragment : Fragment(R.layout.fr_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var i = 1L
        val time = System.currentTimeMillis()
        lifecycleScope.launch {
            while (true) {
                prompt.text = i.toString()
                withContext(Dispatchers.Default) {
                    i++
                }
            }
        }
        lifecycleScope.launch {
            while (true) {
                next.text = ((System.currentTimeMillis() - time) / 1000L).toString()
                delay(1000L)
            }
        }
    }
}
