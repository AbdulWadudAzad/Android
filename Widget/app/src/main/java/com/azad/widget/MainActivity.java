package com.azad.widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView nameTextView, mobileTextView, emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = (TextView) findViewById(R.id.nameTextViewId);
        emailTextView = (TextView) findViewById(R.id.emailTextViewId);

        nameTextView.setText("Abdul Wadud Azad");
        emailTextView.setText("azadmiu37@gmail.com");
    }
}
