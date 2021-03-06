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

public class SelectCharacterActivity extends AppCompatActivity {

    public static Bitmap robotBitmap;

    private Robot robot;

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
        Intent intent = new Intent(this, SetUpJ1Activity.class);
        intent.putExtra("robotPlayer", getIntent().getStringExtra("robotname"));
        startActivity(intent);
    }

    public static Bitmap getRobotBitmap() {
        return robotBitmap;
    }

    public static void setRobotBitmap(Bitmap robotBitmap) {
        SelectCharacterActivity.robotBitmap = robotBitmap;
    }
}
