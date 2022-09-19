package com.letscode.ecommerce.service;

import java.util.List;

import com.letscode.ecommerce.dto.ClienteDto;
import com.letscode.ecommerce.models.Cliente;

public interface ClienteService {
    List<Cliente> listarTodosClientes();

    Cliente novoCliente(ClienteDto cliente);

    Cliente pegaClientePorId(Long id);

    boolean atualizarCliente(Cliente cliente);

    boolean removerCliente(long id);

}
