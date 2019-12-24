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

        var url = "1234"
        val hash = url.lastIndexOf("#")
        url = url.substring(0, hash)
        println("wiktor url: $url")
    }
}
