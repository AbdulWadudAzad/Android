package com.azad.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private GridView gridView;
    private String[] countryNames;
    int[] flags = {R.drawable.afghanistan, R.drawable.armenia, R.drawable.azerbaijan, R.drawable.bahrain,
            R.drawable.bangladesh, R.drawable.bhutan, R.drawable.brunei, R.drawable.cambodia, R.drawable.the_peoples_republic_of_china
            , R.drawable.cyprus, R.drawable.georgia, R.drawable.egypt,  R.drawable.india, R.drawable.indonesia
            , R.drawable.iran, R.drawable.iraq, R.drawable.japan, R.drawable.jordan, R.drawable.kazakhstan
            , R.drawable.kuwait, R.drawable.kyrgyzstan, R.drawable.laos, R.drawable.lebanon, R.drawable.malaysia
            , R.drawable.maldives, R.drawable.mongolia, R.drawable.myanmar, R.drawable.nepal, R.drawable.north_korea
            , R.drawable.oman, R.drawable.pakistan, R.drawable.palestine, R.drawable.the_philippines, R.drawable.qatar
            , R.drawable.russia, R.drawable.saudi_arabia, R.drawable.singapore, R.drawable.south_korea, R.drawable.sri_lanka
            , R.drawable.syria, R.drawable.taiwan, R.drawable.tajikistan, R.drawable.thailand, R.drawable.east_timor
            , R.drawable.turkey, R.drawable.turkmenistan, R.drawable.the_united_arab_emirates, R.drawable.uzbekistan
            , R.drawable.vietnam, R.drawable.yemen};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNames = getResources().getStringArray(R.array.country_name);
        gridView = (GridView) findViewById(R.id.listViewId);


        CustomAdapter adapter=new CustomAdapter(this, countryNames,flags);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value=countryNames[position];
                Toast.makeText(MainActivity.this,value,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
