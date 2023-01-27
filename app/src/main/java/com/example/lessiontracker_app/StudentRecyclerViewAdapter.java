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
    List<Lesson> lessonsList;
    public StudentRecyclerViewAdapter(List<Lesson> lessonsList) {
        this.lessonsList = lessonsList;
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
        holder.data = lessonsList.get(position);
        holder.manzil.setText(String.valueOf(holder.data.getManzil()));
        holder.sabak.setText(String.valueOf(holder.data.getSabak()));
        holder.sabki.setText(String.valueOf(holder.data.getSabki()));
        holder.date.setText(holder.data.getDate());
    }

    @Override
    public int getItemCount() {
        return lessonsList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView manzil,sabki,sabak,date;
        Lesson data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            sabki = itemView.findViewById(R.id.sabki);
            sabak = itemView.findViewById(R.id.sabak);
            manzil = itemView.findViewById(R.id.manzil);
            date = itemView.findViewById(R.id.date);

        }
    }
}
