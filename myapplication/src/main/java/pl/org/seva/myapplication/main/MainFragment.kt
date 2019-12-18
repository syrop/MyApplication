package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import pl.org.seva.myapplication.R
import androidx.lifecycle.lifecycleScope

@ExperimentalCoroutinesApi
class MainFragment : Fragment(R.layout.fr_main) {

    private val ch = BroadcastChannel<Boolean>(Channel.CONFLATED)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val a = lifecycleScope.async {
            cancel()
            2
        }
        GlobalScope.launch {
            println("wiktor ${a.await()}")
            println("wiktor ale fajnie")
        }
    }
}
