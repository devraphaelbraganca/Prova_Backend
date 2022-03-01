package com.mercado.mercado.view.model;

import com.mercado.mercado.model.Produto;

public class VendaMResponse {
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
    
    public static VendaMResponse parse(Produto produto) {
        VendaMResponse prdvenda = new VendaMResponse();
        produto.setSolicitacao(produto.getSolicitacao());
        prdvenda.setNomeVenda(produto.getNome());
        prdvenda.setValorTotal(produto.getValor() * produto.getSolicitacao());
        prdvenda.setQuantidade(produto.getSolicitacao());
        return prdvenda;
    }
}
