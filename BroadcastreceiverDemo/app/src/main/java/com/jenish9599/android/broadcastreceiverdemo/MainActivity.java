package com.jenish9599.android.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private TextView textView;
    private RecyclerView.LayoutManager layoutManager;


    private BroadcastReceiver broadcastReceiver;


    private ArrayList<IncomingNumbers> arrayList = new ArrayList<>();

    private Adeptor adeptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        textView = (TextView)findViewById(R.id.textview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adeptor = new Adeptor(arrayList);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adeptor);
        readFromDb();


        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                readFromDb();
            }
        };
    }


    @Override
    protected void onResume() {
        super.onResume();

        registerReceiver(broadcastReceiver,new IntentFilter(DbContract.UPDATE_UI_FILTER));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    private void readFromDb(){

        arrayList.clear();
        DBHelper dbHelper = new DBHelper(this);

        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        Cursor cursor = dbHelper.readNumber(sqLiteDatabase);


        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                String number ;
                int id ;
                number = cursor.getString(cursor.getColumnIndex(DbContract.INCOMING_NUMBER));

                id = cursor.getInt(cursor.getColumnIndex("id"));

                arrayList.add( new IncomingNumbers(id,number));
            }
            cursor.close();
            dbHelper.close();
            adeptor.notifyDataSetChanged();
            recyclerView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
        }

    }
}
