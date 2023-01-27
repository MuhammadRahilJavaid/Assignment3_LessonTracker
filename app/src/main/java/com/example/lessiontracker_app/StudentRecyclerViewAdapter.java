package com.example.lessiontracker_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentRecyclerViewAdapter extends RecyclerView.Adapter<StudentRecyclerViewAdapter.MyVH> {
    List<Student> studentsList;
    public StudentRecyclerViewAdapter(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    @NonNull
    @Override
    public StudentRecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentRecyclerViewAdapter.MyVH holder, int position) {
        holder.data = studentsList.get(position);
        holder.textViewStudent.setText(holder.data.getName());
        holder.textViewId.setText(holder.data.getId());
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView textViewStudent;
        TextView textViewId;
        Student data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            textViewStudent = itemView.findViewById(R.id.studentName);
            textViewId = itemView.findViewById(R.id.studentId);
        }
    }
}
