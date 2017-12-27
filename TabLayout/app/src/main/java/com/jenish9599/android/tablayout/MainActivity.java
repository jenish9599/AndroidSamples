package com.jenish9599.android.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private int[] imageResId = {
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdaptor(getSupportFragmentManager(),this);
        viewPager.setAdapter(pagerAdapter);


        TabLayout tabLayout = (TabLayout)findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


         for (int i = 0; i < tabLayout.getTabCount(); i++) {
        TabLayout.Tab tab = tabLayout.getTabAt(i);
        tab.setCustomView(getView(i+1));
    }
    }


    private View getView(int position){
        View  v =  LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_tab,null);
        TextView t = v.findViewById(R.id.textView);
        t.setText(position+ "");
        return v;
    }

}
