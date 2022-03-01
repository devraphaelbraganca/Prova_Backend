package com.mercado.mercado.service;

import java.util.List;

import com.mercado.mercado.model.Venda;
import com.mercado.mercado.repository.ProdutoRepository;
import com.mercado.mercado.repository.VendasRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class VendaServiceImpl implements VendaService{
    @Autowired
    private VendasRepository vendaRep;
    @Autowired
    public ProdutoRepository repositorio;

    @Override
    public List<Venda> listarVendas() {
        return vendaRep.findAll();
    }

}
