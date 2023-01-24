package com.example.lessiontracker_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final String DB_NAME = "LessonDB";
    private static final String TABLE_NAME = "Students";
    public Database (Context context){super(context,DB_NAME,null,1);}
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String create = "create table if not exists " + TABLE_NAME + "(id integer primary key autoincrement" +
            ", name text)";
    sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    String drop = "drop table if exists " + TABLE_NAME;
    sqLiteDatabase.execSQL(drop);
    onCreate(sqLiteDatabase);
    }
}
