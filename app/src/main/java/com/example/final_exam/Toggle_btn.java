package com.example.final_exam;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Toggle_btn extends AppCompatActivity {

    ToggleButton t1;
    TextView result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_btn);

        t1= findViewById(R.id.t1);
        result = findViewById(R.id.result);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t1.isChecked()) {
                    result.setText("Toggle Status : On");
                } else {
                    result.setText("Toggle Status : Off");
                }
            }
        });

    }
}