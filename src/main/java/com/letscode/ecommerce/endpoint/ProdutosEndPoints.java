package com.letscode.ecommerce.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.ecommerce.dto.ProdutoDto;
import com.letscode.ecommerce.models.Produto;
import com.letscode.ecommerce.service.ProdutoService;

@RestController
public class ProdutosEndpoints {

    @Autowired
    ProdutoService service;

    @RequestMapping(path = "/produto", method = RequestMethod.POST)
    public ResponseEntity<String> novoProduto(@RequestBody ProdutoDto produtoDto) {
        Boolean sucesso = service.novoProduto(produtoDto);

        if (sucesso) {
            return new ResponseEntity<String>("Produto criado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Criação do produto falhou!", HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(path = "/produto/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> pegaProdutoPorId(@PathVariable Long id) {
        return new ResponseEntity<Produto>(service.pegaProdutoPorId(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(path = "/produto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> excluiProdutoPorId(@PathVariable Long id) {
        Boolean sucesso = service.excluiProdutoPorId(id);

        if (sucesso) {
            return new ResponseEntity<String>("Produto excluido com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Falha ao excluir o produto", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/produto", method = RequestMethod.PUT)
    public ResponseEntity<String> atualizaProduto(@RequestBody Produto produto) {
        Boolean sucesso = service.atualizaProduto(produto);

        if (sucesso) {
            return new ResponseEntity<String>("Produto atualizado com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Falha na atualização do produto", HttpStatus.BAD_REQUEST);
        }
    }
}
