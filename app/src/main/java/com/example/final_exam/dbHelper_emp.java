package com.example.final_exam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper_emp extends SQLiteOpenHelper {
    public dbHelper_emp(Context ctx){
        super(ctx , "emp",null, 1);
    }
    public void onUpgrade(SQLiteDatabase db , int oldversion, int newversion){
        db.execSQL("drop table if exists emp");
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table emp(id int, name varchar, dept varchar)");
    }

    public void  insert(int id, String name, String dept){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("insert into emp values("+id+",'"+name+"','"+dept+"')");
    }

    public void update(int id, String name , String dept){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update emp set name='"+name+"',dept ='"+dept+"' where id= " +id);
    }

    public  void delete(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from emp where id="+id);
    }

    public Cursor display(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select * from emp where id="+id, null);
    }
}
