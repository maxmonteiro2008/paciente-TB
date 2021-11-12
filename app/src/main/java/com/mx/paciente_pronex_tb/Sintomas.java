package com.mx.paciente_pronex_tb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Sintomas extends AppCompatActivity {

    //Members
    Button btn;
    TextView txt;
    CheckBox cb_1,cb_2,cb_3,cb_4,cb_5,cb_6,cb_7,cb_8,cb_9,cb_10,cb_11,cb_12,cb_13,cb_14,cb_15,cb_16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);
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





    }//onCreate
}//App