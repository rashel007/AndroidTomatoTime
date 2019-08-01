package com.work.androidtomatotime.threading.mindorks;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.work.androidtomatotime.R;

public class HandlerLooperExActivity extends AppCompatActivity {

    SimpleWorker mSimpleWorker;
    TextView textView;

    Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textView.setText(msg.obj.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);

        mSimpleWorker = new SimpleWorker();

        mSimpleWorker.execute(() -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Message message = Message.obtain();
            message.obj = "1st Task Completed";
            handler.sendMessage(message);

        }).execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Message message = Message.obtain();
            message.obj = "2st Task Completed";
            handler.sendMessage(message);
        }).execute(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Message message = Message.obtain();
            message.obj = "3st Task Completed";
            handler.sendMessage(message);
            
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSimpleWorker.quit();
    }
}
