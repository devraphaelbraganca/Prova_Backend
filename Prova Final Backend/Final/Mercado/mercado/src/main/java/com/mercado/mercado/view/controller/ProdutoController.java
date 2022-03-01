package com.mercado.mercado.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.mercado.mercado.dto.ProdutoDto;
import com.mercado.mercado.dto.VendaDto;
import com.mercado.mercado.model.Produto;
import com.mercado.mercado.service.ProdutoService;
import com.mercado.mercado.view.model.AttProdutoDTO;
import com.mercado.mercado.view.model.ProdutoMRequest;
import com.mercado.mercado.view.model.ProdutoMResponse;
import com.mercado.mercado.view.model.VendaMResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService servico;

    @PostMapping
    public ResponseEntity<ProdutoMResponse> criarProduto(@RequestBody @Valid ProdutoMRequest produto) {
        ModelMapper mapper = new ModelMapper();
        ProdutoDto dto = mapper.map(produto, ProdutoDto.class);
        dto = servico.criarProduto(dto);
        return new ResponseEntity<>(mapper.map(dto, ProdutoMResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoMResponse>> obterProdutos() {
        ModelMapper mapper = new ModelMapper();
        List<ProdutoDto> dtos = servico.obterTodos();
        List<ProdutoMResponse> resp = dtos.stream().map(dto -> mapper.map(dto, ProdutoMResponse.class)).collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{codigo}")
    public ResponseEntity<ProdutoMResponse> obterPorId(@PathVariable String codigo) {
        Optional<ProdutoDto> produto = servico.obterPorId(codigo);

        if(produto.isPresent()){
            return new ResponseEntity<>( new ModelMapper().map(produto.get(), ProdutoMResponse.class), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(value = "/{codigo}")
    public ResponseEntity<Void> removerProduto(@PathVariable String codigo){
        servico.removerProduto(codigo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

// ----------------------------------------------------------------------------/////////////-------------------------------------------------------------------------
// ----------------------------------------------------------------------------/////////////-------------------------------------------------------------------------
// ----------------------------------------------------------------------------/////////////-------------------------------------------------------------------------

    @PostMapping("/venda/{codigo}/{solicitacao}")
    public ResponseEntity<Produto> venderProduto(@PathVariable String codigo, @PathVariable int solicitacao) {
        ProdutoDto resposta = servico.venderProduto(codigo, solicitacao);

        if (resposta == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
  
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    public AttProdutoDTO venderProduto(@RequestBody @Valid AttProdutoDTO dtoatt) {
        ProdutoDto produto = servico.venderProduto(dtoatt.getCodigo(), dtoatt.getQuantidade());
        return AttProdutoDTO.parse(produto);
    }

    @GetMapping("/vendas")
    public ResponseEntity<List<VendaMResponse>> listarVendas() {
        ModelMapper mapper = new ModelMapper();
        List<VendaDto> dtos3 = servico.listarVendas();
        List<VendaMResponse> resp3 = dtos3.stream().map(dto3 -> mapper.map(dto3, VendaMResponse.class)).collect(Collectors.toList());

        return new ResponseEntity<>(resp3, HttpStatus.OK);
    }
}

