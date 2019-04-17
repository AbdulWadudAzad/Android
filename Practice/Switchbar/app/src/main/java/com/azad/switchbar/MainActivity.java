package com.azad.switchbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aSwitch=(Switch) findViewById(R.id.switchId);

aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
if(isChecked){
    Toast.makeText(MainActivity.this,"On",Toast.LENGTH_SHORT).show();
}else {
    Toast.makeText(MainActivity.this,"Off",Toast.LENGTH_SHORT).show();

}
    }
});


    }
}
