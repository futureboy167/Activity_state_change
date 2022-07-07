package com.rikkei.training.activity_state_change;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private int position;
    private MediaPlayer media;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.position = 0;
        media = MediaPlayer.create(this, R.raw.lemon);
        media.start();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("position",media.getCurrentPosition());
        media.stop();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null){
            this.position = savedInstanceState.getInt("position",position);
        }
        else this.position = 0;

        media.seekTo(this.position);
        media.start();

    }
    protected void onDestroy(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        media.stop();
    }

}