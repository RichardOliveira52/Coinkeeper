package com.curso.Coinkeeper.domains.dtos;

import com.curso.Coinkeeper.domains.Lancamento;
import com.curso.Coinkeeper.domains.enums.Situacao;
import com.curso.Coinkeeper.domains.enums.TipoLancamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class LancamentoDTO {

    private Integer id;

    @NotNull(message = "O campo descricao não pode ser nulo")
    @NotBlank(message = "O campo descricao não pode estar vazio")
    private String descricao;

    @NotNull(message = "O campo Parcela não pode ser nulo")
    @NotBlank(message = "O campo Parcela não pode estar vazio")
    private String parcela;

    @NotNull(message = "O campo dataLancamento é obrigatório")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataLancamento;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataVencimento;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataBaixa;

    @NotNull(message = "O campo valorDocumento é obrigatório")
    private Double valorDocumento;

    @NotNull(message = "O campo tipoLancamento é obrigatório")
    private TipoLancamento tipoLancamento;

    @NotNull(message = "O campo situacao é obrigatório")
    private Situacao situacao;

    @NotNull(message = "O campo pessoaId é obrigatório")
    private Integer pessoaId;
    private String pessoaRazaoSocial;

    @NotNull(message = "O campo centroCustoId é obrigatório")
    private Integer centroCustoId;
    private String centroCustoDescricao;

    @NotNull(message = "O campo contaId é obrigatório")
    private Integer contaId;
    private String contaDescricao;

    public LancamentoDTO() {
    }

    public LancamentoDTO(Lancamento lancamento) {
        this.id = lancamento.getId();
        this.descricao = lancamento.getDescricao();
        this.parcela = lancamento.getParcela();
        this.dataLancamento = lancamento.getDataLancamento();
        this.dataVencimento = lancamento.getDataVencimento();
        this.dataBaixa = lancamento.getDataBaixa();
        this.valorDocumento = lancamento.getValorDocumento();
        this.tipoLancamento = lancamento.getTipoLancamento();
        this.situacao = lancamento.getSituacao();
        this.pessoaId = lancamento.getPessoa().getId();
        this.pessoaRazaoSocial = lancamento.getPessoa().getRazaoSocial();
        this.centroCustoId = lancamento.getCentroCusto().getId();
        this.centroCustoDescricao = lancamento.getCentroCusto().getDescricao();
        this.contaId = lancamento.getConta().getId();
        this.contaDescricao = lancamento.getConta().getDescricao();
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

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(LocalDate dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public Double getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(Double valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(TipoLancamento tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getPessoaRazaoSocial() {
        return pessoaRazaoSocial;
    }

    public void setPessoaRazaoSocial(String pessoaRazaoSocial) {
        this.pessoaRazaoSocial = pessoaRazaoSocial;
    }

    public Integer getCentroCustoId() {
        return centroCustoId;
    }

    public void setCentroCustoId(Integer centroCustoId) {
        this.centroCustoId = centroCustoId;
    }

    public String getCentroCustoDescricao() {
        return centroCustoDescricao;
    }

    public void setCentroCustoDescricao(String centroCustoDescricao) {
        this.centroCustoDescricao = centroCustoDescricao;
    }

    public Integer getContaId() {
        return contaId;
    }

    public void setContaId(Integer contaId) {
        this.contaId = contaId;
    }

    public String getContaDescricao() {
        return contaDescricao;
    }

    public void setContaDescricao(String contaDescricao) {
        this.contaDescricao = contaDescricao;
    }
}
