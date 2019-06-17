package com.azad.backbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button button,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.buttonId);
        button2=(Button) findViewById(R.id.button2Id);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonId){
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        } else if (v.getId()==R.id.button2Id){
            Intent intent=new Intent(MainActivity.this,Main3Activity.class);
            startActivity(intent);
        }
    }
}
