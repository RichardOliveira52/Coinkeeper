package com.curso.Coinkeeper.domains;

import ch.qos.logback.core.model.INamedModel;
import com.curso.Coinkeeper.domains.dtos.ContaDTO;
import com.curso.Coinkeeper.domains.enums.TipoConta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name="conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta")
    private Integer id;

    @NotNull @NotBlank
    private String descricao;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name="tipoConta")
    private TipoConta tipoConta;

    @NotBlank @NotNull
    private String agencia;

    @NotBlank @NotNull
    private String numero;

    @NotNull
    private double limite;
    @NotNull
    private double saldo;
    @ManyToOne
    @JoinColumn(name = "banco")
    private Banco banco;

    @JsonIgnore
    @OneToMany(mappedBy = "conta")
    private List<Lancamento> lancamentos = new ArrayList<>();

    public Conta(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }

    public Conta() {
    }

    public Conta(ContaDTO dto) {
        this.id = dto.getId();
        this.descricao = dto.getDescricao();
        this.tipoConta = dto.getTipoConta();
        this.agencia = dto.getAgencia();
        this.numero = dto.getNumero();
        this.limite = dto.getLimite();
        this.saldo = dto.getSaldo();
        this.banco = new Banco();
        this.banco.setId(dto.getBancoId());
    }

    public Conta(Integer id, String descricao, TipoConta tipoConta, String agencia, String numero, double limite, double saldo, Banco banco) {
        this.id = id;
        this.descricao = descricao;
        this.tipoConta = tipoConta;
        this.agencia = agencia;
        this.numero = numero;
        this.limite = limite;
        this.saldo = saldo;
        this.banco = banco;
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

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Double.compare(conta.limite, limite) == 0 && Double.compare(conta.saldo, saldo) == 0 && Objects.equals(id, conta.id) && Objects.equals(descricao, conta.descricao) && tipoConta == conta.tipoConta && Objects.equals(agencia, conta.agencia) && Objects.equals(numero, conta.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, tipoConta, agencia, numero, limite, saldo);
    }
}
