package com.jenish9599.android.animation2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final TextView hello = (TextView)findViewById(R.id.hello);
//        final ObjectAnimator anim = ObjectAnimator.ofFloat(hello, "alpha", 0.2f);
//        anim.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                Toast.makeText(MainActivity.this, "End!", Toast.LENGTH_SHORT).show();
//            }
//        });


        ObjectAnimator anim1 = ObjectAnimator.ofFloat(hello, "scaleX", 2.0f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(hello, "scaleY", 2.0f);
        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(anim1, anim2);
// Define second set of animations
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(hello, "X", 300);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(hello, "Y", 300);
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(anim3, anim4);
// Play the animation sets one after another
        AnimatorSet set3 = new AnimatorSet();
        set3.playSequentially(set1, set2);
        set3.start();



//        hello.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                anim.start();
//            }
//        });

    }
}
