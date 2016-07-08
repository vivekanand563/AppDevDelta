package com.example.vivekanand.contactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    String name,mobile;
    int img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle data = getIntent().getExtras();
        name = data.getString("name");
        mobile =data.getString("mobile");
        img =data.getInt("imgid");
        ImageView imageView3 = (ImageView)findViewById(R.id.imageView3);
        TextView tv = (TextView)findViewById(R.id.textView);
        TextView tv2 = (TextView)findViewById(R.id.textView2);
        tv.setText("Name: "+name);
        tv2.setText("Mobile No: "+mobile);
        imageView3.setImageResource(img);

    }

    public void editbutton(View v)
    {
        Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
        intent.putExtra("name",name);
        intent.putExtra("mobile",mobile);
        intent.putExtra("img",img);
        startActivity(intent);
    }
}
