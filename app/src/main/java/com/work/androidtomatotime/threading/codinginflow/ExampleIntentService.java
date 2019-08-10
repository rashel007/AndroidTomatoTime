package com.work.androidtomatotime.threading.codinginflow;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.work.androidtomatotime.R;

import static com.work.androidtomatotime.MyApplication.CHANNLE_ID;

public class ExampleIntentService extends IntentService {

    private static final String TAG = "ExampleIntentService";

    private PowerManager.WakeLock wakeLock;

    public ExampleIntentService() {
        super(TAG);
        // true = service will start again with the intent
        // false = service will not start again
        setIntentRedelivery(true);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");

        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                "ExampleApp:Wakelock");
        // if we know our our service running max time, then we can add this
        // this will wake the cpu for 10 mins
//        wakeLock.acquire(60000);
        wakeLock.acquire();
        Log.d(TAG, "WakeLock Started");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification notification = new NotificationCompat.Builder(this, CHANNLE_ID)
                    .setContentTitle("My Example Service")
                    .setContentText("Running...")
                    .setSmallIcon(R.drawable.ic_android_black_24dp)
                    .build();

            // the id must be bigger then 0
            startForeground(1, notification);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        wakeLock.release();
        Log.d(TAG, "WakeLock Released");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Log.d(TAG, "onHandleIntent");

        String input = intent.getStringExtra("inputExtra");

        for (int i = 0; i < 10; i++) {
            Log.d(TAG, input + " - " + i);
            SystemClock.sleep(1000);
        }

    }
}
