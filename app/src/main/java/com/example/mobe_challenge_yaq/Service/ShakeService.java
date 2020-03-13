package com.example.mobe_challenge_yaq.Service;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;

public class ShakeService {
    private float accel; // acceleration apart from gravity
    private float accelCurrent; // current acceleration including gravity
    private float accelLast; // last acceleration including gravity
    private SensorManager sensorManager;
    
    // TODO remove context, il est utilisé que pour afficher un toast
    private Context context;

    public ShakeService(SensorManager sensorManager, Context context) {
        this.sensorManager = sensorManager;
        this.sensorManager.registerListener(mSensorListener,
                this.sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
        accel = 0.00f;
        accelCurrent = SensorManager.GRAVITY_EARTH;
        accelLast = SensorManager.GRAVITY_EARTH;
        this.context = context;
    }

    private final SensorEventListener mSensorListener = new SensorEventListener() {

        public void onSensorChanged(SensorEvent se) {
            float x = se.values[0];
            float y = se.values[1];
            float z = se.values[2];
            accelLast = accelCurrent;
            accelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = accelCurrent - accelLast;
            accel = accel * 0.9f + delta; // perform low-cut filter

            if (accel > 12) {
                Toast toast = Toast.makeText(context, "Device has shaken.", Toast.LENGTH_LONG);
                toast.show();
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    public float getAccel() {
        return accel;
    }

    public void setAccel(float accel) {
        this.accel = accel;
    }

    public float getAccelCurrent() {
        return accelCurrent;
    }

    public void setAccelCurrent(float accelCurrent) {
        this.accelCurrent = accelCurrent;
    }

    public float getAccelLast() {
        return accelLast;
    }

    public void setAccelLast(float accelLast) {
        this.accelLast = accelLast;
    }

    public SensorEventListener getmSensorListener() {
        return mSensorListener;
    }

    public SensorManager getSensorManager() {
        return sensorManager;
    }

    public void setSensorManager(SensorManager sensorManager) {
        this.sensorManager = sensorManager;
    }
}
