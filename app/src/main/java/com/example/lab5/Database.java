package com.example.lab5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class Database extends SQLiteOpenHelper {
    public Database( Context context) {
        super(context, "userdb",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(username TEXT primary key , password TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    public boolean insertData(String username , String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result=db.insert("user",null,contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public boolean getData(String username,String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from user where username='" + username + "' and password=='"+password+"'", null);
        if (cr.getCount() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
