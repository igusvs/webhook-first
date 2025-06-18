package com.example.demo.service;

import com.example.demo.controller.RequestTransacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeebHookService {

    @Autowired
    RestTemplate restTemplateHook;

    @Value("${callback.url}")
    private String urlWebHookTest;

    public void notify(RequestTransacao requestTransacao){

        final var request = new RequestWebHook();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<RequestWebHook> httpEntity =
                new HttpEntity<>(request.buildRequestWebHook(requestTransacao), headers);

        restTemplateHook.exchange(urlWebHookTest, HttpMethod.POST, httpEntity, String.class);

    }

}
