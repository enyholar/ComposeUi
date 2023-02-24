package com.gideondev.composeexperiment.ui.component.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.gideondev.composeexperiment.R
import com.gideondev.composeexperiment.ui.component.common.WindowSize

object ExpiFontFamily {
    val zagma = FontFamily(
        Font(R.font.test_display_sans_regular)
    )
}

//The following styles follow the figma design library - https://www.figma.com/file/colMQvIiUUf1r6s37o1rVF/%F0%9F%9B%A0-Android-Library?node-id=224%3A3461
object SmartPhoneTypography {
    val h1 = TextStyle(
        fontSize = 42.sp,
        lineHeight = 42.sp,
        letterSpacing = 0.01.em
    )
    val h2 = TextStyle(
        fontSize = 32.sp,
        lineHeight = 38.sp,
        letterSpacing = 0.01.em
    )
    val h3 = TextStyle(
        fontSize = 28.sp,
        lineHeight = 34.sp,
        letterSpacing = 0.01.em
    )

    val h4 = TextStyle(
        fontSize = 24.sp,
        lineHeight = 29.sp,
        letterSpacing = 0.01.em
    )

    val h5 = TextStyle(
        fontSize = 20.sp,
        lineHeight = 24.sp
    )

    val subtitle1 = TextStyle(
        fontSize = 18.sp,
        lineHeight = 23.sp,
    )

    val subtitle2 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 21.sp,
    )

    val body1 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 21.sp
    )

    val body2 = TextStyle(
        fontSize = 14.sp,
        lineHeight = 17.sp
    )

    val body3 = TextStyle(
        fontSize = 12.sp,
        lineHeight = 14.sp
    )

    val button = TextStyle(
        color = BackgroundPrimary,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.04.em
    )

    val overline = TextStyle(
        fontSize = 10.sp,
        lineHeight = 13.sp,
        letterSpacing = 0.04.em
    )

    val caption = TextStyle(
        fontSize = 10.sp,
        letterSpacing = 0.04.em
    )
}

object TabletTypography {
    val h1 = TextStyle(
        fontSize = 48.sp,
        lineHeight = 42.sp,
        letterSpacing = 0.0.em
    )
    val h2 = TextStyle(
        fontSize = 40.sp,
        lineHeight = 48.sp,
        letterSpacing = 0.01.em
    )
    val h3 = TextStyle(
        fontSize = 32.sp,
        lineHeight = 38.sp,
        letterSpacing = 0.01.em
    )
    val h4 = TextStyle(
        fontSize = 28.sp,
        lineHeight = 34.sp,
        letterSpacing = 0.01.em
    )

    val h5 = TextStyle(
        fontSize = 24.sp,
        lineHeight = 29.sp
    )

    val subtitle1 = TextStyle(
        fontSize = 20.sp,
        lineHeight = 26.sp,
    )

    val subtitle2 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 20.sp,
    )

    val body1 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 21.sp
    )

    val body2 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 21.sp
    )

    val body3 = TextStyle(
        fontSize = 12.sp,
        lineHeight = 14.sp
    )

    val button = TextStyle(
        color = BackgroundPrimary,
        fontSize = 18.sp,
        lineHeight = 23.sp,
        letterSpacing = 0.06.em
    )

    val overline = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.06.em
    )

    val caption = TextStyle(
        fontSize = 10.sp,
        letterSpacing = 0.04.em
    )

}

// Set of Material typography styles to start with
val smartPhoneTypography = Typography(
    defaultFontFamily = ExpiFontFamily.zagma,
    h1 = SmartPhoneTypography.h1,
    h2 = SmartPhoneTypography.h2,
    h3 = SmartPhoneTypography.h3,
    h4 = SmartPhoneTypography.h4,
    h5 = SmartPhoneTypography.h5,
    subtitle1 = SmartPhoneTypography.subtitle1,
    subtitle2 = SmartPhoneTypography.subtitle2,
    body1 = SmartPhoneTypography.body1,
    body2 = SmartPhoneTypography.body2,
    button = SmartPhoneTypography.button,
    caption = SmartPhoneTypography.caption,
    overline = SmartPhoneTypography.overline
)

val tabletTypography = Typography(
    defaultFontFamily = ExpiFontFamily.zagma,
    h1 = TabletTypography.h1,
    h2 = TabletTypography.h2,
    h3 = TabletTypography.h3,
    h4 = TabletTypography.h4,
    h5 = TabletTypography.h5,
    subtitle1 = TabletTypography.subtitle1,
    subtitle2 = TabletTypography.subtitle2,
    body1 = TabletTypography.body1,
    body2 = TabletTypography.body2,
    button = TabletTypography.button,
    caption = TabletTypography.caption,
    overline = TabletTypography.overline,
)

/**
 * Obtain windowSize via rememberWindowInfo()
 * Body3 or Body Small
 */
fun Typography.body3(windowSize: WindowSize): TextStyle {
    return when(windowSize){
        WindowSize.Compact -> SmartPhoneTypography.body3
        else -> TabletTypography.body3
    }
}

fun TextStyle.bold() = copy(fontWeight = FontWeight.Bold)
fun TextStyle.italic() = copy(fontStyle = FontStyle.Italic)
fun TextStyle.weight(fontWeight: FontWeight) = copy(fontWeight = fontWeight)



