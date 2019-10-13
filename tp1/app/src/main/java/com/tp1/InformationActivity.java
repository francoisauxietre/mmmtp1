package com.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.tp1.model.User;

public class InformationActivity extends AppCompatActivity {

    private String first_name;
    private String last_name;
    private String birth;
    private String phone_number;
    private int ratingbar;
    private int image;

    private User user ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Intent intent = getIntent();
        User user = intent.getParcelableExtra("user");

        first_name = user.getFirst_name();
        last_name = user.getLast_name();
        birth = user.getBirth();
        phone_number = user.getPhone_number();

        TextView first_name_text = findViewById(R.id.first_name_information_text);
        first_name_text.setText(first_name);

        TextView last_name_text = findViewById(R.id.last_name_information_text);
        last_name_text.setText(last_name);

        TextView birth_text = findViewById(R.id.birth_information_text);
        birth_text.setText(birth);

        TextView phone_number_text = findViewById(R.id.phone_number_information_text);
        phone_number_text.setText(phone_number);
    }
}
