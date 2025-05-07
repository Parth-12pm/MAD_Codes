package com.example.final_exam;

import static android.widget.Toast.makeText;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Stud_FeedBack extends AppCompatActivity {

    dbHelper_FeedBack db = new dbHelper_FeedBack(this);
    EditText e1, e2, e3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_feed_back);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        b1 = findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insert(
                        e1.getText().toString(),
                        e2.getText().toString(),
                        e3.getText().toString()
                );
                makeText(Stud_FeedBack.this, "Feedback Submitted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}