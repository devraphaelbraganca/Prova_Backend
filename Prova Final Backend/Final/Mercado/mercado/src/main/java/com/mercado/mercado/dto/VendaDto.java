package com.mercado.mercado.dto;

public class VendaDto {

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

}
