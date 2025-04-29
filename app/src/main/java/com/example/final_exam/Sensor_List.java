package com.example.final_exam;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class Sensor_List extends AppCompatActivity {

    Button b1;
    SensorManager sm;
    TextView t1;
    List<Sensor> sensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);

        b1 = findViewById(R.id.b1);
        t1 = findViewById(R.id.t1);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sensorList = sm.getSensorList(Sensor.TYPE_ALL);
                StringBuilder sensors = new StringBuilder();
                for (Sensor sensor : sensorList) {
                    sensors.append(sensor.getName()).append("\n");
                }
                t1.setText(sensors.toString());
            }
        });
    }
}