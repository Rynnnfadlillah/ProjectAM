package com.example.project_am

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project_am.R
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class UbahPass : AppCompatActivity() {

    private lateinit var oldPasswordEditText: EditText
    private lateinit var newPasswordEditText: EditText
    private lateinit var changePasswordButton: Button
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ubahpass)

        oldPasswordEditText = findViewById(R.id.edit_oldpass)
        newPasswordEditText = findViewById(R.id.edit_newpass)
        changePasswordButton = findViewById(R.id.changepass)
        firebaseAuth = FirebaseAuth.getInstance()

        changePasswordButton.setOnClickListener {
            changePassword()
        }
    }

    private fun changePassword() {
        val user: FirebaseUser? = firebaseAuth.currentUser
        val oldPassword = oldPasswordEditText.text.toString()
        val newPassword = newPasswordEditText.text.toString()

        // Validasi kata sandi lama dan baru
        if (oldPassword.isEmpty() || newPassword.isEmpty()) {
            Toast.makeText(this, "Harap masukkan kata sandi lama dan baru", Toast.LENGTH_SHORT).show()
            return
        }

        val credential = EmailAuthProvider.getCredential(user?.email!!, oldPassword)
        user.reauthenticate(credential)
            .addOnSuccessListener {
                user.updatePassword(newPassword)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Kata sandi berhasil diubah", Toast.LENGTH_SHORT).show()

                        oldPasswordEditText.text.clear()
                        newPasswordEditText.text.clear()
                    }
                    .addOnFailureListener { error ->
                        Toast.makeText(this, error.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
            }
            .addOnFailureListener { error ->
                Toast.makeText(this, error.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        val btn_kembaliubhpass = findViewById<ImageButton>(R.id.btn_kembaliubhpass)

        btn_kembaliubhpass.setOnClickListener{
            val intent = Intent (this, Profile::class.java)
            startActivity(intent)
        }
    }
}
