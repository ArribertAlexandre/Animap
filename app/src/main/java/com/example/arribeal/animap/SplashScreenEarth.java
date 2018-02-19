package com.example.arribeal.animap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScreenEarth extends AppCompatActivity {

    int progress = 0;
    ProgressBar simpleProgressBar;
    private TextView pourcent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_earth);
        simpleProgressBar = (ProgressBar) findViewById(R.id.progressBarDown);

        setProgressValue(progress);


        Thread myThread = new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(5300);
                    Intent intent = new Intent(getApplicationContext(), SplashScreenText.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }

    @Override
    public void onBackPressed()
    {

    }

    private void setProgressValue(final int progress) {

        // set the progress
        simpleProgressBar.setProgress(progress);
        // thread is used to change the progress value
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setProgressValue(progress + 2);
            }
        });
        thread.start();
    }
}
