package com.example.mobe_challenge_yaq.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobe_challenge_yaq.Bean.Robot;
import com.example.mobe_challenge_yaq.R;
import com.google.gson.Gson;

public class SelectCharacterActivity extends AppCompatActivity {

    private Robot robot;
    public static Bitmap robotBitmap;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_character);

        gridLayout = findViewById(R.id.gridSelectCharacter);

        final int childCount = gridLayout.getChildCount();

        for (int i = 0; i < childCount; i++) {
            final int index = i;
            final ImageView character = (ImageView) gridLayout.getChildAt(i);

            character.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) character.getDrawable();
                   robotBitmap = bitmapDrawable.getBitmap();
                    goToSetUpJ1Activity();
                }
            });
        }
    }

    private void goToSetUpJ1Activity() {
        Intent intent = new Intent(this,SetUpJ1Activity.class);
        startActivity(intent);
    }
}
