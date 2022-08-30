package com.letscode.ecommerce.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.ecommerce.service.HorarioService;

@RestController
public class HelloEndPoints {

    @Autowired
    HorarioService horarioService;

    // Logger log = LoggerFactory.getLogger(HelloEndPoints.class);
    Logger log = LoggerFactory.getLogger(HelloEndPoints.class);

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> hello() {
        log.info("/hello endpoint: insercao realizada com sucesso");
        return new ResponseEntity<String>("Hello world!", HttpStatus.OK);
    }

    @RequestMapping(path = "/hello/{nome}", method = RequestMethod.GET)
    public ResponseEntity<String> hello(@PathVariable String nome) {
        log.info("/hello/{nome} endpoint: insercao realizada com sucesso");
        return new ResponseEntity<String>("Hello, " + nome + "!", HttpStatus.OK);
    }

    @RequestMapping(path = "/hello/{nome}/horario", method = RequestMethod.GET)
    public ResponseEntity<String> helloHorario(@PathVariable String nome) {
        String resposta = horarioService.resposta(nome);
        log.info("/hello/{nome}/horario endpoint: insercao realizada com sucesso");
        return new ResponseEntity<String>(resposta, HttpStatus.OK);
    }
}
