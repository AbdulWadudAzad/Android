package com.azad.secondintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Go to the manifests and edit for public the second activity then second activity can be used by any appliction

        button=(Button) findViewById(R.id.firstIntentSecondAct_ButtonID);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.azad.firstintent.SecondActivity");
                startActivity(intent);
            }
        });

    }
}
