package com.example.uzer.musictutor;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by uzer on 31.01.2016.
 */
public class LessonsActivity extends AppCompatActivity {
    Lesson lesson;
    ArrayList<Lesson> lessons;
    ArrayList<String> namesOfLessons;
    ArrayList<HashMap<String, Object>> data;
    ArrayList<Integer> numberOfLesson;
    SimpleAdapter adapter;
    ListView listView;

    SQLiteDatabase sdb;
    DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);


        dbHelper = new DatabaseHelper(this, "mydatabase.db",null,4);
        sdb = dbHelper.getWritableDatabase();

        namesOfLessons = dbHelper.getNamesOfLessons();
        numberOfLesson = dbHelper.getNumbersOfLessons();



        data = new ArrayList<HashMap<String, Object>>(numberOfLesson.size());
        HashMap<String, Object> map;
        for (int i = 0; i < numberOfLesson.size(); i++) {
            map = new HashMap<String, Object>();
            map.put("nameOfLesson", namesOfLessons.get(i));
            map.put("number", numberOfLesson.get(i));
            data.add(map);
        }
        String[] from = {"nameOfLesson"};
        int[] to = {R.id.textView};

        adapter = new SimpleAdapter(this, data, R.layout.adapter_item_lessons, from, to);
        listView = (ListView) findViewById(R.id.lessonsListView);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LessonsActivity.this, TheoryLessonActivity.class);
                //if (lessons.get(position).isAvailiable()) {
                    intent.putExtra("theory", numberOfLesson.get(position));
                    startActivity(intent);
                //} else {
                //     Toast.makeText(getApplicationContext(),getResources().getString(R.string.choise_another_lesson),Toast.LENGTH_SHORT).show();


               //}
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar_only_with_arrow, menu);
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
