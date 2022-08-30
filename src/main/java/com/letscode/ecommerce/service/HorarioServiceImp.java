package com.letscode.ecommerce.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class HorarioServiceImp implements HorarioService {

    public String resposta(String nome) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String agora = LocalDateTime.now().format(formatter);
        return String.format("Hello, %s! Agora são %s, não esqueça!", nome, agora);
    }
}
