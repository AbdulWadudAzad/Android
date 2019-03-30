package com.azad.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MultipleButtonWithListener2Activity extends AppCompatActivity implements View.OnClickListener {
    private Button logButton, signUpBtton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_button_with_listener1);

        logButton = (Button) findViewById(R.id.loginbutton);
        signUpBtton = (Button) findViewById(R.id.signupbutton);
        textView = (TextView) findViewById(R.id.textview1);

        logButton.setOnClickListener(this);
        signUpBtton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.loginbutton){
            textView.setText("Log in is clicked");
        }
        if(v.getId()==R.id.signupbutton){
            textView.setText("Sign up is clicked");
        }

    }
}
