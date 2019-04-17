package com.azad.edittext1;

import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText1, editText2;
    private Button add, subb;
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.edittext1id);
        editText2 = (EditText) findViewById(R.id.edittext2id);

        add = (Button) findViewById(R.id.addbutton);
        subb = (Button) findViewById(R.id.subbbutton);

        textView1 = (TextView) findViewById(R.id.textView1id);

        add.setOnClickListener(this);
        subb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try{

            String number1 = editText1.getText().toString();
            String number2 = editText2.getText().toString();

//converting into double
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);

            if (v.getId() == R.id.addbutton) {
                Double sum = num1 + num2;
                textView1.setText("Result : "+sum);
            } else if (v.getId() == R.id.subbbutton) {
                Double sum = num1 - num2;
                textView1.setText("Result : "+sum);
            }

        }catch (Exception e){
            Toast.makeText(MainActivity.this,"Please Enter numbers",Toast.LENGTH_SHORT).show();
        }

    }
}
