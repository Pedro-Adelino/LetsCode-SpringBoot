package com.letscode.ecommerce.dto;

import java.util.List;

import lombok.Data;

@Data
public class PedidoDto {

    private Long id;

    private Long clienteId;

    private List<Long> listaProdutoId;

    public PedidoDto(Long clienteId, List<Long> listaProdutoId) {
        this.clienteId = clienteId;
        this.listaProdutoId = listaProdutoId;
    }
}
