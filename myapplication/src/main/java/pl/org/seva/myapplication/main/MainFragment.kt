package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.init.onEach

class MainFragment : Fragment(R.layout.fr_main) {
    private val ch = Channel<Int>(Channel.CONFLATED)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        lifecycleScope.launch {
            for (counter in 1..1_000_1000) {
                delay(1000L)
                ch.offer(counter)
            }
        }
        val job = lifecycleScope.launch {
            ch.onEach {
                println("wiktor $it")
            }
        }
        lifecycleScope.launch {
            delay(5000L)
            job.cancel()
            ch.onEach {
                println("wiktor fun $it")
            }
        }
    }
}
