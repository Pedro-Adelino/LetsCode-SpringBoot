package com.letscode.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letscode.ecommerce.models.Pedido;

public interface PedidoDao extends JpaRepository<Pedido, Long> {

}
