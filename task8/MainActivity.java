package com.naukma.alex.task8lightsensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener {
    String LOG_TAG = "test";
    private SensorManager senSensorManager;
    private Sensor senAccelerometer;

    TextView xText;
    TextView yText;
    TextView zText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xText = (TextView) findViewById(R.id.x);
        yText = (TextView) findViewById(R.id.y);
        zText = (TextView) findViewById(R.id.z);
        senSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        senSensorManager.registerListener(this, senAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor mySensor = sensorEvent.sensor;

        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            //Log.d(LOG_TAG,String.valueOf(x));
            xText.setText("x: "+degree(x)+"°");
            yText.setText("y: "+degree(y)+"°");
            zText.setText("z: "+degree(z)+"°");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private String degree(float value){
        return String.valueOf(Math.round(value*9));
    }
}
