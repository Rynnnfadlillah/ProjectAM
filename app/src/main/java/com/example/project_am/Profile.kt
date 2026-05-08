package com.example.project_am


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class Profile : AppCompatActivity() {
    lateinit var textUser: TextView
    val firebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        val btn_ubahpass = findViewById<Button>(R.id.btn_ubahpass)
        val btn_keluar = findViewById<Button>(R.id.btn_keluar)
        val btnkembali = findViewById<ImageButton>(R.id.btn_kembali)

        textUser = findViewById(R.id.usernameProfil)



        val firebasedashboard = firebaseAuth.currentUser
        if(firebasedashboard!=null){
            textUser.text = firebasedashboard.email
        }else{
            startActivity(Intent(this, Login::class.java))
            finish()
        }


        btn_ubahpass.setOnClickListener{
            val intent = Intent (this, UbahPass::class.java)
            startActivity(intent)
        }


        btnkembali.setOnClickListener{
            val intent = Intent (this, Dashboard_SA::class.java)
            startActivity(intent)
        }


        btn_keluar.setOnClickListener{
            firebaseAuth.signOut()
            startActivity(Intent(this,Login::class.java))
            finish()
        }
    }
}