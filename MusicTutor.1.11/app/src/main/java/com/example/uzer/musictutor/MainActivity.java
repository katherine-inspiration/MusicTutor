package com.example.uzer.musictutor;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button lessons, exersices;
    Toast toast;
    Intent intent;
    private static long back_pressed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lessons = (Button)findViewById(R.id.lessons);
        exersices = (Button)findViewById(R.id.exersices);


        lessons.setOnClickListener(this);
        exersices.setOnClickListener(this);
        toast = Toast.makeText(getApplicationContext(),getResources().getString(R.string.want_to_exit),Toast.LENGTH_SHORT);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.lessons:
                toast.cancel();
                intent = new Intent(MainActivity.this, LessonsActivity.class);
                startActivity(intent);
                break;
            case R.id.exersices:
                toast.cancel();
                intent = new Intent(MainActivity.this, ExersicesActivity.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onBackPressed() {

        if (back_pressed + 2000 > System.currentTimeMillis())
            finish();
        else
            toast.show();
        back_pressed = System.currentTimeMillis();




    }
}
