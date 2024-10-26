package com.amerike.hemaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnDevice = findViewById<Button>(R.id.btnDevice)
        val btnEvents = findViewById<Button>(R.id.btnEvents)

        btnDevice.setOnClickListener { navigateToDevice() }
        btnEvents.setOnClickListener { navigateToEvents() }
    }


     private fun navigateToDevice() {
         val intent = Intent(this, DeviceActivity::class.java)
         startActivity(intent)
     }


    private fun navigateToEvents() {
        val intent = Intent(this, EventsActivity::class.java)
        startActivity(intent)
    }


    private fun navigateToProf() {
        val intent = Intent(this, ProfActivity::class.java)
        startActivity(intent)
    }
}