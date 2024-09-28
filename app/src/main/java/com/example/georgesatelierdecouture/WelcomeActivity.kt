package com.example.georgesatelierdecouture

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val button = findViewById<Button>(R.id.button_continue)
        button.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }
    }
}
