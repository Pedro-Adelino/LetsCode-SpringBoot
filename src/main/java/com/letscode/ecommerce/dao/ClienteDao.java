package com.letscode.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letscode.ecommerce.models.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long> {

    List<Cliente> findAllByIdOrEmail(long id, String email); // SELECT * FROM CLIENTE WHERE id = {id} OR email = {email}

    Cliente findByEmail(String email);
}
