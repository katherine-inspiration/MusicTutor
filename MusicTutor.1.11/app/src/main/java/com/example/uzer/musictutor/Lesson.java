package com.example.uzer.musictutor;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by uzer on 18.02.2016.
 */
public class Lesson {
    private String name;
    ArrayList <String> textElements;
    ArrayList <Drawable> drawableElements;
    ArrayList<Integer> typeOfElements;         // 0 - String; 1 - Drawable
    int countOfElements, countOfString, countOfDrawable;


    Lesson(String name){
        textElements = new ArrayList <String> ();
        drawableElements = new ArrayList<Drawable>();
        this.name = name;
        typeOfElements = new ArrayList<Integer>();
    }
    Lesson(){
        textElements = new ArrayList<String>();
        drawableElements = new  ArrayList<Drawable>();
        typeOfElements = new ArrayList<Integer>();
    }

    public ArrayList getAllElements(){
        ArrayList list = new ArrayList();
        int itext = 0;
        int idrawable = 0;
        for (int i = 0; i<countOfElements;i++){
            if (typeOfElements.get(i).equals(1)){
                list.add(drawableElements.get(idrawable));
                idrawable++;
            }else if (typeOfElements.get(i).equals(0)){
                list.add(textElements.get(itext));
                itext++;
            }
        }
        return list;
    }

    private void buildElement(String string, LinearLayout linearLayout,Context context){
        TextView text = new TextView(context);
        text.setText(string);
        text.setTextSize(20);
        text.setAlpha(1);
        text.setTextColor(Color.BLACK);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.LEFT;
        layoutParams.setMargins(10,10,10,10);
        linearLayout.addView(text, layoutParams);
    }
    private void buildElement(Drawable drawable, LinearLayout linearLayout,Context context){
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(drawable);
        imageView.setAdjustViewBounds(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.setMargins(10,10,10,10);
        linearLayout.addView(imageView, layoutParams);
    }


    public void buildLesson(Context context, LinearLayout linearLayout){
        int itext = 0;
        int idrawable = 0;
        for (int i = 0; i<countOfElements;i++){
            if (typeOfElements.get(i).equals(1)){
                buildElement(drawableElements.get(idrawable),linearLayout,context);
                idrawable++;
            }else if (typeOfElements.get(i).equals(0)){
               buildElement(textElements.get(itext).toString(),linearLayout,context);
                itext++;
            }
        }
    }

    public void addElement(Drawable drawable){
        typeOfElements.add(1);
        countOfElements++;
        countOfDrawable++;
        drawableElements.add(drawable);
    }
    public void addElement(String string) {
        typeOfElements.add(0);
        countOfElements++;
        countOfString++;
        textElements.add(string);
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }


}
