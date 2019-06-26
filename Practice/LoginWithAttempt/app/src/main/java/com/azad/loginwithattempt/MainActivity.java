package com.azad.loginwithattempt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUserName, editTextPassword;
    private Button buttonLogin, buttonSignUp;
    private TextView textViewAttempt;
    private int counter=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserName = (EditText) findViewById(R.id.usernameEditTextId);
        editTextPassword = (EditText) findViewById(R.id.passwordEditTextId);
        buttonLogin = (Button) findViewById(R.id.LoginbtnId);
        buttonSignUp = (Button) findViewById(R.id.SignUpbtnId);
        textViewAttempt = (TextView) findViewById(R.id.attemptTextViewId);

        textViewAttempt.setText("Number of attempts remaining : 3");

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();

                if (userName.equals("admin") && password.equals("1234")) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }else{
                    counter--;
                    textViewAttempt.setText("Number of attempts remaining : "+ counter);
                    if (counter==0){
                        buttonLogin.setEnabled(false);
                    }
                }
            }
        });

    }
}
