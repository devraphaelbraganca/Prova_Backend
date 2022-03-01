package com.mercado.mercado.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mercado.mercado.dto.ProdutoDto;
import com.mercado.mercado.dto.VendaDto;
import com.mercado.mercado.model.Produto;
import com.mercado.mercado.model.Venda;
import com.mercado.mercado.repository.ProdutoRepository;
import com.mercado.mercado.repository.VendasRepository;

import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    public ProdutoRepository repositorio;
    @Autowired
    private VendasRepository vendaRep;

    @Override
    public ProdutoDto criarProduto(ProdutoDto produto) {
        ModelMapper mapper = new ModelMapper();
        Produto produtoFiltro = mapper.map(produto, Produto.class);
        produtoFiltro = repositorio.save(produtoFiltro);

        return mapper.map(produtoFiltro, ProdutoDto.class);
    }

    @Override
    public List<ProdutoDto> obterTodos() {
        List<Produto> produtos = repositorio.findAll();

        return produtos.stream().map(produto -> new ModelMapper().map(produto, ProdutoDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<VendaDto> listarVendas() {
        List<Venda> vendas = vendaRep.findAll();
        
        return vendas.stream().map(venda -> new ModelMapper().map(venda, VendaDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<ProdutoDto> obterPorId(String codigo) {
        Optional<Produto> produto = repositorio.findById(codigo);
        
        if(produto.isPresent()) {
            return Optional.of(new ModelMapper().map(produto.get(), ProdutoDto.class));
        }
        
        return Optional.empty();
    }

    @Override
    public void removerProduto(String codigo) {
        repositorio.deleteById(codigo);
    }

    @Override
    public ProdutoDto venderProduto(String codigo, int solicitacao) {
        Optional<Produto> registro = repositorio.findById(codigo);

        if (!registro.isEmpty()) {
            Produto produto = registro.get();
            produto.setSolicitacao(solicitacao);
            ModelMapper mapper2 = new ModelMapper();
            Venda vendaFiltro = mapper2.map(produto, Venda.class);
            vendaFiltro.setNomeVenda(produto.getNome());
            vendaFiltro.setQuantidade(produto.getSolicitacao());
            vendaFiltro.setValorTotal(produto.getValor() * produto.getSolicitacao());
            vendaRep.save(vendaFiltro);

            produto.setQuantidade(produto.getQuantidade() - solicitacao);
            repositorio.save(produto); 

            return mapper2.map(vendaFiltro, ProdutoDto.class);
        }
        else {
            return null;
        }
    }
}
