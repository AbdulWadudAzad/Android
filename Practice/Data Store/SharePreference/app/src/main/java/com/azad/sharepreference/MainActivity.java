package com.azad.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEditText, mobileEditText;
    private Button saveButton, loadButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameEditText = (EditText) findViewById(R.id.nameEditTextId);
        mobileEditText = (EditText) findViewById(R.id.mobileEditTextId);
        saveButton = (Button) findViewById(R.id.save_btnId);
        loadButton = (Button) findViewById(R.id.load_btnId);
        resultTextView = (TextView) findViewById(R.id.resultTextViewId);

        saveButton.setOnClickListener(this);
        loadButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.save_btnId) {

            String userName = nameEditText.getText().toString();
            String mobile = mobileEditText.getText().toString();
            if (userName.equals("") && mobile.equals("")) {
                Toast.makeText(MainActivity.this, "Please enter some data", Toast.LENGTH_SHORT).show();
            } else {
                //Store data in SharePreference
                //here userDetails is a Database name
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit(); //use to write the data
                editor.putString("nameKey", userName); //data is taken by a key, which is nameKey
                editor.putString("mobileKey", mobile);
                editor.commit();

                //used to remobe old data from display after click on save
                nameEditText.setText("");
                mobileEditText.setText("");

                Toast.makeText(MainActivity.this, "Data stored successfully", Toast.LENGTH_SHORT).show();
            }


        } else if (v.getId() == R.id.load_btnId) {
            //to read data or show data
            SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
            if (sharedPreferences.contains("nameKey") && sharedPreferences.contains("mobileKey")) {
                String username = sharedPreferences.getString("nameKey", "Data not found");
                String mobile = sharedPreferences.getString("mobileKey", "Data not found");
                resultTextView.setText(username + "\n" + mobile);
            }

        }


    }
}
