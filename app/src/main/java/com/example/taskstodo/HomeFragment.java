package com.example.taskstodo;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskstodo.db.TaskDAO;
import com.example.taskstodo.db.Tasks;
import com.example.taskstodo.db.TasksDB;

import java.util.List;

public class HomeFragment extends Fragment{
    View view;
    RecyclerView recyclerView;
    TaskDAO instance;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.task_collection);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        instance = TasksDB.getDatabase(requireActivity()).taskDAO();
        List<Tasks> tasks = instance.getTasks();
        recyclerView.setAdapter(new TaskAdapter(requireActivity(), tasks));
        instance = null;
        return view;
    }



}