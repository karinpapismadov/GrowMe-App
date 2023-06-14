package com.example.growme_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    RelativeLayout parent;
    Button Bt1, Bt2, Bt3, Bt4, Bt5, Bt6, Bt7, Bt8, Bt9;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        parent=findViewById(R.id.parent_layout);
        Bt1 = findViewById(R.id.I_have_a_system_how_can_I_now_create_my_garden);
        Bt2 = findViewById(R.id.How_can_I_add_a_plant_into_my_garden);
        Bt3 = findViewById(R.id.system_number_where_is_it);
        Bt4 = findViewById(R.id.How_can_I_reset_my_garden_with_new_plants);
        Bt5 = findViewById(R.id.What_plants_are_recommended_for_gardening);
        Bt6 = findViewById(R.id.What_is_recommended_to_add_to_the_plant_water);
        Bt7 = findViewById(R.id.How_do_I_get_the_system_to_work);
        Bt8 = findViewById(R.id.What_supplies_I_need_to_start_gardening);
        Bt9 = findViewById(R.id.BACK_TO_MENU_PAGE);

        Bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow1();
            }
        });
        Bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow2();
            }
        });
        Bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow3();
            }
        });
        Bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow4();
            }
        });
        Bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow5();
            }
        });
        Bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow6();
            }
        });
        Bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow7();
            }
        });
        Bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow8();
            }
        });

        Bt9.setOnClickListener(view -> startActivity(new Intent(HelpActivity.this, MainMenuPageActivity.class)));

    }

    private void showPopupWindow1(){
        View view=View.inflate(this, R.layout.popup_layout, null);
        Button close=view.findViewById(R.id.close_pop);
        TextView body1=view.findViewById(R.id.popup_msg);
        int width= LinearLayout.LayoutParams.WRAP_CONTENT;
        int height= LinearLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow=new PopupWindow(view, width,height,false);
        popupWindow.showAtLocation(parent, Gravity.CENTER, 0,0);
        body1.setText(R.string.message1);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
    private void showPopupWindow2(){
        View view=View.inflate(this, R.layout.popup_layout, null);
        Button close=view.findViewById(R.id.close_pop);
        TextView body2=view.findViewById(R.id.popup_msg);
        int width= LinearLayout.LayoutParams.WRAP_CONTENT;
        int height= LinearLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow=new PopupWindow(view, width,height,false);
        popupWindow.showAtLocation(parent, Gravity.CENTER, 0,0);
        body2.setText(R.string.message2);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
    private void showPopupWindow3(){
        View view=View.inflate(this, R.layout.popup_layout, null);
        Button close=view.findViewById(R.id.close_pop);
        TextView body3=view.findViewById(R.id.popup_msg);
        int width= LinearLayout.LayoutParams.WRAP_CONTENT;
        int height= LinearLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow=new PopupWindow(view, width,height,false);
        popupWindow.showAtLocation(parent, Gravity.CENTER, 0,0);
        body3.setText(R.string.message3);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
    private void showPopupWindow4(){
        View view=View.inflate(this, R.layout.popup_layout, null);
        Button close=view.findViewById(R.id.close_pop);
        TextView body4=view.findViewById(R.id.popup_msg);
        int width= LinearLayout.LayoutParams.WRAP_CONTENT;
        int height= LinearLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow=new PopupWindow(view, width,height,false);
        popupWindow.showAtLocation(parent, Gravity.CENTER, 0,0);
        body4.setText(R.string.message4);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
    private void showPopupWindow5(){
        View view=View.inflate(this, R.layout.popup_layout, null);
        Button close=view.findViewById(R.id.close_pop);
        TextView body5=view.findViewById(R.id.popup_msg);
        int width= LinearLayout.LayoutParams.WRAP_CONTENT;
        int height= LinearLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow=new PopupWindow(view, width,height,false);
        popupWindow.showAtLocation(parent, Gravity.CENTER, 0,0);
        body5.setText(R.string.message5);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
    private void showPopupWindow6(){
        View view=View.inflate(this, R.layout.popup_layout, null);
        Button close=view.findViewById(R.id.close_pop);
        TextView body6=view.findViewById(R.id.popup_msg);
        int width= LinearLayout.LayoutParams.WRAP_CONTENT;
        int height= LinearLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow=new PopupWindow(view, width,height,false);
        popupWindow.showAtLocation(parent, Gravity.CENTER, 0,0);
        body6.setText(R.string.message6);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
    private void showPopupWindow7(){
        View view=View.inflate(this, R.layout.popup_layout, null);
        Button close=view.findViewById(R.id.close_pop);
        TextView body7=view.findViewById(R.id.popup_msg);
        int width= LinearLayout.LayoutParams.WRAP_CONTENT;
        int height= LinearLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow=new PopupWindow(view, width,height,false);
        popupWindow.showAtLocation(parent, Gravity.CENTER, 0,0);
        body7.setText(R.string.message7);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
    private void showPopupWindow8(){
        View view=View.inflate(this, R.layout.popup_layout, null);
        Button close=view.findViewById(R.id.close_pop);
        TextView body8=view.findViewById(R.id.popup_msg);
        int width= LinearLayout.LayoutParams.WRAP_CONTENT;
        int height= LinearLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow=new PopupWindow(view, width,height,false);
        popupWindow.showAtLocation(parent, Gravity.CENTER, 0,0);
        body8.setText(R.string.message8);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }


}