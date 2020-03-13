package com.example.mobe_challenge_yaq.Activity;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobe_challenge_yaq.Bean.Robot;
import com.example.mobe_challenge_yaq.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class SetUpJ1Activity extends AppCompatActivity {

    private final int Max_COLONNE = 3;

    public static Robot joueur1;

    private GridLayout gridLayout;


    private SelectCharacterActivity selectCharacterActivity;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_j1);
        joueur1 = new Robot("Rosé", selectCharacterActivity.getRobotBitmap(), 0, 0);

        context = this;
        gridLayout = findViewById(R.id.j1Activity);
        final int childCount = gridLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final int index = i;
            final ImageView container = (ImageView) gridLayout.getChildAt(i);
            if (i == joueur1.getPositionDepart()) {
                container.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
            }
            container.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Boolean haut = false;
                    Boolean bas = false;
                    Boolean droite = false;
                    Boolean gauche = false;
                    Integer indexGauche =0;
                    Integer indexDroite =0;
                    Integer indexHaut =0;
                    Integer indexBas =0;
                    Integer lastIndex = joueur1.getDeplacement().size()-1;
                    if(joueur1.getDeplacement().contains(index)){
                        System.out.println("DEJA");
                        Intent intent = new Intent(context,FinalActivity.class);
                        startActivity(intent);
                    }else{

                        if(index % 3 !=0){
                            if(joueur1.getDeplacement().contains(index-1)){
                                gauche = true;
                                indexGauche = index-1;
                            }
                        }
                        if (index % 3 != 2) {
                            if (joueur1.getDeplacement().contains(index + 1)) {
                                droite = true;
                                indexDroite = index +1;
                            }
                        }
                        if (index + 3 < 12) {
                            if (joueur1.getDeplacement().contains(index + 3)) {
                                bas = true;
                                indexBas = index+3;
                            }
                        }
                        if (index - 3 >= 0) {
                            if (joueur1.getDeplacement().contains(index - 3)) {
                                haut = true;
                                indexHaut = index-3;
                            }
                        }
                        if((gauche && joueur1.getDeplacement().get(lastIndex) == indexGauche)
                                || (droite && joueur1.getDeplacement().get(lastIndex) == indexDroite)
                                || (haut && joueur1.getDeplacement().get(lastIndex) == indexHaut)
                                || (bas && joueur1.getDeplacement().get(lastIndex) == indexBas)){
                            joueur1.addDeplacement(index);
                            container.setImageBitmap(selectCharacterActivity.getRobotBitmap());
                        }
                    }
                }
            });
        }
    }
}
