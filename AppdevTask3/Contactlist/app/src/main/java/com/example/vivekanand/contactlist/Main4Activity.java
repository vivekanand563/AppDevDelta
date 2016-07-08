package com.example.vivekanand.contactlist;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    EditText editText3;
    EditText editText4;
    DataBase dataBase;
    ImageView imageView4;
    String name ,mobile,n,m;
    int img_id;
    int i;

    int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        imageView4 = (ImageView)findViewById(R.id.imageView4);
        dataBase = new DataBase(this);
        Bundle data = getIntent().getExtras();
        n = data.getString("name");
        m =data.getString("mobile");
        img_id =data.getInt("img");
        imageView4.setImageResource(img_id);
    }

    public void changeimg(View v)
    {

        switch(c%7)
        {
            case 0:
                imageView4.setImageResource(R.drawable.image1);
                i = R.drawable.image1;
                break;
            case 1:
                imageView4.setImageResource(R.drawable.anuj);
                i = R.drawable.anuj;
                break;
            case 2:
                imageView4.setImageResource(R.drawable.gp);
                i = R.drawable.gp;
                break;
            case 3:
                imageView4.setImageResource(R.drawable.ace);
                i = R.drawable.ace;
                break;
            case 4:
                imageView4.setImageResource(R.drawable.jason);
                i = R.drawable.jason;
                break;
            case 5:
                imageView4.setImageResource(R.drawable.naresh);
                i = R.drawable.naresh;
                break;
            case 6:
                imageView4.setImageResource(R.drawable.vivek);
                i = R.drawable.vivek;
                break;

        }
        c++;
    }
    public void savebutton(View v)
    {
        name = editText3.getText().toString();
        mobile = editText4.getText().toString();
        SQLiteDatabase db = dataBase.dbHandler.getWritableDatabase();
        //ContentValues values = new ContentValues();
        //values.put(dataBase.COLUMN_NAME,name);
        //values.put(dataBase.COLUMN_MOBILE,mobile);
        db.execSQL("UPDATE "+dataBase.TABLE_NAME+
                //" SET "+dataBase.COLUMN_NAME+"=\""+ name +"\","+
                " SET "+dataBase.COLUMN_MOBILE+"=\""+ mobile +"\""+
                " WHERE "+dataBase.COLUMN_MOBILE+"=\""+ m +"\";");
        db.execSQL("UPDATE "+dataBase.TABLE_NAME+
                //" SET "+dataBase.COLUMN_NAME+"=\""+ name +"\","+
                " SET "+dataBase.COLUMN_NAME+"=\""+ name +"\""+
                " WHERE "+dataBase.COLUMN_NAME+"=\""+ n +"\";");

        db.execSQL("UPDATE "+dataBase.TABLE_NAME+
                " SET "+dataBase.COLUMN_IMGID+" = "+ Integer.toString(i) +
                " WHERE "+dataBase.COLUMN_IMGID+" = "+ Integer.toString(img_id) +";");

        db.close();
        Toast.makeText(getApplicationContext(),"Contact saved",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Main4Activity.this,MainActivity.class));
    }
}
