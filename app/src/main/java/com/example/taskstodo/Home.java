package com.example.taskstodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        HomeFragment fragment = new HomeFragment();
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