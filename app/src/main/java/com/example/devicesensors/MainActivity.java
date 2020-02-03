package com.example.devicesensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = "Demo";

    private Integer[] sensorArray = {
            Sensor.TYPE_ACCELEROMETER,                       // 1
            Sensor.TYPE_MAGNETIC_FIELD,                      // 2
            Sensor.TYPE_ORIENTATION,                         // 3
            Sensor.TYPE_GYROSCOPE,                           // 4
            Sensor.TYPE_LIGHT,                               // 5
            Sensor.TYPE_PRESSURE,                            // 6
            Sensor.TYPE_TEMPERATURE,                         // 7
            Sensor.TYPE_PROXIMITY,                           // 8
            Sensor.TYPE_GRAVITY,                             // 9
            Sensor.TYPE_LINEAR_ACCELERATION,                 // 10
            Sensor.TYPE_ROTATION_VECTOR,                     // 11
            Sensor.TYPE_RELATIVE_HUMIDITY,                   // 12
            Sensor.TYPE_AMBIENT_TEMPERATURE,                 // 13
            Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED,         // 14
            Sensor.TYPE_GAME_ROTATION_VECTOR,                // 15
            Sensor.TYPE_GYROSCOPE_UNCALIBRATED,              // 16
            Sensor.TYPE_SIGNIFICANT_MOTION,                  // 17
            Sensor.TYPE_STEP_DETECTOR,                       // 18
            Sensor.TYPE_STEP_COUNTER,                        // 19
            Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR,         // 20
            Sensor.TYPE_HEART_RATE                           // 21
    };

    private String[] sensorStringArray = {
            Sensor.STRING_TYPE_ACCELEROMETER,                       // 1
            Sensor.STRING_TYPE_MAGNETIC_FIELD,                      // 2
            Sensor.STRING_TYPE_ORIENTATION,                         // 3
            Sensor.STRING_TYPE_GYROSCOPE,                           // 4
            Sensor.STRING_TYPE_LIGHT,                               // 5
            Sensor.STRING_TYPE_PRESSURE,                            // 6
            Sensor.STRING_TYPE_TEMPERATURE,                         // 7
            Sensor.STRING_TYPE_PROXIMITY,                           // 8
            Sensor.STRING_TYPE_GRAVITY,                             // 9
            Sensor.STRING_TYPE_LINEAR_ACCELERATION,                 // 10
            Sensor.STRING_TYPE_ROTATION_VECTOR,                     // 11
            Sensor.STRING_TYPE_RELATIVE_HUMIDITY,                   // 12
            Sensor.STRING_TYPE_AMBIENT_TEMPERATURE,                 // 13
            Sensor.STRING_TYPE_MAGNETIC_FIELD_UNCALIBRATED,         // 14
            Sensor.STRING_TYPE_GAME_ROTATION_VECTOR,                // 15
            Sensor.STRING_TYPE_GYROSCOPE_UNCALIBRATED,              // 16
            Sensor.STRING_TYPE_SIGNIFICANT_MOTION,                  // 17
            Sensor.STRING_TYPE_STEP_DETECTOR,                       // 18
            Sensor.STRING_TYPE_STEP_COUNTER,                        // 19
            Sensor.STRING_TYPE_GEOMAGNETIC_ROTATION_VECTOR,         // 20
            Sensor.STRING_TYPE_HEART_RATE                           // 21
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);                                                                              // will hide the title
        getSupportActionBar().hide();                                                                                               // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);          // enable full screen

        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor item: deviceSensors) {
            Log.d(TAG, "Sensor : " + item.getName());
        }

        for (int idx=0; idx < sensorArray.length; idx++) {

            if (sensorManager.getDefaultSensor(sensorArray[idx]) != null) {
                Log.d(TAG, String.format("[%d] Sensor %d %s SUCCESS", idx, sensorArray[idx], sensorStringArray[idx]));
            } else {
                Log.d(TAG, String.format("[%d] Sensor %d %s FAILURE", idx, sensorArray[idx], sensorStringArray[idx]));
            }
        }
    }
}
