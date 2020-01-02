package pl.org.seva.myapplication.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fr_main.*
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.invoke
import pl.org.seva.myapplication.main.extension.nav

class MainFragment : Fragment(R.layout.fr_main) {

    private var cachedView: View? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        println("wiktor on attach")
        println("wiktor $next")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (cachedView == null) {
            println("wiktor creating the view")
            cachedView = super.onCreateView(inflater, container, savedInstanceState)
        }
        return cachedView
    }

    override fun onStart() {
        super.onStart()
        println("wiktor on start")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        next {
            nav(R.id.action_mainFragment_to_secondFragment)
        }

    }
}
