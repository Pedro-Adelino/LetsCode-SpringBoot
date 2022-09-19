package com.letscode.ecommerce.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.ecommerce.dto.PedidoDto;
import com.letscode.ecommerce.models.Pedido;
import com.letscode.ecommerce.service.PedidoService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class PedidoEndpoint {

    @Autowired
    PedidoService service;

    @Operation(description = "Esse método retorna todos os pedidos do sistema, sem filtros.")
    @RequestMapping(path = "/pedidos", method = RequestMethod.GET)
    public ResponseEntity<List<Pedido>> listarTodosPediso() {
        return ResponseEntity.ok(service.listarTodosPedidos());
    }

    @Operation(description = "Esse método cria um novo pedido.")
    @RequestMapping(path = "/pedido", method = RequestMethod.POST)
    public ResponseEntity<Pedido> novoPedido(@RequestBody PedidoDto pedidoDto) {
        return ResponseEntity.ok(service.novoPedido(pedidoDto));
    }

    @Operation(description = "Esse método requer um Id e retorna o pedido correspondente.")
    @RequestMapping(path = "/pedido/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> pegaPedidoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.pegaPedidoPorId(id));
    }

    @Operation(description = "Esse método requer um Id e exclui o pedido correspondente")
    @RequestMapping(path = "/pedido/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> excluiPedidoPorId(@PathVariable Long id) {
        Boolean sucesso = service.excluiPedidoPorId(id);
        if (sucesso) {
            return new ResponseEntity<String>("Pedido excluido com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Falha ao excluir o pedido", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/pedido", method = RequestMethod.PUT)
    public ResponseEntity<String> atualizaPedido(@RequestBody Pedido pedido) {
        Boolean sucesso = service.atualizaPedido(pedido);
        if (sucesso) {
            return new ResponseEntity<String>("Pedido atualizado com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Falha na atualização do pedido", HttpStatus.BAD_REQUEST);
        }
    }
}
