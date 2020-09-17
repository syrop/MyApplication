package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fr_main.*
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.invoke
import kotlin.random.Random

class MainFragment : Fragment(R.layout.fr_main) {

    private val unsorted = arrayOfNulls<Int>(5)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        generate {
            repeat(SIZE) {
                unsorted[it] = Random.nextInt(RANGE)
            }
            unsorted_view.text = unsorted.contentToString()
        }
    }

    companion object {
        const val RANGE = 1024
        const val SIZE = 5
    }
}
