package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import pl.org.seva.myapplication.databinding.FrMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FrMainBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View {
        binding = FrMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.compose.setContent { 
            Text(
                text = "Beneficjantami programu będą kluby sportowe z całego kraju, które będą składały wnioski na przeprowadzenie rekrutacji, a później zajmą się samym szkoleniem. Przewidziano dwie odrębne ścieżki szkolenia. Do pierwszej będą należeli uczniowie i studenci w wieku 18-26 lat, a do drugiej osoby starsze.",
                style = TextStyle(
                    background = Color.LightGray,
                    lineHeight = 30.sp,
                    baselineShift = BaselineShift.Superscript,
                ),
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
            )
        }

    }

}
