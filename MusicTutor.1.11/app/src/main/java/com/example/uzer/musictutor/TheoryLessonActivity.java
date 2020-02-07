package com.example.uzer.musictutor;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by uzer on 19.02.2016.
 */
public class TheoryLessonActivity extends AppCompatActivity {
    Lesson lesson;
    int numberOfLesson;
    ArrayList<Integer> links;
    ArrayList<Integer> types;


    String nameOfLesson;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_lesson);


        dbHelper = new DatabaseHelper(this, "mydatabase.db",null,4);



        Intent intent = getIntent();
        numberOfLesson = intent.getExtras().getInt("theory");

        nameOfLesson = dbHelper.getNameOfLesson(numberOfLesson);

        setTitle(nameOfLesson);
        lesson = new Lesson(nameOfLesson);

        links = dbHelper.getLinksOnContent(numberOfLesson);
        types = dbHelper.getTypesOfContent(numberOfLesson);
        for (int i = 0; i<links.size(); i++){
            if (types.get(i).equals(0)){
                lesson.addElement(getString(links.get(i)));
            }else if (types.get(i).equals(1)){
                lesson.addElement(getResources().getDrawable(links.get(i)));
            }
        }

        lesson.buildLesson(this,(LinearLayout)findViewById(R.id.theory_lesson));



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar_only_with_arrow,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
