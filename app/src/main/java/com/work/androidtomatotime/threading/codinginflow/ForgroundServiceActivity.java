package com.work.androidtomatotime.threading.codinginflow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.work.androidtomatotime.R;

public class ForgroundServiceActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forground_service);

        editText = findViewById(R.id.edittext_input);
    }


    public void startService(View v){

    }

    public void cancelService(View v){

    }
}