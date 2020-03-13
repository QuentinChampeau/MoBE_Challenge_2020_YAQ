package com.example.mobe_challenge_yaq;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobe_challenge_yaq.Activity.SelectNameActivity;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        Button playButton = (Button) findViewById(R.id.playButton);

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
}
