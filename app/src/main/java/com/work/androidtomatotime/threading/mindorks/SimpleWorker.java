package com.work.androidtomatotime.threading.mindorks;

import android.util.Log;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleWorker extends Thread {

    private static final String TAG = "SimpleWorker";


    private AtomicBoolean mAlive = new AtomicBoolean(true);

    private ConcurrentLinkedQueue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();


    public SimpleWorker() {
        super(TAG);
        start();
    }


    @Override
    public void run() {
        Log.d(TAG, "Run");
        while (mAlive.get()) {
            Runnable task = taskQueue.poll();
            if (task != null) {
                Log.d(TAG, "Task Run");
                task.run();
            }else {
                Log.d(TAG, "Task Null");
            }
        }

        Log.d(TAG, "SimpleWorker Terminited");
    }

    public SimpleWorker execute(Runnable task) {
        taskQueue.add(task);
        return this;
    }

    public void quit() {
        mAlive.set(false);
    }

}
