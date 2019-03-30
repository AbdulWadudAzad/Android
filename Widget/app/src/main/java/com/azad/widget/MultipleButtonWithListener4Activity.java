package com.azad.widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MultipleButtonWithListener4Activity extends AppCompatActivity {

    private Button logButton, signUpBtton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_button_with_listener4);

        logButton = (Button) findViewById(R.id.loginbutton);
        signUpBtton = (Button) findViewById(R.id.signupbutton);
        textView = (TextView) findViewById(R.id.textview1);


    }

    public void show_message(View v){
        if(v.getId()==R.id.loginbutton){
            textView.setText("Log in is clicked");
        }
        if(v.getId()==R.id.signupbutton){
            textView.setText("Sign up is clicked");
        }
    }

}
