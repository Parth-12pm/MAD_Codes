package com.example.final_exam;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

//b) Write a program to find the direction from user’s current
//location to MSBTE, Bandra (Write only java and manifest file)

public class Map_1 extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;
    private FusedLocationProviderClient fusedLocationClient;
    private static final LatLng MSBTE_BANDRA = new LatLng(19.0522, 72.8335);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map1);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
        }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_1);
        mapFragment.getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        enableLocationFeatures();
    }

    private void enableLocationFeatures() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            // Enable current location
            map.setMyLocationEnabled(true);

            // Add MSBTE marker
            map.addMarker(new MarkerOptions()
                    .position(MSBTE_BANDRA)
                    .title("MSBTE Bandra"));

            // Draw line when location is available
            map.setOnMyLocationChangeListener(location -> {
                LatLng current = new LatLng(location.getLatitude(), location.getLongitude());

                // Add straight line between current location and MSBTE
                map.addPolyline(new PolylineOptions()
                        .add(current, MSBTE_BANDRA)
                        .width(5)
                        .color(Color.BLUE));

                // Zoom to show both points
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(current, 12));

                // Remove listener to prevent continuous updates
                map.setOnMyLocationChangeListener(null);
            });

        } else {
            Toast.makeText(this, "Location permission required", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            enableLocationFeatures();
        }
    }

}