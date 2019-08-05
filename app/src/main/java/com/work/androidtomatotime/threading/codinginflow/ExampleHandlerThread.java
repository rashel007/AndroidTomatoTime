package com.work.androidtomatotime.threading.codinginflow;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.util.Log;

public class ExampleHandlerThread extends HandlerThread {

    private Handler handler;

    public ExampleHandlerThread() {
        super("ExampleHandlerThread", Process.THREAD_PRIORITY_BACKGROUND);
    }


    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Log.d("ExampleHandlerThread", msg.what + "");
            }
        };
    }


    public Handler getHandler() {
        return handler;
    }
}
