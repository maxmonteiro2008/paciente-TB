package com.mx.paciente_pronex_tb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;

public class TomarMedicamento extends AppCompatActivity {

    //Views members
    private Button btn1, btn2;

    private String email;
    private BottomNavigationView menu;

    // Firebase members
    FirebaseFirestore db ;
    // Firebase members


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomar_medicamento);
        Intent intent = getIntent();

        //Views connection
        btn1 = findViewById(R.id.btn_reg_foto);
        btn2 = findViewById(R.id.bnt_reg);
        menu=findViewById(R.id.bottomNavigationView);



  //Firebase
        //email=mAuth.getCurrentUser().getEmail().toString();
        db = FirebaseFirestore.getInstance();
        email=intent.getStringExtra("email");

//<<------------------------Action View ------------------------------------------
        btn2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                Timestamp data = new Timestamp(new Date());

                RegMedicacao med =new RegMedicacao(data,"null");
                db.collection("/users/"+email+"/medicacao").document()
                        .set(med)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("store:Med", "DocumentSnapshot successfully written!");
                                Snackbar.make( findViewById(R.id.btn_reg_foto), "Dados Registrados",
                                        Snackbar.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("store:Med", "Error writing document", e);
                            }
                        });




                Intent myIntent = new Intent( TomarMedicamento.this, Sentimento.class);
                startActivity(myIntent);



            }


        });//setOnClickListener btn2

        menu.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Intent i = new Intent(TomarMedicamento.this, MainActivity.class);
                        startActivity(i);
                        return true;
                    case R.id.nav_info:
                        //openFragment();
                        return true;
                    case R.id.nav_registro:
                        Intent g = new Intent(TomarMedicamento.this, TomarMedicamento.class);
                        startActivity(g);
                        return true;
                    case R.id.nav_Conta:
                        //openFragment();
                        return true;
                }//switch
                return false;
            }//onNavItem

                });//on nav

    }//OnCreate
}//Activity