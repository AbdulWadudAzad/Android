package com.azad.sqlitedatabaseandtablecreate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEditText, ageEditText, genderEditText, idEditText;
    private Button addButton, displayDataButton, updateButton, deleteButton;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.nameEditTextId);
        ageEditText = (EditText) findViewById(R.id.ageEditTextId);
        genderEditText = (EditText) findViewById(R.id.genderEditTextId);
        idEditText = (EditText) findViewById(R.id.idEditTextId);
        addButton = (Button) findViewById(R.id.addButtonId);
        displayDataButton = (Button) findViewById(R.id.displayButtonId);
        updateButton = (Button) findViewById(R.id.updateButtonId);
        deleteButton = (Button) findViewById(R.id.deleteButtonId);

        databaseHelper = new DatabaseHelper(this); //"this for context
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        addButton.setOnClickListener(this);
        displayDataButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = nameEditText.getText().toString(); //taking the value of Name field from view in name as a string
        String age = ageEditText.getText().toString();
        String gender = genderEditText.getText().toString();
        String id = idEditText.getText().toString();


        if (v.getId() == R.id.addButtonId) {
            long rowId = databaseHelper.insertData(name, age, gender);  //insertData method is created into DatabseHelper class
            if (rowId == -1) {
                Toast.makeText(getApplicationContext(), "Row insert unsuccessfull", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(getApplicationContext(), "Row " + rowId + " is inserted", Toast.LENGTH_SHORT).show();

            }
        } else if (v.getId() == R.id.displayButtonId) {
            Cursor result = databaseHelper.displayAllData();
            if (result.getCount() == 0) {
                //display message if no data is availabe
                showData("Error", "No data found");
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (result.moveToNext()) {
                stringBuffer.append("ID : " + result.getString(0) + "\n");
                stringBuffer.append("Name : " + result.getString(1) + "\n");
                stringBuffer.append("Age : " + result.getString(2) + "\n");
                stringBuffer.append("Gender : " + result.getString(3) + "\n\n\n");
            }
            showData("ResultSet", stringBuffer.toString());
        } else if (v.getId() == R.id.updateButtonId) {
           Boolean isUpdate= databaseHelper.updateData(id, name, age, gender);
           if(isUpdate==true){
               Toast.makeText(getApplicationContext(), "Data update successfull", Toast.LENGTH_SHORT).show();
           }else {
               Toast.makeText(getApplicationContext(), "Data update unsuccessfull", Toast.LENGTH_SHORT).show();

           }

        } else if (v.getId() == R.id.deleteButtonId) {
            int value= databaseHelper.deleteData(id);
            if(value > 0){
                Toast.makeText(getApplicationContext(), "Data delete successfull", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(), "Data delete unsuccessfull", Toast.LENGTH_SHORT).show();

            }

        }

    }

    public void showData(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
    }

}
