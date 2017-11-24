package com.example.arribeal.animap;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class SplashScreenText extends AppCompatActivity {
     private TextView explication;
     private Button passer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_text);


        explication = (TextView)findViewById(R.id.textViewExplication);
        explication.setText(" Cette application a pour but de lister les animaux présents sur chaque continent.\n\n" +
                " Diverses informations seront disponibles sur chaque animal comme par exemple l'esperance de vie, le poids et la taille moyenne ou encore si l'espèce est en voie d'extinction... \n\n" +
        " Cette application à été créée dans le cadre d'un projet d'une licence professionnelle SMIN à l'IUT1 de Grenoble.");

        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/Prototype.ttf");
        explication.setTypeface(type);

        passer = (Button)findViewById(R.id.buttonPasser);
        passer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuPrincipal.class);
                startActivity(intent);
                finish();
            }
        });

        passer.setVisibility(View.INVISIBLE);

        Thread myThread = new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(5000);
                    passer.getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            passer.setVisibility(View.VISIBLE);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();

    }

    /*public void afficheBouton()
    {
        passer.setVisibility(View.VISIBLE);
    }*/

}
