package com.example.project_am

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.cardview.widget.CardView

class MenuCategory_Admin : AppCompatActivity() {
    private lateinit var btnout: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_categori_ad)

        val item1CardView = findViewById<CardView>(R.id.item1CardView)
        item1CardView.setOnClickListener {
            val intent = Intent (this, Variant_Electronic::class.java)
            startActivity(intent)
        }
        val item2CardView = findViewById<CardView>(R.id.item2CardView)
        item2CardView.setOnClickListener {
            val intent = Intent (this, Variant_Office::class.java)
            startActivity(intent)
        }
        val item3CardView = findViewById<CardView>(R.id.item3CardView)
        item3CardView.setOnClickListener {
            val intent = Intent (this, Variant_Kitchen::class.java)
            startActivity(intent)
        }
        val item4CardView = findViewById<CardView>(R.id.item4CardView)
        item4CardView.setOnClickListener {
            val intent = Intent (this, Variant_Medical::class.java)
            startActivity(intent)
        }
        val item5CardView = findViewById<CardView>(R.id.item5CardView)
        item5CardView.setOnClickListener {
            val intent = Intent (this, Variant_Tools::class.java)
            startActivity(intent)
        }
        val item6CardView = findViewById<CardView>(R.id.item6CardView)
        item6CardView.setOnClickListener {
            val intent = Intent (this, Variant_Accessories::class.java)
            startActivity(intent)
        }
        val item7CardView = findViewById<CardView>(R.id.item7CardView)
        item7CardView.setOnClickListener {
            val intent = Intent (this, Variant_Sports::class.java)
            startActivity(intent)
        }

        btnout = findViewById(R.id.btn2)
        btnout.setOnClickListener {
            val intent = Intent (this,Dashboard_A::class.java)
            startActivity(intent)
        }
    }
}