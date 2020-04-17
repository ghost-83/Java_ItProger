package com.first_app.itproger.itprogerproject;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.jgabrielfreitas.core.BlurImageView;

public class MainActivity extends AppCompatActivity {

    private BlurImageView blur_img;
    private ImageButton play, stop;
    private MediaPlayer audio;
    private int pausePos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blur_img = (BlurImageView)findViewById(R.id.bg_blur);
        blur_img.setBlur(5);

        play = (ImageButton) findViewById(R.id.playBtn);
        stop = (ImageButton) findViewById(R.id.stopBtn);
    }

    public void OnClickBtn(View v) {
        switch(v.getId()) {
            case R.id.playBtn:
                if(audio == null) {
                    audio = MediaPlayer.create(getApplicationContext(), R.raw.music);
                    audio.start();
                    play.setImageResource(R.drawable.pause);
                } else if(audio.isPlaying()) {
                    audio.pause();
                    pausePos = audio.getCurrentPosition();
                    play.setImageResource(R.drawable.play);
                } else if(!audio.isPlaying()) {
                    audio.seekTo(pausePos);
                    audio.start();
                    play.setImageResource(R.drawable.pause);
                }
                break;
            case R.id.stopBtn:
                if(audio != null) {
                    audio.stop();
                    audio = null;
                    play.setImageResource(R.drawable.play);
                }
                break;
        }
    }


}
