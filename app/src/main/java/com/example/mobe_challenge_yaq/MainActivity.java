package com.example.mobe_challenge_yaq;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.mobe_challenge_yaq.Activity.SelectNameActivity;
import com.example.mobe_challenge_yaq.Service.NoiseService;
import com.example.mobe_challenge_yaq.Service.ShakeService;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;

    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestRecordAudioPermission();

        context = this;
        Button playButton = (Button) findViewById(R.id.playButton);

        ShakeService.Start((SensorManager) getSystemService(Context.SENSOR_SERVICE));

        //NoiseService.start();

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

    public void requestRecordAudioPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, REQUEST_RECORD_AUDIO_PERMISSION);
    }

    public static void callBackShaken() {
        Toast.makeText(context, "Shaken !", Toast.LENGTH_SHORT).show();
    }

    public static void callBackNoise() {
        System.out.println("Noise");
    }
}
