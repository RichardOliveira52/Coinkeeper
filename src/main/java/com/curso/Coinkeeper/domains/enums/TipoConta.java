package com.curso.Coinkeeper.domains.enums;

public enum TipoConta {
    CONTACORRENTE(0,"CONTACORRENTE"),CONTAINVESTIMENTO(1,"CONTAINVESTIMENTO"),CARTAODECREDITO(2,"CARTAODECREDITO"),ALIMENTACAO(3,"ALIMENTACAO"),POUPANCA(4,"POUPANCA");

    private Integer id;
    private String tipo;

    TipoConta(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static TipoConta toEnum(Integer id){
        if(id==null) return null;
        for(TipoConta x : TipoConta.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Tipo Conta invalida");
    }
}

