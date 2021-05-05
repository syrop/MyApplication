package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.databinding.FrMainBinding

class MainFragment : Fragment(R.layout.fr_main) {

    private lateinit var binding: FrMainBinding

    private var flow = MutableStateFlow<Int>(0)

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FrMainBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            flow.collect {
                println("wiktor it")
            }
        }
        flow.asLiveData()
        flow.tryEmit(1)
        println("wiktor")
    }
}
