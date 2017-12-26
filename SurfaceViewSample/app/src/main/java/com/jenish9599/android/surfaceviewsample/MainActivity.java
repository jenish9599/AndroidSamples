package com.jenish9599.android.surfaceviewsample;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener {


    private SurfaceView surfaceView;
    private MediaPlayer mediaPlayer;
    private SurfaceHolder surfaceHolder;
    private static final String VIDEO_PATH = "http://r6---sn-ci5gup-qxaz.googlevideo.com/videoplayback?expire=1514324358&mime=video%2Fmp4&key=cms1&id=o-ALVWGW1-UDdeeIp8ah1BlKv58G1b3nBzKnY4J_jv3Cpf&gcr=in&ipbits=0&sparams=dur,ei,expire,gcr,id,initcwndbps,ip,ipbits,itag,lmt,mime,mip,mm,mn,ms,mv,pl,ratebypass,source&ei=Jm1CWpO_NMuCowOAuqGACg&itag=18&ip=13.127.16.95&lmt=1509072329663158&source=youtube&ratebypass=yes&dur=402.750&pl=22&signature=40C9B8336FFFC52DFE2F6CEFE6E26694C69853F3.06A3110913CD0E53B6C8DFDFD202DA3839CA0E58&video_id=BQ0mxQXmLsk&title=Camila+Cabello+-+Havana+ft.+Young+Thug&cms_redirect=yes&mip=106.213.164.235&mm=31&mn=sn-ci5gup-qxaz&ms=au&mt=1514303276&mv=m";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        surfaceView = (SurfaceView)findViewById(R.id.SurfaceLayout);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(MainActivity.this);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDisplay(surfaceHolder);
        try {

            mediaPlayer.setDataSource(VIDEO_PATH);
            mediaPlayer.prepare();
            mediaPlayer.setOnPreparedListener(MainActivity.this);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {

        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }
}
