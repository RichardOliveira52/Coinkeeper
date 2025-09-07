package com.curso.Coinkeeper.domains.dtos;

import com.curso.Coinkeeper.domains.Banco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BancoDTO {
    private Integer id;
    @NotBlank(message = "O campo Razão Social não pode estar vazio")
    @NotNull(message = "O campo Razão Social não pode ser nulo")
    private String razaoSocial;

    public BancoDTO() {
    }

    public BancoDTO(Banco banco) {
        this.id = banco.getId();
        this.razaoSocial = banco.getRazaoSocial();
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
}
