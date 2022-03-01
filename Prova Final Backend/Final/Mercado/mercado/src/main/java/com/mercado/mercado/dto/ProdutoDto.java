package com.mercado.mercado.dto;

public class ProdutoDto {
    private String codigo;
    private String nome;
    private double valor;
    private int quantidade;

    private int solicitacao;
    private double valorTotal = valor*solicitacao;

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getSolicitacao() {
        return solicitacao;
    }
    public void setSolicitacao(int solicitacao) {
        this.solicitacao = solicitacao;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
