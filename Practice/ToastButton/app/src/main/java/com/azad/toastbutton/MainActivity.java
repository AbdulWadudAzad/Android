package com.azad.toastbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login,logout;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button) findViewById(R.id.loginbutton);
        logout=(Button) findViewById(R.id.logoutbutton);
        textView=(TextView) findViewById(R.id.textview);
    }
    public void showMessage(View v){
        if(v.getId()==R.id.loginbutton){
            Toast toast=Toast.makeText(MainActivity.this,"Login button is clicked",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,130);
            toast.show();
        }else if(v.getId()==R.id.logoutbutton){
            Toast toast=Toast.makeText(MainActivity.this,"Logout button is clicked",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,170);
            toast.show();
        }
    }
}
