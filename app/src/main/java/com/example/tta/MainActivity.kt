package com.example.tta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.tta.features.tta_test.TtaTestScreen
import com.example.tta.ui.theme.TTATheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TTATheme {
               // CompositionLocalProvider(LocalRippleTheme provides DisabledRippleThemeColorAndAlpha) {
                    TtaTestScreen()
//                }
            }
        }
    }
}





