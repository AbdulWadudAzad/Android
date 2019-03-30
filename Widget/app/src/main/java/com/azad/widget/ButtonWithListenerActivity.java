package com.azad.widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ButtonWithListenerActivity extends AppCompatActivity {
    int click = 0;
    private Button logButton;
    private TextView logTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_with_listener);

        logButton = (Button) findViewById(R.id.signupbutton);
        logTextView = (TextView) findViewById(R.id.logintextview);

        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click++;
                logTextView.setText("Sign Up button is clicked " + click + " time");
            }
        });
    }
}
