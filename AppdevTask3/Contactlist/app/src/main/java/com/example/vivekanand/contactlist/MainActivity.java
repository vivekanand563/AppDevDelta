package com.example.vivekanand.contactlist;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ListView vivekslistview;
    DataBase dbhandler;
    ArrayList<String> al = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhandler = new DataBase(this);
        vivekslistview = (ListView)findViewById(R.id.vivekslistview);
        al = dbhandler.getallcontacts();

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al);

        vivekslistview.setAdapter(adp);
        vivekslistview.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String str = String.valueOf(parent.getItemAtPosition(position));

                        SQLiteDatabase db = dbhandler.dbHandler.getReadableDatabase();
                        String query= "SELECT * FROM " + dbhandler.TABLE_NAME +" WHERE 1";
                        Cursor cu = db.rawQuery(query,null);
                        cu.moveToFirst();
                        while (!cu.isAfterLast())
                        {
                            String n = cu.getString(cu.getColumnIndex(dbhandler.COLUMN_NAME));
                            String m = cu.getString(cu.getColumnIndex(dbhandler.COLUMN_MOBILE));
                            int imageid = cu.getInt(cu.getColumnIndex(dbhandler.COLUMN_IMGID));
                            String row = n+" "+m;
                            if(Objects.equals(row,str))
                            {
                                Intent i = new Intent(MainActivity.this,Main3Activity.class);
                                i.putExtra("name",n);
                                i.putExtra("mobile",m);
                                i.putExtra("imgid",imageid);
                                startActivity(i);
                            }
                            cu.moveToNext();
                        }


                    }
                }
        );
    }

    public void onClick(View v)
    {
        Intent b = new Intent(MainActivity.this,Main2Activity.class);
        b.putExtra("id",0);
        startActivity(b);

    }
}
