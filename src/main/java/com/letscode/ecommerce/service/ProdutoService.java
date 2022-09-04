package com.letscode.ecommerce.service;

import com.letscode.ecommerce.dto.ProdutoDto;
import com.letscode.ecommerce.models.Produto;

public interface ProdutoService {
    Boolean novoProduto(ProdutoDto produtoDto);

    Produto pegaProdutoPorId(Long id);

    Boolean excluiProdutoPorId(Long id);

    Boolean atualizaProduto(Produto produto);

}
