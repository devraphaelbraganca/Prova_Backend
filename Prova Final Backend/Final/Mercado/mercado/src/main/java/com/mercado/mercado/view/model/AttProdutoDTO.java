package com.mercado.mercado.view.model;

import com.mercado.mercado.dto.ProdutoDto;

public class AttProdutoDTO {
    
    private String codigo;
    private int quantidade;

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public static AttProdutoDTO parse(ProdutoDto produto) {
        AttProdutoDTO dtoatt = new AttProdutoDTO();
        dtoatt.setCodigo(produto.getCodigo());
        dtoatt.setQuantidade(produto.getQuantidade() - produto.getSolicitacao());
        return dtoatt;
    }

}
