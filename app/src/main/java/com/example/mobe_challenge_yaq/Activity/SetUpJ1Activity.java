package com.example.mobe_challenge_yaq.Activity;


import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobe_challenge_yaq.Bean.HasNoise;
import com.example.mobe_challenge_yaq.Bean.Robot;
import com.example.mobe_challenge_yaq.R;
import com.example.mobe_challenge_yaq.Service.NoiseService;
import com.example.mobe_challenge_yaq.Service.ShakeService;


public class SetUpJ1Activity extends AppCompatActivity {
    public static Robot joueur1;

    private static GridLayout gridLayout;

    private Button buttonFinal;

    private SelectCharacterActivity selectCharacterActivity;

    private static Context context;

    private static HasNoise hasNoise = new HasNoise();
    private int lastPos = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_j1);
        joueur1 = new Robot(getIntent().getStringExtra("robotPlayer"), selectCharacterActivity.getRobotBitmap(), 0, 0);

        context = this;
        gridLayout = findViewById(R.id.j1Activity);

        ShakeService.Start((SensorManager) getSystemService(Context.SENSOR_SERVICE));
      //  NoiseService.start();

        buttonFinal = findViewById(R.id.goToFinalActivity);
        buttonFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!joueur1.getDeplacement().contains(lastPos) || joueur1.getDeplacement().get(joueur1.getDeplacement().size() - 1) != lastPos) {
                    System.out.println("PAS POSSIBLE");
                } else {

                    Intent intent = new Intent(context, FinalActivity.class);
                    startActivity(intent);
                }
            }
        });
        final int childCount = gridLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final int index = i;
            final ImageView container = (ImageView) gridLayout.getChildAt(i);
            if (i == joueur1.getPositionDepart()) {
                container.setImageBitmap(joueur1.getBitmap());
            }
            container.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Boolean haut = false;
                    Boolean bas = false;
                    Boolean droite = false;
                    Boolean gauche = false;
                    Integer indexGauche = 0;
                    Integer indexDroite = 0;
                    Integer indexHaut = 0;
                    Integer indexBas = 0;
                    Integer lastIndex = joueur1.getDeplacement().size() - 1;
                    if (joueur1.getDeplacement().contains(index)) {
                        System.out.println("DEJA");
                    } else {

                        if (index % 3 != 0) {
                            if (joueur1.getDeplacement().contains(index - 1)) {
                                gauche = true;
                                indexGauche = index - 1;
                            }
                        }
                        if (index % 3 != 2) {
                            if (joueur1.getDeplacement().contains(index + 1)) {
                                droite = true;
                                indexDroite = index + 1;
                            }
                        }
                        if (index + 3 < 12) {
                            if (joueur1.getDeplacement().contains(index + 3)) {
                                bas = true;
                                indexBas = index + 3;
                            }
                        }
                        if (index - 3 >= 0) {
                            if (joueur1.getDeplacement().contains(index - 3)) {
                                haut = true;
                                indexHaut = index - 3;
                            }
                        }
                        if ((gauche && joueur1.getDeplacement().get(lastIndex) == indexGauche)
                                || (droite && joueur1.getDeplacement().get(lastIndex) == indexDroite)
                                || (haut && joueur1.getDeplacement().get(lastIndex) == indexHaut)
                                || (bas && joueur1.getDeplacement().get(lastIndex) == indexBas)) {
                            joueur1.addDeplacement(index);
                            container.setImageBitmap(selectCharacterActivity.getRobotBitmap());
                        }
                    }
                }
            });
        }

        hasNoise.setValueChangeListener(new HasNoise.onValueChangeListener() {
            @Override
            public void onChange() {
                int rand = (int)(Math.random() * 2);
                System.out.println(rand);
                final ImageView container = (ImageView) gridLayout.getChildAt(SetUpJ2Activity.positionTrap.get(rand));
                container.setImageDrawable(getResources().getDrawable(R.drawable.bomb));
            }
        });

    }

    public static void removeAll() {
        joueur1.getDeplacement().removeAll(joueur1.getDeplacement());
        final int childCount = gridLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final int index = i;
            final ImageView container = (ImageView) gridLayout.getChildAt(i);
            if (i == joueur1.getPositionDepart()) {
                joueur1.addDeplacement(joueur1.getPositionDepart());
                container.setImageBitmap(joueur1.getBitmap());
            } else {
                container.setImageDrawable(context.getResources().getDrawable(R.drawable.pave));
            }
        }
    }

    public static void callBackShaken() {
        removeAll();
    }

    public static void callBackNoise() {
        hasNoise.setVariable(true);
    }
}
