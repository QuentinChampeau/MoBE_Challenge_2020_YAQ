package com.example.mobe_challenge_yaq.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobe_challenge_yaq.MainActivity;
import com.example.mobe_challenge_yaq.R;

public class VictoryActivity extends AppCompatActivity {
    private static Context context;
    private TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);
        context = this;

        tx = findViewById(R.id.isVictory);
        Button button = findViewById(R.id.goToHome);

        if (FinalActivity.victory) {
            tx.setText("VICTOIRE");
        } else {
            tx.setText("DEFAITE");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
