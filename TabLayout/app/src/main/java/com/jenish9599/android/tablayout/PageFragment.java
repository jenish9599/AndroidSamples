package com.jenish9599.android.tablayout;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jenishpatel on 27/12/17.
 */

public class PageFragment extends android.support.v4.app.Fragment {


    public static final String ARG_PAGE = "ARG_PAGE";


    private int mPage;


    public static PageFragment newInstance(int page){
        Bundle args = new Bundle();
        PageFragment pageFragment = new PageFragment();
        args.putInt(ARG_PAGE,page);
        pageFragment.setArguments(args);

        return pageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_page,container,false);
        TextView textView = (TextView)v;
        textView.setText("Fragment #" + mPage);
        return v;
    }



}
