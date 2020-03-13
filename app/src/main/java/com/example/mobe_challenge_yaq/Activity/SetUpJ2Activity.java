package com.example.mobe_challenge_yaq.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobe_challenge_yaq.R;

import java.util.ArrayList;
import java.util.List;

public class SetUpJ2Activity extends AppCompatActivity {

    private GridLayout gridLayout;

    private List<Integer> positionTrap;

    private Context context;

    private Button nextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_j2);
        nextActivity = findViewById(R.id.mybutton);
        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,SelectCharacterActivity.class);
                startActivity(intent);
            }
        });
        context = this;
        positionTrap = new ArrayList<>();
        gridLayout = findViewById(R.id.j2Activity);
        final int childCount = gridLayout.getChildCount();

        for (int i = 0; i < childCount; i++) {
            final int index = i;
            final ImageView container = (ImageView) gridLayout.getChildAt(i);

            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        if (positionTrap.contains(index)) {
                            positionTrap.remove(positionTrap.indexOf(index));
                            container.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
                        } else if (positionTrap.size() != 2){
                            positionTrap.add(index);
                            container.setImageDrawable(getResources().getDrawable(R.drawable.spidertrap));
                        }
                    if (positionTrap.size() == 2) {
                        CharSequence text = "Tous vos pièges sont posés!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        Toast.makeText(context, text, duration).show();
                    }
                }
            });
        }
    }

}