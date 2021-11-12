package com.mx.paciente_pronex_tb;

import com.google.firebase.Timestamp;

public class RegSentimento {


    private Timestamp data;
    private Integer geral;
    private Integer sintomas;



    public RegSentimento () {}

    public RegSentimento (Timestamp data, Integer geral, Integer sintomas) {

        this.data=data;
        this.geral= geral;
        this.sintomas=sintomas;
    }

    public Integer getGeral() {
        return this.geral;
    }

    public Integer getSintomas() {
        return this.sintomas;
    }

    public Timestamp getData() {
        return this.data;
    }







} // Class Reg sentimento
