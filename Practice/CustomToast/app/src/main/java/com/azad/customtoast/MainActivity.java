package com.azad.customtoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.loginButtonId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=getLayoutInflater();
              View customView=  inflater.inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.customtoastid));
                Toast toast=new Toast(MainActivity.this);
                toast.setGravity(Gravity.CENTER,0,0);
              toast.setDuration(Toast.LENGTH_SHORT);
              toast.setView(customView);
              toast.show();
            }
        });
    }
}
