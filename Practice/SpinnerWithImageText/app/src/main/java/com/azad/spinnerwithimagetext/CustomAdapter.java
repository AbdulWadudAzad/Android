package com.azad.spinnerwithimagetext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private String[] countryName;
    private String[] poplation;
    int[] flags;
    Context context;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int[] flags, String[] countryName, String[] poplation ) {
        this.context = context;
        this.flags = flags;
        this.countryName = countryName;
        this.poplation = poplation;
    }

    @Override
    public int getCount() {
        return countryName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if(view==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.sample_view,null,false);

        }
        ImageView imageView=view.findViewById(R.id.countryFlagId);
        imageView.setImageResource(flags[position]);

        TextView country=view.findViewById(R.id.countryNameId);
        country.setText(countryName[position]);

        TextView totalPopulation=view.findViewById(R.id.countryPopulationId);
        totalPopulation.setText(poplation[position]);
        return view;
    }
}
