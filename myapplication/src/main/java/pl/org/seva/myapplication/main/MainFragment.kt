package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.channels.Channel
import pl.org.seva.myapplication.R

class MainFragment : Fragment(R.layout.fr_main) {
    private val ch = Channel<Int>(Channel.CONFLATED)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Single.just {
            Thread.sleep(1000L)
            println("wiktor thread ${Thread.currentThread()}")
                2
        }.observeOn(Schedulers.computation())
            .subscribeOn(Schedulers.io())
            .subscribe {}

    }
}
