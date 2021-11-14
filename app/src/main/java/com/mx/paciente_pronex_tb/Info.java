package com.mx.paciente_pronex_tb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Info extends AppCompatActivity {

    //Members
    private Button btn1, btn2;
    private SeekBar sb1, sb2;
    private MediaPlayer mPlayer1, mPlayer2;
    private BottomNavigationView menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

     btn1=findViewById(R.id.btn_1);
     btn2=findViewById(R.id.btn_2);
     sb1=findViewById(R.id.sb_1);
     sb2=findViewById(R.id.sb_2);
     menu=findViewById(R.id.bottomNavigationView);
     //mPlayer1= MediaPlayer.create(this, R.raw.baitikochi_chuste);
     //mPlayer2= MediaPlayer.create(this, R.raw.baitikochi_chuste);

     //Actions========================================================================

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
       });


       menu.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Intent i= new Intent(Info.this, MainActivity.class);
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