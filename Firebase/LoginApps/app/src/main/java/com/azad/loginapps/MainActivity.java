package com.azad.loginapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button signInButton;
    private EditText signInEmailEditText, signInpasswrdEditText;
    private TextView signUpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInEmailEditText = (EditText) findViewById(R.id.tditTextEmailSignInId);
        signInpasswrdEditText = (EditText) findViewById(R.id.tditTextPasswordSignInId);
        signInButton = (Button) findViewById(R.id.buttonSignInId);
        signUpTextView = (TextView) findViewById(R.id.textViewSignUpId);

        signUpTextView.setOnClickListener(this);
        signInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonSignInId:

                break;

            case R.id.textViewSignUpId:
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                break;

        }
    }
}
