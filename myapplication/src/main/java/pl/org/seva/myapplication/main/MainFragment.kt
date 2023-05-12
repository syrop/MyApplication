@file:OptIn(ExperimentalCoroutinesApi::class)

package pl.org.seva.myapplication.main

import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import pl.org.seva.myapplication.BuildConfig
import pl.org.seva.myapplication.databinding.FrMainBinding
import kotlin.coroutines.EmptyCoroutineContext

class MainFragment : Fragment() {

    private lateinit var binding: FrMainBinding


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View {
        binding = FrMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.prompt.text = BuildConfig.VERSION_NAME

        repeat(3) {
            sendOfflineObjectBadgingSync(it)
        }

    }

    private fun sendOfflineObjectBadgingSync(id: Int) {
        lifecycleScope.launch {
            suspendCancellableCoroutine { cont ->
                sendOfflineObjectBadgingAsync(id) {
                    println("wiktor end $id ${Thread.currentThread()}")
                    cont.resumeWith(Result.success(Unit))
                }
            }
        }
    }

    private fun sendOfflineObjectBadgingAsync(id: Int, onComplete: () -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            println("wiktor start $id")
            delay(1000)
            withContext(Dispatchers.Main.immediate) {
                onComplete()
            }
        }
    }

    companion object {
        val mutex = Mutex()
    }

}
