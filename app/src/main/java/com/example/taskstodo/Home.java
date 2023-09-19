package com.example.taskstodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Home extends AppCompatActivity implements View.OnClickListener {

    FragmentManager manager;
    LinearLayout notification, tasks, home;
    ImageView notificationIcon, homeIcon;
    TextView notificationText, homeText, tasksText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        manager = getSupportFragmentManager();
        home = findViewById(R.id.home);
        notification = findViewById(R.id.notification);
        tasks = findViewById(R.id.tasks);
        homeIcon = findViewById(R.id.homeIcon);
        notificationIcon = findViewById(R.id.notificationIcon);
        tasksText = findViewById(R.id.tasksText);
        homeText = findViewById(R.id.homeText);
        notificationText = findViewById(R.id.notificationText);

    }

    @Override
    public void onClick(View view) {

    }
}