package com.example.mobe_challenge_yaq.Service;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Handler;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.mobe_challenge_yaq.Activity.SetUpJ1Activity;

public final class NoiseService {
    private static final int NOISEDETECT = 207000;

    Context c;

    public NoiseService(Context c){
        this.c=c;

        Handler mainHandler = new Handler(c.getMainLooper());
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                listening();
            } // This is your code
        };
        mainHandler.post(myRunnable);
    }


    private static boolean listening() {
        int minSize = AudioRecord.getMinBufferSize(8000,
                AudioFormat.CHANNEL_IN_MONO,
                AudioFormat.ENCODING_PCM_16BIT);
        AudioRecord audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC,
                8000, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT,
                minSize);

        short[] buffer = new short[minSize];

        audioRecord.startRecording();
        while (true) {

            audioRecord.read(buffer, 0, minSize);
            for (short s : buffer) {
                if (Math.abs(s) > NOISEDETECT) {
                    int blow_value = Math.abs(s);
                    System.out.println("Blow Value = " + blow_value);
                    audioRecord.stop();
                    SetUpJ1Activity.callBackNoise();
                    // stop
                    return true;
                }
            }
        }
    }
}
