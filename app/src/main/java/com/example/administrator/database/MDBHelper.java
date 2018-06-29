package com.example.administrator.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MDBHelper extends SQLiteOpenHelper {
    public static final String KEY_ID="_id";
    public static final String KEY_NAME="name";
    public static final String KEY_PHONE="phone";
    public static final String KEY_EMAIL="email";
    public static final String KEY_BIRTH="bir";
    public static final String DATABASE_NAME="Contact";
    public static final String TABLE_NAME="mem";
    public static final int DATABASE_VERSION= 1;

    public MDBHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       final String DATABASE_CREATE ="CREATE TABLE IF NOT EXISTS "+ TABLE_NAME+ "("+
                                    KEY_ID+" integer PRIMARY KEY autoincrement,"+
                                    KEY_NAME+","+
                                    KEY_PHONE+","+
                                    KEY_EMAIL+","+
                                    KEY_BIRTH+"):";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
