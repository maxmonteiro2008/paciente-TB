package com.mx.paciente_pronex_tb;

import com.google.firebase.Timestamp;

public class RegSentimento {


    private Timestamp data;
    private Integer geral;
    private Integer sintomas;
    private Boolean  cansado= false;
    private Boolean  tonto= false;
    private Boolean  insonia= false;
    private Boolean  fraqueza= false;
    private Boolean  falta_apetite= false;
    private Boolean  febre= false;
    private Boolean  vomito= false;
    private Boolean  diarreia= false;
    private Boolean  dor_estomago= false;
    private Boolean  dor_corpo= false;
    private Boolean  pele_vermelha= false;
    private Boolean  coceira= false;
    private Boolean  tremores= false;
    private Boolean  suor_urina_vermelhos= false;
    private Boolean  tristeza= false;

    public Boolean getCansado() {
        return cansado;
    }

    public void setCansado(Boolean cansado) {
        this.cansado = cansado;
    }

    public Boolean getTonto() {
        return tonto;
    }

    public void setTonto(Boolean tonto) {
        this.tonto = tonto;
    }

    public Boolean getInsonia() {
        return insonia;
    }

    public void setInsonia(Boolean insonia) {
        this.insonia = insonia;
    }

    public Boolean getFraqueza() {
        return fraqueza;
    }

    public void setFraqueza(Boolean fraqueza) {
        this.fraqueza = fraqueza;
    }

    public Boolean getFalta_apetite() {
        return falta_apetite;
    }

    public void setFalta_apetite(Boolean falta_apetite) {
        this.falta_apetite = falta_apetite;
    }

    public Boolean getFebre() {
        return febre;
    }

    public void setFebre(Boolean febre) {
        this.febre = febre;
    }

    public Boolean getVomito() {
        return vomito;
    }

    public void setVomito(Boolean vomito) {
        this.vomito = vomito;
    }

    public Boolean getDiarreia() {
        return diarreia;
    }

    public void setDiarreia(Boolean diarreia) {
        this.diarreia = diarreia;
    }

    public Boolean getDor_estomago() {
        return dor_estomago;
    }

    public void setDor_estomago(Boolean dor_estomago) {
        this.dor_estomago = dor_estomago;
    }

    public Boolean getDor_corpo() {
        return dor_corpo;
    }

    public void setDor_corpo(Boolean dor_corpo) {
        this.dor_corpo = dor_corpo;
    }

    public Boolean getPele_vermelha() {
        return pele_vermelha;
    }

    public void setPele_vermelha(Boolean pele_vermelha) {
        this.pele_vermelha = pele_vermelha;
    }

    public Boolean getCoceira() {
        return coceira;
    }

    public void setCoceira(Boolean coceira) {
        this.coceira = coceira;
    }

    public Boolean getTremores() {
        return tremores;
    }

    public void setTremores(Boolean tremores) {
        this.tremores = tremores;
    }

    public Boolean getSuor_urina_vermelhos() {
        return suor_urina_vermelhos;
    }

    public void setSuor_urina_vermelhos(Boolean suor_urina_vermelhos) {
        this.suor_urina_vermelhos = suor_urina_vermelhos;
    }

    public Boolean getTristeza() {
        return tristeza;
    }

    public void setTristeza(Boolean tristeza) {
        this.tristeza = tristeza;
    }

    public Boolean getSonolencia() {
        return sonolencia;
    }

    public void setSonolencia(Boolean sonolencia) {
        this.sonolencia = sonolencia;
    }

    private Boolean  sonolencia= false;



    public RegSentimento () {}

    public RegSentimento (Timestamp data, Integer geral) {

        this.data=data;
        this.geral= geral;
    }

    public Integer getGeral() {
        return this.geral;
    }

    public void setGeral(Integer par) {
         this.geral=par;
    }



    public Timestamp getData() {
        return this.data;
    }









} // Class Reg sentimento
