package com.tp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tp1.adapter.RecyclerAdapter;
import com.tp1.model.User;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_new_user;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private List<User> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        usersList = new ArrayList<User>();

        User fa = new User("fa", "ox", "180972", "0002256", "rennes", "ille et vilaine");
        User fa1 = new User("fafa", "oxi", "180972", "0002256", "rennes", "ille et vilaine");
        User fa2 = new User("fafa1", "oxa", "180972", "0002256", "rennes", "ille et vilaine");
        User fa3 = new User("fa", "ox", "180972", "0002256", "rennes", "ille et vilaine");
        User fa4 = new User("fafa", "oxi", "180972", "0002256", "rennes", "ille et vilaine");
        User fa5 = new User("fafa1", "oxa", "180972", "0002256", "rennes", "ille et vilaine");
        User fa6= new User("fa", "ox", "180972", "0002256", "rennes", "ille et vilaine");
        User fa7 = new User("fafa", "oxi", "180972", "0002256", "rennes", "ille et vilaine");
        User fa8 = new User("fafa1", "oxa", "180972", "0002256", "rennes", "ille et vilaine");
        User fa9= new User("fa", "ox", "180972", "0002256", "rennes", "ille et vilaine");
        User fa10 = new User("fafa", "oxi", "180972", "0002256", "rennes", "ille et vilaine");
        User fa11= new User("fafa1", "oxa", "180972", "0002256", "rennes", "ille et vilaine");
        User fa12 = new User("fa", "ox", "180972", "0002256", "rennes", "ille et vilaine");
        User fa13= new User("fafa", "oxi", "180972", "0002256", "rennes", "ille et vilaine");
        User fa14 = new User("fafa1", "oxa", "180972", "0002256", "rennes", "ille et vilaine");

        this.usersList.add(fa);
        this.usersList.add(fa1);
        this.usersList.add(fa2);
        this.usersList.add(fa3);
        this.usersList.add(fa4);
        this.usersList.add(fa5);
        this.usersList.add(fa6);
        this.usersList.add(fa7);
        this.usersList.add(fa8);
        this.usersList.add(fa9);
        this.usersList.add(fa10);
        this.usersList.add(fa11);
        this.usersList.add(fa12);

        setContentView(R.layout.activity_recycler);

        button_new_user =findViewById(R.id.button_new_user);
        button_new_user.setOnClickListener(this);


        // handle the recycler view
        recyclerView = findViewById(R.id.recycler_view);
        recyclerAdapter = new RecyclerAdapter(this.usersList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

    }

    @Override
    public void onClick(View v) {
        Log.i("info", "click in RecyclerActivity");
        Intent recycler_intent = new Intent(getApplicationContext(), UserActivity.class);
        startActivityForResult(recycler_intent, 0);
    }

    //methode apelle lors du retour du bouton valider de UserActivity
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        Log.i("info", "retour de User Activity");
        Bundle extras = intent.getExtras();

        User user = intent.getParcelableExtra("user");
        usersList.add(user);
        recyclerAdapter.notifyDataSetChanged();
    }
}
