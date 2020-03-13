package com.example.mobe_challenge_yaq;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.mobe_challenge_yaq.Activity.SelectNameActivity;
import com.example.mobe_challenge_yaq.Service.NoiseService;
import com.example.mobe_challenge_yaq.Service.ShakeService;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;

    private Context context;

    private ShakeService shakeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestRecordAudioPermission();

        context = this;
        Button playButton = (Button) findViewById(R.id.playButton);

        // TODO remove context, il est utilisé que pour afficher un toast
        shakeService = new ShakeService((SensorManager) getSystemService(Context.SENSOR_SERVICE), context);

        NoiseService.start();

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSelectPlayerName();
            }
        });
    }

    private void goToSelectPlayerName() {
        Intent intent = new Intent(context, SelectNameActivity.class);
        changeActivity(intent);
    }

    private void changeActivity(Intent i) {
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        shakeService.getSensorManager().registerListener(shakeService.getmSensorListener(),
                shakeService.getSensorManager().getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        shakeService.getSensorManager().unregisterListener(shakeService.getmSensorListener());
        super.onPause();
    }

    public void requestRecordAudioPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, REQUEST_RECORD_AUDIO_PERMISSION);
    }
}
