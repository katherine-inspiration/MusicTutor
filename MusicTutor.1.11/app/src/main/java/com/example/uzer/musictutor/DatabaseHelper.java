package com.example.uzer.musictutor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by uzer on 27.03.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 4;

    public static final String DATABASE_NAME = "mydatabase.db";
    public static final String TABLE1_NAME = "lessons";
    public static final String TABLE2_NAME = "content";
    public static final String TABLE1_ID_COLUMN = "_id";
    public static final String TABLE1_NAME_COLUMN = "name";
    public static final String TABLE2_ID_COLUMN = "_id";
    public static final String TABLE2_LINK_COLUMN = "link";
    public static final String TABLE2_TYPE_COLUMN = "type";
    public static final String TABLE2_LESSON_ID_COLUMN = "lesson_id";
    public static final String TABLE3_NAME = "exercises";
    public static final String TABLE3_ID_COLUMN = "_id";
    public static final String TABLE3_NAME_COLUMN = "name";
    public static final String TABLE4_NAME = "choiceExerciseContent";
    public static final String TABLE4_ID_COLUMN = "_id";
    public static final String TABLE4_EXERCISE_ID_COLUMN = "exercise_id";
    public static final String TABLE4_CONTENT_COLUMN = "content";
    public static final String TABLE4_KEY_COLUMN = "key";

    ContentValues contentValues = new ContentValues();


    private SQLiteDatabase db;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
        super(context, name, factory, version);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE1_NAME + " ( " +
                TABLE1_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE1_NAME_COLUMN + " TEXT )";
        db.execSQL(query);
        query = "CREATE TABLE " + TABLE2_NAME + " ( " +
                TABLE2_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE2_LINK_COLUMN + " INTEGER, " +
                TABLE2_TYPE_COLUMN + " INTEGER, " +
                TABLE2_LESSON_ID_COLUMN + " INTEGER )";
        db.execSQL(query);
        query = "CREATE TABLE " + TABLE3_NAME + " ( " +
                TABLE3_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE3_NAME_COLUMN + " TEXT )";
        db.execSQL(query);
        query = "CREATE TABLE " + TABLE4_NAME + " ( " +
                TABLE4_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE4_EXERCISE_ID_COLUMN + " INTEGER, " +
                TABLE4_CONTENT_COLUMN + " INTEGER, " +
                TABLE4_KEY_COLUMN + " TEXT )";
        db.execSQL(query);

        db.execSQL("INSERT INTO " + TABLE1_NAME + " ( " + TABLE1_NAME_COLUMN + " ) VALUES (\"Урок 1. Нотный стан\" )");

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson1_0);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 1);
        db.insert(TABLE2_NAME, null, contentValues);



        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson1_0);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 1);
        db.insert(TABLE2_NAME, null, contentValues);


        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson1_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 1);
        db.insert(TABLE2_NAME, null, contentValues);


        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson1_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 1);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson1_2);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 1);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson1_3);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 1);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson1_2);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 1);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson1_4);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 1);
        db.insert(TABLE2_NAME, null, contentValues);



        db.execSQL("INSERT INTO " + TABLE1_NAME + " ( " + TABLE1_NAME_COLUMN + " ) VALUES (\"Урок 2. Тон. Полутон\" )");

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson1_1_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 2);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson1_1_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 2);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson1_1_2);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 2);
        db.insert(TABLE2_NAME, null, contentValues);


        db.execSQL("INSERT INTO " + TABLE1_NAME + " ( " + TABLE1_NAME_COLUMN + " ) VALUES (\"Урок 3. Знаки альтерации\" )");

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson2_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 3);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson2_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 3);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson2_2);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 3);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson2_2);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 3);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson2_3);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 3);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson2_3);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 3);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson2_4);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 3);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson2_4);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 3);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson2_5);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 3);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson2_5);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 3);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson2_6);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 3);
        db.insert(TABLE2_NAME, null, contentValues);




        db.execSQL("INSERT INTO " + TABLE1_NAME + " ( " + TABLE1_NAME_COLUMN + " ) VALUES (\"Урок 4. Такт. Метр. Ритм\" )");

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson3_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 4);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson3_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 4);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson3_2);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 4);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson3_2);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 4);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson3_3);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 4);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson3_3);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 4);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson3_4);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 4);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson3_4);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 4);
        db.insert(TABLE2_NAME, null, contentValues);




        db.execSQL("INSERT INTO " + TABLE1_NAME + " ( " + TABLE1_NAME_COLUMN + " ) VALUES (\"Урок 5. Длительности\" )");

        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson5_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 5);
        db.insert(TABLE2_NAME, null, contentValues);

        db.execSQL("INSERT INTO " + TABLE1_NAME + " ( " + TABLE1_NAME_COLUMN + " ) VALUES (\"Урок 6. Паузы\" )");

        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson6_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 6);
        db.insert(TABLE2_NAME, null, contentValues);


        db.execSQL("INSERT INTO " + TABLE1_NAME + " ( " + TABLE1_NAME_COLUMN + " ) VALUES (\"Урок 7. Интервалы\" )");

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson7_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 7);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson7_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 7);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson7_2);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 7);
        db.insert(TABLE2_NAME, null, contentValues);


        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson7_2);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 7);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson7_3);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 7);
        db.insert(TABLE2_NAME, null, contentValues);


        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson7_3);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 7);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson7_4);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 7);
        db.insert(TABLE2_NAME, null, contentValues);


        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson7_4);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 7);
        db.insert(TABLE2_NAME, null, contentValues);



        db.execSQL("INSERT INTO " + TABLE1_NAME + " ( " + TABLE1_NAME_COLUMN + " ) VALUES (\"Урок 8. Консонансы и диссонансы\" )");


        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson8_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 8);
        db.insert(TABLE2_NAME, null, contentValues);

        db.execSQL("INSERT INTO " + TABLE1_NAME + " ( " + TABLE1_NAME_COLUMN + " ) VALUES (\"Урок 9. Аккорд. Трезвучие.\" )");

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson9_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 9);
        db.insert(TABLE2_NAME, null, contentValues);


        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson9_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 9);
        db.insert(TABLE2_NAME, null, contentValues);



        db.execSQL("INSERT INTO " + TABLE1_NAME + " ( " + TABLE1_NAME_COLUMN + " ) VALUES (\"Урок 10. Обращение трезвучий\" )");


        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson10_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 10);
        db.insert(TABLE2_NAME, null, contentValues);


        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson10_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 10);
        db.insert(TABLE2_NAME, null, contentValues);

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson10_2);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 10);
        db.insert(TABLE2_NAME, null, contentValues);


        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson10_2);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 10);
        db.insert(TABLE2_NAME, null, contentValues);


        db.execSQL("INSERT INTO " + TABLE1_NAME + " ( " + TABLE1_NAME_COLUMN + " ) VALUES (\"Урок 11. Доминантсепаккорд и его обращения\" )");

        contentValues.put(TABLE2_LINK_COLUMN, R.string.lesson11_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 0);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 11);
        db.insert(TABLE2_NAME, null, contentValues);


        contentValues.put(TABLE2_LINK_COLUMN, R.drawable.lesson11_1);
        contentValues.put(TABLE2_TYPE_COLUMN, 1);
        contentValues.put(TABLE2_LESSON_ID_COLUMN, 11);
        db.insert(TABLE2_NAME, null, contentValues);




        ContentValues cvExerciseWithChoice = new ContentValues();
        db.execSQL("INSERT INTO " + TABLE3_NAME + " (" + TABLE3_NAME_COLUMN + ") VALUES (\"Назови ноту\")");

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "До");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);


        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "До-диез");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "До-бемоль");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ре");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_5);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ре-диез");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_6);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ре-бемоль");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_7);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ми");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_8);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ми-диез");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_9);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ми-бемоль");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_10);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Фа");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_11);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Фа-диез");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_12);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Фа-бемоль");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_13);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Соль");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_14);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Соль-диез");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_15);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Соль-бемоль");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_16);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ля");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_17);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ля-диез");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_18);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ля-бемоль");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_19);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Си");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_20);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Си-диез");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 1);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise1_21);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Си-бемоль");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);


        db.execSQL("INSERT INTO " + TABLE3_NAME + " (" + TABLE3_NAME_COLUMN + ") VALUES (\"Угадай интервал\")");


        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,2);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.raw.audio1_ch1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая прима");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 2);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio1_m2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая секунда");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 2);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio1_b2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая секунда");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);


        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 2);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio1_m3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая терция");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 2);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio1_b3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая терция");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 2);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio1_ch4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая кварта");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 2);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio1_ch5);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая квинта");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 2);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio1_m6);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая секста");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 2);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio1_b6);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая секста");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 2);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio1_m7);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая септима");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 2);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio1_b7);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая септима");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 2);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio1_ch8);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая октава");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);


        db.execSQL("INSERT INTO " + TABLE3_NAME + " (" + TABLE3_NAME_COLUMN + ") VALUES (\"Назови интервал\")");

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.drawable.exercise3_m2_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая секунда");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m2_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая секунда");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m2_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая секунда");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m2_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая секунда");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m2_5);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая секунда");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);


        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b2_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая секунда");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b2_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая секунда");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b2_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая секунда");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b2_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая секунда");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b2_5);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая секунда");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);


        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m3_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая терция");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m3_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая терция");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m3_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая терция");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m3_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая терция");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m3_5);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая терция");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);



        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b3_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая терция");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b3_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая терция");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b3_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая терция");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b3_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая терция");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b3_5);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая терция");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_ch4_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая кварта");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_ch4_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая кварта");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_ch4_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая кварта");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_ch4_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая кварта");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_ch4_5);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая кварта");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_ch5_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая квинта");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_ch5_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая квинта");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_ch5_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая квинта");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_ch5_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая квинта");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m6_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая секста");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m6_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая секста");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m6_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая секста");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m6_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая секста");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m6_5);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая секста");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b6_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая секста");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b6_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая секста");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b6_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая секста");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b6_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая секста");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b6_5);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая секста");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m7_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая септима");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m7_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая септима");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m7_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая септима");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m7_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая септима");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_m7_5);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Малая септима");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b7_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая септима");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b7_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая септима");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b7_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая септима");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_b7_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Большая септима");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_ch8_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая октава");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_ch8_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая октава");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_ch8_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая октава");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN, 3);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.drawable.exercise3_ch8_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Чистая октава");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);


        db.execSQL("INSERT INTO " + TABLE3_NAME + " (" + TABLE3_NAME_COLUMN + ") VALUES (\"Угадай аккорд\")");


        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN, R.raw.audio4_b53_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Б53");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_b53_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Б53");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_b53_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Б53");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_b53_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Б53");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_m53_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "М53");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_m53_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "М53");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_m53_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "М53");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_m53_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "М53");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_uv53_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ув53");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_uv53_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ув53");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_uv53_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ув53");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_uv53_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ув53");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_um53_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ум53");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_um53_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ум53");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_um53_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ум53");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_um53_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Ум53");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_b6_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Б6");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_b6_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Б6");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_b6_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Б6");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_b6_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Б6");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_b64_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Б64");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_b64_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Б64");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_b64_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Б64");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_b64_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Б64");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_m6_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "М6");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_m6_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "М6");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_m6_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "М6");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_m6_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "М6");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_m64_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "М64");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_m64_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "М64");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_m64_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "М64");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_m64_4);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "М64");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_d2_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Д2");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_d2_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Д2");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_d2_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Д2");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_d43_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Д43");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_d43_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Д43");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_d43_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Д43");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_d65_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Д65");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_d65_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Д65");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_d65_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Д65");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_d7_1);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Д7");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_d7_2);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Д7");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

        cvExerciseWithChoice.put(TABLE4_EXERCISE_ID_COLUMN,4);
        cvExerciseWithChoice.put(TABLE4_CONTENT_COLUMN,R.raw.audio4_d7_3);
        cvExerciseWithChoice.put(TABLE4_KEY_COLUMN, "Д7");
        db.insert(TABLE4_NAME, null, cvExerciseWithChoice);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE4_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE3_NAME);
        onCreate(db);


    }

    public String getNameOfLesson(int id){
        String name = "";
        String selectQuery = "SELECT " + TABLE1_NAME_COLUMN + " FROM " + TABLE1_NAME + " WHERE " + TABLE1_ID_COLUMN + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){

            name = cursor.getString(0);

        }
        if(cursor!=null && !cursor.isClosed()){
            cursor.close();
        }
        return name;
    }

    public ArrayList<String> getNamesOfExercises(){
        ArrayList <String> list = new ArrayList<String>();
        String selectQuery = "SELECT " + TABLE3_NAME_COLUMN + " FROM " + TABLE3_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()){
            do{
                list.add(cursor.getString(0));
            }while(cursor.moveToNext());
        }
        if (cursor!=null &&!cursor.isClosed()){
            cursor.close();
        }
        return list;
    }

    public ArrayList<String> getNamesOfLessons(){

        ArrayList list = new ArrayList<String>();
        String selectQuery = "SELECT " + TABLE1_NAME_COLUMN + " FROM " + TABLE1_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do{
                list.add(cursor.getString(0));
            }while(cursor.moveToNext());
        }
        if(cursor!=null && !cursor.isClosed()){
            cursor.close();
        }
        return list;
    }

    public ArrayList <Integer> getNumbersOfExercises(){
        ArrayList <Integer> list = new ArrayList<Integer>();
        String selectQuery = "SELECT " + TABLE3_ID_COLUMN + " FROM " + TABLE3_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()){
            do{
                list.add(cursor.getInt(0));
            }while(cursor.moveToNext());
        }
        if (cursor!=null &&!cursor.isClosed()){
            cursor.close();
        }
        return list;
    }

    public ArrayList<Integer> getNumbersOfLessons(){
        ArrayList <Integer> list = new ArrayList<Integer>();
        String query = "SELECT " + TABLE1_ID_COLUMN + " FROM " + TABLE1_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do{
                list.add(cursor.getInt(0));
            }while (cursor.moveToNext());
        }
        if(cursor!=null&&!cursor.isClosed()){
            cursor.close();
        }
        return list;
    }

    public String getNameOfExercise(int id){
        String selectQuery = "SELECT " + TABLE3_NAME_COLUMN + " FROM " + TABLE3_NAME + " WHERE " + TABLE3_ID_COLUMN + " = " + id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        String name = "";
        if (cursor.moveToFirst()){

            name = cursor.getString(0);

        }
        if(cursor!=null && !cursor.isClosed()){
            cursor.close();
        }
        return name;

    }





    public ArrayList<Integer> getLinksOnContent(int id){
        ArrayList<Integer> list = new ArrayList<Integer>();
        String query = "SELECT " + TABLE2_LINK_COLUMN + " FROM " + TABLE2_NAME + " WHERE " + TABLE2_LESSON_ID_COLUMN + " = " + id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do{
                list.add(cursor.getInt(0));
            }while (cursor.moveToNext());
        }
        if (cursor!=null&&!cursor.isClosed()){
            cursor.close();
        }
        return list;
    }

    public ArrayList<Integer> getTypesOfContent(int id){
        ArrayList<Integer> list = new ArrayList<Integer>();
        String query = "SELECT " + TABLE2_TYPE_COLUMN + " FROM " + TABLE2_NAME + " WHERE " + TABLE2_LESSON_ID_COLUMN + " = " + id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do{
                list.add(cursor.getInt(0));
            }while (cursor.moveToNext());
        }
        if (cursor!=null&&!cursor.isClosed()){
            cursor.close();
        }
        return list;
    }
    public ArrayList<Integer> getLinksOnQuestionChoiceExercise(int exerciseId){
        ArrayList<Integer>list = new ArrayList<Integer>();
        String selectQuery = "SELECT " + TABLE4_CONTENT_COLUMN + " FROM " + TABLE4_NAME + " WHERE " + TABLE4_EXERCISE_ID_COLUMN + " = " + exerciseId;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getInt(0));
            } while (cursor.moveToNext());
        }
        if (cursor!=null&&!cursor.isClosed()){
                cursor.close();
            }
        return list;
    }
    public ArrayList<String> getKeysChoiceExercise(int exerciseId){

        ArrayList list = new ArrayList<String>();
        String selectQuery = "SELECT " + TABLE4_KEY_COLUMN + " FROM " + TABLE4_NAME + " WHERE " + TABLE4_EXERCISE_ID_COLUMN + " = " + exerciseId;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do{
                list.add(cursor.getString(0));
            }while(cursor.moveToNext());
        }
        if(cursor!=null && !cursor.isClosed()){
            cursor.close();
        }
        return list;
    }


}
