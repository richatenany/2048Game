package edu.purdue.rtenany.cs180lab11retake;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final MediaPlayer sound = MediaPlayer.create(this, R.raw.cow);
        sound.start();
        Thread myThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    sound.stop();
                    startActivity(intent);
                }
            }
        };
        myThread.start();
    }
}
