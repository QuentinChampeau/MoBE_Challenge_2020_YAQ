package com.example.mobe_challenge_yaq.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobe_challenge_yaq.R;

import java.util.ArrayList;
import java.util.List;

public class SetUpJ2Activity extends AppCompatActivity {

    private GridLayout gridLayout;

    public static List<Integer> positionTrap;

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

                if (positionTrap.size() != 2) {
                    CharSequence text = "Veuillez poser vos piège";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    Toast.makeText(context, text, duration).show();
                } else {
                    Intent intent = new Intent(context, SelectCharacterActivity.class);
                    intent.putExtra("robotname", getIntent().getStringExtra("playerName"));
                    startActivity(intent);
                }
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
                    if (index != 0 && index != 11) {

                        if ((positionTrap.contains(8) && index == 10) || (positionTrap.contains(10) && index == 8) || (positionTrap.contains(1) && index == 3) || (positionTrap.contains(3) && index == 1)) {
                            CharSequence text = "Ne bloque pas tous les chemins";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            Toast.makeText(context, text, duration).show();
                        } else {
                            if (positionTrap.contains(index)) {
                                positionTrap.remove(positionTrap.indexOf(index));
                                container.setImageDrawable(getResources().getDrawable(R.drawable.pave));
                            } else if (positionTrap.size() != 2) {
                                positionTrap.add(index);
                                container.setImageDrawable(getResources().getDrawable(R.drawable.bomb));
                            }
                            if (positionTrap.size() == 2) {
                                CharSequence text = "Tous vos pièges sont posés!";
                                int duration = Toast.LENGTH_SHORT;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                                Toast.makeText(context, text, duration).show();
                            }
                        }
                    }
                }
            });
        }
    }
}
