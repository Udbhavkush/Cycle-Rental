package com.example.udbhav.cyclerental;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by udbhav on 29/3/17.
 */

public class CycleDatabase {

    private static final String DATABASE_NAME = "CYCLES_RENTAL";
    private static final String DATABASE_TABLE = "Cycle_data";
    private static final int DATABASE_VERSION = 1;

    public static final String C_NAME = "NAME";
    public static final String C_DESC = "DESCRIPTION";
    public static final String C_RENT = "RENT_PER_HOUR";

    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase mydatabase;




    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(
                    "CREATE TABLE " + DATABASE_TABLE + "("
                    + C_NAME + " TEXT PRIMARY KEY, "
                    + C_DESC + " TEXT NOT NULL , "
                    + C_RENT + " INTEGER NOT NULL);"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    public CycleDatabase(Context c) {
        context = c;
    }

    public CycleDatabase open() throws SQLException {
        dbHelper = new DBHelper(context);
        mydatabase = dbHelper.getWritableDatabase();
        return this;
    }

    public long createEntry(String s, String s1, Integer integer) {
        ContentValues cv = new ContentValues();
        cv.put(C_NAME, s);
        cv.put(C_DESC, s1);
        cv.put(C_RENT, integer);
        return mydatabase.insert(DATABASE_TABLE, null, cv);
    }

    public String getDescription(String name) {
        String[] columns = {C_DESC};
        String selection = C_NAME + "=?";
        String[] selectionArgs = {name};
        Cursor cursor = mydatabase.query(DATABASE_TABLE, columns, selection,selectionArgs, null, null, null);
        int idesc = cursor.getColumnIndex(C_DESC);
        cursor.moveToFirst();
        String res = "";
        res = res + cursor.getString(idesc);
        cursor.close();
        return res;

    }

    public int getRent(String name) {
        String[] columns = {C_RENT};
        String selection = C_NAME + "=?";
        String[] selectionArgs = {name};
        Cursor cursor = mydatabase.query(DATABASE_TABLE, columns, selection,selectionArgs, null, null, null);
        int idesc = cursor.getColumnIndex(C_RENT);
        cursor.moveToFirst();
        int res = 0;
        res = cursor.getInt(idesc);
        cursor.close();
        return res;

    }

    public void close() {
        dbHelper.close();
    }



}
