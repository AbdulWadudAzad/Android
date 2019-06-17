package com.azad.welcomescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class welcome_schreen extends AppCompatActivity {
private ProgressBar progressBar;
int progressSpeed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //used full schreen activity
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_welcome_schreen);

        progressBar=(ProgressBar) findViewById(R.id.progressBarId);

         Thread thread=new Thread(new Runnable() {   //Thread used for show progress
             @Override
             public void run() {
                 doWork();
                 startApp();
             }
         });

         thread.start();
    }


    public void doWork() {

        for (progressSpeed = 20; progressSpeed <= 100; progressSpeed = progressSpeed + 20) {

            try {
                Thread.sleep(1000);   //Heere sleep 1000mm used for show progress sfter every 1 second
                progressBar.setProgress(progressSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void startApp(){

        //Intent used for go one activity to another activity
        Intent intent=new Intent(welcome_schreen.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
