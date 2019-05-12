package com.azad.countryprofileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = (ImageView) findViewById(R.id.imageViewId);
        textView = (TextView) findViewById(R.id.textViewId);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String countryName = bundle.getString("name");
            showDetais(countryName);
        }


    }

    void showDetais(String countryName){

        if(countryName.equals("bangladesh")){
            imageView.setImageResource(R.mipmap.bangladesh);
            textView.setText(R.string.Bangladesh_Details);
        }
        if(countryName.equals("pakistan")){
            imageView.setImageResource(R.mipmap.pakistan);
            textView.setText(R.string.Pakistan_Details);
        }
        if(countryName.equals("turkey")){
            imageView.setImageResource(R.mipmap.turkey);
            textView.setText(R.string.Turkey_Details);
        }

    }

}
