package com.example.lessiontracker_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    List<Lesson> lessonsList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Button btn;
    EditText sabki,sabak,manzil;
    TextView date;
    Database db;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        id = Integer.parseInt(intent.getStringExtra("Id"));
        db = new Database(this);

        btn = findViewById(R.id.addLesson);
        date = findViewById(R.id.datee);
        sabak= findViewById(R.id.sabakk);
        sabki= findViewById(R.id.sabkii);
        manzil= findViewById(R.id.manzill);


        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        String ddate = df.format(new Date());
        date.setText(ddate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.valueOf(sabak.getText().toString())<=30 && Integer.valueOf(sabki.getText().toString())==Integer.valueOf(sabak.getText().toString())-1
                        && Integer.valueOf(manzil.getText().toString())<=Integer.valueOf(sabak.getText().toString()))
                {
                    db.insertLesson(new Lesson(ddate, Integer.valueOf(sabki.getText().toString()),
                            Integer.valueOf(sabak.getText().toString()),
                            Integer.valueOf(manzil.getText().toString()),
                            id));
                    refresh();
                }
                sabak.setText("");
                sabki.setText("");
                manzil.setText("");
            }
        });
        recyclerView = findViewById(R.id.recylerViewStudent);
        refresh();


//        adapter.notifyDataSetChanged();



    }
    public void refresh(){
        lessonsList = db.GetLessons(id);
        recyclerView.setHasFixedSize(true);
        //LinearLayoutManager GridLayoutManager
        layoutManager = new LinearLayoutManager(MainActivity.this);
//        layoutManager = new LinearLayoutManager(MainActivity.this,
//                LinearLayoutManager.HORIZONTAL,
//                true);
        adapter = new StudentRecyclerViewAdapter(lessonsList) ;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}