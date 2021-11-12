package com.mx.paciente_pronex_tb;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.RED;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;


import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Firebase

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity{

    //Views members
    private Button btn1, btn2;
    private EditText edname, edpassword;
    private TextView txt;


    private String email, password;

    // Firebase members
    private FirebaseAuth mAuth;
    private FirebaseUser fbuser=null;

    private void login(String email, String password,TextView tv) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("LOGIN", "signInWithEmail:success");
                            fbuser = mAuth.getCurrentUser();
                            final Dialog diag=new Dialog(MainActivity.this);
                            diag.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            diag.setCancelable(true);

                            tv.setText(fbuser.getEmail().toString());
                            tv.setTextColor(BLACK);
                            Intent myIntent = new Intent(MainActivity.this, TomarMedicamento.class);
                            myIntent.putExtra("email", fbuser.getEmail().toString());
                            startActivity(myIntent);


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.i("LOGIN", "signInWithEmail:failure", task.getException());
                            tv.setText("login fail");
                            tv.setTextColor(RED);


                        }

                    }
                });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Firebase
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            mAuth.signOut();
        }

        //Views connection
        btn1 = findViewById(R.id.btn_login);
        btn2 = findViewById(R.id.bnt_esqueceu);
        txt = findViewById(R.id.txt_email);


        edname = findViewById(R.id.edt_login);
        edpassword = findViewById(R.id.edt_pass);
//  <---------------------------------------------------- View ACTIONS_---------------------------------------->

        btn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {

                email = edname.getText().toString();
                password = edpassword.getText().toString();


                if ((email.isEmpty()) && (password.isEmpty())) {

                    Log.i("LOGIN-test", "mark");

                    email = "miguelmonte.vix@gmail.com";
                    password = "pronexTB";
                }
                login(email,password, txt);


            if (fbuser!=null) {





                }
            }


        });//setOnClickListener btn1


        btn2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {

              Intent myIntent = new Intent(MainActivity.this, RecoveryPass.class);
              startActivity(myIntent);



                }


        });//setOnClickListener btn2
    } //OnCreate
} //Main Activity