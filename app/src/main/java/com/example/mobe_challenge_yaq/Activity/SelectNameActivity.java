package com.example.mobe_challenge_yaq.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobe_challenge_yaq.R;

public class SelectNameActivity extends AppCompatActivity {

    private Context context;

    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_name);

        myButton = findViewById(R.id.goToJ1);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSetUpJ2Activity();
            }
        });

        context = this;
    }

    private void goToSetUpJ2Activity() {
        Intent intent = new Intent(this,SetUpJ2Activity.class);
        startActivity(intent);
    }
}
