package com.work.androidtomatotime.threading.codinginflow;

import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.work.androidtomatotime.R;

public class HandlerThreadActivity extends AppCompatActivity {

    private static final String TAG = "HandlerThreadActivity";

    private ExampleHandlerThread handlerThread = new ExampleHandlerThread();
//    private Handler handler;

    private ExampleRunnable1 exampleRunnable1;
    private ExampleRunnable2 exampleRunnable2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);

        handlerThread.start();

//        handler = new Handler(handlerThread.getLooper());

        exampleRunnable1 = new ExampleRunnable1();
        exampleRunnable2 = new ExampleRunnable2();


    }


    public void doWork(View view) {

        Message message = Message.obtain();
        message.what = 2;
        handlerThread.getHandler().sendMessage(message);

        handlerThread.getHandler().postDelayed(exampleRunnable1, 2000);
        handlerThread.getHandler().post(exampleRunnable2);

    }

    public void removeMessage(View view) {
        // if we pass null then it will remove all
//        handler.removeCallbacksAndMessages(null);
        //this will remove specific runnable
        handlerThread.getHandler().removeCallbacks(exampleRunnable1);
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
