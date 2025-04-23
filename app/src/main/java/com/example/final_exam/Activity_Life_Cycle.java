package com.example.final_exam;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_Life_Cycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        toast("Activity Created");
    }

    protected void onStart(){
        super.onStart();
        toast("Activity Started");
    }
    protected void onResume(){
        super.onResume();
        toast("Activity Resumed");
    }
    protected void onPause(){
        super.onPause();
        toast("Activity Paused");
    }
    protected void onRestart(){
        super.onRestart();
        toast("Activity Restarted");
    }
    protected void onDestroy(){
        super.onDestroy();
        toast("Activity Destroyed");
    }

    public void toast(String msg){
        Toast.makeText(this , msg , Toast.LENGTH_SHORT).show();
    }
}