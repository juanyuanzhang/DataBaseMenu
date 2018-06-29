package com.example.administrator.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class MDBAdapter {
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_BIRTH = "bir";
    private MDBHelper mdbHelper;
    private SQLiteDatabase mdb;
    private final Context mCtx;
    private static final String TABLE_NAME = "mem";
    private ContentValues values;
    public MDBAdapter(Context mCtx){
        this.mCtx = mCtx;
        open();

    }
    public void open (){
        mdbHelper = new MDBHelper(mCtx);
        mdb= mdbHelper.getWritableDatabase();
        Log.i("open","成功");

    }
    public void close(){
        if (mdbHelper!= null){
            mdbHelper.close();
        }
    }
    public Cursor listContacts(){
        Cursor mCurcor = mdb.query(TABLE_NAME,new String[]{KEY_ID,KEY_NAME,KEY_PHONE,KEY_EMAIL,KEY_BIRTH},null,null,null,null,null,null);
        if (mCurcor != null){
            mCurcor.moveToFirst();
        }
        return mCurcor;
    }
    public long createContact(String name ,String phone , String email ,String birth){
        try {
            values = new ContentValues();
            values.put(KEY_NAME, name);
            values.put(KEY_PHONE, phone);
            values.put(KEY_EMAIL, email);
            values.put(KEY_BIRTH, birth);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Toast.makeText(mCtx,"新增成功",Toast.LENGTH_LONG).show();
        }
        return mdb.insert(TABLE_NAME,null,values);
    }
    public long updateContacts (int id,String name,String phone , String email, String birth){
        return
    }
}
