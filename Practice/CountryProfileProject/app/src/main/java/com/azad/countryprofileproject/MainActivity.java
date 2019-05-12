package com.azad.countryprofileproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonBD, buttonPK, buttonTK;
    private AlertDialog.Builder alertDialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBD = (Button) findViewById(R.id.bangladeshButtonId);
        buttonPK = (Button) findViewById(R.id.pakistanButtonId);
        buttonTK = (Button) findViewById(R.id.turkeyButtonId);

        buttonBD.setOnClickListener(this);
        buttonPK.setOnClickListener(this);
        buttonTK.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bangladeshButtonId) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "bangladesh");
            startActivity(intent);
        } else if (v.getId() == R.id.pakistanButtonId) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "pakistan");
            startActivity(intent);
        } else if (v.getId() == R.id.turkeyButtonId) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "turkey");
            startActivity(intent);
        }
    }



    @Override
    public void onBackPressed() {
        alertDialogBuilder=new AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setIcon(R.mipmap.questionmark);
        alertDialogBuilder.setTitle(R.string.titleOfAlert);
        alertDialogBuilder.setMessage(R.string.messageOfAlert);
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
