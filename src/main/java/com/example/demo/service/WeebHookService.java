package com.example.demo.service;

import com.example.demo.controller.RequestTransacao;
import com.example.demo.domain.Origem;
import com.example.demo.domain.OrigemFactory;
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

    @Autowired
    private OrigemFactory origemFactory;


    public void callBack(final RequestTransacao requestTransacao){
        log.info("Callback iniciado para a transacao id: {}", requestTransacao.id());

        final var request = new RequestWebHook();

        HttpEntity<RequestWebHook> httpEntity =
                new HttpEntity<>(request.buildRequestWebHook(requestTransacao), headerDefaultFactory());

        log.info("Callback aplicado para url e id: {}", Map.of("url", requestTransacao.id(), "id", requestTransacao.id()));

        final var response = restTemplateHook.exchange(urlFactory(requestTransacao), HttpMethod.POST, httpEntity, String.class);

        log.info("Status code callback : {}", response.getStatusCode());

    }

    private String urlFactory(RequestTransacao requestTransacao){
        final var result = origemFactory.getStrategy(Origem.valueOf(requestTransacao.origem()));
        return result.definirOrigem(Origem.valueOf(requestTransacao.origem()));
    }

    private HttpHeaders headerDefaultFactory(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
    }

}
