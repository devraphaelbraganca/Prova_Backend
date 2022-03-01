package com.mercado.mercado.view.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class ProdutoMRequest {

    private String codigo;
    @NotEmpty(message = "O valor tem que ser preenchido")
    private String nome;
    private double valor;
    @Min(value = 0, message = "A quantidade de estoque deve ser maior do que zero.")
    private int quantidade;

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
}