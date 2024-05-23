package com.example.tta.utils.compositionLocals

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.tta.ui.theme.FinalOrangeApp

object DisabledRippleThemeColorAndAlpha : RippleTheme {

    @Composable
    override fun defaultColor(): Color = FinalOrangeApp

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha( 0.5f, 0.5f, 0.5f, 0.8f)
}
