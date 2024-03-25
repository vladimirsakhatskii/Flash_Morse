package com.example.flash_morse;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundClass {
    private Context context;

    private MediaPlayer tire = MediaPlayer.create(context,R.raw.tire);
    private MediaPlayer tochka = MediaPlayer.create(context, R.raw.tochka);

    public SoundClass(Context context) {
        this.context = context;
    }
    public void SoundPlay(MediaPlayer sound){
        sound.start();
    }
    public void setTire(){
        SoundPlay(tire);
    }
    public void setTochka(){
        SoundPlay(tochka);
    }
}
