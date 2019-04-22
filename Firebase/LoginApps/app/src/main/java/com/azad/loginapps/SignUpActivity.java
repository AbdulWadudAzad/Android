package com.azad.loginapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private Button signUpButton;
    private EditText signUpEmailEditText, signUpasswrdEditText;
    private TextView signInTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpEmailEditText=(EditText) findViewById(R.id.tditTextEmailSignUpId);
        signUpasswrdEditText=(EditText) findViewById(R.id.tditTextPasswordSignUpId);
        signUpButton=(Button) findViewById(R.id.buttonSignUpId);
        signInTextView=(TextView) findViewById(R.id.textViewSignInId);

        signInTextView.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonSignUpId:

                break;

            case R.id.textViewSignInId:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;

        }
    }
}
