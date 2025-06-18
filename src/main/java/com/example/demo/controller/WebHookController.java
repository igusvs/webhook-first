package com.example.demo.controller;

import com.example.demo.service.WeebHookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController("/")
public class WebHookController {

    @Autowired
    WeebHookService hookService;

    private static final Logger log = LoggerFactory.getLogger(WebHookController.class);

    @PostMapping("/api/webhook/transaction")
    private ResponseEntity<?> notificarTransacao(@RequestBody RequestTransacao requestTransacao) {
        log.info("Requisicao recebida para transacao ID: {}", requestTransacao.id());
        log.debug("Detalhes requisicao: {}", requestTransacao);

        hookService.callBack(requestTransacao);
        return ResponseEntity.ok().build();

    }


}
