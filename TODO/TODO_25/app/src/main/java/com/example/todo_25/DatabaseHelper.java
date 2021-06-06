package com.example.todo_25;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "StudentRecord.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME" ;
    public static final String COL_4 = "MARKS";
    public DatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME
        + " (ID INTEGER PRIMARY KEY, " + " NAME TEXT, SURNAME TEXT, MARKS INTEGER)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String id, String name, String surname, String marks) {
        SQLiteDatabase db = this.getWritableDatabase(); //to write insert the database
        //to put values insert the table
        //remember that it is not yet inserted in database
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, marks);

        //insert it in database
        //long is used because the return type is -1
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            //not successful
            return false;
        else
            return true;

    }
        //the data retreived will be in cursor format
    //return cursor to mainactivity
    public Cursor getAllData () {
        SQLiteDatabase db = this.getWritableDatabase();
        //selectionargs is null because we are going to retrieve all the data
                //if you have condition like where ID is 12190106, then we have to use selectionargs
                Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
                return res;
    }

    public boolean updateData(String id, String name, String surname, String marks){
        //we have to create object of database in every operation
        SQLiteDatabase db1 = this.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(COL_1, id);
                contentValues.put(COL_2, name);
                contentValues.put(COL_3, surname);
                contentValues.put(COL_4, marks);
              long result =   db1.update(TABLE_NAME, contentValues, "ID = ?", new String[] { id });
                if (result != 0)
                    return true;
                return false;

    }

    public Integer deleteData(String id ){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {
                id
        });
    }


}

