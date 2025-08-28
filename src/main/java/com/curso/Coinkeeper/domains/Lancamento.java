package com.curso.Coinkeeper.domains;

import com.curso.Coinkeeper.domains.dtos.LancamentoDTO;
import com.curso.Coinkeeper.domains.enums.Situacao;
import com.curso.Coinkeeper.domains.enums.TipoLancamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;
@Entity
@Table(name="lancamento")
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lancamento")
    private Integer id;
    @NotNull@NotBlank
    private String descricao;
    @NotNull@NotBlank
    private String parcela;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataLancamento;
    @JsonFormat (pattern = "yyyy-MM-dd")
    private LocalDate dataVencimento;
    @JsonFormat (pattern = "yyyy-MM-dd")
    private LocalDate dataBaixa;
    @NotNull
    private double valorDocumento;
    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name="tipoLancamento")
    private TipoLancamento tipoLancamento;
    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name="situacao")
    private Situacao situacao;
    @ManyToOne
    @JoinColumn(name = "pessoa")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "centrocusto")
    private CentroCusto centroCusto;

    @ManyToOne
    @JoinColumn(name = "contaid")
    private Conta conta;

    public Lancamento() {
    }
    public Lancamento(LancamentoDTO dto) {
        this.id = dto.getId();
        this.descricao = dto.getDescricao();
        this.parcela = dto.getParcela();
        this.dataLancamento = dto.getDataLancamento();
        this.dataVencimento = dto.getDataVencimento();
        this.dataBaixa = dto.getDataBaixa();
        this.valorDocumento = dto.getValorDocumento();
        this.tipoLancamento = dto.getTipoLancamento();
        this.situacao = dto.getSituacao();
        this.pessoa = new Pessoa();
        this.pessoa.setId(dto.getPessoaId());
        this.centroCusto = new CentroCusto();
        this.centroCusto.setId(dto.getCentroCustoId());
        this.conta = new Conta();
        this.conta.setId(dto.getContaId());
    }

    public Lancamento(Integer id, String descricao, String parcela, LocalDate dataLancamento, LocalDate dataVencimento, LocalDate dataBaixa, double valorDocumento, TipoLancamento tipoLancamento, Situacao situacao, Pessoa pessoa, CentroCusto centroCusto, Conta conta) {
        this.id = id;
        this.descricao = descricao;
        this.parcela = parcela;
        this.dataLancamento = dataLancamento;
        this.dataVencimento = dataVencimento;
        this.dataBaixa = dataBaixa;
        this.valorDocumento = valorDocumento;
        this.tipoLancamento = tipoLancamento;
        this.situacao = situacao;
        this.pessoa = pessoa;
        this.centroCusto = centroCusto;
        this.conta = conta;
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

    public double getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(double valorDocumento) {
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public CentroCusto getCentroCusto() {
        return centroCusto;
    }

    public void setCentroCusto(CentroCusto centroCusto) {
        this.centroCusto = centroCusto;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lancamento that = (Lancamento) o;
        return Double.compare(that.valorDocumento, valorDocumento) == 0 && Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao) && Objects.equals(parcela, that.parcela) && Objects.equals(dataLancamento, that.dataLancamento) && Objects.equals(dataVencimento, that.dataVencimento) && Objects.equals(dataBaixa, that.dataBaixa) && tipoLancamento == that.tipoLancamento && situacao == that.situacao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, parcela, dataLancamento, dataVencimento, dataBaixa, valorDocumento, tipoLancamento, situacao);
    }
}
