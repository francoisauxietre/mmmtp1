package com.tp1;
//author Francois auxietre mail.auxietre@gmail.com

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button_user;
    private Button button_game;
    private Menu menu = null;
    private String number_text="__"; //on passe le numero de telephone vide pour l'instant


    @Override
    /**
     * methode par default
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.button_user = findViewById(R.id.button_user);

        button_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user_activity_intent = new Intent(getApplicationContext(), com.tp1.UserActivity.class);
                //passage du numero entre deux Activity
                user_activity_intent.putExtra("PHONE_NUMBER", number_text);
                startActivity(user_activity_intent);
                finish();
            }
        });

        this.button_game = findViewById(R.id.button_jeu);

        button_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game_intent = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(game_intent);
                finish();
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
        inflater.inflate(R.menu.menu_main, menu);

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
        if (id == R.id.action_settings) {
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

    public void reset_form(MenuItem item) {
            Log.i("info", "methode resest form");
//        ((TextInputLayout)findViewById(R.id.input_nom)).getEditText().setText("");
//        ((TextInputLayout)findViewById(R.id.input_prenom)).getEditText().setText("");
//        ((TextInputLayout)findViewById(R.id.input_ville)).getEditText().setText("");
//        ((EditText)findViewById(R.id.input_dob)).setText("");
    }


}