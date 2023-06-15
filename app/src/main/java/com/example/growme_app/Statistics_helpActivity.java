package com.example.growme_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Statistics_helpActivity extends AppCompatActivity {
    Button back, bt1,bt2,bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_help);

        back = findViewById(R.id.BACK_TO_STATISTICS_PAGE);
        bt1 = findViewById(R.id.What_can_I_see_in_the_statistics_page);
        bt2 = findViewById(R.id.How_can_I_watch_a_specific_sensor_data_values);
        bt3 = findViewById(R.id.What_does_the_graph_values_mean);

        bt1.setOnClickListener(view -> {
            Intent intent = new Intent(Statistics_helpActivity.this, StatHelpBt1.class);
            startActivity(intent);
        });
        bt2.setOnClickListener(view -> {
            Intent intent = new Intent(Statistics_helpActivity.this, StatHelpBt2.class);
            startActivity(intent);
        });
        bt3.setOnClickListener(view -> {
            Intent intent = new Intent(Statistics_helpActivity.this, StatHelpBt3.class);
            startActivity(intent);
        });

        back.setOnClickListener(view -> {
            Intent intent = new Intent(Statistics_helpActivity.this, StatisticsActivity.class);
            startActivity(intent);
        });
    }
}