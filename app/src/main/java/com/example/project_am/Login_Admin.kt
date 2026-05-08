package com.example.project_am

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login_Admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_admin)

        val btnback = findViewById<Button>(R.id.btn_back)
        btnback.setOnClickListener {
            val intent = Intent(this, Start_Login::class.java)
            startActivity(intent)
        }

        val showPasswordCheckBox = findViewById<CheckBox>(R.id.showpass)
        val passwordEditText = findViewById<EditText>(R.id.edit_password)

        // Set kotak centang tercentang secara default
        showPasswordCheckBox.isChecked = true

        // Tampilkan password secara default
        passwordEditText.transformationMethod = null

        showPasswordCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Menampilkan password
                passwordEditText.transformationMethod = null
            } else {
                // Menyembunyikan password
                passwordEditText.transformationMethod = android.text.method.PasswordTransformationMethod.getInstance()
            }
        }

        val btnLogin = findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener {
            val emailInput = findViewById<EditText>(R.id.edit_email).text.toString()
            val passwordInput = findViewById<EditText>(R.id.edit_password).text.toString()

            Login(emailInput, passwordInput)
        }
    }

    private fun Login(emailInput: String, passwordInput: String) {
        val validEmail = "tim2@gmail.com"
        val validPassword = "gasgasgas"

        if (emailInput == validEmail && passwordInput == validPassword) {
            val intent = Intent(this, Dashboard_A::class.java)
            intent.putExtra("EMAIL", emailInput) // Mengirim email ke Dashboard_A
            startActivity(intent)
        } else {
            // Jika input tidak cocok, tampilkan pesan kesalahan
            Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
        }
    }
}
