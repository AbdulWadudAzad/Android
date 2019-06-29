package com.azad.sqlitedatabaseandtablecreate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Student.db";
    private static final String TABLE_NAME = "student_details";
    private static final int VERSION_NAME = 2;  //change the version every time like: 1, 2, 3...

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String AGE = "Age";
    private static final String GENDER = "Gender";

    /// it's use to create database first time
    // private static final String CREATE_TABLE=" CREATE TABLE "+TABLE_NAME+"( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255), "+AGE+" INTEGER );";
    ///After create database then add gender for update databae
    private static final String CREATE_TABLE = " CREATE TABLE " + TABLE_NAME + "( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255), " + AGE + " INTEGER, " + GENDER + " VARCHAR(20) );";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

    private Context context;  //context use to show Toast

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NAME);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Toast.makeText(context, "Tble is created :", Toast.LENGTH_SHORT).show();
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {
            Toast.makeText(context, "Exception :" + e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Toast.makeText(context, "Table is updated :", Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (Exception e) {
            Toast.makeText(context, "Exception :" + e, Toast.LENGTH_SHORT).show();
        }
    }

    public long insertData(String name, String age, String gender) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase(); //for wright/store in database
        ContentValues contentValues = new ContentValues(); //for all data store together
        contentValues.put(NAME, name); //Column name and value
        contentValues.put(AGE, age);
        contentValues.put(GENDER, gender);
        long rowId = sqLiteDatabase.insert(TABLE_NAME, null, contentValues); //Use to insert into database
        return rowId;
    }

    public Cursor displayAllData() {  // method for display all data
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL, null);
        return cursor;
    }

    public boolean updateData(String id, String name, String age, String gender) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(); //for all data store together
        contentValues.put(NAME, name); //Column name and value
        contentValues.put(AGE, age);
        contentValues.put(GENDER, gender);
        contentValues.put(ID, id);
        sqLiteDatabase.update(TABLE_NAME, contentValues, ID+" = ?", new String[]{id});
        return true;
    }


    public Integer deleteData(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME, ID +" = ?",new String[]{id});
    }


}
