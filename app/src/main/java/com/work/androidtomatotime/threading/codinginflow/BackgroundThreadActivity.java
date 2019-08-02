package com.work.androidtomatotime.threading.codinginflow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.work.androidtomatotime.R;

public class BackgroundThreadActivity extends AppCompatActivity {

    private static final String TAG = "BackgroundThreadActivit";

    Button btnStartThread, btnStopThread;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.back_ground_thread_activity);

        btnStartThread = findViewById(R.id.btnThreadStart);
        btnStopThread = findViewById(R.id.btnThreadStop);
        btnStartThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startThread();
            }
        });
        btnStopThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopThread();
            }
        });
    }


    public void startThread() {
        BackgroundThread backgroundThread = new BackgroundThread(10);
        backgroundThread.start();
    }

    public void stopThread() {

    }



    class BackgroundThread extends Thread {

        private int seconds;

        BackgroundThread(int seconds) {
            this.seconds = seconds;
        }


        @Override
        public void run() {

            for (int i = 0; i < seconds; i++) {
                Log.d(TAG, "Thread Running " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
