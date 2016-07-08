package com.example.vivekanand.contactlist;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    ListView lv;
    ListAdapter adp;
    int _id[] = {R.drawable.image1,R.drawable.ace,R.drawable.anuj,R.drawable.naresh,R.drawable.jason,R.drawable.vivek};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        adp = new customadapter(Main5Activity.this,_id);
        lv = (ListView)findViewById(R.id.lv);
        lv.setAdapter(adp);
        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Toast.makeText(getApplicationContext(),String.valueOf(_id[position]),Toast.LENGTH_SHORT).show();
                        Intent s = new Intent(Main5Activity.this,Main2Activity.class);
                        s.putExtra("id",_id[position]);
                        startActivity(s);
                    }
                }
        );
    }


}
