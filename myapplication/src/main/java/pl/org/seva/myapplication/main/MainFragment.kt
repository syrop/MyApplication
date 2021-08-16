package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.databinding.FrMainBinding
import io.reactivex.Completable

class MainFragment : Fragment(R.layout.fr_main) {

    private lateinit var binding: FrMainBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        println("wiktor on create view")
        binding = FrMainBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val stateFlow = MutableStateFlow(0)
        GlobalScope.launch {
            stateFlow.value++
            delay(1000)
        }

    }
}
