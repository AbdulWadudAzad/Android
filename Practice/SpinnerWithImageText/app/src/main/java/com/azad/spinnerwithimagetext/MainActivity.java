package com.azad.spinnerwithimagetext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private String[] countryName;
    private String[] poplation;
    private int[] flags = {R.drawable.afghanistan, R.drawable.armenia, R.drawable.azerbaijan, R.drawable.bahrain
            , R.drawable.bangladesh, R.drawable.bhutan, R.drawable.brunei, R.drawable.cambodia, R.drawable.china
            , R.drawable.cyprus, R.drawable.egypt, R.drawable.georgia, R.drawable.india, R.drawable.indonesia
            , R.drawable.iran, R.drawable.iraq};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinnerId);

        countryName = getResources().getStringArray(R.array.country_name);
        poplation = getResources().getStringArray(R.array.total_population);

        CustomAdapter adapter = new CustomAdapter(this, flags, countryName, poplation);
        spinner.setAdapter(adapter);
    }
}
