package com.jenish9599.android.recyclerviewsnap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;



    private ArrayList<DataModel> data = new ArrayList<>();

    private Adaptor adaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        data.add(new DataModel("1","ehfghkja"));
        data.add(new DataModel("2","ehfghkja"));
        data.add(new DataModel("3","ehfghkja"));
        data.add(new DataModel("4","ehfghkja"));
        data.add(new DataModel("5","ehfghkja"));
        data.add(new DataModel("6","ehfghkja"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));



        SnapHelper snapHelperTop = new GravitySnapHelper(Gravity.TOP);
        snapHelperTop.attachToRecyclerView(recyclerView);

        adaptor = new Adaptor(data);


        recyclerView.setAdapter(adaptor);


        adaptor.notifyDataSetChanged();

    }
}
