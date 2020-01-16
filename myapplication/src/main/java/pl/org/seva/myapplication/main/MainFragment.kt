package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fr_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.invoke
import pl.org.seva.myapplication.main.extension.nav

class MainFragment : Fragment(R.layout.fr_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        next {
            nav(R.id.action_mainFragment_to_secondFragment)
        }

        val scope = CoroutineScope(Job())

        scope.launch {
                null!!
        }

        scope.launch {
            delay(1000)
            println("wiktor I am doing something")
        }
        val a = flow { emit(2) }
    }
}
