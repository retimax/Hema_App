package com.amerike.hemaapp

import Task
import TaskAdapter
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class EventsActivity : AppCompatActivity() {

    private lateinit var tvDate: TextView
    private lateinit var recyclerViewTasks: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private val tasks = mutableListOf<Task>()
    private val calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        tvDate = findViewById(R.id.tv_date)
        recyclerViewTasks = findViewById(R.id.recycler_view_tasks)
        recyclerViewTasks.layoutManager = LinearLayoutManager(this)
        taskAdapter = TaskAdapter(tasks)
        recyclerViewTasks.adapter = taskAdapter

        updateDate()

        findViewById<Button>(R.id.btn_previous_day).setOnClickListener {
            calendar.add(Calendar.DAY_OF_YEAR, -1)
            updateDate()
        }

        findViewById<Button>(R.id.btn_next_day).setOnClickListener {
            calendar.add(Calendar.DAY_OF_YEAR, 1)
            updateDate()
        }

        findViewById<Button>(R.id.btn_add_task).setOnClickListener {
            addTask()
        }
    }

    private fun updateDate() {
        tvDate.text = dateFormat.format(calendar.time)
        // Aquí podrías cargar las tareas para el día seleccionado si las tuvieras guardadas
        tasks.clear() // Para este ejemplo, limpiamos la lista de tareas
        taskAdapter.notifyDataSetChanged()
    }

    private fun addTask() {
        // Aquí podrías abrir un diálogo para ingresar los detalles de la tarea
        val newTask = Task("Nueva Tarea", "Descripción de la tarea")
        tasks.add(newTask)
        taskAdapter.notifyItemInserted(tasks.size - 1)
    }
}
