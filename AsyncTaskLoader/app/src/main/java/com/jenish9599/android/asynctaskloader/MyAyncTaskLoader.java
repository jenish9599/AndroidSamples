package com.jenish9599.android.asynctaskloader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

/**
 * Created by jenishpatel on 12/12/17.
 */

public class MyAyncTaskLoader extends AsyncTaskLoader<String> {



    public MyAyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    public String loadInBackground() {
        for(int i=0;i<=100;i++)
        {
            try {
                Thread.sleep(50);
                Log.d("TAG","loadInBackground :  " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "Task Result";
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
