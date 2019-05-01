package com.azad.loginapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private Button signUpButton;
    private EditText signUpEmailEditText, signUpasswrdEditText;
    private TextView signInTextView;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sign Up");

        mAuth = FirebaseAuth.getInstance();

        progressBar=(ProgressBar) findViewById(R.id.progressBarSignUpId);
        signUpEmailEditText = (EditText) findViewById(R.id.tditTextEmailSignUpId);
        signUpasswrdEditText = (EditText) findViewById(R.id.tditTextPasswordSignUpId);
        signUpButton = (Button) findViewById(R.id.buttonSignUpId);
        signInTextView = (TextView) findViewById(R.id.textViewSignInId);

        signInTextView.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonSignUpId:
                userRegister();
                break;

            case R.id.textViewSignInId:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;

        }
    }

    private void userRegister() {
        String email = signUpEmailEditText.getText().toString().trim();
        String password = signUpasswrdEditText.getText().toString().trim();

        if (email.isEmpty()) {
            signUpEmailEditText.setError("Enter an email address");
            signUpEmailEditText.requestFocus();
            return;
        }


        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signUpEmailEditText.setError("Enter a valid email address");
        signUpEmailEditText.requestFocus();
        return; }

        if (password.isEmpty()) {
            signUpasswrdEditText.setError("Enter a password");
            signUpasswrdEditText.requestFocus();
            return;
        }
        if(password.length()<6){
            signUpasswrdEditText.setError("Minimum length of a password should be 6");
            signUpasswrdEditText.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);



        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressBar.setVisibility(View.GONE);

                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Registration is Successful",Toast.LENGTH_LONG).show();


                        }else {
                            Toast.makeText(getApplicationContext(),"Registration is Successful",Toast.LENGTH_LONG).show();



                        }





                    }
                });

    }
}
