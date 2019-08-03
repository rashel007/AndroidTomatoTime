package com.work.androidtomatotime.threading.codinginflow;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.work.androidtomatotime.R;

import static com.work.androidtomatotime.threading.codinginflow.Examplehandler.TASK_A;
import static com.work.androidtomatotime.threading.codinginflow.Examplehandler.TASK_B;


/**
 * In this example we will learn Looper, MessageQueue and Handler
 */

public class LopperThreadExmplActivity extends AppCompatActivity {

    private static final String TAG = "LopperThreadExmplActivi";

    Button btnStartThread, btnStopThread, btnTaskA, btnTaskB;

    ExampleLooperThread looperThread = new ExampleLooperThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lopper_thread_exmpl);

        initView();
    }

    private void initView() {

        btnStartThread = findViewById(R.id.btnThreadStart);
        btnStopThread = findViewById(R.id.btnThreadStop);
        btnTaskA = findViewById(R.id.btnTaskA);
        btnTaskB = findViewById(R.id.btnTaskB);

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
        btnTaskA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskA();
            }
        });
        btnTaskB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskB();
            }
        });

    }

    private void startThread() {
        looperThread.start();
    }

    private void stopThread() {
        looperThread.looper.quit();

        // also we can do this
//        looperThread.handler.getLooper().quit();
    }


    private void taskA() {

        /**
         * As we have the looper . we can create a handler in this activity like below
         *
         *
         *  Handler handler = new Handler(looperThread.looper);
         *         handler.post(new Runnable() {
         *             @Override
         *             public void run() {
         *
         *             }
         *         });
         *
         *
         */


//        looperThread.handler.post(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    Log.d(TAG, "run: " + i);
//                    SystemClock.sleep(1000);
//                }
//            }
//        });

        Message message = Message.obtain();
        message.what = TASK_A;
        looperThread.handler.sendMessage(message);
    }

    private void taskB() {
        Message message = Message.obtain();
        message.what = TASK_B;
        looperThread.handler.sendMessage(message);
    }

}
