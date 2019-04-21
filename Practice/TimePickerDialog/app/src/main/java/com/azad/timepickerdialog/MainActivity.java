package com.azad.timepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private TextView textView;
    private TimePickerDialog timePickerDialog;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.buttonId);
        textView=(TextView) findViewById(R.id.textViewId);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TimePicker timePicker=new TimePicker(this);
        int currentHour=timePicker.getCurrentHour();
        int currentMenute=timePicker.getCurrentMinute();

        timePickerDialog=new TimePickerDialog(MainActivity.this,

                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
textView.setText(hourOfDay+":"+minute );
                    }
                }, currentHour, currentMenute,true );
        timePickerDialog.show();
    }
}
