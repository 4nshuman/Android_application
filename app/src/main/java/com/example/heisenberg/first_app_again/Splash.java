package com.example.heisenberg.first_app_again;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by heisenberg on 11/4/17.
 */

public class Splash extends Activity {
    MediaPlayer bgm;
    @Override
    protected void onCreate(@Nullable Bundle splashBundle) {
        super.onCreate(splashBundle);
        setContentView(R.layout.splash);
        bgm = MediaPlayer.create(Splash.this, R.raw.bgm);
        bgm.start();
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                    throw new InterruptedException();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    Intent mainActivity = new Intent("android.intent.action.MENU");
                    startActivity(mainActivity);
                    bgm.release();
                    finish();
                }
            }
        };
        timer.start();
    }
}
