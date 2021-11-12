package com.mx.paciente_pronex_tb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class Sentimento extends AppCompatActivity {

    //Members

    private Button btn;
    private CheckBox cb_1, cb_2, cb_3;
    private TextView txt1, txt2;
    private int sint=0;

    // Firebase members
    FirebaseFirestore db ;
    FirebaseAuth mauth;
    FirebaseUser fb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentimento);
        mauth= FirebaseAuth.getInstance();
        fb=mauth.getCurrentUser();

        btn = findViewById(R.id.btn_sentimento);
        cb_1=findViewById(R.id.checkBox_1);
        cb_2=findViewById(R.id.checkBox_2);
        cb_3= findViewById(R.id.checkBox_3);
        txt1 = findViewById(R.id.txt_1);
        txt2 = findViewById(R.id.txt_2);

 // Actions
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {



                if ( cb_1.isChecked()) {

                     sint=0;
                }
                if ( cb_2.isChecked()) {

                    sint=1;
                }
                if ( cb_3.isChecked()) {

                    sint=5;
                }


                Intent  nextIntent= new Intent(Sentimento.this,Sintomas.class);

                nextIntent.putExtra("Sentimento",sint);

                startActivity(nextIntent);



            }  //OnClick


        });  //setOnClickListener btn



    }//Om Create
} // App