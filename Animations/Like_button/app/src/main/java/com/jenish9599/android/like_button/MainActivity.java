package com.jenish9599.android.like_button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.like.LikeButton;
import com.like.OnLikeListener;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    private LikeButton likeButton1 ;
    private LikeButton likeButton2;
    private LikeButton likeButton3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeButton1 = (LikeButton)findViewById(R.id.heart_button);
        likeButton1.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                Toast.makeText(getApplicationContext(),"Love", LENGTH_SHORT).show();


            }

            @Override
            public void unLiked(LikeButton likeButton) {

            }
        });


        likeButton2 = (LikeButton)findViewById(R.id.star_button);
        likeButton2.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                Toast.makeText(getApplicationContext(),"Stared ",LENGTH_SHORT).show();
            }

            @Override
            public void unLiked(LikeButton likeButton) {

            }
        });

        likeButton3 = (LikeButton)findViewById(R.id.thumb_button);
        likeButton3.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                Toast.makeText(getApplicationContext(),"Liked",LENGTH_SHORT).show();
            }

            @Override
            public void unLiked(LikeButton likeButton) {

            }
        });
    }

}
