package com.example.mobe_challenge_yaq.Service;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;

import com.example.mobe_challenge_yaq.MainActivity;

public class ShakeService {
    private static float mAccel; // acceleration apart from gravity
    private static float mAccelCurrent; // current acceleration including gravity
    private static float mAccelLast; // last acceleration including gravity
    private static SensorManager mSensorManager;

    public static void Start(SensorManager sensorManager) {
        mSensorManager = sensorManager;
        mSensorManager.registerListener(mSensorListener,
                mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
        mAccel = 0.00f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;
    }


    private static final SensorEventListener mSensorListener = new SensorEventListener() {

        public void onSensorChanged(SensorEvent se) {
            float x = se.values[0];
            float y = se.values[1];
            float z = se.values[2];
            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel * 0.9f + delta; // perform low-cut filter

            if (mAccel > 12) {
                System.out.println("Shake detect");
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };
}
