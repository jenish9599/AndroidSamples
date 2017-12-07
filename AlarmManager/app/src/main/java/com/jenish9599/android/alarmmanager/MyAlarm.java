package com.jenish9599.android.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.audiofx.BassBoost;
import android.provider.Settings;

/**
 * Created by jenishpatel on 08/12/17.
 */

public class MyAlarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        MediaPlayer mediaPlayer = MediaPlayer.create(context,Settings.System.DEFAULT_NOTIFICATION_URI);

        int i=0;
        while(i < 10000000) {
            mediaPlayer.start();
        }
    }
}
