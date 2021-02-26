package com.example.musicrunclub;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    MediaPlayer player;
    private ImageButton imgButton1;
    private ImageButton imgButton2;
    private ImageButton imgButton3;
    private ImageButton imgButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//Button1 to start music 1
        imgButton1 = (ImageButton) findViewById(R.id.image1);
        imgButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

//Button2 to start music 2
        imgButton2 = (ImageButton) findViewById(R.id.image2);
        imgButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
//Button3 to start music 3
        imgButton3 = (ImageButton) findViewById(R.id.image3);
        imgButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

//Button4 to start music 4
        imgButton4 = (ImageButton) findViewById(R.id.image4);
        imgButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });

    }

    public void openActivity1() {
        Intent intent = new Intent(this, com.example.musicrunclub.Song1.class);
        startActivity(intent);
    }

    public void openActivity2() {
        Intent intent = new Intent(this, com.example.musicrunclub.song2.class);
        startActivity(intent);
    }

    public void openActivity3() {
        Intent intent = new Intent(this, com.example.musicrunclub.song3.class);
        startActivity(intent);
    }

    public void openActivity4() {
        Intent intent = new Intent(this, com.example.musicrunclub.song4.class);
        startActivity(intent);
    }


    //Song1 Play
    public void play1(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.jab_tak);
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
    public void play2(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.kaun_tujhe);
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
    public void play3(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.besabriyaan);
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
    public void play4(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.har_gully_mein_dhoni_hai);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void pause(View v) {
        if (player != null) {
            player.pause();
        }
    }

    public void stop(View v) {
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

    public void home(View view) {
        Intent intent = new Intent(this, com.example.musicrunclub.MainActivity.class);
        startActivity(intent);
    }
}