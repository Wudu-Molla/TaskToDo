package com.example.taskstodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskstodo.db.TaskDAO;
import com.example.taskstodo.db.Tasks;
import com.example.taskstodo.db.TasksDB;

import java.util.Calendar;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder>{

    private final Context context;
    List<Tasks> tasks;
    TaskViewHolder viewHolder;
    OnItemClicked onItemClicked;


    public TaskAdapter(Context context, List<Tasks> tasks, OnItemClicked onItemClicked) {
        this.context = context;
        this.tasks = tasks;
        this.onItemClicked = onItemClicked;


    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        viewHolder =  new TaskViewHolder(LayoutInflater.from(context).inflate( R.layout.task_view, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {

        holder.task.setText(tasks.get(position).getTask());
        holder.end_date.setText(tasks.get(position).getEndDate());
        holder.isDone.setChecked(tasks.get(position).isDone);
        if(tasks.get(position).isDone) {
            holder.remaining_time.setText(R.string.done);
        }else{
            Calendar cal = Calendar.getInstance();
            String now = String.valueOf(cal.getTime());
            holder.remaining_time.setText(now);
        }
        holder.task_view.setOnClickListener(view ->{
            onItemClicked.onItemClicked(tasks.get(position));
        });

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }


    public interface OnItemClicked{
        void onItemClicked(Tasks task);
    }


}
