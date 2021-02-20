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

    private fun consecutive(num: Long): Int {
        val x = HashSet<Int>()

        fun solutions(a: Long, b: Long) {
            val delta = (2 * a + 1).toDouble().pow(2) -4 * (2*a - 2 * b)
            val sqrtDelta = sqrt(delta)
            val x1 = (-2 * a - 1 - sqrtDelta) / 2
            val x2 = (-2 * a - 1 + sqrtDelta) / 2
            println("wiktor x1 $x1")
            println("wiktor x2 $x2")
            val s1 = (2 + x1)/2*(x1 + 1)
            println("wiktor s1 $s1")
        }

        solutions(1, num)
        return 0
    }

    @ObsoleteCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        consecutive(10)
        consecutive(15)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
