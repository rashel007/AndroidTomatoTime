package com.work.androidtomatotime.threading.codinginflow;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.work.androidtomatotime.R;

import java.lang.ref.WeakReference;

public class AsyncTaskActivity extends AppCompatActivity {

    ProgressBar progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        progress_bar = findViewById(R.id.progress_bar);
    }

    public void startAsyncTask(View v) {
        ExampleAsyncTask asyncTask = new ExampleAsyncTask(this);
        asyncTask.execute(10);
    }


    /**
     * to avoid memory lead we make the class static .
     * to access mainactivity ui element in asynctask we create a weakreference of main activity.
     */
    private static class ExampleAsyncTask extends AsyncTask<Integer, Integer, String> {

        private WeakReference<AsyncTaskActivity> mainActivityWeakReference;

         ExampleAsyncTask(AsyncTaskActivity activity) {
            mainActivityWeakReference = new WeakReference<AsyncTaskActivity>(activity);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            AsyncTaskActivity activity = mainActivityWeakReference.get();

            if (activity == null || activity.isFinishing())
                return;

            activity.progress_bar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Integer... integers) {

            for (int i = 0; i < integers[0]; i++) {

                // publishProgress will call onProgressUpdate

                publishProgress((i * 100) / integers[0]);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "Finished";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            AsyncTaskActivity activity = mainActivityWeakReference.get();

            if (activity == null || activity.isFinishing())
                return;

            activity.progress_bar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            AsyncTaskActivity activity = mainActivityWeakReference.get();

            if (activity == null || activity.isFinishing())
                return;

            Toast.makeText(activity, s, Toast.LENGTH_SHORT).show();
            activity.progress_bar.setProgress(0);
            activity.progress_bar.setVisibility(View.INVISIBLE);
        }


    }
}
