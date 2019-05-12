package com.azad.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listViewId);

        final String[] countryNames = getResources().getStringArray(R.array.country_name);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.simpleview, R.id.textViewId, countryNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value=countryNames[position];
                Toast.makeText(MainActivity.this,value+" in "+position+" index",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
