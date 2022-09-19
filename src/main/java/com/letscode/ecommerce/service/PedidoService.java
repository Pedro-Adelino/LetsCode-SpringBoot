package com.letscode.ecommerce.service;

import java.util.List;

import com.letscode.ecommerce.dto.PedidoDto;
import com.letscode.ecommerce.models.Pedido;

public interface PedidoService {

    List<Pedido> listarTodosPedidos();

    Pedido novoPedido(PedidoDto pedidoDto);

    Pedido pegaPedidoPorId(Long id);

    Pedido excluiPedidoPorId(Long id);

    Pedido atualizaPedido(Pedido pedido);
}
