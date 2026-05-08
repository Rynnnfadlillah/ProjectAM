package com.example.project_am


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Dashboard_A : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val emailTextView = findViewById<TextView>(R.id.username)


        val btn_profile = findViewById<ImageButton>(R.id.btn_profile)
        val btn_summary = findViewById<Button>(R.id.btn_summary)

        val btn_editp = findViewById<Button>(R.id.btn_editprdct)

        val btn_produk = findViewById<Button>(R.id.btn_riwayat)


        btn_profile.setOnClickListener {
            val intent = Intent(this, Profile_A::class.java)
            startActivity(intent)
        }

        btn_editp.setOnClickListener {
            val intent = Intent(this, Under_Development::class.java)
            startActivity(intent)
        }

            btn_produk.setOnClickListener {
                val intent = Intent(this, Tampil_Produk::class.java)

                startActivity(intent)
            }
            btn_summary.setOnClickListener {
                val intent = Intent(this, MenuCategory_Admin::class.java)
                startActivity(intent)
            }
        }
    }
