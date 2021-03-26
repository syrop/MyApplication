package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import pl.org.seva.myapplication.R
import kotlin.math.log
import kotlin.math.pow
import kotlin.math.roundToInt

class MainFragment : Fragment(R.layout.fr_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val oneIn = 1.0 / (PER_CENT / 100.0)
        println("wiktor LINEAR")
        val casesInPerCent = CASES_TOTAL / PER_CENT
        val all = (casesInPerCent * 100.0).roundToInt()
        val movingAverage = CASES.take(DAYS_EXPONENTIAL).sum() / DAYS_EXPONENTIAL.toDouble()
        println("wiktor moving average: %.0f".format(movingAverage))
        println("wiktor 1 in %.2f".format(oneIn))
        println("wiktor %% per day: %.4f".format(CASES.first() / casesInPerCent))
        val inXDays = CASES_TOTAL + DAYS_LINEAR * CASES.first()
        val perCentInXDays = inXDays / casesInPerCent
        val inXDaysOneIn = 1 / (perCentInXDays / 100.0)
        println("wiktor in $DAYS_LINEAR days 1 in %.2f".format(inXDaysOneIn))
        val daysUntilAll = (casesInPerCent * (100.0 - PER_CENT) / CASES.first()).toInt()
        println("wiktor ${daysUntilAll.toYears()} days until all")
        println("wiktor EXPONENTIAL")
        println("wiktor %% per day: %.3f".format(perCentDaily()))
        println("wiktor %% per $DAYS_EXPONENTIAL days: %.1f".format(perCentInDays(DAYS_EXPONENTIAL)))
        println("wiktor doubling every %.3f days".format(doubling()))
        if (doubling() > 0.0) {
            var cases = CASES_TOTAL

            var day = 0
            while (cases < all) {
                day++
                val perDay = perDay(day)
                cases += perDay
                val perCent = cases.toDouble() / all.toDouble() * 100.0
                println("wiktor day $day daily: $perDay total: %.2f%%".format(perCent))
            }
            println("wiktor ${day.toYears()}: $cases")
        }
    }

    private fun perDay(day: Int): Int {
        val root = 2.0.pow(1.0 / doubling())
        return (CASES.first() * root.pow(day.toDouble())).roundToInt()
    }

    private fun doubling(): Double {
        val perCent = perCentInDays(DAYS_EXPONENTIAL)
        val daily = (perCent / 100.0 + 1.0).pow(1.0 / DAYS_EXPONENTIAL)
        return log(2.0, daily)
    }

    private fun perCentDaily() = perCentInDays(1)

    private fun perCentInDays(days: Int) =
            (CASES[0].toDouble() / CASES[days].toDouble() - 1.0) * 100.0

    private fun Int.toYears() =
            "${(this / DAYS_IN_YEAR).toInt()} years ${(this % DAYS_IN_YEAR).roundToInt()} days"

    @Suppress("SpellCheckingInspection")
    companion object {
        const val CASES_TOTAL = 2_198_966
        const val PER_CENT = 5.81
        const val DAYS_EXPONENTIAL = 7
        // 26_600-28_500: przy takiej średniej z 7 dni będzie narodowa kwarantanna
        val CASES = arrayOf(
            35_143,
            34_151,
            29_978,
            16_741,
            14_578,
            21_849,
            26_405,
            25_998,
            27_278,
            25_052,
            14_396,
            10_896,
            17_259,
            21_049,
            17_260,
            9_954,
            6_170,
            13_574,
            14_857,
            15_829,
            15_250,
            15_698,
            7_937,
            4_786,
            10_099,
            12_100,
            11_539,
            12_142,
            12_146,
            6_310,
            )
        const val POPULATION = 38_300_357 // 38_300_339, 38_305_109
        const val DAYS_LINEAR = 100
        const val DAYS_IN_YEAR = 365.25
    }
}
