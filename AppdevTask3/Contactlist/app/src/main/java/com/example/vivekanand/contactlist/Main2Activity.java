package com.example.vivekanand.contactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    DataBase dbhandler;
    ImageView imageView2;
    int _id;
    //int default_id =R.drawable.image1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        dbhandler = new DataBase(this);
        Bundle data = getIntent().getExtras();
        _id = data.getInt("id");
        if(_id != 0)
        {
            imageView2 = (ImageView)findViewById(R.id.imageView2);
            imageView2.setImageResource(_id);
        }

    }
     public void savebuttonclick(View v)
     {
         String name ,mobile;
         name = editText.getText().toString();
         mobile = editText2.getText().toString();

         if(_id == 0)
         {   dbhandler.save(name,mobile,R.drawable.image1);}
         else
         {
             dbhandler.save(name,mobile,_id);
         }
         Toast.makeText(this,"Contact saved",Toast.LENGTH_SHORT).show();
         startActivity(new Intent(Main2Activity.this,MainActivity.class));




     }


    public void backbuttonclick(View v)
    {
        startActivity(new Intent(Main2Activity.this,MainActivity.class));
    }

    public void imgclick(View v)
    {
        startActivity(new Intent(Main2Activity.this,Main5Activity.class));
    }




}
