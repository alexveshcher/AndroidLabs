package com.naukma.alex.task1_notification;

import android.app.Activity;
import android.app.NotificationManager;

import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                createNotification();
            }
        });
    }

    private void createNotification() {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.common_full_open_on_phone)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!")
                        .setTicker("You have a new notification")
                        .setSound(Uri.parse("android.resource://"+ getPackageName()
                                + "/" + R.raw.sounds_917_communication_channel));

        // Sets an ID for the notification
        int mNotificationId = 001;
        // Gets an instance of the NotificationManager service
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        notificationManager.notify(mNotificationId, mBuilder.build());
    }


}