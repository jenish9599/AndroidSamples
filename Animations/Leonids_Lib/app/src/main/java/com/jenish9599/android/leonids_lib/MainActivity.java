package com.jenish9599.android.leonids_lib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.plattysoft.leonids.ParticleSystem;

import static com.jenish9599.android.leonids_lib.R.drawable.dots;
import static com.jenish9599.android.leonids_lib.R.drawable.star;


public class MainActivity extends AppCompatActivity{




    private ParticleSystem particleSystem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        particleSystem = new ParticleSystem(this, 500, R.drawable.star, 2000);
                particleSystem.setSpeedRange(0.2f, 0.5f)
                .emit((int)event.getX(),(int)event.getY(),50,200);
        return true;
    }

}
