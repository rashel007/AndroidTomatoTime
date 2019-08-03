package com.work.androidtomatotime.threading.codinginflow;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.work.androidtomatotime.R;

public class HandlerThreadActivity extends AppCompatActivity {

    private static final String TAG = "HandlerThreadActivity";

    private HandlerThread handlerThread = new HandlerThread("handlerThread");
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);

        handlerThread.start();

        handler = new Handler(handlerThread.getLooper());
    }


    public void doWork(View view) {
        handler.postDelayed(new ExampleRunnable1(), 2000);
        handler.post(new ExampleRunnable2());

    }

    public void removeMessage(View view) {
    }


    static class ExampleRunnable1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                Log.d(TAG, "Runnable1 " + i);
                SystemClock.sleep(1000);
            }
        }
    }

    static class ExampleRunnable2 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                Log.d(TAG, "Runnable2 " + i);
                SystemClock.sleep(1000);
            }
        }
    }
}
