package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import pl.org.seva.myapplication.R

class MainFragment : Fragment(R.layout.fr_main) {

    private suspend fun a() = suspendCancellableCoroutine<Int> { continuation ->
        continuation.resumeWith(Result.success(1))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            println("wiktor ${a()}")
        }
    }

    class VM : ViewModel() {
        fun a() {
            viewModelScope.launch {

            }
        }
    }
}
