package com.example.taskstodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.taskstodo.db.Tasks;


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
            holder.remaining_time.setTextColor(context.getColor(R.color.green));
        }else{
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month =cal.get(Calendar.MONTH)+1;
            int day = cal.get(Calendar.DAY_OF_MONTH);

            String [] s = tasks.get(position).getEndDate().split("/");

            int remaining_day = Integer.valueOf(s[0]) - day;
            int remaining_month = Integer.valueOf(s[1]) - month;
            int remaining_year = Integer.valueOf(s[2]) - year;

            if(remaining_month < 1 && remaining_year < 1){
                holder.remaining_time.setText("Remaining time: " + remaining_day +" days" );
                holder.remaining_time.setTextColor(context.getColor(R.color.green));
            }
            if(remaining_day==0) {
                holder.remaining_time.setText("Remaining time: Ends today");
                holder.remaining_time.setTextColor(context.getColor(R.color.yellow));
            }
            if(remaining_day<0) {
                holder.remaining_time.setText("Remaining time: Ended");
                holder.remaining_time.setTextColor(context.getColor(R.color.red));

            }

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
