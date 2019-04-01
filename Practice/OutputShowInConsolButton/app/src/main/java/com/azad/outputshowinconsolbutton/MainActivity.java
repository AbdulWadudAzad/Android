package com.azad.outputshowinconsolbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
            Log.d("tag","Login Button is Clicked");
        }else if(v.getId()==R.id.logoutbutton){
            Log.d("tag","Logout Button is Clicked");

        }
    }

//    after running the project go to android monitor/Run consol for view output
}
