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

    Button Bt1, Bt2, Bt3, Bt4, Bt5, Bt6, Bt7, Bt8, back;
    RelativeLayout parent;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        parent=findViewById(R.id.parent_layout);
        Bt1 = findViewById(R.id.I_have_a_system_how_can_I_now_create_my_garden);


        Bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow1();
            }
        });


        back = findViewById(R.id.BACK_TO_MENU_PAGE);


        back.setOnClickListener(view -> {
            Intent intent = new Intent(HelpActivity.this, MainMenuPageActivity.class);
            startActivity(intent);
        });
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

}