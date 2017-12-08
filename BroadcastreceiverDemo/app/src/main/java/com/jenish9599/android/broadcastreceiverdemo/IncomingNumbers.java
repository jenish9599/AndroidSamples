package com.jenish9599.android.broadcastreceiverdemo;

/**
 * Created by jenishpatel on 08/12/17.
 */

public class IncomingNumbers {

    private int id;
    private String number;

    public IncomingNumbers(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
