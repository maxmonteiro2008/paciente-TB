package com.mx.paciente_pronex_tb;

import com.google.firebase.Timestamp;

public class RegUsuario {

    private Timestamp datainic;
    private String nome;
    private String cel;
    private String profissional;
    private Integer papel;





    public RegUsuario(){}
    public RegUsuario(String nome, String cel, String profissional, Integer papel, Timestamp inic) {
        this.nome = nome;
        this.cel = cel;
        this.profissional = profissional;
        this.papel = papel;
        this.datainic=inic;

    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getProfissional() {
        return profissional;
    }

    public void setProfissional(String profissional) {
        this.profissional = profissional;
    }

    public Integer getPapel() {
        return papel;
    }

    public void setPapel(Integer papel) {
        this.papel = papel;
    }



    public Timestamp getDataInic() {
        return datainic;
    }

    public void setDataInic(Timestamp inic) {
        this.datainic = inic;
    }






}
