package com.example.musicrunclub;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2a extends AppCompatActivity {
    MediaPlayer player;
    private ImageButton imgButton1a;
    private ImageButton imgButton2a;
    private ImageButton imgButton3a;
    private ImageButton imgButton4a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2a);

//Button1 to start music 1
        imgButton1a = (ImageButton) findViewById(R.id.image1a);
        imgButton1a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1a();
            }
        });

//Button2 to start music 2
        imgButton2a = (ImageButton) findViewById(R.id.image2a);
        imgButton2a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2a();
            }
        });
//Button3 to start music 3
        imgButton3a = (ImageButton) findViewById(R.id.image3a);
        imgButton3a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3a();
            }
        });

//Button4 to start music 4
        imgButton4a = (ImageButton) findViewById(R.id.image4a);
        imgButton4a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4a();
            }
        });

    }

    public void openActivity1a() {
        Intent intent = new Intent(this, com.example.musicrunclub.Song1a.class);
        startActivity(intent);
    }

    public void openActivity2a() {
        Intent intent = new Intent(this, com.example.musicrunclub.song2a.class);
        startActivity(intent);
    }
    public void openActivity3a() {
        Intent intent = new Intent(this, com.example.musicrunclub.song3a.class);
        startActivity(intent);
    }
    public void openActivity4a() {
        Intent intent = new Intent(this, com.example.musicrunclub.song4a.class);
        startActivity(intent);
    }


    //Song1 Play
    public void play1a(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.dil_mang_rha_hai);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    //Song2 Play
    public void play2a(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.filhaal);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    //Song3 Play
    public void play3a (View v) {
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

    //Song4 Play
    public void play4a(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.chahu_mai_yaa_na);
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
    public void home(View view){
        Intent intent = new Intent(this, com.example.musicrunclub.MainActivity.class);
        startActivity(intent);
    }
}