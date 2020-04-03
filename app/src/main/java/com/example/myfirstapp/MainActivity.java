package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Called when the user taps the Compass button */
    public void startCompass(View view) {
        Intent intent = new Intent(this, DisplayCompassActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Accelerometer button */
    public void startAccelerometer(View view) {
        Intent intent = new Intent(this, DisplayAccelerometerActivity.class);
        startActivity(intent);
    }
}
