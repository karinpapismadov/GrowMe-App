package com.example.growme_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText registerName, registerEmail, registerPassword;
    TextView loginRedirectText;
    Button registerButton;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // taking FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();

        // initialising all views through id defined above
        registerName=findViewById(R.id.register_name);
        registerEmail = findViewById(R.id.register_email);
        registerPassword = findViewById(R.id.register_password);
        registerButton = findViewById(R.id.register_button);
        loginRedirectText= findViewById(R.id.Login_redirect_text);
        // Set on Click Listener on Registration button
        loginRedirectText.setOnClickListener(v -> {
            Intent intent
                    = new Intent(RegisterActivity.this,
                    LoginActivity.class);
            startActivity(intent);            });

        registerButton.setOnClickListener(v -> registerNewUser());
    }

    private void registerNewUser()
    {

        // Take the value of two edit texts in Strings
        String email,name, password;
        name=registerName.getText().toString();
        email = registerEmail.getText().toString();
        password = registerPassword.getText().toString();

        // Validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter email!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter password!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter password!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }

        // create new user or register new user
        mAuth
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(),
                                        "Registration successful!",
                                        Toast.LENGTH_LONG)
                                .show();

                        // if the user created intent to login activity
                        Intent intent
                                = new Intent(RegisterActivity.this,
                                LoginActivity.class);
                        startActivity(intent);
                    }
                    else {

                        // Registration failed
                        Toast.makeText(
                                        getApplicationContext(),
                                        "Registration failed!!"
                                                + " Please try again",
                                        Toast.LENGTH_LONG)
                                .show();
                    }
                });
    }
}