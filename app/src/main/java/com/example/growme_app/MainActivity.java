package com.example.growme_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnLetsStart;
    TextView tvWelcome, tvCreatedBy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLetsStart = findViewById(R.id.LETS_START_button_in_main_page);
        tvWelcome = findViewById(R.id.welcomeTo_Headline_in_main_page);
        tvCreatedBy = findViewById(R.id.createdBy_in_main_page);

        btnLetsStart.setOnClickListener(view -> {

        });
        btnLetsStart.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, RegisterActivity2.class)));

    }
}