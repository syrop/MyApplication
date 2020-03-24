package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.fr_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.org.seva.myapplication.R

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

        val a = BroadcastChannel<Int>(Channel.CONFLATED)
    }
}
