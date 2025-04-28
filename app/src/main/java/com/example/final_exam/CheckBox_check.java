package com.example.final_exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class CheckBox_check extends AppCompatActivity {

    CheckBox c1,c2,c3,c4,c5;
    Button b1;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        result = findViewById(R.id.result);
        b1 = findViewById(R.id.b1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Selected();
            }
        });

    }

    public void Selected(){
        StringBuilder str = new StringBuilder("Selected Subjet :\n");
        if(c1.isChecked())
            str.append("sub 1\n");
        if(c2.isChecked())
            str.append("sub 2\n");
        if(c3.isChecked())
            str.append("sub 3\n");
        if(c4.isChecked())
            str.append("sub 4\n");
        if(c5.isChecked())
            str.append("sub 5\n");

        result.setText(str);
    }
}