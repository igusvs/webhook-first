package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("/")
public class WebHookController {

    private static final Logger log = LoggerFactory.getLogger(WebHookController.class);

    @PostMapping("/api/webhook/transaction")
    private ResponseEntity<?> notificarTransacao(RequestTransacao requestTransacao) {
        log.info();
        return ResponseEntity.ok().build();
    }


}
