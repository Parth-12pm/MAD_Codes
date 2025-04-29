package com.example.final_exam;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Temperature extends AppCompatActivity {

    EditText e1;
    ToggleButton t1;
    TextView res;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        e1 = findViewById(R.id.e1);
        t1 = findViewById(R.id.t1);
        res = findViewById(R.id.res);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = e1.getText().toString();
                double temp = Double.parseDouble(input);

                if (t1.isChecked()) {
                    double fahrenheit = (temp * 9 / 5) + 32;
                    res.setText("In Fahrenheit: " + fahrenheit);
                } else {
                    double celsius = (temp - 32) * 5 / 9;
                    res.setText("In Celsius: " + celsius);
                }
            }
        });
    }
}