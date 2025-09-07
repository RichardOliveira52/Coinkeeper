package com.curso.Coinkeeper.domains.dtos;

import com.curso.Coinkeeper.domains.Banco;
import com.curso.Coinkeeper.domains.Conta;
import com.curso.Coinkeeper.domains.enums.TipoConta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ContaDTO {
    private Integer id;

    @NotNull(message = "O campo descrição não pode ser nulo")
    @NotBlank(message = "O campo descrição não pode estar vazio")
    private String descricao;

    @NotNull(message = "O campo tipoConta é obrigatório")
    private TipoConta tipoConta;

    @NotNull(message = "O campo agência não pode ser nulo")
    @NotBlank(message = "O campo agência não pode estar vazio")
    private String agencia;

    @NotNull(message = "O campo numero não pode ser nulo")
    @NotBlank(message = "O campo número não pode estar vazio")
    private String numero;

    @NotNull(message = "O campo limite é obrigatório")
    private Double limite;

    @NotNull(message = "O campo saldo é obrigatório")
    private Double saldo;

    @NotNull(message = "O campo bancoId é obrigatório")
    private Integer bancoId;
    private String bancoRazaoSocial;

    public ContaDTO() {
    }

    public ContaDTO(Conta conta) {
        this.id = conta.getId();
        this.descricao = conta.getDescricao();
        this.tipoConta = conta.getTipoConta();
        this.agencia = conta.getAgencia();
        this.numero = conta.getNumero();
        this.limite = conta.getLimite();
        this.saldo = conta.getSaldo();
        this.bancoId = conta.getBanco().getId();
        this.bancoRazaoSocial = conta.getBanco().getRazaoSocial();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getBancoId() {
        return bancoId;
    }

    public void setBancoId(Integer bancoId) {
        this.bancoId = bancoId;
    }

    public String getBancoRazaoSocial() {
        return bancoRazaoSocial;
    }

    public void setBancoRazaoSocial(String bancoRazaoSocial) {
        this.bancoRazaoSocial = bancoRazaoSocial;
    }
}
