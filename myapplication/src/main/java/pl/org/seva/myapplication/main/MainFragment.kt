package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import pl.org.seva.myapplication.R

class MainFragment : Fragment(R.layout.fr_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val product = BEGIN_WITH.toCharArray()
        for (i in BEGIN_WITH.indices step 2) {
            product[i] = product[i].toUpperCase()
        }
        println("wiktor ${String(product)}")
    }

    companion object {
        const val BEGIN_WITH = "cie gjal łang po"
    }
}
