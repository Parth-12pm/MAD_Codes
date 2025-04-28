package com.example.final_exam;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class stud_Database extends AppCompatActivity {

    EditText rollET, nameET, marksET;
    Button insertBtn, getBtn, updateBtn, deleteBtn;
    dbHelper_stud db;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_database);

        rollET = findViewById(R.id.roll);
        nameET = findViewById(R.id.name);
        marksET = findViewById(R.id.marks);
        insertBtn = findViewById(R.id.insert);
        getBtn = findViewById(R.id.get);
        updateBtn = findViewById(R.id.update);
        deleteBtn = findViewById(R.id.delete);
        db = new dbHelper_stud(this);


        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertStudent(getRoll(), getName(), getMarks());
                toast("Inserted");
            }
        });

        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.getStudent(getRoll());
                if (c.moveToFirst()) {
                    nameET.setText(c.getString(1));
                    marksET.setText(c.getString(2));
                } else toast("Not Found");
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.updateStudent(getRoll(), getName(), getMarks());
                toast("Updated");
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteStudent(getRoll());
                toast("Deleted");
            }
        });
    }

    int getRoll() { return Integer.parseInt(rollET.getText().toString()); }
    String getName() { return nameET.getText().toString(); }
    int getMarks() { return Integer.parseInt(marksET.getText().toString()); }
    void toast(String msg) { Toast.makeText(this, msg, Toast.LENGTH_SHORT).show(); }
}