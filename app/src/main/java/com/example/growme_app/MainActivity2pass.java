package com.example.growme_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2pass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2pass);

        EditText loginCode, loginPassword;

        Button loginButton;

        loginCode = findViewById(R.id.login_code);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.Login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ////iffff
                Intent intent = new Intent(MainActivity2pass.this, MainMenuPageActivity.class);
                startActivity(intent);
            }
        });
    }
}