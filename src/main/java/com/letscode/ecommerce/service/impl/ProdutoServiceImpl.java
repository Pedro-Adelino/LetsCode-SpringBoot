package com.letscode.ecommerce.service.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.letscode.ecommerce.dao.ProdutoDao;
import com.letscode.ecommerce.dto.ProdutoDto;
import com.letscode.ecommerce.models.Produto;
import com.letscode.ecommerce.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoDao dao;

    @Override
    public Boolean novoProduto(ProdutoDto produtoDto) {
        try {
            Produto produto = new Produto(produtoDto.getNome(), produtoDto.getPreco(), produtoDto.getDescricao());
            dao.save(produto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Produto pegaProdutoPorId(Long id) {
        try {
            return dao.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado", e);
        }
    }

    @Override
    public Boolean excluiProdutoPorId(Long id) {
        try {
            dao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean atualizaProduto(Produto produto) {
        try {
            dao.save(produto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
