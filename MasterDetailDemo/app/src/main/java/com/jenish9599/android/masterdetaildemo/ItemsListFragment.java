package com.jenish9599.android.masterdetaildemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by jenishpatel on 27/12/17.
 */

public class ItemsListFragment extends Fragment {


    private OnListItemSelectedListener listener;

    public interface OnListItemSelectedListener{
        public void onItemSelected(Item item);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof OnListItemSelectedListener){
            listener = (OnListItemSelectedListener)context;
        }
        else{
            throw new ClassCastException(
                    context.toString()
                            + " must implement ItemsListFragment.OnListItemSelectedListener");
        }
    }

    private ArrayAdapter<Item> adapterItems;
    private ListView lvItems;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Item> items = Item.getItems();
        adapterItems = new ArrayAdapter<Item>(getActivity(),
                android.R.layout.simple_list_item_activated_1, items);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items_list,container,false);
        lvItems = (ListView) view.findViewById(R.id.lvItems);
        lvItems.setAdapter(adapterItems);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = adapterItems.getItem(position);
                listener.onItemSelected(item);
            }
        });
        return view;
    }

    public void setActivateOnItemClick(boolean activateOnItemClick) {


        lvItems.setChoiceMode(
                activateOnItemClick ? ListView.CHOICE_MODE_SINGLE
                        : ListView.CHOICE_MODE_NONE);
    }
}
