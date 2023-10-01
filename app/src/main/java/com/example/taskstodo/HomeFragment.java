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

public class HomeFragment extends Fragment{
    View view;
    RecyclerView recyclerView;
    Cursor cursor;
    TaskDAO dbManager;


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
//        dbManager = new TaskDAO(requireActivity());
//        dbManager.openDB();
//        cursor = dbManager.getData();
//        recyclerView.setAdapter(new TaskAdapter(requireActivity(), cursor));

        return view;
    }



}