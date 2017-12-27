package com.jenish9599.android.masterdetaildemo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ItemDetailActivity extends AppCompatActivity {


    ItemDetailFragment itemDetailFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Item item = (Item) getIntent().getSerializableExtra("item");
        if (savedInstanceState == null) {

            itemDetailFragment = ItemDetailFragment.newInstance(item);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, itemDetailFragment);
            ft.commit();
        }
    }
}
