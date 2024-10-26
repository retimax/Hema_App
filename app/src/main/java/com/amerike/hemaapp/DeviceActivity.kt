package com.amerike.hemaapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class DeviceActivity : AppCompatActivity() {

    private lateinit var tvTemperature: TextView
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var temperatureUpdater: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device)

        tvTemperature = findViewById(R.id.temperature_text)

        // Configura el Runnable para actualizar la temperatura cada segundo
        temperatureUpdater = object : Runnable {
            override fun run() {
                val randomTemperature = Random.nextDouble(35.00, 37.00)
                tvTemperature.text = "Temperature: %.2f °C".format(randomTemperature)

                // Programa la siguiente actualización en 1 segundo
                handler.postDelayed(this, 1000)
            }
        }

        // Inicia el proceso de actualización
        handler.post(temperatureUpdater)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Detén las actualizaciones cuando la actividad se destruya
        handler.removeCallbacks(temperatureUpdater)
    }
}
