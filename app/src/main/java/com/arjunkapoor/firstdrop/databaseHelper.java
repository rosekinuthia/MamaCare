package com.arjunkapoor.firstdrop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.sql.Date;

/**
 * Created by ARJUN on 3/17/2016.
 */
public class databaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "babyDatabase";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "BABYTABLE";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DOB = "dateofbirth";
    private static final String KEY_GENDER = "gender";


    public databaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE_CREATION = "CREATE TABLE " + TABLE_NAME +
                "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_NAME + " TEXT," +
                KEY_DOB + " DATE," +
                KEY_GENDER + " TEXT);";
        db.execSQL(TABLE_CREATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    public void addBaby(babyDatabaseManager baby) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, baby.getName()); // Contact Name
        values.put(KEY_DOB, baby.getdateofbirth());
        values.put(KEY_GENDER, baby.getgender());// Contact Phone Number

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    public babyDatabaseManager getBaby(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID,
                        KEY_NAME, KEY_DOB, KEY_GENDER}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        babyDatabaseManager baby = new babyDatabaseManager(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));
        // return contact
        return baby;
    }

    public int totalCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    public void deleteEntry(int rowId) {
        SQLiteDatabase db = getWritableDatabase();
        String x = "UPDATE " + TABLE_NAME + " SET " + KEY_NAME + " = " + " 'deleted'" + " where " + KEY_ID + " = " + rowId;
        db.execSQL(x);

    }


}
