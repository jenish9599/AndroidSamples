package com.jenish9599.android.sensey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.nisrulz.sensey.Sensey;
import com.github.nisrulz.sensey.ShakeDetector;

public class MainActivity extends AppCompatActivity {

    private Sensey sensey;

    @Override
    protected void onDestroy() {


        Sensey.getInstance().stop();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Sensey.getInstance().init(getApplicationContext());

        ShakeDetector.ShakeListener shakeListener = new ShakeDetector.ShakeListener() {
            @Override
            public void onShakeDetected() {
                Toast.makeText(getApplicationContext(),"Shaking Detedted",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onShakeStopped() {
                Toast.makeText(getApplicationContext(),"Shaking Stoped",Toast.LENGTH_SHORT).show();
            }
        };

        Sensey.getInstance().startShakeDetection(shakeListener);

    }
}
