package com.example.project_am

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Profile_A : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_a)


        val btn_keluar = findViewById<Button>(R.id.btn_keluar)
        val btnkembali = findViewById<ImageButton>(R.id.btn_kembali)
        btnkembali.setOnClickListener{
            finish()
        }


        btn_keluar.setOnClickListener{
            val intent = Intent (this, Login_Admin::class.java)
            startActivity(intent)
        }
    }
}