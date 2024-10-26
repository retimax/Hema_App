import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amerike.hemaapp.R

data class Task(val name: String, val description: String)

class TaskAdapter(private val tasks: List<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTaskName: TextView = itemView.findViewById(R.id.tv_task_name)
        val tvTaskDescription: TextView = itemView.findViewById(R.id.tv_task_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.tvTaskName.text = task.name
        holder.tvTaskDescription.text = task.description
    }

    override fun getItemCount() = tasks.size
}
