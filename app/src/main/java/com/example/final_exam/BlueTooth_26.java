package com.example.final_exam;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.Set;

public class BlueTooth_26 extends AppCompatActivity {
    static final int REQ_CODE = 2;
    private BluetoothAdapter Badapter;
    private TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth26);

        Badapter = BluetoothAdapter.getDefaultAdapter();

        Button b1 = findViewById(R.id.b1);
        Button b2 = findViewById(R.id.b2);
        Button b3 = findViewById(R.id.b3);
        t1 = findViewById(R.id.t1);

        if (!checkPermission()) reqPermission();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Badapter.isEnabled()) {
                    if (checkPermission()) {
                        startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), REQ_CODE);
                    }
                } else {
                    toast("Bluetooth is already ON");
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Badapter.isEnabled()) {
                    startActivity(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS));
                    toast("Go to settings to turn off Bluetooth");
                } else {
                    toast("Bluetooth is already OFF");
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
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
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED;
    }

    private void reqPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BLUETOOTH_CONNECT}, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {
            toast(resultCode == RESULT_OK ? "Bluetooth enabled" : "Bluetooth enabling canceled");
        }
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
