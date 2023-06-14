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

public class Statistics_lightActivity extends AppCompatActivity {

    private TextView water_AVG;
    TextView avg, stat_head,water_head;
    Button back,graph;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_light);

        water_AVG = findViewById(R.id.waterAVG);
        back = findViewById(R.id.back_button);
        avg = findViewById(R.id.average_headline);
        stat_head = findViewById(R.id.stat_headline);
        water_head = findViewById(R.id.water_headline);
        graph = findViewById(R.id.graph_button);


        //showing database info in a var
        DatabaseReference statisticsRef = FirebaseDatabase.getInstance().getReference().child("statistics");
        statisticsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot waterLevelSnapshot = dataSnapshot.child("LDR value").child("Average");
                Double waterLevelAverage = waterLevelSnapshot.getValue(Double.class);
                water_AVG.setText(String.valueOf(waterLevelAverage));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });


        //graph button
        graph.setOnClickListener(view -> {
            Intent intent = new Intent(Statistics_lightActivity.this, Statistics_lightActivityGrpah.class);
            startActivity(intent);
        });

        //back button
        back.setOnClickListener(view -> {
            Intent intent = new Intent(Statistics_lightActivity.this, StatisticsActivity.class);
            startActivity(intent);
        });
    }
}