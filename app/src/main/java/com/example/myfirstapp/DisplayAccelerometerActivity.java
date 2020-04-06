package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayAccelerometerActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private TextView xText, yText, zText, statusText;
    private ConstraintLayout colorBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_accelerometer);

        //Creates the sensor manager
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        //Creates sensor
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Create sensor listener
        mSensorManager.registerListener(this, mAccelerometer,mSensorManager.SENSOR_DELAY_NORMAL);
        xText = findViewById(R.id.x);
        yText = findViewById(R.id.y);
        zText = findViewById(R.id.z);
        statusText = findViewById(R.id.status);
        colorBg = findViewById(R.id.colorAcc);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void onSensorChanged(SensorEvent event) {
        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);

        if (event.values[2] > 9.8 && event.values[1] < 1 && event.values[0] < 1) {
            statusText.setText("Bra telefonen ligger still");
            colorBg.setBackgroundColor(Color.GREEN);
        } else {
            statusText.setText("");
            colorBg.setBackgroundColor(Color.TRANSPARENT);
        }


    }

}
