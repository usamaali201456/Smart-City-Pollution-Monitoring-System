package com.example.smd_assignment3_question1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class recycleractual extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleractual);
        String [] names={"Shamoon","Shahid"} ;
        RecyclerView programminglist=(RecyclerView) findViewById(R.id.my_recycler_view);
        programminglist.setLayoutManager(new LinearLayoutManager(this));
        programminglist.setAdapter(new ProgrammingAdapter(names));

    }
}
