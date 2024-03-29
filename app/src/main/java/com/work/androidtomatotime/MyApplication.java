package com.work.androidtomatotime;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class MyApplication extends Application {

    public static final String CHANNLE_ID = "myservicechannel";

    @Override
    public void onCreate() {
        super.onCreate();


        createNotificationChannel();
    }


    private void createNotificationChannel() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNLE_ID,
                    "My Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }

    }
}
