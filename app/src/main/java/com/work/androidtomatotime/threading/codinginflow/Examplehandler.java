package com.work.androidtomatotime.threading.codinginflow;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class Examplehandler extends Handler {
    private static final String TAG = "Examplehandler";

    public static final int TASK_A = 1;
    public static final int TASK_B = 2;

    @Override
    public void handleMessage(Message msg) {

        switch (msg.what) {
            case TASK_A:
                Log.d(TAG, "Task A");
                break;
            case TASK_B:
                Log.d(TAG, "Task B");
                break;
        }
    }
}
