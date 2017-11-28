package com.example.arribeal.animap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class PageContinent extends AppCompatActivity {
    private Button afrique;
    private Button ameriquenord;
    private Button ameriquesud;
    private Button antarctique;
    private Button arctique;
    private Button asie;
    private Button europe;
    private Button oceanie;
    private Button retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_continent);

        afrique = (Button)findViewById(R.id.buttonAfrique);
        ameriquenord = (Button)findViewById(R.id.buttonAmeriqueNord);
        ameriquesud = (Button)findViewById(R.id.buttonAmeriqueSud);
        antarctique = (Button)findViewById(R.id.buttonAntarctique);
        arctique = (Button)findViewById(R.id.buttonArctique);
        asie = (Button)findViewById(R.id.buttonAsie);
        europe = (Button)findViewById(R.id.buttonEurope);
        oceanie = (Button)findViewById(R.id.buttonOceanie);
        retour = (Button)findViewById(R.id.buttonRetour);


        afrique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ameriquenord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ameriquesud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        antarctique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        arctique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        asie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        europe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        oceanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MenuPrincipal.class));
                finish();
            }
        });





        }

    @Override
    public void onBackPressed()
    {

    }

}
