package com.example.project_am

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class Start_Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_login)

        val btnsuperadmin = findViewById<LinearLayout>(R.id.card1)
        val btnadmin = findViewById<LinearLayout>(R.id.card2)
        btnsuperadmin.setOnClickListener {
            val intent = Intent (this, Login::class.java)
            startActivity(intent)
        }
        btnadmin.setOnClickListener {
            val intent = Intent (this, Login_Admin::class.java)
            startActivity(intent)
        }
    }
}