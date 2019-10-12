package com.tp1;


import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

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
    private String final_submit_text;
    private String final_text;
    private RatingBar rating_bar;

    private Menu menu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);

        this.buttonValidate = findViewById(R.id.button_validate);
        this.buttonValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                verification de l'action du bouton
                Log.i("info", "button_validate clicked");


                //                recuperation des donnees
                first_name_edit_text = (EditText) findViewById(R.id.first_name_edit_text);
                first_name_text = first_name_edit_text.getText().toString();
                Log.i("info", first_name_text);

                //                recuperation des donnees
                last_name_edit_text = (EditText) findViewById(R.id.last_name_edit_text);
                last_name_text = last_name_edit_text.getText().toString();
                Log.i("info", last_name_text);

//                recuperation des donnees
                birth_edit_text = (EditText) findViewById(R.id.birth_edit_text);
                birth_text = birth_edit_text.getText().toString();
                Log.i("info", birth_text);


                //                recuperation des donnees
                town_edit_text = (EditText) findViewById(R.id.town_edit_text);
                town_text = town_edit_text.getText().toString();
                Log.i("info", town_text);

                final_text = "f_name " + first_name_text + "\n l_name " + last_name_text + "\n town " + town_text;
                Toast.makeText(getApplicationContext(), final_text, Toast.LENGTH_SHORT).show();


            }
        });

        this.buttonSubmit = findViewById(R.id.button_submit);
        this.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("info", "button_submit clicked");
                rating_bar = findViewById(R.id.ratingBar);

                final_submit_text = "submit " + rating_bar.getRating();
                Toast.makeText(getApplicationContext(),
                        final_submit_text, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    /**
     *
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        //R.menu.menu est l'id de notre menu
        inflater.inflate(R.menu.menu_user, menu);

        // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    /**
     *
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        //les actions sont definies dans les methodes ci dessous et dans le fichier menu_main
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings_user) {
            return true;
        }


        switch (id) {
            case R.id.reset_form:
                //Dans le Menu "m", on active tous les items dans le groupe d'identifiant "R.id.group2"
                menu.setGroupEnabled(R.id.reset_form, true);
                return true;

            case R.id.add_form:
                menu.setGroupEnabled(R.id.add_form, true);
                return true;

            default: {
                throw new IllegalStateException("Inapropriate value please check in mainActivity: " + item.getItemId());
            }

        }


        //return super.onOptionsItemSelected(item);
    }

    public void reset_form_click(MenuItem item) {
        Log.i("info", "methode resest form");
        ((EditText) findViewById(R.id.first_name_edit_text)).setText("");
        ((EditText) findViewById(R.id.last_name_edit_text)).setText("");
        ((EditText) findViewById(R.id.birth_edit_text)).setText("");
        ((EditText) findViewById(R.id.town_edit_text)).setText("");
        ((RatingBar) findViewById(R.id.ratingBar)).setRating(0);

    }


}