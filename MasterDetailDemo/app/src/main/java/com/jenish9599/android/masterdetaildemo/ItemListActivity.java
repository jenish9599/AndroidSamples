package com.jenish9599.android.masterdetaildemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity implements ItemsListFragment.OnListItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);



    }


    @Override
    public void onItemSelected(Item item) {
        Intent i = new Intent(this, ItemDetailActivity.class);
        i.putExtra("item", item);
        startActivity(i);
    }
}
