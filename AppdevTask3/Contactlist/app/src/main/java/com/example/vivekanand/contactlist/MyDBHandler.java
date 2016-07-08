package com.example.vivekanand.contactlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vivekanand on 07-07-2016.
 */
public class MyDBHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="contact.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "contact";
    public static final String COLUMN_ID ="_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_MOBILE = "mobile";
    public static final String COLUMN_IMGID = "img_id";
    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+TABLE_NAME+ " ("
                +COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COLUMN_NAME+" VARCHAR(100), "
                +COLUMN_MOBILE+" VARACHAR(100), "
                +COLUMN_IMGID+" INTEGER"+
                ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        //onCreate(db);
    }


}
