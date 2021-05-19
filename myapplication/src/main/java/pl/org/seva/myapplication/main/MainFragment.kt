package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.databinding.FrMainBinding

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

        fun Basia.czeslaw() {
            b = object : Ala() {
            }
        }

        val a = Basia()
        val b = Basia()
        a.czeslaw()
        b.czeslaw()
        a.b.a++
        println("wiktor a: ${a.b.a}")
        println("wiktor b: ${b.b.a}")
    }
}

class Basia {
    lateinit var b: Ala
}

open class Ala {
    var a = 0
}