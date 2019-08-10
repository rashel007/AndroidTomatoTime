package com.work.androidtomatotime.threading.codinginflow;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.work.androidtomatotime.R;

import static com.work.androidtomatotime.MyApplication.CHANNLE_ID;

public class MyForGroundService extends Service {

    private static final String TAG = "MyForGroundService";


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String input = intent.getStringExtra("inputExtra");

        Intent intent1 = new Intent(this, ForgroundServiceActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, intent1, 0
        );

        Notification notification = new NotificationCompat.Builder(this, CHANNLE_ID)
                .setContentTitle("My Example Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentIntent(pendingIntent)
                .build();

        // the id must be bigger then 0
        startForeground(1, notification);


        return START_NOT_STICKY; // means out service will just begun and not started again
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
