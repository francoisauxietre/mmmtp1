package com.tp1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    private Button buttonValidate;
    private Button buttonSubmit;
    private String first_name_text;
    private String last_name_text;
    private String town_text;
    private String birth_text;
    private EditText birth_edit_text;
    private EditText first_name_edit_text;
    private EditText last_name_edit_text;
    private EditText town_edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //ne pas oublier de assigner avec findViewById sinon l'application crach

        this.buttonValidate = findViewById(R.id.button_validate);
        this.buttonValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                verification de l'action du bouton
                Log.i("info", "button_validate clicked");


                //                recuperation des donnees
                first_name_edit_text = (EditText)findViewById(R.id.first_name_edit_text);
                first_name_text = first_name_edit_text.getText().toString();
                Log.i("info", first_name_text);

                //                recuperation des donnees
                last_name_edit_text = (EditText)findViewById(R.id.last_name_edit_text);
                last_name_text = last_name_edit_text.getText().toString();
                Log.i("info", last_name_text);

//                recuperation des donnees
                birth_edit_text = (EditText)findViewById(R.id.birth_edit_text);
                birth_text = birth_edit_text.getText().toString();
                Log.i("info", birth_text);


                //                recuperation des donnees
                town_edit_text = (EditText)findViewById(R.id.town_edit_text);
                town_text = town_edit_text.getText().toString();
                Log.i("info", town_text);


            }
        });

        this.buttonSubmit = findViewById(R.id.button_submit);
        this.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("info", "button_submit clicked");
            }
        });
    }





}
