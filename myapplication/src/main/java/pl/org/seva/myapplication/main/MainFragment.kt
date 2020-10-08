package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import pl.org.seva.myapplication.R

class MainFragment : Fragment(R.layout.fr_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val oneIn = 1.0 / (PER_CENT / 100.0)
        println("wiktor one in $oneIn")
        val perCent = CASES_TOTAL / PER_CENT
        println("wiktor one percent: $perCent")
        val inHundredDays = CASES_TOTAL + 100 * CASES_PER_DAY
        val perCentInHundredDays = inHundredDays / perCent
        println("wiktor % in 100 days: $perCentInHundredDays")
        val inHundredDaysOneIn = 1 / (perCentInHundredDays / 100.0)
        println("wiktor in 100 days 1 in $inHundredDaysOneIn")
    }

    companion object {
        const val CASES_PER_DAY = 4280
        const val CASES_TOTAL = 111_599
        const val PER_CENT = 0.3
    }
}
