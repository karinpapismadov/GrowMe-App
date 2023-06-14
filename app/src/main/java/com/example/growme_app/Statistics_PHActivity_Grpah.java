package com.example.growme_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Statistics_PHActivity_Grpah extends AppCompatActivity {  
    private BarChart barChart;
    private DatabaseReference waterLevelRef;
    private List<Float> waterLevelValues;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_phgrpah);

        // Get a reference to the "Water level" value in the database.
        waterLevelRef = FirebaseDatabase.getInstance().getReference().child("CurrentData").child("PH value");

        back = findViewById(R.id.Back_graph);

        barChart = findViewById(R.id.barchart);
        barChart.setBackgroundColor(Color.WHITE);
        barChart.setDrawGridBackground(false);
        barChart.setDrawBarShadow(false);
        barChart.setPinchZoom(false);
        barChart.setDrawValueAboveBar(true);

        waterLevelValues = new ArrayList<>();

        waterLevelRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Read water level value from the database
                String waterLevelStr = dataSnapshot.getValue(String.class);
                float waterLevelValue = Float.parseFloat(waterLevelStr);

                // Add the new water level value to the list
                waterLevelValues.add(waterLevelValue);

                // Update the chart with the new values
                updateChart();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("WaterLevelGraphActivity", "The read failed: " + databaseError.getCode());
            }
        });
    }

    private void updateChart() {
        // Create a list of BarEntry objects
        List<BarEntry> entries = new ArrayList<>();

        for (int i = 0; i < waterLevelValues.size(); i++) {
            // Create a BarEntry object with the water level value
            BarEntry barEntry = new BarEntry(i, waterLevelValues.get(i));
            entries.add(barEntry);
        }

        // Create a BarDataSet object with the entries
        BarDataSet dataSet = new BarDataSet(entries, "PH value");

        // Set colors for the bars
        dataSet.setColors(Color.BLUE);

        // Create a BarData object with the data set
        BarData barData = new BarData(dataSet);

        // Set the data for the bar chart
        barChart.setData(barData);

        // Refresh the chart
        barChart.invalidate();

        back.setOnClickListener(view -> {
            Intent intent = new Intent(Statistics_PHActivity_Grpah.this, StatisticsActivity.class);
            startActivity(intent);
        });
    }
}