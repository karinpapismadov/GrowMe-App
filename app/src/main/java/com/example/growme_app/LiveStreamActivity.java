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
            String url = "https://9db3-2a0d-6fc0-84e-9d00-a051-a3f2-7720-b032.ngrok-free.app/stream";
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