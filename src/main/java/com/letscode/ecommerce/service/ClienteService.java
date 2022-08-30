package com.letscode.ecommerce.service;

import java.util.List;

import com.letscode.ecommerce.dao.ClienteDao;
import com.letscode.ecommerce.models.Cliente;

public interface ClienteService {
    List<Cliente> listarTodosClientes();

    boolean novoCliente(ClienteDao cliente);

}
