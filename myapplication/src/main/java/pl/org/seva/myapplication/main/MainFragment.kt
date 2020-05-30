package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import pl.org.seva.myapplication.R


class MainFragment : Fragment(R.layout.fr_main) {

    private var str: String? = "jadzia"

    private fun popStr() = str.also {
        str = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("wiktor pop ${popStr()}")
        println("wiktor str $str")
    }
}
