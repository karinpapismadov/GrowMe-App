package com.example.growme_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Statistics_waterLevel_Activity extends AppCompatActivity {

    TextView water_AVG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_water_level);

        water_AVG = findViewById(R.id.waterAVG);

    }
}