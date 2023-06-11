package com.example.growme_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StatisticsActivity extends AppCompatActivity {

    CardView water, light,PH, back, temp, help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);


        water = findViewById(R.id.water_level_card);
        light = findViewById(R.id.Light_card);
        PH = findViewById(R.id.PH_Card);
        back = findViewById(R.id.back_Card);
        temp = findViewById(R.id.temp_Card);
        help = findViewById(R.id.help_Card);


        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatisticsActivity.this, Statistics_waterLevel_Activity.class);
                startActivity(intent);
            }
        });

        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatisticsActivity.this, Statistics_lightActivity.class);
                startActivity(intent);
            }
        });

        PH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatisticsActivity.this, Statistics_PHActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatisticsActivity.this, MainMenuPageActivity.class);
                startActivity(intent);
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatisticsActivity.this, Statistics_tempActivity.class);
                startActivity(intent);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatisticsActivity.this, Statistics_helpActivity.class);
                startActivity(intent);
            }
        });

    }
}