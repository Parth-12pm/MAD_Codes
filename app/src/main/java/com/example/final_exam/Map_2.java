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

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class Map_2 extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;
    private FusedLocationProviderClient fusedLocationClient;
    private LatLng carLocation; // This will store the car's current location

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
        }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Get the map fragment and set it up
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

            // Get current location using FusedLocationProviderClient
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, location -> {
                        if (location != null) {
                            // Set car's location to current location
                            carLocation = new LatLng(location.getLatitude(), location.getLongitude());

                            // Add car location marker
                            map.addMarker(new MarkerOptions()
                                    .position(carLocation)
                                    .title("Your Car's Current Location"));

                            // Zoom to car's location
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(carLocation, 12));

                            Toast.makeText(this, "Your Car's Current Location :\n" + carLocation, Toast.LENGTH_SHORT).show();
                            // Optionally, draw a polyline if needed, for example from a known destination
                            // LatLng destination = new LatLng(19.0522, 72.8335); // Example: MSBTE Bandra
                            // map.addPolyline(new PolylineOptions().add(carLocation, destination).width(5).color(Color.BLUE));
                        }
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
