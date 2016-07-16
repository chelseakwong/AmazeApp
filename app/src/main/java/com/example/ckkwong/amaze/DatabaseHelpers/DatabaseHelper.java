package com.example.ckkwong.amaze.DatabaseHelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by pasarig on 7/15/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Amaze.db";
    public static final String TABLE_USERS = "Users_Table";
    public static final String COL_USER_ID = "User_ID";
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
                        COL_EMAIL_ID + " TEXT, " +
                        COL_PASSWORD + " TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(sqLiteDatabase);
    }

    public boolean insert(String emailId, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_EMAIL_ID, emailId);
        contentValues.put(COL_PASSWORD, password);
        long result = sqLiteDatabase.insert(TABLE_USERS, null, contentValues);
        return (result == -1) ? false : true;
    }

    public boolean checkIfExistingUser(String emailID, String password, Context context) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String[] columns = {"User_ID"};
        String selection = "Email_ID=?";
        String[] selectionArgs = {emailID};
        Cursor c = null;

        int isExistingUser = 0;
        try {
            c = sqLiteDatabase.query(DatabaseHelper.TABLE_USERS, columns, selection, selectionArgs, null, null, null);
            c.moveToFirst();
            isExistingUser = c.getCount();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return (isExistingUser <= 0) ? false : true;
    }


    public boolean checkIfValidUser(String emailID, String password, Context context) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String[] columns = {"User_ID"};
        String selection = "Email_ID=? AND Password=?";
        String[] selectionArgs = {emailID, password};
        Cursor c = null;

        int isExistingUser = 0;
        try {
            c = sqLiteDatabase.query(DatabaseHelper.TABLE_USERS, columns, selection, selectionArgs, null, null, null);
            c.moveToFirst();
            isExistingUser = c.getCount();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return (isExistingUser <= 0) ? false : true;
    }
}
