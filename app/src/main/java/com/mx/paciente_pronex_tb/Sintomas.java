package com.mx.paciente_pronex_tb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;

public class Sintomas extends AppCompatActivity {


    //Members
    Button btn;
    TextView txt;
    CheckBox cb_1,cb_2,cb_3,cb_4,cb_5,cb_6,cb_7,cb_8,cb_9,cb_10,cb_11,cb_12,cb_13,cb_14,cb_15,cb_16;
Integer sentimento,sintoma=0;
    //Firebase
    FirebaseFirestore db ;
    FirebaseAuth mauth;
    FirebaseUser fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);
// Recover intent extras
        sentimento=getIntent().getIntExtra("Sentimento",0);
       //Inflate members
       btn=findViewById(R.id.btn_sentimento);
       txt=findViewById(R.id.txt_1);
       cb_1=findViewById(R.id.checkBox_1);
        cb_2=findViewById(R.id.checkBox_2);
        cb_3=findViewById(R.id.checkBox_3);
        cb_4=findViewById(R.id.checkBox_4);
        cb_5=findViewById(R.id.checkBox_5);
        cb_6=findViewById(R.id.checkBox_6);
        cb_7=findViewById(R.id.checkBox_7);
        cb_8=findViewById(R.id.checkBox_8);
        cb_9=findViewById(R.id.checkBox_9);
        cb_10=findViewById(R.id.checkBox_10);
        cb_11=findViewById(R.id.checkBox_11);
        cb_12=findViewById(R.id.checkBox_12);
        cb_13=findViewById(R.id.checkBox_13);
        cb_14=findViewById(R.id.checkBox_14);
        cb_15=findViewById(R.id.checkBox_15);
        cb_16=findViewById(R.id.checkBox_16);

//Firebase

        mauth=FirebaseAuth.getInstance();
        fb=mauth.getCurrentUser();
        db = FirebaseFirestore.getInstance();



        // ACTIONS==================================================================
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                Timestamp data = new Timestamp(new Date());
                RegSentimento regsent =new RegSentimento (data,sentimento);

                if(cb_1.isChecked()){
                    regsent.setCansado(true);
                }
                if(cb_2.isChecked()){
                    regsent.setTonto(true);
                }
                if(cb_3.isChecked()){
                    regsent.setInsonia(true);
                }
                if(cb_4.isChecked()){
                    regsent.setFraqueza(true);
                }
                if(cb_5.isChecked()){
                    regsent.setFalta_apetite(true);
                }
                if(cb_6.isChecked()){
                    regsent.setFebre(true);
                }
                if(cb_7.isChecked()){
                    regsent.setVomito(true);
                }
                if(cb_8.isChecked()){
                    regsent.setDiarreia(true);
                }
                if(cb_9.isChecked()){
                    regsent.setDor_estomago(true);
                }
                if(cb_10.isChecked()){
                    regsent.setDor_corpo(true);
                }
                if(cb_11.isChecked()){
                    regsent.setPele_vermelha(true);
                }
                if(cb_12.isChecked()){
                    regsent.setCoceira(true);
                }
                if(cb_13.isChecked()){
                    regsent.setTremores(true);
                }
                if(cb_14.isChecked()){
                    regsent.setSuor_urina_vermelhos(true);
                }
                if(cb_15.isChecked()){
                    regsent.setTristeza(true);
                }
                if(cb_16.isChecked()){
                    regsent.setSonolencia(true);
                }

                db.collection("/users/"+fb.getEmail()+"/sentimento").document()
                        .set(regsent)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("store:RegSent", "DocumentSnapshot successfully written!");

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("store:RegSentimento", "Error writing document", e);
                            }
                        });




                Intent myIntent = new Intent( Sintomas.this, TomarMedicamento.class);
                startActivity(myIntent);



            }


        });//setOnClickListener btn2




    }//onCreate
}//App