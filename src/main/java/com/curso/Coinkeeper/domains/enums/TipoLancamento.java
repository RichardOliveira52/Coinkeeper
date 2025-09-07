package com.curso.Coinkeeper.domains.enums;

public enum TipoLancamento {
    CREDITO(0, "CREDITO"), DEBITO(1, "DEBITO");
    private Integer id;
    private String forma;

    TipoLancamento(Integer id, String forma) {
        this.id = id;
        this.forma = forma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }
    public static TipoLancamento toEnum(Integer id){
        if(id==null) return null;
        for(TipoLancamento x : TipoLancamento.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Tipo Lançamento invalido");
    }
}


