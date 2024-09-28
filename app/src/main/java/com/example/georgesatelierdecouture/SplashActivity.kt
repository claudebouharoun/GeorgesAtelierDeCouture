package com.example.georgesatelierdecouture

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Navigate to WelcomeActivity after 2 seconds
        android.os.Handler().postDelayed({
            startActivity(Intent(this, splashScreen::class.java))
            finish()
        }, 2000)
    }
}
