package com.example.final_exam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class Img_cap extends AppCompatActivity {

    ImageView i1;
    Button b1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_cap);

        i1 = findViewById(R.id.i1);
        b1 = findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(in, 1);
            }
        });
    }

    protected void onActivityResult(int reqcode, int resultcode, Intent data) {
        super.onActivityResult(reqcode, resultcode, data);

        if (reqcode == 1) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            i1.setImageBitmap(image);
        }
    }


}