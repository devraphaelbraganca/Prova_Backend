package com.mercado.mercado.repository;

import com.mercado.mercado.model.Venda;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendasRepository extends MongoRepository<Venda, String>{
    
}
