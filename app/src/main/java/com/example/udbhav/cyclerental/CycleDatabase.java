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

    public String getData() {
        String[] columns = new String[]{C_NAME, C_DESC, C_RENT};
        Cursor c = mydatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
        String result = "";

        int iname = c.getColumnIndex(C_NAME);
        int idesc = c.getColumnIndex(C_DESC);
        int irent = c.getColumnIndex(C_RENT);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result = result + c.getString(iname) + " " + c.getString(idesc) + " " + c.getString(irent) + "\n";
        }
        return result;
    }

    public void close() {
        dbHelper.close();
    }



}
