package pl.org.seva.myapplication.main

import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.databinding.FrMainBinding
import pl.org.seva.myapplication.main.init.PriorityExecutor
import java.text.SimpleDateFormat
import java.util.concurrent.ThreadPoolExecutor

class MainFragment : Fragment(R.layout.fr_main) {

    private lateinit var binding: FrMainBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FrMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val flow0 = MutableStateFlow(0)
        val flow1 = MutableStateFlow(1)

        PriorityExecutor.submitAction(flow0) {
            a(0)
        }

        PriorityExecutor.submitAction(flow1) {
            a(1)
        }

        lifecycleScope.launch {
            while(true) {
                delay(SWITCH_DELAY)
                println("wiktor reversing")
                flow0.value = 1
                flow1.value = 0
                delay(SWITCH_DELAY)
                println("wiktor switching back")
                flow0.value = 0
                flow1.value = 1
            }
        }
    }

    private suspend fun a(id: Int) {
        while (true) {
            Thread.sleep(DELAY)
            yield()
            println("wiktor coroutine $id")
        }
    }

    companion object {
        const val DELAY = 1000L
        const val SWITCH_DELAY = 5000L
    }

}
