package com.mx.paciente_pronex_tb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;

public class home extends AppCompatActivity {
//Membros
    private TextView txt_1,txt_2,txt_3,txt_4;
    private BottomNavigationView menu;
    RegUsuario paciente =new RegUsuario();
    // Firebase members
    FirebaseFirestore db ;
    FirebaseAuth mauth;
    FirebaseUser fb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Views connection
        txt_1= findViewById(R.id.txt_1);
        txt_2= findViewById(R.id.txt_2);
        txt_3= findViewById(R.id.txt_3);
        txt_4= findViewById(R.id.txt_4);
        menu=findViewById(R.id.bottomNavigationView);



        //Firebase
        mauth= FirebaseAuth.getInstance();
        fb=mauth.getCurrentUser();
        db = FirebaseFirestore.getInstance();

        Timestamp data = new Timestamp(new Date());


        db.collection("users").document(fb.getEmail())
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot){
                        RegUsuario paciente = documentSnapshot.toObject(RegUsuario.class);
                        Log.d("Usuario", "DocumentSnapshot successfully retrive!");
                        txt_1.setText(paciente.getNome());
                        txt_2.setText(paciente.getCel());
                        txt_4.setText(paciente.getProfissional());
                        Timestamp inic=paciente.getDataInic();
                        Integer dif= data.compareTo(inic);
                        txt_3.setText( dif.toString());
                        }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("store:Med", "Error retriving document", e);
                    }
                });


        menu.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:

                        return true;
                    case R.id.nav_info:
                        //openFragment();
                        return true;
                    case R.id.nav_registro:
                        Intent g = new Intent(home.this, TomarMedicamento.class);
                        startActivity(g);
                        return true;
                    case R.id.nav_Conta:
                        //openFragment();
                        return true;
                }//switch
                return false;
            }//onNavItem

        });//on nav


    }///On create
}//App