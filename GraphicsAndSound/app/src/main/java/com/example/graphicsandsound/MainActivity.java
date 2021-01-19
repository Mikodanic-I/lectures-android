package com.example.graphicsandsound;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
    MediaPlayer boratSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize media player with chosen mp3
        boratSound = MediaPlayer.create(this, R.raw.borat_very_nice);

        // Initialize SwitchCompact switch because of android lint error
        SwitchCompat loopSwitch = (SwitchCompat) findViewById(R.id.loopSwitch);

        loopSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boratSound.setLooping(isChecked);
            }
        });
    }

    public void playMusic(View view) {
        boratSound.start();
    }
    public void pauseMusic(View view) {
        if (boratSound.isPlaying()) boratSound.pause();
    }
}