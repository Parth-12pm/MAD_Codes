package com.example.final_exam;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Grid_View extends AppCompatActivity {

    String cities[] = {
            "New York", "Los Angeles", "Chicago", "Houston", "Phoenix",
            "London", "Paris", "Tokyo", "Berlin", "Toronto",
            "Sydney", "Dubai", "Mumbai", "Singapore", "Barcelona",
            "Hong Kong", "Rome", "Bangkok", "Istanbul", "Amsterdam"
    };
    GridView g1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        g1 = findViewById(R.id.g1);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.text, R.id.txt1, cities);
        g1.setAdapter(arrayAdapter);

        g1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = cities[position];
                Toast.makeText(parent.getContext(), "Selected : " + selected, Toast.LENGTH_SHORT).show();
            }
        });

    }
}