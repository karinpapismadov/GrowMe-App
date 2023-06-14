package com.example.growme_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserActivity extends AppCompatActivity {


    TextView name, code, mail;
    @SuppressLint("WrongViewCast")
    Button back = findViewById(R.id.user_back);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userRef = database.getReference("CurrentData");

        name = findViewById(R.id.text_show_name);
        code = findViewById(R.id.text_show_code);
        mail = findViewById(R.id.text_show_email);


        // Attach a ValueEventListener to retrieve the data from Firebase
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Retrieve the metric values from the dataSnapshot
                String nameU = dataSnapshot.child("name").getValue(String.class);
                String mailU = dataSnapshot.child("mail").getValue(String.class);
                String codeU = dataSnapshot.child("code").getValue(String.class);


                // Set the metric values to the TextViews
                name.setText(nameU);
                mail.setText(mailU);
                code.setText(codeU);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle onCancelled event
            }
        });



        //back button
        back.setOnClickListener(view -> {
            Intent intent = new Intent(UserActivity.this, MainMenuPageActivity.class);
            startActivity(intent);
        });
    }
}