package com.jenish9599.android.gallery;

import android.app.Fragment;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {


    public ArrayList<ImageModel> data = new ArrayList<>();
    int pos;
    Toolbar toolbar;
    private ViewPager viewPager;

    private SectionsPagerAdapter sectionsPagerAdapter;

    private ClickableViewPager clickableViewPager;
    private static ActionBar actionBar;
    private  static Window window;
    private static Boolean flag = false;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        toolbar = (Toolbar)findViewById(R.id.detail_toolbar);
        viewPager = (ViewPager)findViewById(R.id.container);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        window = getWindow();
        data = getIntent().getParcelableArrayListExtra("data");
        pos = getIntent().getIntExtra("pos",0);

        setTitle(data.get(pos).getName());

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),data);
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.setCurrentItem(pos);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setTitle(data.get(position).getName());


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });







    }




    public class SectionsPagerAdapter extends FragmentPagerAdapter{


        ArrayList<ImageModel> data = new ArrayList<>();


        public SectionsPagerAdapter(FragmentManager fm,ArrayList<ImageModel> data) {
            super(fm);
            this.data = data;
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position,data.get(position).getName().toString(),data.get(position).getUrl().toString());
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return data.get(position).getName();
        }
    }



    public static class PlaceholderFragment extends android.support.v4.app.Fragment {
        String name, url;
        int pos;
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String ARG_IMG_TITLE = "image_title";
        private static final String ARG_IMG_URL = "image_url";

        @Override
        public void setArguments(Bundle args) {
            super.setArguments(args);
            this.pos = args.getInt(ARG_SECTION_NUMBER);
            this.name = args.getString(ARG_IMG_TITLE);
            this.url = args.getString(ARG_IMG_URL);
        }

        public static PlaceholderFragment newInstance(int sectionNumber, String name, String url) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putString(ARG_IMG_TITLE, name);
            args.putString(ARG_IMG_URL, url);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public void onStart() {
            super.onStart();

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

            final ImageView imageView = (ImageView) rootView.findViewById(R.id.detail_image);
            Glide.with(getActivity()).load(url).thumbnail(0.1f).into(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(flag == false) {
                        window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        actionBar.hide();
                        flag = true;
                    }else {
                        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        window.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                        actionBar.show();
                        flag = false;
                    }
                }
            });

            return rootView;
        }
    }

}
