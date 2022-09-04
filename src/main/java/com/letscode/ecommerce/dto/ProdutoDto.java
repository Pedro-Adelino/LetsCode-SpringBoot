package com.letscode.ecommerce.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProdutoDto {

    private String nome;

    private Double preco;

    private String descricao;
}
