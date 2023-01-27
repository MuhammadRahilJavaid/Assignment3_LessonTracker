package com.example.lessiontracker_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class Student_Insert extends AppCompatActivity {
    private ListView lst;
    private EditText name;
    private Button btn;
    private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_insert);
        btn = findViewById(R.id.button);
        name = findViewById(R.id.StudentName);
        lst = findViewById(R.id.studentList);
        db = new Database(this);
        RefreshGrid();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().length()>0){
                    db.insertStudent(new Student(name.getText().toString()));
                    name.setText("");
                    RefreshGrid();
                }
            }
        });
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Student_Insert.this, MainActivity.class);
                Student message = (Student) adapterView.getItemAtPosition(i);
                intent.putExtra("Name", message.getName());
                intent.putExtra("Id", Integer.toString(message.getId()));
                startActivity(intent);
            }
        });
    }

    public void RefreshGrid(){
        List<Student> students = db.GetStudents();

        ArrayAdapter arrayAdapter = new ArrayAdapter<Student>(Student_Insert.this, android.R.layout.simple_list_item_1,students);
        lst.setAdapter(arrayAdapter);



//        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, students){
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                View view = super.getView(position, convertView, parent);
//                TextView text = (TextView) view.findViewById(android.R.id.text1);
//                text.setText(students.get(position).toString());
//                return view;
//            }
//        };
//        listView.setAdapter(adapter);
    }
}