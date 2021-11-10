package com.mx.paciente_pronex_tb;


import com.google.firebase.Timestamp;

public class RegMedicacao {

    private Timestamp data;
    private String ref;



    public RegMedicacao() {}

    public RegMedicacao(Timestamp data, String ref) {

        this.data=data;
        this.ref=ref;
    }

    public String getRef() {
        return this.ref;
    }

    public Timestamp getData() {
        return this.data;
    }


}//RegMedicação