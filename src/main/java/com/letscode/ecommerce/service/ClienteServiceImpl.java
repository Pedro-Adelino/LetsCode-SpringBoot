package com.letscode.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letscode.ecommerce.dao.ClienteDao;
import com.letscode.ecommerce.models.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteDao clienteDao;

    @Override
    public List<Cliente> listarTodosClientes() {
        return clienteDao.findAll();
    }

    @Override
    public boolean novoCliente(ClienteDao cliente) {
        // TODO Auto-generated method stub
        return false;
    }

}
