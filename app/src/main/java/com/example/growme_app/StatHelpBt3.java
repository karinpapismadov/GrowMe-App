package com.example.growme_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class StatHelpBt3 extends AppCompatActivity {
    Button back;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat_help_bt3);
        back = findViewById(R.id.back_to_stat_help_page);


        back.setOnClickListener(view -> {
            Intent intent = new Intent(StatHelpBt3.this, Statistics_helpActivity.class);
            startActivity(intent);
        });
    }
}