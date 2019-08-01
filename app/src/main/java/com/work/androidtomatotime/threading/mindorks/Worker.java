package com.work.androidtomatotime.threading.mindorks;

import android.os.Handler;
import android.os.HandlerThread;

public class Worker  extends HandlerThread {

    private static final String TAG = "Worker";

    private Handler handler;


    public Worker(){
        super(TAG);

        handler = new Handler(getLooper());
    }

    public Worker execute(Runnable task) {
        handler.post(task);

        return this;
    }
}
