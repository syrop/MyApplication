package pl.org.seva.myapplication.main

import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.rx2.asFlowable
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.databinding.FrMainBinding
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

class MainFragment : Fragment(R.layout.fr_main) {

    private var _binding: FrMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FrMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    data class A(val a: Int) {
        val b = Random.nextInt()
    }

    @ObsoleteCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val a = A(0)
        val b = A(0)
        println("wiktor equals: ${a == b}")
        println("wiktor a: ${a.b}")
        println("wiktor b: ${b.b}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
