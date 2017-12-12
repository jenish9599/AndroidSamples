package com.jenish9599.android.asynctaskloader;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{


    private Button button;
    private TextView textView;

    private LoaderManager loaderManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.Result);
        button = (Button)findViewById(R.id.button);

        loaderManager = getLoaderManager();


        if(loaderManager.getLoader(1)!=null)
        {
            loaderManager.initLoader(1,null,this);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s();

            }
        });
    }


    public void s(){
        loaderManager.initLoader(1, null, this);
    }
    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        return new MyAyncTaskLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        textView.setText(data);

    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
