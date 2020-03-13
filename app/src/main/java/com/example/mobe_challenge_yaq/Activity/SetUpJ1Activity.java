package com.example.mobe_challenge_yaq.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.example.mobe_challenge_yaq.Bean.Position;
import com.example.mobe_challenge_yaq.Bean.Robot;
import com.example.mobe_challenge_yaq.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SetUpJ1Activity extends AppCompatActivity {

    private final int Max_COLONNE = 3;

    private Robot joueur1;

    private GridLayout gridLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_j1);
        joueur1 =new Robot("Rosé", SelectCharacterActivity.robotBitmap, 0, 0);


        gridLayout = findViewById(R.id.j1Activity);



        final int childCount = gridLayout.getChildCount();

        for (int i= 0; i < childCount; i++){
            final int index = i;
            final ImageView container = (ImageView) gridLayout.getChildAt(i);
            if(i == joueur1.getPositionDepart()){
                container.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
            }
            container.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    Boolean haut = false;
                    Boolean bas = false;
                    Boolean droite = false;
                    Boolean gauche = false;
                    if(joueur1.getDeplacement().contains(index)){
                        System.out.println("DEJA");
                    }else{

                        if(index % 3 !=0){
                            if(joueur1.getDeplacement().contains(index-1)){
                                gauche = true;
                            }
                        }
                        if (index % 3 !=2){
                            if(joueur1.getDeplacement().contains(index+1)){
                                droite = true;
                            }
                        }
                        if(index + 3 <12){
                            if(joueur1.getDeplacement().contains(index+3)){
                                bas = true;
                            }
                        }
                        if(index -3 >= 0 ){
                            if(joueur1.getDeplacement().contains(index-3)){
                                haut = true;
                            }
                        }

                        if(gauche || bas || droite || haut){
                            joueur1.addDeplacement(index);
                            container.setImageBitmap(SelectCharacterActivity.robotBitmap);
//                            container.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
                        }
                    }

                }
            });
        }



    }
}
