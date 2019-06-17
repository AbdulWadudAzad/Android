package com.azad.progress_bar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    int preogress;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressbarId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                doWork();

            }
        });  //Thread used to showing progress

        thread.start();
    }

    public void doWork() {
        for (preogress = 10; preogress <= 100; preogress = preogress + 10) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(preogress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
