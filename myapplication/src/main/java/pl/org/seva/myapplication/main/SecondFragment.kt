package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fr_main.*
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.back
import pl.org.seva.myapplication.main.extension.nav
import pl.org.seva.myapplication.main.extension.invoke
import pl.org.seva.myapplication.main.extension.onBack

class SecondFragment : Fragment(R.layout.fr_main) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        next { nav(R.id.action_secondFragment_to_thirdFragment) }
        setHasOptionsMenu(true)

        onBack {
            // Handle the back button event
            println("wiktor second back")
            back()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            println("wiktor second home")
        }
        return super.onOptionsItemSelected(item)
    }
}
