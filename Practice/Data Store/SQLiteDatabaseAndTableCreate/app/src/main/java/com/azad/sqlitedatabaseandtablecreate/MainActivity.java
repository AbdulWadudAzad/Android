package com.azad.sqlitedatabaseandtablecreate;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEditText, ageEditText, genderEditText;
    private Button addButton, displayDataButton;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.nameEditTextId);
        ageEditText = (EditText) findViewById(R.id.ageEditTextId);
        genderEditText = (EditText) findViewById(R.id.genderEditTextId);
        addButton = (Button) findViewById(R.id.addButtonId);
        displayDataButton = (Button) findViewById(R.id.displayButtonId);

        databaseHelper = new DatabaseHelper(this); //"this for context
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        addButton.setOnClickListener(this);
        displayDataButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String gender = genderEditText.getText().toString();
        if (v.getId() == R.id.addButtonId) {
            long rowId = databaseHelper.insertData(name, age, gender);  //insertData method is created into DatabseHelper class
            if (rowId == -1) {
                Toast.makeText(getApplicationContext(), "Row insert unsuccessfull", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(getApplicationContext(), "Row " + rowId + " is inserted", Toast.LENGTH_SHORT).show();

            }
        }

        if (v.getId() == R.id.displayButtonId) {
            Cursor result = databaseHelper.displayAllData();
if(result.getCount()==0){
    //display message if no data is availabe

    return;
}

        }

    }


}
