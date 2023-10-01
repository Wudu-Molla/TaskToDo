package com.example.taskstodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.taskstodo.db.DBManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Home extends AppCompatActivity implements View.OnClickListener {

    FragmentManager manager;
    AlertDialog alert;
    FloatingActionButton floating_add_button;
    LinearLayout notification, tasks, home;
    ImageView notificationIcon, homeIcon;
    TextView notificationText, homeText, tasksText;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        manager = getSupportFragmentManager();
        dbManager = new DBManager(this);
        home = findViewById(R.id.home);
        notification = findViewById(R.id.notification);
        tasks = findViewById(R.id.tasks);
        homeIcon = findViewById(R.id.homeIcon);
        notificationIcon = findViewById(R.id.notificationIcon);
        floating_add_button = findViewById(R.id.add);
        floating_add_button.setOnClickListener(this);
        tasksText = findViewById(R.id.tasksText);
        homeText = findViewById(R.id.homeText);
        notificationText = findViewById(R.id.notificationText);
        home.setOnClickListener(this);
        notification.setOnClickListener(this);
        tasks.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.add:
                LayoutInflater inflater =  LayoutInflater.from(this);
                View createView = inflater.inflate(R.layout.task_create_view, null);
                EditText task_content = createView.findViewById(R.id.task_content);
                DatePicker datePicker = createView.findViewById(R.id.date);
                Button task_create_cancel_btn = createView.findViewById(R.id.task_create_cancel_btn);
                Button task_create_btn = createView.findViewById(R.id.task_create_btn);
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Home.this);
                alertBuilder.setTitle("Create new task");
                alertBuilder.setView(createView);
                alert = alertBuilder.create();
                alert.show();
                task_create_btn.setOnClickListener(view1 -> {
                    String content = task_content.getText().toString();
                    if (!content.isEmpty()){
                        String dayOfMonth = String.valueOf(datePicker.getDayOfMonth());
                        String month = String.valueOf(datePicker.getMonth()+1);
                        String year = String.valueOf(datePicker.getYear());
                        String end_date_of_task = dayOfMonth +"/" + month + "/" + year;
                        dbManager.openDB();
                        dbManager.insert(content, end_date_of_task, "false");
                        dbManager.closeDB();
                        Toast.makeText(Home.this, "Task created successfully", Toast.LENGTH_SHORT).show();
                        alert.cancel();

                    }
                });
                task_create_cancel_btn.setOnClickListener(view1 -> {
                    alert.cancel();
                    Toast.makeText(Home.this, "Canceled", Toast.LENGTH_SHORT).show();
                });




            break;
            case R.id.tasks:
                manager.beginTransaction()
                        .replace(R.id.fragment_container, TasksFragment.class, null).commit();
                tasks.setBackground(getDrawable(R.drawable.rounded));
                tasksText.setVisibility(View.VISIBLE);

                home.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                notification.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                homeText.setVisibility(View.GONE);
                notificationText.setVisibility(View.GONE);

                homeIcon.setImageResource(R.drawable.home);
                notificationIcon.setImageResource(R.drawable.notification);

                break;
            case R.id.notification:
                tasks.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                tasksText.setVisibility(View.GONE);

                notification.setBackground(getDrawable(R.drawable.rounded));
                home.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                homeText.setVisibility(View.GONE);
                notificationText.setVisibility(View.VISIBLE);

                homeIcon.setImageResource(R.drawable.home);
                notificationIcon.setImageResource(R.drawable.notification_selected);
                manager.beginTransaction()
                        .replace(R.id.fragment_container, NotificationFragment.class, null).commit();
            break;
            default:
                manager.beginTransaction()
                        .add(R.id.fragment_container, HomeFragment.class, null).commit();
                tasks.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                tasksText.setVisibility(View.GONE);

                home.setBackground(getDrawable(R.drawable.rounded));
                notification.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                homeText.setVisibility(View.VISIBLE);
                notificationText.setVisibility(View.GONE);

                homeIcon.setImageResource(R.drawable.home_selected);
                notificationIcon.setImageResource(R.drawable.notification);
            break;
        }
    }
}