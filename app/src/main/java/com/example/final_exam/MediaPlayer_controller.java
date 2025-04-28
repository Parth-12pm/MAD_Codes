package com.example.final_exam;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MediaPlayer_controller extends AppCompatActivity {

    Button b1, b2, b3;
    VideoView v1;
    MediaPlayer M1;
    MediaController M2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player_controller);

        b1 = findViewById(R.id.play);
        b2 = findViewById(R.id.pause);
        b3 = findViewById(R.id.stop);
        v1 = findViewById(R.id.v1);


        M1 = MediaPlayer.create(this, R.raw.music1);

        M2 = new MediaController(this);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video1;
        v1.setVideoPath(videoPath);
        v1.setMediaController(M2);
        v1.start();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                M1.start();
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                M1.pause();
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    M1.stop();
                    M1.prepare();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
}