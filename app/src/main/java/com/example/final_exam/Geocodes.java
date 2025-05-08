package com.example.final_exam;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Geocodes extends AppCompatActivity {

    private Geocoder geocoder;
    TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geocodes);

        geocoder = new Geocoder(this, Locale.getDefault());
        t1 = findViewById(R.id.geocodeResult);
        t2 = findViewById(R.id.reverseGeocodeResult);

        // Geocoding: Address to Lat/Lon
        String locationName = "1600 Amphitheatre Parkway, Mountain View, CA";
        try {
            List<Address> addresses = geocoder.getFromLocationName(locationName, 1);
            if (!addresses.isEmpty()) {
                Address address = addresses.get(0);
                double latitude = address.getLatitude();
                double longitude = address.getLongitude();
                displayToast("Geocoding Result:\nLat: " + latitude + ", Lon: " + longitude);
                t1.setText("Geocoding Result:\nLat: " + latitude + ", Lon: " + longitude);
            } else {
                displayToast("Geocoding failed: Location not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            displayToast("Geocoding failed: " + e.getMessage());
        }

        // Reverse Geocoding: Lat/Lon to Address
        double latitude = 37.423021;
        double longitude = -122.083739;
        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (!addresses.isEmpty()) {
                Address address = addresses.get(0);
                String addressText = address.getAddressLine(0);
                displayToast("Reverse Geocoding Result:\n" + addressText);
                t2.setText("Reverse Geocoding Result:\n" + addressText);

            } else {
                displayToast("Reverse geocoding failed: Address not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            displayToast("Reverse geocoding failed: " + e.getMessage());
        }
    }

    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
