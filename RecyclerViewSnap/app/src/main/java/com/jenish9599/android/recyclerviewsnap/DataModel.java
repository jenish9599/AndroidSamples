package com.jenish9599.android.recyclerviewsnap;

/**
 * Created by jenishpatel on 12/12/17.
 */

public class DataModel {
    String body ;
    String img;

    public DataModel(String body, String img) {
        this.body = body;
        this.img = img;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
