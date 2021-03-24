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
        println("wiktor factor: %.2f".format(PER_DAY * 100_000.0 / all))
        println("wiktor 1 in %.2f".format(oneIn))
        println("wiktor %% per day: %.4f".format(PER_DAY / casesInPerCent))
        val inXDays = CASES_TOTAL + DAYS_LINEAR * PER_DAY
        val perCentInXDays = inXDays / casesInPerCent
        val inXDaysOneIn = 1 / (perCentInXDays / 100.0)
        println("wiktor in $DAYS_LINEAR days 1 in %.2f".format(inXDaysOneIn))
        val daysUntilAll = (casesInPerCent * (100.0 - PER_CENT) / PER_DAY).toInt()
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
        return (PER_DAY * root.pow(day.toDouble())).roundToInt()
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
        const val PER_DAY = 29_978
        const val CASES_TOTAL = 2_120_671
        const val PER_CENT = 5.62
        const val DAYS_EXPONENTIAL = 7
        // 26_600-28_500: przy takiej średniej z 7 dni będzie narodowa kwarantanna
        val CASES = arrayOf(
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
            3_890,
            7_038,
            8_510,
            8_777,
            9_073,
            8_694,
            5_178,
            2_543,
            5_334,
            6_586,
            6_379,
            7_008,
            6_930,
            4_029,
            2_431,
            4_728,
            6_026,
            6_053,
            6_496,
            6_802,
            4_326,
            2_503,
            4_706,
            5_864,
            6_144,
            7_156,
            6_789,
            4_604,
            2_419,
            4_683,
            6_322,
            6_640,
            7_152,
            6_919,
            4_835,
            3_271,
            6_055,
            7_412,
            7_795,
            9_436,
            9_053,
            5_569,
            4_662,
            9_410,
            8_790,
            12_054,
            14_151,
            7_624,
            4_432,
            5_739,
            6_945,
            11_088,
            13_397,
            12_955,
            7_914,
            3_211,
            3_678,
            5_048,
            9_077,
            13_115,
            12_361,
            7_192,
            4_633,
            8_594,
            11_267,
            11_013,
            11_953,
            12_454,
            6_907,
            4_896,
            8_977,
            11_497,
            13_110,
            13_749,
            12_168,
            8_312,
            4_423,
            9_176,
            12_430,
            13_239,
            14_838,
            13_855,
            9_105,
            5_733,
            11_483,
            15_178,
            17_060,
            16_687,
            15_362,
            10_139,
            15_002,
            17_856,
            24_213,
            22_464,
            23_975,
            19_883,
            19_152,
            20_816,
            21_854,
            25_571,
            24_051,
            22_683,
            25_221,
            25_454,
            21_713,
            24_785,
            27_086,
            27_143,
            24_692,
            19_364,
            15_578,
            17_171,
            21_897,
            21_628,
            20_156,
            18_820,
            16_300,
            10_241,
            11_742,
            13_628,
            13_632,
            12_107,
            10_040,
            9_291,
            7_482,
            8_536,
            9_622,
            7_705,
            8_099,
            6_526,
            5_068,
            4_394,
            4_178,
            5_300,
            4_739,
            4_280,
            3_003,
            2_236,
            2_006,
            1_934,
            2_367,
            2_292,
            1_967,
            1_552,
            1_326,
            1_306,
            1_350,
            1_584,
            1_587,
            1_136,
            974,
            711,
            748,
            910,
            1_002,
            757,
            837,
            600,
            605,
            377,
            502,
            603,
            594,
            506,
            421,
            400,
            302,
            437,
            567,
            691,
            612,
            595,
            550,
            502,
            631,
            759,
            791,
            887,
            729,
            763,
            548,
            581,
            900,
            903,
            767,
            735,
            597,
            595,
            594,
            771,
            832,
            811,
            715,
            551,
            619,
            624,
            843,
            809,
            726,
            640,
            680,
            575,
            548,
            658,
            657,
            615,
            512,
            502,
            )
        const val POPULATION = 38_300_357 // 38_300_339, 38_305_109
        const val DAYS_LINEAR = 100
        const val DAYS_IN_YEAR = 365.25
    }
}
