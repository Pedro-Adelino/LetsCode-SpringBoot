package com.letscode.ecommerce.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutosEndpoints {

    @RequestMapping(path = "/novoProduto", method = RequestMethod.POST)
    public ResponseEntity<String> novoProduto() {
        return new ResponseEntity<String>("Produto criado com sucesso", HttpStatus.CREATED);
    }

    @RequestMapping(path = "/pegaProduto/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> pegaProdutoPorId(@PathVariable String id) {
        return new ResponseEntity<String>("Requisitado produto id: " + id, HttpStatus.OK);
    }

    @RequestMapping(path = "/excluirProduto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> excluirProdutoPorId(@PathVariable String id) {
        return new ResponseEntity<String>("Requisitada exclusão do produto id: " + id, HttpStatus.OK);
    }

    @RequestMapping(path = "/atualizarProduto/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> atualizarProdutoPorId(@PathVariable String id) {
        return new ResponseEntity<String>("Requisitada atualização do produto id: " + id, HttpStatus.OK);
    }
}
