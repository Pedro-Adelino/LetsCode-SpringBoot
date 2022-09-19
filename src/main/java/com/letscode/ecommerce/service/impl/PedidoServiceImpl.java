package com.letscode.ecommerce.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.letscode.ecommerce.dao.PedidoDao;
import com.letscode.ecommerce.dto.PedidoDto;
import com.letscode.ecommerce.models.Pedido;
import com.letscode.ecommerce.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoDao dao;

    @Override
    public List<Pedido> listarTodosPedidos() {
        return dao.findAll();
    }

    @Override
    public Pedido novoPedido(PedidoDto pedidoDto) {
        try {
            Pedido pedido = new Pedido(pedidoDto.getId(), pedidoDto.getCliente(), pedidoDto.getProdutos());
            dao.save(pedido);
            return pedido;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public Pedido pegaPedidoPorId(Long id) {
        try {
            return dao.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado");
        }
    }

    @Override
    public Boolean excluiPedidoPorId(Long id) {
        try {
            dao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean atualizaPedido(Pedido pedido) {
        try {
            dao.save(pedido);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
