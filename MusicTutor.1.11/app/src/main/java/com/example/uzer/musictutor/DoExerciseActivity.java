package com.example.uzer.musictutor;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by uzer on 13.03.2016.
 */
public class DoExerciseActivity extends AppCompatActivity {
    int numberOfExercise;
    String nameOfExercise;
    Intent intent;
    RadioGroup radioGroup;
    String key;
    int count = 1;
    int mistakes = 0;
    final static int maxCountOfMistakes = 3;
    private static long back_pressed;
    TextView mistakesText;
    DatabaseHelper dbHelper;
    SQLiteDatabase sdb;
    ArrayList<String> keys;
    ImageView picture;
    ImageButton play;
    boolean isPlaying;
    Integer predvSound;
    Button ok;
    ArrayList<Integer> sounds;
    int countOfLevels;
    RadioButton radio[];

    SoundPool soundPool;
    boolean loaded = false;
    int soundID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DatabaseHelper(this, "mydatabase.db", null, 4);
        sdb = dbHelper.getWritableDatabase();
        intent = getIntent();
        numberOfExercise = intent.getExtras().getInt("numberOfExercise");
        nameOfExercise = dbHelper.getNameOfExercise(numberOfExercise);

        switch (numberOfExercise) {
            case 1:
            case 3:
                setContentView(R.layout.exercise_with_radio_group);
                setTitle(nameOfExercise);


                ok = (Button) findViewById(R.id.ok_0);
                keys = dbHelper.getKeysChoiceExercise(numberOfExercise);
                final ArrayList<Drawable> images = new ArrayList<>();
                ArrayList<Integer> linksOnDrawable = dbHelper.getLinksOnQuestionChoiceExercise(numberOfExercise);
                for (int i = 0; i < linksOnDrawable.size(); i++) {
                    images.add(getResources().getDrawable(linksOnDrawable.get(i)));
                }




                countOfLevels = 10;
                mistakesText = (TextView) findViewById(R.id.mistakes_0);
                mistakesText.setText(getString(R.string.mistakes, mistakes, maxCountOfMistakes));

                nextLevel0(null, images, keys);

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString().equals(key)) {
                            Toast.makeText(getApplicationContext(), getString(R.string.right), Toast.LENGTH_SHORT).show();
                            count++;
                            if (count <= countOfLevels) {
                                nextLevel0(picture.getDrawable(), images, keys);
                            } else {
                                Intent amazingIntent = new Intent(DoExerciseActivity.this, YouAreAmazingActivity.class);
                                startActivity(amazingIntent);

                            }
                        } else {
                            Toast.makeText(getApplicationContext(), getString(R.string.think_more), Toast.LENGTH_SHORT).show();
                            mistakes++;
                            mistakesText.setText(getString(R.string.mistakes, mistakes, maxCountOfMistakes));
                            if (mistakes == maxCountOfMistakes) {
                                Intent looserIntent = new Intent(DoExerciseActivity.this, YouAreLooserActivity.class);
                                startActivity(looserIntent);
                            }

                        }
                    }
                });

                break;


            case 2:
            case 4:
                setContentView(R.layout.activity_sound_test);
                setTitle(nameOfExercise);
                ok = (Button) findViewById(R.id.ok_sounds);
                keys = dbHelper.getKeysChoiceExercise(numberOfExercise);
                sounds = dbHelper.getLinksOnQuestionChoiceExercise(numberOfExercise);
                countOfLevels = 10;
                mistakesText = (TextView) findViewById(R.id.mistakes_1);
                mistakesText.setText(getString(R.string.mistakes, mistakes, maxCountOfMistakes));
                isPlaying = false;
                play = (ImageButton) findViewById(R.id.imageButton);
                radio = new RadioButton[4];
                radioGroup = (RadioGroup) findViewById(R.id.radioGroup_1);
                radio[0] = (RadioButton) findViewById(R.id.radioVersion0_1);
                radio[1] = (RadioButton) findViewById(R.id.radioVersion1_1);
                radio[2] = (RadioButton) findViewById(R.id.radioVersion2_1);
                radio[3] = (RadioButton) findViewById(R.id.radioVersion3_1);


                this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
                soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
                soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                    @Override
                    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                        loaded = true;
                    }
                });

                nextLevelSound();

                play.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

// Getting the user sound settings
                        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                        float actualVolume = (float) audioManager
                                .getStreamVolume(AudioManager.STREAM_MUSIC);
                        float maxVolume = (float) audioManager
                                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                        float volume = actualVolume / maxVolume;
// Is the sound loaded already?
                        if (loaded) {
                            soundPool.play(soundID, volume, volume, 1, 0, 1f);
                        }
                    }
                });

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString().equals(key)) {
                            Toast.makeText(getApplicationContext(), getString(R.string.right), Toast.LENGTH_SHORT).show();
                            count++;
                            if (count <= countOfLevels) {
                                nextLevelSound();
                            } else {
                                Intent amazingIntent = new Intent(DoExerciseActivity.this, YouAreAmazingActivity.class);
                                startActivity(amazingIntent);
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), getString(R.string.think_more), Toast.LENGTH_SHORT).show();
                            mistakes++;
                            mistakesText.setText(getString(R.string.mistakes, mistakes, maxCountOfMistakes));
                            if (mistakes == maxCountOfMistakes) {
                                Intent looserIntent = new Intent(DoExerciseActivity.this, YouAreLooserActivity.class);
                                startActivity(looserIntent);
                            }

                        }
                    }
                });
                break;
        }
    }

    public void nextLevel0(Drawable predvImage, ArrayList<Drawable> images, ArrayList<String> keys) {
        TextView scoreText = (TextView) findViewById(R.id.score_0);
        scoreText.setText(getString(R.string.score, count, countOfLevels));
        int rand;
        Drawable image;
        do {
            rand = (int) (Math.random() * (images.size()));
            image = images.get(rand);
        } while (image == predvImage);
        key = keys.get(rand);
        HashSet<String> variants = new HashSet<String>();
        variants.add(key);
        while (variants.size() != 4) {
            rand = (int) (Math.random() * (keys.size()));
            variants.add(keys.get(rand));
        }

        picture = (ImageView) findViewById(R.id.noteImage0);
        picture.setImageDrawable(image);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_0);
        RadioButton[] radio = new RadioButton[4];
        radio[0] = (RadioButton) findViewById(R.id.radioVersion0_0);
        radio[1] = (RadioButton) findViewById(R.id.radioVersion1_0);
        radio[2] = (RadioButton) findViewById(R.id.radioVersion2_0);
        radio[3] = (RadioButton) findViewById(R.id.radioVersion3_0);

        int i = 0;
        for (String str : variants) {
            radio[i].setText(str);
            i++;
        }

    }

    public void nextLevelSound() {

        TextView scoreText = (TextView) findViewById(R.id.score_1);
        scoreText.setText(getString(R.string.score, count, countOfLevels));
        int rand;

        rand = (int) (Math.random() * (sounds.size()));
        if (count!=1){ soundPool.unload(soundID); }
        soundID = soundPool.load(this, sounds.get(rand), 1);


        key = keys.get(rand);

        HashSet<String> variants = new HashSet<String>();
        variants.add(key);

        while (variants.size() != 4) {
            rand = (int) (Math.random() * (keys.size()));
            variants.add(keys.get(rand));

        }

        int i = 0;
        for (String str : variants) {
            radio[i].setText(str);
            i++;
        }
    }


    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis())
            super.onBackPressed();
        else
            Toast.makeText(getApplicationContext(), getString(R.string.want_to_exit_from_exercise), Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();

    }

}
