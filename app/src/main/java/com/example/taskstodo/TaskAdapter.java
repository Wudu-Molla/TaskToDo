package com.example.taskstodo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskstodo.db.Tasks;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private Context context;
    List<Tasks> tasks;


    public TaskAdapter(Context context, List<Tasks> tasks) {
        this.context = context;
        this.tasks = tasks;


    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskViewHolder(LayoutInflater.from(context).inflate( R.layout.task_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {

        holder.task.setText(tasks.get(position).getTask());
        holder.end_date.setText(tasks.get(position).getEndDate());
        holder.isDone.setChecked(tasks.get(position).isDone);



    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
