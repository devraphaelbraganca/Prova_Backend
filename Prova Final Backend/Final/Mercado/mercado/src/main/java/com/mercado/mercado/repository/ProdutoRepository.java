package com.mercado.mercado.repository;

import com.mercado.mercado.model.Produto;
import com.mercado.mercado.model.Venda;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String>{

    Venda save(Venda vendaFiltro);

}
