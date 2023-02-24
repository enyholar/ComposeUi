package com.gideondev.composeexperiment.ui.component.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import com.gideondev.composeexperiment.ui.component.common.WindowSize
import com.gideondev.composeexperiment.ui.component.common.rememberWindowInfo

internal val DarkColorPalette = darkColors(
    primary = BackgroundPrimary,
    primaryVariant = BackgroundSecondary,
    secondary = BackgroundSecondary,
    background = BackgroundSecondary,
    surface = BackgroundPrimary,
    onPrimary = TextPrimary,
    onSecondary = TextPrimary,
    onBackground = TextPrimary,
    onSurface = TextPrimary
)

@Composable
fun ExpiTheme(
    content: @Composable () -> Unit
){
    val windowSize = rememberWindowInfo()
    val typography = when (windowSize.screenWidthInfo) {
        is WindowSize.Compact -> smartPhoneTypography
        else -> tabletTypography
    }

    MaterialTheme(
        colors = DarkColorPalette,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}