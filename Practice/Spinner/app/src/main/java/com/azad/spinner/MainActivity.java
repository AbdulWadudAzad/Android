package com.azad.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import static com.azad.spinner.R.id.textViewId;

public class MainActivity extends AppCompatActivity {
private TextView textView;
private Spinner spinner;
private Button button;
String[] countryName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView) findViewById(textViewId);
        spinner=(Spinner) findViewById(R.id.spinnerId);
        button=(Button) findViewById(R.id.buttonId);

        countryName=getResources().getStringArray(R.array.country_name);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.sample_view,R.id.textViewOfsampleViewId,countryName);
        spinner.setAdapter(adapter);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String value=spinner.getSelectedItem().toString();
        textView.setText(value);


    }
});

    }
}
