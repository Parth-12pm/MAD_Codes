package com.example.final_exam;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Animations extends AppCompatActivity {

    ImageView img;
    Button btnF, btnM, btnB, btnS, btnR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);

        img = findViewById(R.id.imageView);
        btnF = findViewById(R.id.btnFade);
        btnM = findViewById(R.id.btnMove);
        btnB = findViewById(R.id.btnBlink);
        btnS = findViewById(R.id.btnScale);
        btnR = findViewById(R.id.btnRotate);

        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(Animations.this, R.anim.fade);
                img.startAnimation(anim);
            }
        });

        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(Animations.this, R.anim.move);
                img.startAnimation(anim);
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(Animations.this, R.anim.blink);
                img.startAnimation(anim);
            }
        });

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(Animations.this, R.anim.scale);
                img.startAnimation(anim);
            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(Animations.this, R.anim.rotate);
                img.startAnimation(anim);
            }
        });
    }
}