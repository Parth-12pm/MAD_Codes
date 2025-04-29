package com.example.final_exam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Vid_cap extends AppCompatActivity {
    VideoView v1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vid_cap);

        v1 = findViewById(R.id.v1);
        b1 = findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(in, 1);
            }
        });
    }

    protected void onActivityResult(int reqcode, int resultcode, Intent data) {
        super.onActivityResult(reqcode, resultcode, data);
        if (reqcode == 1) {
            MediaController mc = new MediaController(this);
            v1.setMediaController(mc);
            Uri vURI = data.getData();
            v1.setVideoURI(vURI);
            v1.start();
        }
    }
}