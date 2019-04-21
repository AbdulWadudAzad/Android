package com.azad.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.DigitalClock;
import android.widget.TextClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private AnalogClock analogClock;
private TextClock textClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        analogClock=(AnalogClock) findViewById(R.id.analogClockId);
        textClock=(TextClock) findViewById(R.id.textClockId);

        analogClock.setOnClickListener(this);
        textClock.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
if (v.getId()==R.id.analogClockId){
    Toast.makeText(MainActivity.this,"Analog Clock",Toast.LENGTH_SHORT).show();
}else if (v.getId()==R.id.textClockId){
    Toast.makeText(MainActivity.this,"Text Clock",Toast.LENGTH_SHORT).show();
}
    }
}
