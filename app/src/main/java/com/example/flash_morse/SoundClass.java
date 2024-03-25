package com.example.flash_morse;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundClass {
    private Context context;

    public SoundClass(Context context) {
        this.context = context;
    }
    public void SoundPlay(MediaPlayer sound){
        sound.start();
    }
}
