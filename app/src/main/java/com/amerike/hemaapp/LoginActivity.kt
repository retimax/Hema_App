package com.amerike.hemaapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username: EditText = findViewById(R.id.username)
        val password: EditText = findViewById(R.id.password)
        val signInButton: Button = findViewById(R.id.btn_sign_in)
        val signUpButton: Button = findViewById(R.id.btn_sign_up)

        signInButton.setOnClickListener {
            val userText = username.text.toString()
            val passText = password.text.toString()

            // Simulación
            if (userText == "user" && passText == "1234") {
                Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}