package com.azad.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView, imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageViewId);
        imageView1 = (ImageView) findViewById(R.id.imageView1Id);
        imageView2 = (ImageView) findViewById(R.id.imageView2Id);

        imageView.setOnClickListener(this);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageViewId) {
            imageView.setVisibility(View.GONE);
            imageView1.setVisibility(View.VISIBLE);

        } else if (v.getId() == R.id.imageView1Id) {
            imageView1.setVisibility(View.GONE);
            imageView2.setVisibility(View.VISIBLE);

        } else if(v.getId() == R.id.imageView2Id) {
            imageView2.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);

        }
    }
}
