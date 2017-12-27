package com.jenish9599.android.masterdetaildemo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jenishpatel on 27/12/17.
 */

public class Item implements Serializable{


    private static final long serialVersionUID = -1213949467658913456L;

    private String title;
    private String body;

    public Item(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return getTitle();
    }

    public static ArrayList<Item> getItems(){
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Item 1", "This is the first item"));
        items.add(new Item("Item 2", "This is the second item"));
        items.add(new Item("Item 3", "This is the third item"));
        return items;
    }
}