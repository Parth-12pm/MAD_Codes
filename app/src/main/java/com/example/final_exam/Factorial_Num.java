package com.example.final_exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Factorial_Num extends AppCompatActivity {
    Button b1;
    EditText e1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial_num);

        b1 = findViewById(R.id.b1);
        e1 = findViewById(R.id.e1);
        t1 = findViewById(R.id.t1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(e1.getText().toString());
                t1.setText("Factorial : " + findFactorial(num));
            }
        });
    }

    private long findFactorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}