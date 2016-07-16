package com.example.ckkwong.amaze.DatabaseHelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pasarig on 7/15/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Amaze.db";
    public static final String TABLE_USERS = "Users_Table";
    public static final String COL_USER_ID = "User_ID";
    public static final String COL_FULL_NAME = "Full_Name";
    public static final String COL_EMAIL_ID = "Email_ID";
    public static final String COL_PASSWORD = "Password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_USERS + " ( " +
                COL_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_FULL_NAME + " TEXT, " +
                COL_EMAIL_ID + " TEXT, " +
                COL_PASSWORD + " TEXT)"
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(sqLiteDatabase);
    }

    public boolean insert(String fullName, String emailId, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_FULL_NAME, fullName);
        contentValues.put(COL_EMAIL_ID, emailId);
        contentValues.put(COL_PASSWORD, password);
        long result = sqLiteDatabase.insert(TABLE_USERS, null, contentValues);
        return (result == -1) ? false : true;
    }
}
