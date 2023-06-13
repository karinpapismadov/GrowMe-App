package com.example.growme_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class RegisterActivity2 extends AppCompatActivity {

    EditText registerName, registerCode, registerPassword,registerMail;
    Button register;
    TextView LoginAlreadyHaveButton;
    FirebaseAuth fAuth;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference root = db.getReference().child("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        registerName=findViewById(R.id.register_name);
        registerMail=findViewById(R.id.register_mail);
        registerCode = findViewById(R.id.register_code);
        registerPassword = findViewById(R.id.register_password);
        register = findViewById(R.id.register_button);
        LoginAlreadyHaveButton = findViewById(R.id.Login_redirect_text);
        fAuth=FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),LoginActivity2.class));
            finish();
        }

        register.setOnClickListener(v -> {

            String email = registerMail.getText().toString().trim();
            String password = registerPassword.getText().toString().trim();


            if(TextUtils.isEmpty(email)){
                registerMail.setError("E-mail is required");
                return;
            }
            if(TextUtils.isEmpty(password)){
                registerPassword.setError("Password is required");
                return;
            }
            if(password.length()<6){
                registerPassword.setError("Password must contain 6 characters or more");
                return;
            }
            fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    String name = registerName.getText().toString();
                    String code = registerCode.getText().toString();
                    HashMap<String, String> userMap = new HashMap<>();

                    userMap.put("name", name);
                    userMap.put("code", code);
                    userMap.put("email", email);

                    root.setValue(userMap);
                    Toast.makeText(RegisterActivity2.this,"User created", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),LoginActivity2.class));
                }else{
                    Toast.makeText(RegisterActivity2.this, "Error !" + Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                }
            });

        });
        LoginAlreadyHaveButton.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity2.this, LoginActivity2.class);
            startActivity(intent);
        });
    }
}