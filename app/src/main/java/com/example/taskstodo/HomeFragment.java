package com.example.taskstodo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.taskstodo.db.TaskDAO;
import com.example.taskstodo.db.Tasks;
import com.example.taskstodo.db.TasksDB;

public class HomeFragment extends Fragment implements TaskAdapter.OnItemClicked {
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
        recyclerView.setAdapter(new TaskAdapter(requireActivity(), instance.getTasks(), this));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {

                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                        int position = viewHolder.getAdapterPosition();
                        int id = instance.getTasks().get(position).getUid();
                        instance.deleteTask(id);

                    }
                }
        );
        itemTouchHelper.attachToRecyclerView(recyclerView);
        return view;
    }


    @Override
    public void onItemClicked(Tasks task) {
        instance.update(task.getUid(), !task.isDone());
        recyclerView.setAdapter(new TaskAdapter(requireActivity(), instance.getTasks(), this));
    }

}