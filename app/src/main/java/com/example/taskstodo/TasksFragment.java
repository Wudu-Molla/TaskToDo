package com.example.taskstodo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.taskstodo.db.TaskDAO;
import com.example.taskstodo.db.Tasks;
import com.example.taskstodo.db.TasksDB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TasksFragment extends Fragment implements EndedTaskAdapter.OnItemClicked, View.OnClickListener {
    private View view;
    RecyclerView recyclerView;
    TaskDAO instance;
    Button delete, edit;
    FloatingActionButton floating_menu;
    LinearLayout menu_bar;
    private int id;
    private boolean menu_clicked = false;
    public TasksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tasks, container, false);
        edit = view.findViewById(R.id.edit);
        delete = view.findViewById(R.id.delete);
        floating_menu = view.findViewById(R.id.menu);
        menu_bar = view.findViewById(R.id.menu_bar);
        recyclerView = view.findViewById(R.id.ended_tasks_collection);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        instance = TasksDB.getDatabase(requireActivity()).taskDAO();
        recyclerView.setAdapter(new EndedTaskAdapter(requireActivity(), instance.getTasks(), this));
        edit.setOnClickListener(this);
        delete.setOnClickListener(this);
        floating_menu.setOnClickListener(this);
        return view;
    }

    @Override
    public void onItemClicked(Tasks task) {
        id = task.getUid();
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.edit){
            Toast.makeText(requireActivity(), "edit", Toast.LENGTH_SHORT).show();
        }if(view.getId() == R.id.delete){
            instance.deleteTask(id);
            recyclerView.setAdapter(new EndedTaskAdapter(requireActivity(), instance.getTasks(), this));
            Toast.makeText(requireActivity(), "deleted", Toast.LENGTH_SHORT).show();

        }if(view.getId() == R.id.menu){
            menu_clicked = !menu_clicked;
            if (menu_clicked) {
                floating_menu.setImageResource(R.drawable.close_icons);
                menu_bar.setVisibility(View.VISIBLE);
            }else{
                floating_menu.setImageResource(R.drawable.menu_icons);
                menu_bar.setVisibility(View.GONE);

            }
        }

    }
}