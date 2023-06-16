package com.example.growme_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

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

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;

public class MetricsActivity extends AppCompatActivity {

    private TextView fan, LDR, LED, water, PH, humidity, temp;
    private int ledStatus = -1;  // Initialize with a value that doesn't exist
    private int fanStatus = -1;  // Initialize with a value that doesn't exist

    Button back;
    private NotificationManager notificationManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metrics);

        fan = findViewById(R.id.fan_level_metrics);
        LDR = findViewById(R.id.light_metrics);
        LED = findViewById(R.id.LED_metrics);
        water = findViewById(R.id.water_level_metrics);
        PH = findViewById(R.id.ph_level_metrics);
        humidity = findViewById(R.id.Humidity_metrics);
        temp = findViewById(R.id.temperature_metrics);
        back = findViewById(R.id.back_button_metrics);

        createNotificationChannel();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference metricsRef = database.getReference("CurrentData");

        // Attach a ValueEventListener to retrieve the data from Firebase
        metricsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Retrieve the metric values from the dataSnapshot
                String fanLevel = dataSnapshot.child("Fans").getValue(String.class);
                String ledValue = dataSnapshot.child("LED").getValue(String.class);
                String ldrValue = dataSnapshot.child("LDR value").getValue(String.class);
                String waterLevel = dataSnapshot.child("Water level").getValue(String.class);
                String pHValue = dataSnapshot.child("PH value").getValue(String.class);
                String humidityValue = dataSnapshot.child("Humidity").getValue(String.class);
                String temperatureValue = dataSnapshot.child("Temperature").getValue(String.class);
                ///// new
                int currentFanLevel = Integer.parseInt(fanLevel);
                int currentLEDValue = Integer.parseInt(ledValue);
                // Set the metric values to the TextViews
                fan.setText(fanLevel);
                LDR.setText(ldrValue);
                LED.setText(ledValue);
                water.setText(waterLevel);
                PH.setText(pHValue);
                humidity.setText(humidityValue);
                temp.setText(temperatureValue);

                // Check the metric values and show notifications if necessary
                // checkFanStatus(Integer.parseInt(fanLevel));
                checkPHValue(Double.parseDouble(pHValue));
                checkWaterLevel(Integer.parseInt(waterLevel));
                checkTemperature(Double.parseDouble(temperatureValue));
                //checkLEDStatus(Integer.parseInt(ledValue));
                checkHumidity(Double.parseDouble(humidityValue));
                ///// led+fan check
                checkFanStatus(currentFanLevel);
                checkLEDStatus(currentLEDValue);

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

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("GrowMeAppChannel",
                    "GrowMe App Channel",
                    NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Channel for GrowMe App Notifications");
            channel.enableLights(true);
            channel.setLightColor(Color.GREEN);
            channel.enableVibration(true);

            notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void showNotification(String title, String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "GrowMeAppChannel")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                .setAutoCancel(true);

        notificationManager.notify(1, builder.build());
    }

    private void checkPHValue(double pHValue) {
        if (pHValue < 1 || pHValue > 14) {
            showNotification("PH Level Alert", "pH value is out of range");
        }
    }

    private void checkWaterLevel(int waterLevel) {
        if (waterLevel == 0) {
            showNotification("Water Level Alert", "Water level is critically low");
        } else if (waterLevel > 100) {
            showNotification("Water Level Alert", "Water level is too high");
        }
    }

    private void checkTemperature(double temperature) {
        if (temperature < -10 || temperature > 60) {
            showNotification("Temperature Alert", "Temperature is out of range");
        }
    }

    private void checkHumidity(double humidity) {
        if (humidity < 0 || humidity > 100) {
            showNotification("Humidity Alert", "Humidity is out of range");
        }
    }
    //// NEW ////////

    private void checkFanStatus(int fanLevel) {
        // Check if the fan status has changed from the current state
        if (fanLevel == 1 && fanStatus != 1) {
            // Fan turned on, show notification
            showNotification("Fan Status", "The fan has been turned on");
        } else if (fanLevel == 0 && fanStatus != 0) {
            // Fan turned off, show notification
            showNotification("Fan Status", "The fan has been turned off");
        }
        // Update the fanStatus variable to the current state
        fanStatus = fanLevel;
    }


    private void checkLEDStatus(int ledValue) {
        // Check if the LED status has changed from the current state
        if (ledValue == 1 && ledStatus != 1) {
            // LED turned on, show notification
            showNotification("LED Status", "The LED has been turned on");
        } else if (ledValue == 0 && ledStatus != 0) {
            // LED turned off, show notification
            showNotification("LED Status", "The LED has been turned off");
        }
        // Update the ledStatus variable to the current state
        ledStatus = ledValue;
    }

}
