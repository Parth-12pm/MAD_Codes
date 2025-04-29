package com.example.final_exam;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.Set;

public class BlueTooth_Devices_List extends AppCompatActivity {
    private BluetoothAdapter Badapter;
    private TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth26);

        Badapter = BluetoothAdapter.getDefaultAdapter();
        t1 = findViewById(R.id.t1);
        Button b1 = findViewById(R.id.b3);

        if (!checkPermission()) reqPermission();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkPermission()) {
                    reqPermission();
                    return;
                }

                Set<BluetoothDevice> devices = Badapter.getBondedDevices();
                t1.setText("");

                if (!devices.isEmpty()) {
                    for (BluetoothDevice device : devices) {
                        t1.append("\nDevice: " + device.getName() + " - " + device.getAddress());
                    }
                } else {
                    t1.setText("No devices found");
                }
            }
        });
    }

    private boolean checkPermission() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT)
                == PackageManager.PERMISSION_GRANTED;
    }

    private void reqPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.BLUETOOTH_CONNECT}, 1);
    }
}
