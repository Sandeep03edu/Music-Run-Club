package com.example.musicrunclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.musicrunclub.MainActivity;
import com.example.musicrunclub.R;

public class song3a extends AppCompatActivity {
    MediaPlayer player;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song3a);
    }

    public void back(View view){
        Intent intent = new Intent(this, MainActivity2a.class);
        startActivity(intent);
    }
    public void next(View view){
        Intent intent = new Intent(this, song4a.class);
        startActivity(intent);
    }

    public void play1a(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.ek_tu_hai_yaar_mera);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    public void pausea(View v) {
        if (player != null) {
            player.pause();
        }
    }

    public void stopa(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }

}