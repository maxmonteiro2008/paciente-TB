package com.mx.paciente_pronex_tb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Info extends AppCompatActivity {

    //Members
    private Button btn1, btn2;
    private SeekBar sb1, sb2;
    private BottomNavigationView menu;

    Timer timer1 = new Timer();
    Timer timer2 = new Timer();
    Integer dur1=0, dur2=0;
    Integer step1=0, step2=0;

    Integer bst1=0,bst2=0;

    private MediaPlayer mPlayer_1= new MediaPlayer();
    private MediaPlayer mPlayer_2;

    public  void play_1(View v){

        if(bst1==0) {

            btn1.setText("PAUSE");
            mPlayer_1.start();
                 /** timer1.scheduleAtFixedRate(new TimerTask() {
                      @Override
                      public void run() {
                          if (!(step1 * sb1.getProgress() >= dur1)) {
                              sb1.setProgress(mPlayer1.getCurrentPosition()/step1);
                          }
                      }

                  },0,step1);**/
            bst1=1;


        }
        else{
            mPlayer_1.pause();
            btn1.setText("PLAY");
            bst1=0;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

     btn1= findViewById(R.id.btn_1);
     btn2= findViewById(R.id.btn_2);
     sb1=findViewById(R.id.sb_1);

     sb2=findViewById(R.id.sb_2);
     sb2.setProgress(0);
     menu=findViewById(R.id.bottomNavigationView);




     mPlayer_1.setAudioAttributes(
             new AudioAttributes
                     .Builder()
                     .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                     .build());
        mPlayer_1= MediaPlayer.create(this, R.raw.brothers_by_francesco_dandrea);
mPlayer_1.start();
        dur1=mPlayer_1.getDuration();
       Log.i("MPlayer", dur1.toString());
         sb1.setMax(dur1);
        sb1.setProgress(0);
        step1=dur1/100;

        //mPlayer2= MediaPlayer.create(this, R.raw.baitikochi_chuste);


     //Actions========================================================================



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(bst1==0) {

                  btn1.setText("PAUSE");
                  mPlayer_1.start();
                 /** timer1.scheduleAtFixedRate(new TimerTask() {
                      @Override
                      public void run() {
                          if (!(step1 * sb1.getProgress() >= dur1)) {
                              sb1.setProgress(mPlayer1.getCurrentPosition()/step1);
                          }
                      }

                  },0,step1);**/
                  bst1=1;


              }
              else{
                  mPlayer_1.pause();
                  btn1.setText("PLAY");
                  bst1=0;

              }
              }

       });


       menu.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Intent i= new Intent(Info.this, home.class);
                        startActivity(i);
                        return true;
                    case R.id.nav_info:
                        //openFragment();
                        return true;
                    case R.id.nav_registro:
                        Intent g= new Intent(Info.this, TomarMedicamento.class);
                        startActivity(g);
                        return true;
                    case R.id.nav_Conta:
                        //openFragment();
                        return true;
                }

                return false;
            }//on nav
        });




    }//On Create


}//Activity