package com.example.growme_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelpActivity extends AppCompatActivity {

    Button Bt1, Bt2, Bt3, Bt4, Bt5, Bt6, Bt7, Bt8, back;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);


        Bt1 = findViewById(R.id.I_have_a_system_how_can_I_now_create_my_garden);
        Bt2 = findViewById(R.id.How_can_I_add_a_plant_into_my_garden);
        Bt3 = findViewById(R.id.system_number_where_is_it);
        Bt4 = findViewById(R.id.How_can_I_reset_my_garden_with_new_plants);
        Bt5 = findViewById(R.id.What_plants_are_recommended_for_gardening);
        Bt6 = findViewById(R.id.What_is_recommended_to_add_to_the_plant_water);
        Bt7 = findViewById(R.id.How_do_I_get_the_system_to_work);
        Bt8 = findViewById(R.id.What_supplies_I_need_to_start_gardening);

        Bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpActivity.this, PopHelpBt1.class));
            }
        });

        Bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpActivity.this, PopHelpBt2.class));
            }
        });
        Bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpActivity.this, PopHelpBt3.class));
            }
        });
        Bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpActivity.this, PopHelpBt4.class));
            }
        });
        Bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpActivity.this, PopHelpBt5.class));
            }
        });
        Bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpActivity.this, PopHelpBt6.class));
            }
        });
        Bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpActivity.this, PopHelpBt7.class));
            }
        });
        Bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpActivity.this, PopHelpBt8.class));
            }
        });



        back = findViewById(R.id.BACK_TO_MENU_PAGE);


        back.setOnClickListener(view -> {
            Intent intent = new Intent(HelpActivity.this, MainMenuPageActivity.class);
            startActivity(intent);
        });
    }
}
