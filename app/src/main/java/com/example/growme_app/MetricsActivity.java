package com.example.growme_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MetricsActivity extends AppCompatActivity {


    private TextView fan, LDR, LED, water, PH, humidity, temp;
    Button back;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metrics);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference metricsRef = database.getReference("CurrentData");

        fan = findViewById(R.id.fan_level_metrics);
        LDR = findViewById(R.id.light_metrics);
        LED = findViewById(R.id.LED_metrics);
        water = findViewById(R.id.water_level_metrics);
        PH = findViewById(R.id.ph_level_metrics);
        humidity = findViewById(R.id.Humidity_metrics);
        temp = findViewById(R.id.temperature_metrics);
        back = findViewById(R.id.back_button_metrics);

        // Attach a ValueEventListener to retrieve the data from Firebase
        metricsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Retrieve the metric values from the dataSnapshot
                String fanLevel = dataSnapshot.child("Fans").getValue(String.class);
                String ldrValue = dataSnapshot.child("LDR value").getValue(String.class);
                String ledValue = dataSnapshot.child("LED").getValue(String.class);
                String waterLevel = dataSnapshot.child("Water level").getValue(String.class);
                String pHValue = dataSnapshot.child("PH value").getValue(String.class);
                String humidityValue = dataSnapshot.child("Humidity").getValue(String.class);
                String temperatureValue = dataSnapshot.child("Temperature").getValue(String.class);

                // Set the metric values to the TextViews
                fan.setText(fanLevel);
                LDR.setText(ldrValue);
                LED.setText(ledValue);
                water.setText(waterLevel);
                PH.setText(pHValue);
                humidity.setText(humidityValue);
                temp.setText(temperatureValue);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle onCancelled event
            }
        });



        //back button
        back.setOnClickListener(view -> {
            Intent intent = new Intent(MetricsActivity.this, MainMenuPageActivity.class);
            startActivity(intent);
        });
    }
}