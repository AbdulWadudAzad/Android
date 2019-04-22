package com.azad.font;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView textView1,textView2;
private Typeface typeface1,typeface2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1=(TextView) findViewById(R.id.textVied1Id);
        textView2=(TextView) findViewById(R.id.textVied2Id);

        typeface1=Typeface.createFromAsset(getAssets(),"fonts/BodoniFLF_Bold.ttf");
        textView1.setTypeface(typeface1);

        typeface2=Typeface.createFromAsset(getAssets(),"fonts/BodoniFLF_Italic.ttf");
        textView1.setTypeface(typeface2);
    }
}
