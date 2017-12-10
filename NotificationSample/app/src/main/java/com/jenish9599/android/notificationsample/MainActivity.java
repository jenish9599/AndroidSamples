package com.jenish9599.android.notificationsample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.BatchUpdateException;

import static android.app.PendingIntent.*;

public class MainActivity extends AppCompatActivity {


    private Button button ;
    NotificationCompat.Builder notification;
    private static final int uniqueID = 45612;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        button = (Button)findViewById(R.id.on_btn);
        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification.setSmallIcon(R.drawable.ic_launcher_foreground);
                notification.setTicker("This is the ticker");
                notification.setWhen(System.currentTimeMillis());
                notification.setContentTitle("Title");
                notification.setContentText("I am the Body");


                Intent intent = new Intent(getApplicationContext(),MainActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivities(getApplicationContext(),0, new Intent[]{intent}, 0);
                notification.setContentIntent(pendingIntent);


                NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                nm.notify(uniqueID,notification.build());


            }
        });
    }
}
