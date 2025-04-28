package com.example.final_exam;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class emp_Database extends AppCompatActivity {
    TextView t1;
    EditText e1, e2, e3;
    Button b1, b2, b3, b4;

    dbHelper_emp db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_database);

        t1 = findViewById(R.id.t1);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);

        db = new dbHelper_emp(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insert(getID(), getName(), getDept());
                toast("Inserted");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.update(getID(), getName(), getDept());
                toast("Updated");
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.display(getID());
                if (c.moveToFirst()) {
                    e2.setText(c.getString(1));
                    e3.setText(c.getString(2));

                    String result = "Emp id :" + getID() + "\n" +
                            "Emp Name :" + c.getString(1) + "\n" +
                            "Emp dept :" + c.getString(2);
                    t1.setText(result);

                } else {
                    toast("not found");
                }
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete(getID());
                toast("deleted");
            }
        });
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public int getID() {
        return Integer.parseInt(e1.getText().toString());
    }

    public String getName() {
        return e2.getText().toString();
    }

    public String getDept() {
        return e3.getText().toString();
    }
}