package com.example.lessiontracker_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final String DB_NAME = "LessonDB";
    private static final String TABLE_NAME = "Students";
    private static final String TABLE_NAME2 = "Lessons";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String SABKI = "sabki";
    private static final String SABAK = "sabak";
    private static final String MANZIL = "manzil";
    private static final String S_ID = "s_id";

    public Database (Context context){super(context,DB_NAME,null,1);}
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String create = "create table if not exists " + TABLE_NAME + "(id integer primary key autoincrement," +
            " name text)";
    String createLesson = "create table if not exists " + TABLE_NAME2 + "(id integer primary key autoincrement," +
            "date text,sabki integer, sabak integer, manzil integer,s_id integer," +
            "FOREIGN KEY (s_id) REFERENCES "+TABLE_NAME+ "(id));";
    sqLiteDatabase.execSQL(create);
    sqLiteDatabase.execSQL(createLesson);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    String drop = "drop table if exists " + TABLE_NAME;
    sqLiteDatabase.execSQL(drop);
    onCreate(sqLiteDatabase);
    }

    public List<Student> GetStudents(){

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);


        if (cursor.moveToFirst()) {
            do {
                students.add(new Student(cursor.getInt(0),cursor.getString(1)));
            } while (cursor.moveToNext());
        }

//        if (cursor.moveToFirst()) {
//            do {
//                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
//                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
//                students.add(new Student(id,name));
//            } while (cursor.moveToNext());
//        }

        cursor.close();
        db.close();

        return students;
    }




    public List<Lesson> GetLessons(int i){

        List<Lesson> lessons = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME2 +" where id = "+i+";";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);


        if (cursor.moveToFirst()) {
            do {
                lessons.add(new Lesson(cursor.getString(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4),cursor.getInt(5)));
            } while (cursor.moveToNext());
        }

//        if (cursor.moveToFirst()) {
//            do {
//                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
//                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
//                students.add(new Student(id,name));
//            } while (cursor.moveToNext());
//        }

        cursor.close();
        db.close();

        return lessons;
    }

    public void insertLesson(Lesson lesson) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SABAK, lesson.getSabak());
        values.put(SABKI, lesson.getSabki());
        values.put(MANZIL, lesson.getManzil());
        values.put(S_ID, lesson.getSid());
        values.put("date", lesson.getDate());


        db.insert(TABLE_NAME2, null, values);
        db.close();
    }





    public void insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());


        db.insert(TABLE_NAME, null, values);
        db.close();
    }




}

