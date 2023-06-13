package com.example.growme_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        EditText loginEmail, loginPassword;
        TextView RegisterDontHave;
        FirebaseAuth fAuth;

        Button loginButton;

        loginEmail = findViewById(R.id.login_email);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.Login_button);
        RegisterDontHave = findViewById(R.id.Register_redirect_text);
        fAuth = FirebaseAuth.getInstance();


        loginButton.setOnClickListener(view -> {

            String email = loginEmail.getText().toString().trim();
            String password = loginPassword.getText().toString().trim();

            if(TextUtils.isEmpty(email)){
                loginEmail.setError("E-mail is required");
                return;
            }
            if(TextUtils.isEmpty(password)){
                loginPassword.setError("Password is required");
                return;
            }
            if(password.length()<6){
                loginPassword.setError("Password must contain 6 characters or more");
                return;
            }
            fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity2.this,"Logged in successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainMenuPageActivity.class));
                }else {
                    Toast.makeText(LoginActivity2.this,"Error !" + Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        });


        RegisterDontHave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity2.this, RegisterActivity2.class);
                startActivity(intent);
            }
        });
    }
}