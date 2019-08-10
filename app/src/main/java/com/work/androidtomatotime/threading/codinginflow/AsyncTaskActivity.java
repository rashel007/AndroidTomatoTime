package com.work.androidtomatotime.threading.codinginflow;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.work.androidtomatotime.R;

public class AsyncTaskActivity extends AppCompatActivity {

    private ProgressBar progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        progress_bar = findViewById(R.id.progress_bar);
    }

    public void startAsyncTask(View v){

    }



    private class ExampleAsyncTask extends AsyncTask<Integer, Integer, String>{

        @Override
        protected String doInBackground(Integer... integers) {
            return null;
        }
    }
}
