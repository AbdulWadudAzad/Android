package com.azad.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox milk, water, suger;
    private Button button;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        milk = (CheckBox) findViewById(R.id.checkboxmilkid);
        suger = (CheckBox) findViewById(R.id.checkboxsugerid);
        water = (CheckBox) findViewById(R.id.checkboxwaterid);
        button = (Button) findViewById(R.id.buttonid);
        result = (TextView) findViewById(R.id.textView2id);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();

                if (milk.isChecked()) {
                    String value = milk.getText().toString();
                    stringBuilder.append(value + " is checked \n");
                } else if (suger.isChecked()) {
                    String value = suger.getText().toString();
                    stringBuilder.append(value + " is checked \n");
                } else if (water.isChecked()) {
                    String value = water.getText().toString();
                    stringBuilder.append(value + " is checked \n" );
                }
                result.setText(stringBuilder);
            }
        });


    }
}
