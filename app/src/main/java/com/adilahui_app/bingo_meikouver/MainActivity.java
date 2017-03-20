package com.adilahui_app.bingo_meikouver;

import android.app.Activity;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {

    TextView tv, tv2;
    int number;
    ArrayList<Integer> recordNum;
    Random ram;
    String record = "履歴";
    SoundPool soundPool;
    int mp3;
    int dram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        } else {
            AudioAttributes attr = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(attr)
                    .setMaxStreams(5)
                    .build();
        }

        mp3 = soundPool.load(this, R.raw.taiko01, 1);
        dram = soundPool.load(this, R.raw.nc85014, 1);


        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.display);
        tv2 = (TextView) findViewById(R.id.display2);
        ram = new Random();

    }

    public void onClear(View view){
        tv2.setText("");
        tv.setText("");
        record = "";

    }

    public void onPushedButton(View view) {

        soundPool.play(mp3, 1f, 1f, 0, 0, 1f);
        number = ram.nextInt(99) + 1;
        record += " " + number;
        tv2.setText(record);
        tv.setText("" + number);


    }
    public void onDram(View view){

        soundPool.play(dram, 1f, 1f, 0, 0, 1f);
    }
}
