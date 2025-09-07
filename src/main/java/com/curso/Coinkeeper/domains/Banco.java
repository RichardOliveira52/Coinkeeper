package com.curso.Coinkeeper.domains;

import com.curso.Coinkeeper.domains.dtos.BancoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name="banco")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_banco")
    private Integer id;

    @NotNull @NotBlank
    private String razaoSocial;

    @JsonIgnore
    @OneToMany(mappedBy = "banco")
    private List<Conta> contas = new ArrayList<>();

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public Banco(List<Conta> contas) {
        this.contas = contas;
    }

    public Banco() {
    }
    public Banco(BancoDTO dto) {
        this.id = dto.getId();
        this.razaoSocial = dto.getRazaoSocial();
    }

    public Banco(Integer id, String razaoSocial) {
        this.id = id;
        this.razaoSocial = razaoSocial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banco banco = (Banco) o;
        return Objects.equals(id, banco.id) && Objects.equals(razaoSocial, banco.razaoSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, razaoSocial);
    }
}
