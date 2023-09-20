package com.example.taskstodo;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskViewHolder extends RecyclerView.ViewHolder {


    CheckBox isDone;
    TextView task, end_date, remaining_time;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        isDone = itemView.findViewById(R.id.is_done);
        task = itemView.findViewById(R.id.task);
        end_date = itemView.findViewById(R.id.end_date);
        remaining_time = itemView.findViewById(R.id.remaining_time);
    }
}
