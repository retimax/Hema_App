package com.amerike.hemaapp

import android.content.Intent
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

        val signUpButton = findViewById<Button>(R.id.btn_sign_up)
        val signInButton = findViewById<Button>(R.id.btn_sign_in)

        signUpButton.setOnClickListener { navigateToRegister() }
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
    private fun navigateToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}