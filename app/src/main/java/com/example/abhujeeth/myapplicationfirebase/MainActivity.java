package com.example.abhujeeth.myapplicationfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button,buttonone;
    RecyclerView recyclerView;
    List viewobjects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.buttonone);
       buttonone=(Button)findViewById(R.id.buttontwo);

       button.setOnClickListener(this);
        buttonone.setOnClickListener(this);

        initializeRecyclerView();
        makeRecyclerObjects();

    }

    private void makeRecyclerObjects() {

        viewobjects=new ArrayList<>();
        ModelClass objone=new ModelClass("Download notes for any class",R.drawable.notes);
        viewobjects.add(objone);
        ModelClass objtwo=new ModelClass("Get admission online on discount",R.drawable.adm);
        viewobjects.add(objtwo);
        ModelClass objthree=new ModelClass("Get QuestionBanks and Guesspapers",R.drawable.questionbank);
        viewobjects.add(objthree);
        ModelClass objfour=new ModelClass("Hi",R.drawable.notes);
        viewobjects.add(objfour);
        RecyclerView.Adapter adapter = new MyAdapter(MainActivity.this, viewobjects);
        recyclerView.setAdapter(adapter);

    }

    private void initializeRecyclerView() {
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public void onClick(View v) {

        if(v==button)
        {
            Intent intent = new Intent(MainActivity.this,Registration.class);
            startActivity(intent);
        }

        if(v==buttonone)
        {
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }

    }
}
