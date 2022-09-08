package com.letscode.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letscode.ecommerce.dao.ClienteDao;
import com.letscode.ecommerce.dto.ClienteDto;
import com.letscode.ecommerce.models.Cliente;
import com.letscode.ecommerce.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteDao clienteDao;

    @Override
    public List<Cliente> listarTodosClientes() {
        return clienteDao.findAll();
    }

    @Override
    public Cliente novoCliente(ClienteDto cliente) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean atualizarCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removerCliente(long id) {
        // TODO Auto-generated method stub
        return false;
    }

}
