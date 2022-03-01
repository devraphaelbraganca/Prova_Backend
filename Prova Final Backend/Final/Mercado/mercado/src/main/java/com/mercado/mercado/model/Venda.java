package com.mercado.mercado.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("venda")
public class Venda {

    private String nomeVenda;
    private double valorTotal;
    private int quantidade;

    public String getNomeVenda() {
        return nomeVenda;
    }
    public void setNomeVenda(String nomeVenda) {
        this.nomeVenda = nomeVenda;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public static Venda parse(Produto produto) {
        Venda vendaFiltro = new Venda();
        vendaFiltro.setNomeVenda(produto.getNome());
        vendaFiltro.setValorTotal(produto.getValor() * produto.getSolicitacao());
        vendaFiltro.setQuantidade(produto.getSolicitacao());
        return vendaFiltro;
    }
}
