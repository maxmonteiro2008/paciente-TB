package com.mx.paciente_pronex_tb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


//Firebase

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RecoveryPass extends AppCompatActivity {
    //Views members
    private Button btn1;
    private EditText edname;
    private TextView txt;

    private String email, password;
    // Firebase members
    private FirebaseAuth mAuth=FirebaseAuth.getInstance();
    private FirebaseUser fbuser=null;





    private void recover(String emailAddress, FirebaseAuth auth)    {


       auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.i("LOGIN", "Email sent.");
                            Toast.makeText(getApplicationContext(),"Email sent.",Toast.LENGTH_SHORT).show();
                        }
                        else  {
                            Log.i("LOGIN", "Email  error");
                        }
                    }
                });



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery_pass);

        btn1 = findViewById(R.id.btn_login);
        txt = findViewById(R.id.txt_email);


        edname = findViewById(R.id.edt_login);


        //  <---------------------------------------------------- View ACTIONS_---------------------------------------->

        btn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {

                email = edname.getText().toString();

                recover(email, mAuth);





                }



        });//setOnClickListener btn1

    }
}