package com.curso.Coinkeeper.domains.dtos;

import com.curso.Coinkeeper.domains.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PessoaDTO {
    private Integer id;

    @NotBlank(message = "O campo razão social não pode estar vazio")
    @NotNull(message = "O campo razão social não pode ser nulo")
    private String razaoSocial;

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.razaoSocial = pessoa.getRazaoSocial();
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
