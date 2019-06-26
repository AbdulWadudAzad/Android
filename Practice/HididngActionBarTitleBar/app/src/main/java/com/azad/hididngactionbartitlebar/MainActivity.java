package com.azad.hididngactionbartitlebar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Hiding Action Bar
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button1=(Button) findViewById(R.id.button1Id);
        button2=(Button) findViewById(R.id.button2Id);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button1Id){
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.button2Id){
            Intent intent=new Intent(MainActivity.this,Main3Activity.class);
            startActivity(intent);
        }
    }
}
