package com.example.growme_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class HelpActivity extends AppCompatActivity {

    Button Bt1, Bt2, Bt3, Bt4, Bt5, Bt6, Bt7, Bt8, Bt9;

    @SuppressLint("MissingInflatedId")
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
        Bt9 = findViewById(R.id.BACK_TO_MENU_PAGE);

        //Bt1.setOnClickListener(view -> startActivity(new Intent(HelpActivity.this, Bt1Activity.class)));
        //Bt2.setOnClickListener(view -> startActivity(new Intent(HelpActivity.this, Bt2Activity.class)));
        //Bt3.setOnClickListener(view -> startActivity(new Intent(HelpActivity.this, Bt3Activity.class)));
        //Bt4.setOnClickListener(view -> startActivity(new Intent(HelpActivity.this, Bt4Activity.class)));
        //Bt5.setOnClickListener(view -> startActivity(new Intent(HelpActivity.this, Bt5Activity.class)));
        //Bt6.setOnClickListener(view -> startActivity(new Intent(HelpActivity.this, Bt6Activity.class)));
        //Bt7.setOnClickListener(view -> startActivity(new Intent(HelpActivity.this, Bt7Activity.class)));
        //Bt8.setOnClickListener(view -> startActivity(new Intent(HelpActivity.this, Bt8Activity.class)));
        Bt9.setOnClickListener(view -> startActivity(new Intent(HelpActivity.this, MainMenuPageActivity.class)));



    }
}