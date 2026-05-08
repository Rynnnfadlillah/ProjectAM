package com.example.project_am

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Under_Development : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_under_development)


        val btn_back = findViewById<Button>(R.id.btn_back)
        btn_back.setOnClickListener {
        finish()
        }
    }
}