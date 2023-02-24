package com.gideondev.composeexperiment.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import com.gideondev.composeexperiment.MainActivity
import com.gideondev.composeexperiment.ui.component.background.ExpiBackground
import com.gideondev.composeexperiment.ui.component.theme.ExpiTheme
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ExpiTheme {
                ExpiBackground(color = MaterialTheme.colors.primary) {
                    SplashScreen{
                        openMainActivity()
                    }
                }
            }
        }
    }

    private fun openMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}