package com.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PhoneActivity extends AppCompatActivity {
    private Button button_save;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;

    private Button button_delete_number;
    private TextView phone_number_textview;
    private String number_text = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone);

        this.button_save = findViewById(R.id.button_save_phone);

        this.phone_number_textview = findViewById(R.id.phone_number_textview);
        this.phone_number_textview.setText(number_text);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("info", "retourne a UserActivity");
                Intent user_activity_intent = new Intent(getApplicationContext(), com.tp1.UserActivity.class);
                //passage du numero entre deux Activity
                user_activity_intent.putExtra("PHONE_NUMBER", number_text);
                startActivity(user_activity_intent);
                finish();
            }
        });

        this.button_delete_number = findViewById(R.id.button_delete_number);
        button_delete_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("info", "efface numero onClick in PhoneActivity");
                int number_length = number_text.length();

                //verification que le numero a aumoins un caracterre
                if (number_length>=1){
                number_text = number_text.substring(0, number_length - 1);
                phone_number_textview.setText(number_text);}

            }
        });

        this.button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("info", "nombre 1");
                number_text += "1";
                phone_number_textview.setText(number_text);
            }
        });

        this.button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("info", "nombre 2");
                number_text += "2";
                phone_number_textview.setText(number_text);
            }
        });

        this.button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number_text += "3";
                phone_number_textview.setText(number_text);
            }
        });

        this.button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number_text += "4";
                phone_number_textview.setText(number_text);
            }
        });
        this.button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number_text += "5";
                phone_number_textview.setText(number_text);
            }
        });
        this.button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number_text += "6";
                phone_number_textview.setText(number_text);
            }
        });
        this.button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number_text += "7";
                phone_number_textview.setText(number_text);
            }
        });
        this.button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number_text += "8";
                phone_number_textview.setText(number_text);
            }
        });
        this.button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number_text += "9";
                phone_number_textview.setText(number_text);
            }
        });



    }
}

//Intent intent = new Intent(getBaseContext(), SignoutActivity.class);
//intent.putExtra("EXTRA_SESSION_ID", sessionId);
//startActivity(intent);
//Access that intent on next activity:
//
//String sessionId = getIntent().getStringExtra("EXTRA_SESSION_ID");