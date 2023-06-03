package com.example.growme_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LiveStreamActivity extends AppCompatActivity {

    Button back,live;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_stream);

        back = findViewById(R.id.back_button_live);
        live  = findViewById(R.id.live_url_button);

        live.setOnClickListener(view -> {
            String url = "https://37a6-2a0d-6fc0-804-dc00-75f5-d55c-a82-3a3f.ngrok-free.app/stream/";
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        back.setOnClickListener(view -> {
            Intent intent = new Intent(LiveStreamActivity.this, MainMenuPageActivity.class);
            startActivity(intent);
        });
    }
}