package com.curso.Coinkeeper.domains.dtos;

import com.curso.Coinkeeper.domains.CentroCusto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CentroCustoDTO {
    private Integer id;
    @NotBlank(message = "O campo descrição não pode estar vazio")
    @NotNull(message = "O campo descrição não pode ser nulo")
    private String descricao;

    public CentroCustoDTO() {
    }

    public CentroCustoDTO(CentroCusto centroCusto) {
        this.id = centroCusto.getId();
        this.descricao = centroCusto.getDescricao();
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
}
