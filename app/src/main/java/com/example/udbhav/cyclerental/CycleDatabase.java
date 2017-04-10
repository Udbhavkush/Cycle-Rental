package com.example.udbhav.cyclerental;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by udbhav on 29/3/17.
 */

public class CycleDatabase {

    private static final String DATABASE_NAME = "CYCLE_RENTAL";
    private static final String DATABASE_TABLE = "Cycle_data";
    private static final String DATABASE_TABLE1 = "Booking_data";
    private static final int DATABASE_VERSION = 1;
    public static final String C_NAME = "NAME";
    public static final String C_DESC = "DESCRIPTION";
    public static final String C_ID = "IMAGEID";
    public static final String C_RENT = "RENT_PER_HOUR";

    public static final String U_NAME = "USERNAME";

    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase mydatabase;




    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            Log.d("udbhav", "before creating tables");
            /*db.execSQL(
                    "CREATE TABLE " + DATABASE_TABLE + "("
                    + C_ID + " TEXT PRIMARY KEY, "
                    + C_NAME + " TEXT NOT NULL, "
                    + C_DESC + " TEXT NOT NULL, "
                    + C_RENT + " INTEGER NOT NULL);"
            );*/

            db.execSQL(
                    "CREATE TABLE " + DATABASE_TABLE1 + "("
                            + C_ID + " TEXT PRIMARY KEY, "
                            + C_NAME + " TEXT NOT NULL, "
                            + U_NAME + " TEXT NOT NULL);"
            );

            db.execSQL(
                    "CREATE TABLE " + DATABASE_TABLE + "("
                            + C_ID + " TEXT PRIMARY KEY, "
                            + C_NAME + " TEXT NOT NULL, "
                            + C_DESC + " TEXT NOT NULL, "
                            + C_RENT + " INTEGER NOT NULL);"
            );
            Log.d("udbhav", "both the tables created");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE1);
            onCreate(db);
        }
    }

    public void laudahoonmain(){
        String query="SELECT * FROM "+DATABASE_TABLE1+";";
        Cursor c = dbHelper.getWritableDatabase().rawQuery(query,null);
        if (c!=null)
        {
            c.moveToFirst();
            Log.d("anurag", c.getString(0)+"");
            c.close();
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

    public long createEntry(String i,String s, String s1, Integer integer) {
        ContentValues cv = new ContentValues();
        cv.put(C_ID, i);
        cv.put(C_NAME, s);
        cv.put(C_DESC, s1);
        cv.put(C_RENT, integer);

        return mydatabase.insert(DATABASE_TABLE, null, cv);
    }

    public long createEntry2(String cid,String cname, String uname) {
        ContentValues cv = new ContentValues();
        cv.put(C_ID, cid);
        cv.put(C_NAME, cname);
        cv.put(U_NAME, uname);
        Log.i("I was Here","vjdfbjvdf");
        return mydatabase.insert(DATABASE_TABLE1, null, cv);
    }

    public String getName(String cid) {
        String[] columns = {C_NAME};
        String selection = C_ID + "=?";
        String[] selectionArgs = {cid};
        Cursor cursor = mydatabase.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
        int iname = cursor.getColumnIndex(C_NAME);
        if(cursor.getCount() == 0) return "";
        cursor.moveToFirst();
        String res = "";
        res = res + cursor.getString(iname);
        cursor.close();
        return res;

    }

    public String getDescription(String cid) {
        String[] columns = {C_DESC};
        String selection = C_ID + "=?";
        String[] selectionArgs = {cid};
        Cursor cursor = mydatabase.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
        int idesc = cursor.getColumnIndex(C_DESC);
        if(cursor.getCount() == 0) return "";
        cursor.moveToFirst();
        String res = "";
        res = res + cursor.getString(idesc);
        cursor.close();
        return res;

    }

    public int getRent(String cid) {
        String[] columns = {C_RENT};
        String selection = C_ID + "=?";
        String[] selectionArgs = {cid};
        Cursor cursor = mydatabase.query(DATABASE_TABLE, columns, selection,selectionArgs, null, null, null);
        int irent = cursor.getColumnIndex(C_RENT);
        if (cursor.getCount() == 0) return 0;
        cursor.moveToFirst();
        int res = 0;
        res = cursor.getInt(irent);
        cursor.close();
        return res;
    }


    public String getName1(String cid) {
        String[] columns = {C_NAME};
        String selection = C_ID + "=?";
        Log.d("udbhav", cid);
        String[] selectionArgs = {cid};
        Cursor cursor = mydatabase.query(DATABASE_TABLE1, columns, selection, selectionArgs, null, null, null);
        int iname = cursor.getColumnIndex(C_NAME);
        if (cursor.getCount() == 0) return "";
        cursor.moveToFirst();
        Log.d("udbhav", "aftermovetofirst");
        String res = "";
        res = res + cursor.getString(iname);
        Log.d("udbhav", res);
        cursor.close();
        return res;

    }

    public boolean count(String cid) {
        String[] columns = {C_NAME};
        String selection = C_ID + "=?";
        Log.d("udbhav", cid);
        String[] selectionArgs = {cid};
        Cursor cursor = mydatabase.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
        //int iname = cursor.getColumnIndex(C_NAME);

        if(cursor.getCount() == 0)
            return true;
        return false;

    }

    public boolean count1(String cid) {
        String[] columns = {C_NAME};
        String selection = C_ID + "=?";
        Log.d("udbhav", cid);
        String[] selectionArgs = {cid};
        Cursor cursor = mydatabase.query(DATABASE_TABLE1, columns, selection, selectionArgs, null, null, null);
        //int iname = cursor.getColumnIndex(C_NAME);
        if(cursor.getCount() == 0)
            return true;
        return false;
    }

    /*public String getContent() {
        String[] columns = {C_ID,C_NAME, U_NAME};
        Cursor c = mydatabase.query(DATABASE_TABLE1, columns, null, null, null, null, null );
        String res = "";
        c.moveToFirst();
        //for(c.moveToFirst(); c.isLast(); c.moveToNext()) {
        int iid = c.getColumnIndex(C_ID);
        int iname = c.getColumnIndex(C_NAME);
        int iuname = c.getColumnIndex(U_NAME);
        res = res +" " + c.getString(iname) + " " + c.getString(iuname) + " " + c.getString(iid);
        c.close();
        return res;

    }*/

/*
    public String getContent() {
        String[] columns = {C_ID,C_NAME, C_DESC};
        Cursor c = mydatabase.query(DATABASE_TABLE, columns, null, null, null, null, null );
        String res = "";
        c.moveToLast();
        //for(c.moveToFirst(); c.isLast(); c.moveToNext()) {
            int iid = c.getColumnIndex(C_ID);
            int iname = c.getColumnIndex(C_NAME);
            int idesc = c.getColumnIndex(C_DESC);
            res = res +" " + c.getString(iname) + " " + c.getString(idesc) + " " + c.getString(iid);
        c.close();
        return res;

    }
*/
    public void close() {
        dbHelper.close();
    }



}
