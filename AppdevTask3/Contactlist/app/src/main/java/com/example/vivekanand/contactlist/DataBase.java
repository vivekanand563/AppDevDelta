package com.example.vivekanand.contactlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by Vivekanand on 07-07-2016.
 */
public class DataBase {
    public static final String TABLE_NAME = "contact";
    public static final String COLUMN_IMGID ="img_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_MOBILE = "mobile";

    Context con;
    MyDBHandler dbHandler;

    public DataBase(Context context ) {
        con = context;
        dbHandler = new MyDBHandler(con);
    }

    public void save(String name,String mobile,int image_id) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_MOBILE, mobile);
        values.put(COLUMN_IMGID,image_id);
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        db.insert(TABLE_NAME, COLUMN_NAME, values);
        db.close();
    }


    public ArrayList<String> getallcontacts()
    {
        ArrayList<String> data = new ArrayList<>();
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        String query= "SELECT * FROM " + TABLE_NAME +" WHERE 1";
        Cursor cu = db.rawQuery(query,null);
        cu.moveToFirst();
        while (!cu.isAfterLast())
        {
            String n = cu.getString(cu.getColumnIndex(COLUMN_NAME));
            String m = cu.getString(cu.getColumnIndex(COLUMN_MOBILE));
            String row = n+" "+m;
            data.add(row);
            cu.moveToNext();
        }

        return data;
    }

}
