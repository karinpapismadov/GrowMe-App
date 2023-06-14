package com.example.growme_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    Button Bt1, Bt2, Bt3, Bt4, Bt5, Bt6, Bt7, Bt8, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);


        back = findViewById(R.id.BACK_TO_MENU_PAGE);


        back.setOnClickListener(view -> {
            Intent intent = new Intent(HelpActivity.this, MainMenuPageActivity.class);
            startActivity(intent);
        });
    }
}