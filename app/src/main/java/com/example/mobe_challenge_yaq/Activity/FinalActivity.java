package com.example.mobe_challenge_yaq.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobe_challenge_yaq.R;

public class FinalActivity extends AppCompatActivity {


    GridLayout gridLayout;

    public static boolean victory = true;
    boolean finish = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        gridLayout = findViewById(R.id.finalActivity);

        Handler handler1 = new Handler();
        for (int i = 0; i < SetUpJ1Activity.joueur1.getDeplacement().size(); i++) {
            final int index = i;
            final ImageView imageView = (ImageView) gridLayout.getChildAt(SetUpJ1Activity.joueur1.getDeplacement().get(index));
            handler1.postDelayed(new Runnable() {

                @Override
                public void run() {
                    if (index > 0) {
                        ImageView lastImage = (ImageView) gridLayout.getChildAt(SetUpJ1Activity.joueur1.getDeplacement().get(index - 1));
                        lastImage.setImageDrawable(getResources().getDrawable(R.drawable.pave));
                    }

                    imageView.setImageBitmap(SelectCharacterActivity.robotBitmap);
                    if (SetUpJ2Activity.positionTrap.contains(SetUpJ1Activity.joueur1.getDeplacement().get(index))) {
                        victory = false;
                        finish = true;
                        goToVictory();

                    }
                    if (index == SetUpJ1Activity.joueur1.getDeplacement().size() - 1) {
                        if (!finish) {
                            goToVictory();
                        }
                    }
                }
            }, 2000 * i);
        }
    }

    private void goToVictory() {
        Intent intent = new Intent(this, VictoryActivity.class);
        startActivity(intent);
    }

}
