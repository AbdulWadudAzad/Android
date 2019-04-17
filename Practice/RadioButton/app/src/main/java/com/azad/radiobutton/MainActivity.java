package com.azad.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private RadioGroup radioGroup;
private RadioButton radioButton;
private Button button;
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=(RadioGroup) findViewById(R.id.radioGroupId);
        button=(Button) findViewById(R.id.showButtonid);
        textView=(TextView) findViewById(R.id.resultId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int selectedId=  radioGroup.getCheckedRadioButtonId();

              radioButton=(RadioButton) findViewById(selectedId);
                String value= radioButton.getText().toString();

              textView.setText("You have selected "+ value);
            }
        });

    }
}
