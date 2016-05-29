package com.example.vivekanand.task;


import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int c = 0;
    TextView vivekstext;
    Button viveksbutton;
    Button resetbutton;
    RelativeLayout vivekslayout;
    String c3;


    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        c3=vivekstext.getText().toString();
        outState.putString("edittext",c3);

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        vivekstext.setText(savedInstanceState.getString("edittext"));
        c=Integer.parseInt(vivekstext.getText().toString());
        change(c);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        viveksbutton = (Button)findViewById(R.id.viveksbutton);
        resetbutton = (Button)findViewById(R.id.resetbutton);
        vivekstext = (TextView)findViewById(R.id.vivekstext);
        SharedPreferences backup = getSharedPreferences("key",MODE_PRIVATE);
        c= backup.getInt("count", 0);
        vivekstext.setText(Integer.toString(c));
        change(c);



        viveksbutton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v)
                    {

                        c++;
                        SharedPreferences backup =getSharedPreferences("key",MODE_PRIVATE);
                        SharedPreferences.Editor backup_edit= backup.edit();
                        backup_edit.putInt("count",c);
                        backup_edit.commit();

                        vivekstext.setText(Integer.toString(c));

                        change(c);
                    }
                }
        );
        resetbutton.setOnClickListener(
                new Button.OnClickListener()
                {
                    public  void onClick(View s)
                    {
                        c=0;
                        SharedPreferences backup =getSharedPreferences("key",MODE_PRIVATE);
                        SharedPreferences.Editor backup_edit= backup.edit();
                        backup_edit.putInt("count",0);
                        backup_edit.commit();
                        vivekstext.setText(Integer.toString(0));
                        change(0);

                    }
                }
        );


    }

    public void change(int a)
    {

        vivekslayout=(RelativeLayout)findViewById(R.id.vivekslayout);
        if(a==0)
        {
            vivekslayout.setBackgroundColor(Color.WHITE);
        }
        else
        {
            a=a%4;
            switch (a)
            {
                case 0:
                    vivekslayout.setBackgroundColor(Color.RED);
                    break;
                case 1:
                    vivekslayout.setBackgroundColor(Color.GREEN);
                    break;
                case 2:
                    vivekslayout.setBackgroundColor(Color.BLUE);
                    break;
                case 3:
                    vivekslayout.setBackgroundColor(Color.GRAY);
                    break;
            }
        }
    }


}
