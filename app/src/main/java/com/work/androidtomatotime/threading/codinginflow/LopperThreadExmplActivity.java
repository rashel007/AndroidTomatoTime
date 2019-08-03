package com.work.androidtomatotime.threading.codinginflow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.work.androidtomatotime.R;

public class LopperThreadExmplActivity extends AppCompatActivity {

    private static final String TAG = "LopperThreadExmplActivi";

    Button btnStartThread, btnStopThread, btnTaskA, btnTaskB;

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

    }

    private void stopThread() {

    }


    private void taskA() {

    }

    private void taskB() {

    }

}
