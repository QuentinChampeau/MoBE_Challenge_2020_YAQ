package com.example.mobe_challenge_yaq;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
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
        Button gameRulesButton = (Button) findViewById(R.id.gameRulesButton);

        //NoiseService.start();

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSelectPlayerName();
            }
        });

        gameRulesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToGameRules();
            }
        });
    }

    private void goToSelectPlayerName() {
        Intent intent = new Intent(context, SelectNameActivity.class);
        changeActivity(intent);
    }

    private void goToGameRules() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.rules_popup);
        dialog.setCancelable(true);

        dialog.show();
    }

    private void changeActivity(Intent i) {
        startActivity(i);
    }

    public void requestRecordAudioPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, REQUEST_RECORD_AUDIO_PERMISSION);
    }

    public static void callBackNoise() {
        System.out.println("Noise");
    }
}
