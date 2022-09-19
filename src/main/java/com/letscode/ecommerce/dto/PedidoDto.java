package com.letscode.ecommerce.dto;

import java.util.List;

import com.letscode.ecommerce.models.Cliente;
import com.letscode.ecommerce.models.Produto;

import lombok.Data;

@Data
public class PedidoDto {

    private Long id;

    private Cliente cliente;

    private List<Produto> produtos;

}
