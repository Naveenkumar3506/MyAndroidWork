package com.naveen.testapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class ListTableView extends AppCompatActivity {

    RecyclerView rvListNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_table_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        rvListNames = findViewById(R.id.rvNameList);

        ArrayList<User> usersList = new ArrayList<>();

        User user =new User();
        user.setName("Muthu");
        user.setPhone("0123456");

        usersList.add(user);

        user =new User();
        user.setName("Naveen");
        user.setPhone("00000000");

        usersList.add(user);

        AdapterListTableView adapterListTableView = new AdapterListTableView(usersList,this);



        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvListNames.setLayoutManager(mLayoutManager);
        rvListNames.setItemAnimator(new DefaultItemAnimator());

        rvListNames.setAdapter(adapterListTableView);


    }

}
