package com.example.demo.service;

import com.example.demo.controller.RequestTransacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeebHookService {

    private static final Logger log = LoggerFactory.getLogger(WeebHookService.class);

    @Autowired
    RestTemplate restTemplateHook;

    @Value("${callback.url}")
    private String urlWebHookTest;

    public void callBack(RequestTransacao requestTransacao){
        log.info("Callback iniciado para a transacao id: {}", requestTransacao.id());

        final var request = new RequestWebHook();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<RequestWebHook> httpEntity =
                new HttpEntity<>(request.buildRequestWebHook(requestTransacao), headers);

        log.info("Callback aplicado para url e id: {}", Map.of("url", requestTransacao.id(), "id", requestTransacao.id()));

        final var response = restTemplateHook.exchange(urlWebHookTest, HttpMethod.POST, httpEntity, String.class);

        log.info("Status code callback : {}", response.getStatusCode());

    }

}
