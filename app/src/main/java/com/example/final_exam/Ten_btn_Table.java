package com.example.final_exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//Design UI using table layout to display buttons with 0 – 9
//numbers on it. Even display submit and clear button. When
//user clicks on particular buttons and later when clicks on
//submit button, it should display the numbers clicked

public class Ten_btn_Table extends AppCompatActivity {
    TextView textViewResult;
    StringBuilder input = new StringBuilder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_btn_table);
        textViewResult = findViewById(R.id.textViewResult);

        int[] buttonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        };

        for (int id : buttonIds) {
            Button btn = findViewById(id);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNumberClick(v);
                }
            });
        }

        findViewById(R.id.btnClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClearClick(v);
            }
        });

        findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmitClick(v);
            }
        });

    }

    public void onNumberClick(View view) {
        Button btn = (Button) view;
        input.append(btn.getText().toString());
        textViewResult.setText(input.toString());
    }

    public void onClearClick(View view) {
        input.setLength(0);
        textViewResult.setText("");
    }

    public void onSubmitClick(View view) {
        textViewResult.setText("Entered: " + input.toString());
    }
}