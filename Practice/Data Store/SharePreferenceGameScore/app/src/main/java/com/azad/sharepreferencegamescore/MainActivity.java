package com.azad.sharepreferencegamescore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView scoreTextView;
    private Button increasseButton, decreaseButton;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextView = (TextView) findViewById(R.id.scoreTextViewId);
        increasseButton = (Button) findViewById(R.id.additionScore_bnId);
        decreaseButton = (Button) findViewById(R.id.substractionScore_bnId);

        increasseButton.setOnClickListener(this);
        decreaseButton.setOnClickListener(this);

        if (loadScore() != 0) {
            scoreTextView.setText("Score : " + loadScore());
        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.additionScore_bnId) {
            score = score + 10;
            scoreTextView.setText("Score: " + score);
            saveScore(score);

        } else if (v.getId() == R.id.substractionScore_bnId) {
            score = score - 10;
            scoreTextView.setText("Score: " + score);
            saveScore(score);

        }
    }

    // used to save score
    private void saveScore(int score) {
        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("lastScore", score);
        editor.commit();

    }

    private int loadScore() {
        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);
        int gameScore = sharedPreferences.getInt("lastScore", 0);
        return gameScore;
    }

}
