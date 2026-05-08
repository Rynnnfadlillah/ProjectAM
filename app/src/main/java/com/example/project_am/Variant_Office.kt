package com.example.project_am

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Variant_Office : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_variant_office)

        val btnkeluar = findViewById<ImageButton>(R.id.btn1)
        btnkeluar.setOnClickListener {
            finish()
        }

    }
}