package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import pl.org.seva.myapplication.R

@ExperimentalCoroutinesApi
class MainFragment : Fragment(R.layout.fr_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val job = lifecycleScope.launch {
            try {
                delay(5000)
            }
            finally {
                println("wiktor finally")
            }
        }
        job.cancel()
    }
}
