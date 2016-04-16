package com.naukma.alexveshcher.task5gesture;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Log.d("lol", "run runnable");
            Toast.makeText(getApplicationContext(), "Hello World!", Toast.LENGTH_LONG).show();
        }
    };
    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //long eventDuration;


        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            handler.postDelayed(runnable, 5000);
        }
        if(event.getAction() == MotionEvent.ACTION_UP) {
            handler.removeCallbacks(runnable);
        }

        return true;
    }
}