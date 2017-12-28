package com.jenish9599.android.notificationsample;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.RemoteInput;

/**
 * Created by jenishpatel on 29/12/17.
 */

public class DirectReplyIntent extends IntentService{
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */


    public static String KEY_TEXT_REPLY = "key_text_reply";
    public static String KEY_NOTIFY_ID = "key_notify_id";

    public DirectReplyIntent() {
        super("DirectReplyIntent");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        CharSequence directReply = getMessageText(intent);
        if (directReply != null) {
            Notification repliedNotification =
                    new NotificationCompat.Builder(DirectReplyIntent.this)
                            .setSmallIcon(R.drawable.ic_launcher_background)
                            .setContentText("Received: " + directReply)
                            .build();

            NotificationManager notificationManager = (NotificationManager) getSystemService(
                    Context.NOTIFICATION_SERVICE);

            int notifyId = intent.getIntExtra(KEY_NOTIFY_ID, -1);
            notificationManager.notify(notifyId, repliedNotification);
        }
    }

    private CharSequence getMessageText(Intent intent) {

        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null) {
            return remoteInput.getCharSequence(KEY_TEXT_REPLY);
        }
        return null;
    }
}
