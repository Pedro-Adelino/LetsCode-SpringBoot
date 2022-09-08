package com.letscode.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.letscode.ecommerce.dao.ClienteDao;
import com.letscode.ecommerce.dto.ClienteDto;
import com.letscode.ecommerce.models.Cliente;
import com.letscode.ecommerce.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteDao clienteDao;

    private final PasswordEncoder passwordEncoder;

    public ClienteServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Cliente> listarTodosClientes() {
        return clienteDao.findAll();
    }

    @Override
    public Cliente novoCliente(ClienteDto clienteDto) {
        try {
            if (clienteDto.getId() == 0) {
                clienteDto.setSenha(passwordEncoder.encode(clienteDto.getSenha()));
            }
            Cliente cliente = new Cliente(clienteDto.getNome(), clienteDto.getSobrenome(), clienteDto.getEmail(),
                    clienteDto.getSexo(), clienteDto.getCpf(), clienteDto.getSenha(), clienteDto.getPerfil());
            clienteDao.save(cliente);
            cliente.setSenha("");
            return cliente;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean atualizarCliente(Cliente cliente) {
        try {
            clienteDao.save(cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean removerCliente(long id) {
        try {
            clienteDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}