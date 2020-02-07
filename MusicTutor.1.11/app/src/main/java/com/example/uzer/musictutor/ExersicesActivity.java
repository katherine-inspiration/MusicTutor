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

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by uzer on 15.02.2016.
 */

public class ExersicesActivity extends AppCompatActivity {
    ArrayList <String> namesOfExercises;
    ArrayList <Integer> numberOfExercise;
    ArrayList<HashMap<String, Object>> data;
    SimpleAdapter adapter;
    ListView listView;
    DatabaseHelper dbHelper;
    SQLiteDatabase sdb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exersices);

        dbHelper = new DatabaseHelper(this, "mydatabase.db",null,4);
        sdb = dbHelper.getWritableDatabase();

        namesOfExercises = dbHelper.getNamesOfExercises();
        numberOfExercise = dbHelper.getNumbersOfExercises();

        data = new ArrayList<HashMap<String, Object>>(numberOfExercise.size());
        HashMap<String,Object> map;
        for (int i = 0; i < numberOfExercise.size(); i++) {
            map = new HashMap<String,Object>();
            map.put("NameOfExercise",namesOfExercises.get(i));
            map.put("NumberOfExercise",numberOfExercise.get(i));
            data.add(map);
        }

        String[] from = {"NameOfExercise"};
        int [] to = {R.id.textViewTypeOfExercise};

        adapter = new SimpleAdapter(this, data, R.layout.adapter_item_exersices, from, to);
        listView = (ListView)findViewById(R.id.exercisesListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ExersicesActivity.this, DoExerciseActivity.class);
                intent.putExtra("numberOfExercise",numberOfExercise.get(position));
                startActivity(intent);
            }
        });

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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ExersicesActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
