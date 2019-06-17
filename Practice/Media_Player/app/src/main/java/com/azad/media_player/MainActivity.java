package com.azad.media_player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton pauseButton;
    private ImageButton playButton;
    private ImageButton forwardButton;
    private ImageButton backwardButton;

    private TextView titleTextView;
    private TextView durationTextView;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backwardButton = (ImageButton) findViewById(R.id.fast_rewindId);
        forwardButton = (ImageButton) findViewById(R.id.fast_forwardId);
        pauseButton = (ImageButton) findViewById(R.id.pauseId);
        playButton = (ImageButton) findViewById(R.id.playId);



        mediaPlayer = MediaPlayer.create(this, R.raw.al_fatiha);

        backwardButton.setOnClickListener(this);
        forwardButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        playButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.fast_rewindId) {

        } else if (v.getId() == R.id.fast_forwardId) {

        } else if (v.getId() == R.id.pauseId) {

            if (mediaPlayer != null) {
                mediaPlayer.stop();
                Toast.makeText(MainActivity.this, "Recitation Pause", Toast.LENGTH_LONG).show();
            }

        } else if (v.getId() == R.id.playId) {
            if (mediaPlayer != null) {
                mediaPlayer.start();
                Toast.makeText(MainActivity.this, "Recitation Played", Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer!=null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
        super.onDestroy();
    }

}
