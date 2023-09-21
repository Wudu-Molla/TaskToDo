package com.example.taskstodo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskstodo.db.DBManager;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private Context context;
    Cursor cursor;


    public TaskAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;


    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskViewHolder(LayoutInflater.from(context).inflate( R.layout.task_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        cursor.moveToPosition(position);
        holder.task.setText(cursor.getString(1));
        holder.end_date.setText(cursor.getString(2));
        String is_done = cursor.getString(3);
        holder.remaining_time.setText(is_done);
        if(is_done == "true"){
            holder.isDone.setChecked(true);
        } else{
            holder.isDone.setChecked(false);
        }


    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }
}
