package com.example.mobe_challenge_yaq.Service;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;

import com.example.mobe_challenge_yaq.Activity.SetUpJ1Activity;

public final class NoiseService {
    private static final int NOISEDETECT = 207000;

    public static void start() {
        new Thread(new Runnable() {
            public void run() {
                listening();
            }
        }).start();
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
