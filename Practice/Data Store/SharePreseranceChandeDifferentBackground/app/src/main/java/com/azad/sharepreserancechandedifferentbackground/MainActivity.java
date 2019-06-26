package com.azad.sharepreserancechandedifferentbackground;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.linerLayoutId);

        if(loadColor() != 0){
            linearLayout.setBackgroundColor(loadColor());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.skyColorId) {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.skyColor));
            storeColor(getResources().getColor(R.color.skyColor));
        } if (item.getItemId() == R.id.orangeColorId) {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.orangeColor));
            storeColor(getResources().getColor(R.color.orangeColor));
        } if (item.getItemId() == R.id.greenColorId) {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.greenColor));
            storeColor(getResources().getColor(R.color.greenColor));
        }
        return super.onOptionsItemSelected(item);
    }

    private void storeColor(int color) {
        SharedPreferences sharedPreferences = getSharedPreferences("BackgroundColor", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("myColor", color);
        editor.commit();
    }

    private int loadColor() {
        SharedPreferences sharedPreferences = getSharedPreferences("BackgroundColor", Context.MODE_PRIVATE);
        int selectColor = sharedPreferences.getInt("myColor", 0);
        return selectColor;
    }

}
