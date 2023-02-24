package com.gideondev.composeexperiment.ui.splash

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gideondev.composeexperiment.R
import com.gideondev.composeexperiment.ui.component.preview.FOLDABLE_SPEC
import com.gideondev.composeexperiment.ui.component.preview.LANDSCAPE_SPEC
import com.gideondev.composeexperiment.ui.component.preview.PHONE_SPEC
import com.gideondev.composeexperiment.ui.component.preview.PORTRAIT_SPEC
import com.gideondev.composeexperiment.ui.component.theme.ExpiTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun SplashScreen(navigateToMain: () -> Unit) {
//    FlipAnimation()
    SplashContent(navigateToMain = navigateToMain)
}

@Composable
private fun SplashContent(navigateToMain: () -> Unit) {
    //  AnimatedImage()
    val rotateDegrees = remember {
        Animatable(0f)
    }

    val zoomIn = remember {
        Animatable(1f)
    }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            rotateDegrees.animateTo(
                targetValue = 360F,
                // tween Animation
                animationSpec = tween(
                    durationMillis = 500,
                    easing = LinearEasing
                )
            )

            zoomIn.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 1000)
            )
            // Customize the delay time

            navigateToMain()
        }

    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        // Change the logo
        Image(painter = painterResource(id = R.drawable.totalav),
            contentDescription = "Logo",
            modifier = Modifier
                .graphicsLayer {
                    rotationY = rotateDegrees.value
                }
                .width(150.dp)
                .height(150.dp)
                .scale(scale = zoomIn.value))
    }

    DisposableEffect(rotateDegrees) {
        Log.d("RotatingImage", "Current rotation degrees: $rotateDegrees")
        onDispose { }
    }

    DisposableEffect(zoomIn) {
        Log.d("ZoomImage", "Current rotation degrees: $zoomIn")
        onDispose { }
    }

}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = null,
        modifier = Modifier
            .size(200.dp)
    )
}

@Preview(name = "phone", device = PHONE_SPEC)
@Preview(name = "foldable", device = FOLDABLE_SPEC)
@Preview(name = "landscape", device = LANDSCAPE_SPEC)
@Preview(name = "tablet", device = PORTRAIT_SPEC)
@Composable
private fun PreviewSignInScreen() {
    ExpiTheme {
        SplashContent {

        }
    }
}

