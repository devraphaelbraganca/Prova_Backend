package com.mercado.mercado.service;

import java.util.List;
import java.util.Optional;

import com.mercado.mercado.dto.ProdutoDto;
import com.mercado.mercado.dto.VendaDto;

public interface ProdutoService {
    ProdutoDto criarProduto(ProdutoDto produto);
    List<ProdutoDto> obterTodos();
    Optional<ProdutoDto> obterPorId(String codigo);
    void removerProduto(String codigo);
    ProdutoDto venderProduto(String codigo, int quantidade);
    List<VendaDto> listarVendas();
}
