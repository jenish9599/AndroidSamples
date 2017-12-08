package com.jenish9599.android.broadcastreceiverdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jenishpatel on 08/12/17.
 */

public class DBHelper extends SQLiteOpenHelper {



    private static final String DATABASE_NAME = "numberDb";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE  = "create table " + DbContract.TABLE_NAME + "(id integer primary key autoincrement," + DbContract.INCOMING_NUMBER+" text);";
    private static final String DROP_TABLE = "drop table if exists " + DbContract.TABLE_NAME;


    public DBHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
                db.execSQL(CREATE) ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);

    }


    public void saveNumber(String number,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbContract.INCOMING_NUMBER,number);
        db.insert(DbContract.TABLE_NAME,null,contentValues);
    }


    public Cursor readNumber(SQLiteDatabase db)
    {
        String[] projections = {"id",DbContract.INCOMING_NUMBER};

        return (db.query(DbContract.TABLE_NAME,projections,null,null,null,null,null));
    }
}
