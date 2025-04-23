package com.example.final_exam;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Radio_btn extends AppCompatActivity {
    RadioGroup rgrp;
    RadioButton r1, r2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_btn);

        rgrp = findViewById(R.id.rgrp);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        result = findViewById(R.id.result);

        rgrp.setOnCheckedChangeListener((group, checkedId) -> {
            int ischecked = rgrp.getCheckedRadioButtonId();

            if (ischecked == R.id.r1)
                result.setText("selected Male ");
            if (ischecked == R.id.r2)
                result.setText("selected Female");
        });

    }
}