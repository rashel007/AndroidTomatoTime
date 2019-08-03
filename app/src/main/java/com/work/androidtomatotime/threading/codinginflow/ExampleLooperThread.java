package com.work.androidtomatotime.threading.codinginflow;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class ExampleLooperThread extends Thread {

    private static final String TAG = "ExampleLooperThread";

    public Handler handler;

    public Looper looper;

    @Override
    public void run() {

//        // this will throw an error "Can't create handler inside thread that has not called Looper.prepare()"
//        handler = new Handler();

        /**
         * SO for this we have to call Looper.prepare() before initializing handler
         * Looper.prepare() includes MessageQueue
         * And the order must be as below. we have to call looper.loop to start the messagequeue
         */

        Looper.prepare();

        looper = Looper.myLooper();

        handler = new Examplehandler();

        // this will start a infinite for loop (for (;;) )
        Looper.loop();


        Log.d(TAG, "End of run()");
    }
}
