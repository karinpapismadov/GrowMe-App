package com.example.growme_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PopHelpBt2 extends AppCompatActivity {
    Button back;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_help_bt2);

        back = findViewById(R.id.BACK_TO_HELP_PAGE);


        back.setOnClickListener(view -> {
            Intent intent = new Intent(PopHelpBt2.this, HelpActivity.class);
            startActivity(intent);
        });
    }
}
