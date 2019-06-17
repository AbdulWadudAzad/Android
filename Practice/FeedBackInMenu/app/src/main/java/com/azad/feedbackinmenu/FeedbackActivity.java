package com.azad.feedbackinmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {
    private Button submitButton, clearButton;
    private EditText nameEditText, messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        submitButton = (Button) findViewById(R.id.submitButtonId);
        clearButton = (Button) findViewById(R.id.clearButtonId);
        nameEditText = (EditText) findViewById(R.id.NameEditTextId);
        messageEditText = (EditText) findViewById(R.id.MessageEditTextId);

        submitButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        try {

            String name = nameEditText.getText().toString();
            String message = messageEditText.getText().toString();

            if (v.getId() == R.id.submitButtonId) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"azadmiu37@gmail.com"});
                //Here we can a single email address or multiple email address, where all email will be send

                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from app");
                intent.putExtra(Intent.EXTRA_TEXT, "Name: " + name + "\n Message: " + message);

                startActivity(Intent.createChooser(intent, "Feedback with"));

            } else if (v.getId() == R.id.clearButtonId) {

                nameEditText.setText("");
                messageEditText.setText("");

            }

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Exception :"+ e,Toast.LENGTH_SHORT).show();
        }


    }
}
