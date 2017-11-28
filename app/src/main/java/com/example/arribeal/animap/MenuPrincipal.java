package com.example.arribeal.animap;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MenuPrincipal extends AppCompatActivity {
    private Button boutonContinent;
    private Button boutonGeolocalisation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        final LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);


        boutonGeolocalisation = (Button)findViewById(R.id.buttonAutourDeMoi);
        boutonGeolocalisation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                    Toast.makeText(getApplicationContext(), "Le GPS est actif", Toast.LENGTH_SHORT).show();
                }else{
                    showGPSDisabledAlertToUser();
                }

            }
        });

        boutonContinent = (Button)findViewById(R.id.buttonContinent);
        boutonContinent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PageContinent.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed()
    {

    }

    private void showGPSDisabledAlertToUser(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("La géolocalisation est désactivée. Voulez-vous allez dans les paramètres du GPS pour l'activer ?")
                .setTitle("Géolocalisation")
                .setCancelable(false)
                .setPositiveButton("Accéder au GPS",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                Intent callGPSSettingIntent = new Intent(
                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(callGPSSettingIntent);
                            }
                        });
        alertDialogBuilder.setNegativeButton("Annuler",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}

