package com.letscode.ecommerce.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.letscode.ecommerce.dto.ClienteDto;
import com.letscode.ecommerce.models.Cliente;
import com.letscode.ecommerce.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ClienteEndpoints {

    @Autowired
    ClienteService clienteService;

    @Operation(description = "Esse método retorna todos os clientes do sistema, sem filtros.")
    @RequestMapping(path = "/cliente", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> getAllClients() {
        List<Cliente> clienteList = clienteService.listarTodosClientes();
        return ResponseEntity.ok(clienteList);
    }

    @RequestMapping(path = "/cliente", method = RequestMethod.POST)
    public ResponseEntity<Cliente> novoCliente(@RequestBody ClienteDto cliente) {
        Cliente clienteSalvo = clienteService.novoCliente(cliente);
        if (clienteSalvo != null) {
            return ResponseEntity.ok(clienteSalvo);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Criacao do cliente falhou");
        }
    }

    @RequestMapping(path = "/cliente", method = RequestMethod.PUT)
    public ResponseEntity<String> atualizarCliente(@RequestBody Cliente cliente) {
        boolean sucesso = clienteService.atualizarCliente(cliente);
        if (sucesso) {
            return new ResponseEntity<String>("Cliente atualizado com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Atualização do cliente falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(path = "/cliente/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removerCliente(@PathVariable long id) {
        boolean sucesso = clienteService.removerCliente(id);
        if (sucesso) {
            return new ResponseEntity<String>("Cliente deletado com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Remocao do cliente falhou!", HttpStatus.BAD_REQUEST);
        }
    }
}
