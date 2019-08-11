package com.work.androidtomatotime.threading.codinginflow;

import android.content.Intent;
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


    public void startService(View v) {
        String input = editText.getText().toString();

//        Intent intentService = new Intent(this, ExampleIntentService.class);
//        intentService.putExtra("inputExtra", input);
//        ContextCompat.startForegroundService(this, intentService);

        // jobintentservice
        Intent intentService = new Intent(this, ExJobIntentService.class);
        intentService.putExtra("inputExtra", input);
        ExJobIntentService.enqueueWork(this, intentService);


    }

    public void cancelService(View v) {
//        Intent intentService = new Intent(this, MyForGroundService.class);
//        stopService(intentService);
    }
}
