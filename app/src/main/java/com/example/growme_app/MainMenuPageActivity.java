package com.example.growme_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainMenuPageActivity extends AppCompatActivity {

    Button back, help, exit;
    CardView user, create, reset, live, statistics, metrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_page);

        back = findViewById(R.id.back_button);
        help = findViewById(R.id.help_button);
        exit = findViewById(R.id.exit_button);
        user = findViewById(R.id.user_card);
        create = findViewById(R.id.create_card);
        reset = findViewById(R.id.reset_Card);
        live = findViewById(R.id.live_Card);
        statistics = findViewById(R.id.statistics_Card);
        metrics = findViewById(R.id.metrics_Card);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuPageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuPageActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuPageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuPageActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuPageActivity.this, CreateGardenActivity.class);
                startActivity(intent);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuPageActivity.this, ResetGardenActivity.class);
                startActivity(intent);
            }
        });
        live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuPageActivity.this, LiveStreamActivity.class);
                startActivity(intent);
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuPageActivity.this, CreateGardenActivity.class);
                startActivity(intent);
            }
        });
        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuPageActivity.this, StatisticsActivity.class);
                startActivity(intent);
            }
        });
        metrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuPageActivity.this, MetricsActivity.class);
                startActivity(intent);
            }
        });



    }
}