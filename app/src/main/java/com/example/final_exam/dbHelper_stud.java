package com.example.final_exam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper_stud extends SQLiteOpenHelper {
    public dbHelper_stud(Context ctx){
        super(ctx, "DB", null , 1);
    }

    public void  onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists student");
        onCreate(db);
    }

    public void  onCreate(SQLiteDatabase db){
        db.execSQL("create table student(rollno INT primary key, name varchar , marks int)");
    }

    public void insertStudent(int roll, String name, int marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO student VALUES(" + roll + ", '" + name + "', " + marks + ")");
    }

    public Cursor getStudent(int roll) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM student WHERE rollno = " + roll, null);
    }

    public void updateStudent(int roll, String name, int marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE student SET name='" + name + "', marks=" + marks + " WHERE rollno=" + roll);
    }

    public void deleteStudent(int roll) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM student WHERE rollno=" + roll);
    }
}
