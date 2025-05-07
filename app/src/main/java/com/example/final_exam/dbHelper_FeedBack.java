package com.example.final_exam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper_FeedBack extends SQLiteOpenHelper {
    public dbHelper_FeedBack(Context cxt) {
        super(cxt, "db", null, 1);
    }

    public void onUpgrade(SQLiteDatabase db, int oldDB, int newDB) {
        db.execSQL("drop table if exists feedback");
        onCreate(db);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table feedback(rollno varchar,name varchar, feedback varchar)");
    }

    public void insert(String rollno, String name, String feedback) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Insert into feedback values('" + rollno + "','" + name + "','" + feedback + "')");
    }

}
