package pl.org.seva.myapplication.main

import android.os.Bundle
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fr_main.*
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.nav
import pl.org.seva.myapplication.main.extension.invoke

class SecondFragment : Fragment(R.layout.fr_main) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        next { nav(R.id.action_secondFragment_to_thirdFragment) }

        requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Handle the back button event
            println("wiktor second back")
        }
    }
}
