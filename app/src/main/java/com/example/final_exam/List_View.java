package com.example.final_exam;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class List_View extends AppCompatActivity {
    ListView l1;
    String cities[] = {
            "New York", "Los Angeles", "Chicago", "Houston", "Phoenix",
            "London", "Paris", "Tokyo", "Berlin", "Toronto",
            "Sydney", "Dubai", "Mumbai", "Singapore", "Barcelona",
            "Hong Kong", "Rome", "Bangkok", "Istanbul", "Amsterdam"
    };
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        l1 = findViewById(R.id.l1);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.text,R.id.txt1,cities);
        l1.setAdapter(arrayAdapter);

        l1.setOnItemClickListener(((parent, view, position, id) -> {
            String selected = cities[position];
            Toast.makeText(this,"Selected : "+selected,Toast.LENGTH_SHORT).show();
        }));
    }

}