package com.letscode.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.letscode.ecommerce.dao.PedidoDao;
import com.letscode.ecommerce.dto.PedidoDto;
import com.letscode.ecommerce.models.Cliente;
import com.letscode.ecommerce.models.Pedido;
import com.letscode.ecommerce.models.Produto;
import com.letscode.ecommerce.service.ClienteService;
import com.letscode.ecommerce.service.PedidoService;
import com.letscode.ecommerce.service.ProdutoService;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoDao pedidoDao;

    @Autowired
    ClienteService clienteService;

    @Autowired
    ProdutoService produtoService;

    @Override
    public List<Pedido> listarTodosPedidos() {
        return pedidoDao.findAll();
    }

    @Override
    public Pedido novoPedido(PedidoDto pedidoDto) {
        try {

            Cliente cliente = clienteService.pegaClientePorId(pedidoDto.getClienteId());
            List<Produto> produtos = fazListaProdutos(pedidoDto.getListaProdutoId());
            Pedido pedido = new Pedido(cliente, produtos);
            pedidoDao.save(pedido);
            return pedido;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public Pedido pegaPedidoPorId(Long id) {
        try {
            return pedidoDao.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado");
        }
    }

    @Override
    public Boolean excluiPedidoPorId(Long id) {
        try {
            pedidoDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean atualizaPedido(Pedido pedido) {
        try {
            pedidoDao.save(pedido);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private List<Produto> fazListaProdutos(List<Long> listaIds) {
        List<Produto> produtos = new ArrayList<>();
        for (Long id : listaIds) {
            Produto produto = produtoService.pegaProdutoPorId(id);
            produtos.add(produto);
        }
        return produtos;
    }
}
