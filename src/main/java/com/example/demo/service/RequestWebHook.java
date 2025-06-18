package com.example.demo.service;

import com.example.demo.controller.RequestTransacao;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

public class RequestWebHook {

    @JsonProperty("id_transacao")
    private String idTransacao;

    private String valor;

    @JsonProperty("data_transacao")
    private String dataTransacao;

    private String assinatura;



    public RequestWebHook buildRequestWebHook(RequestTransacao requestTransacao){

        RequestWebHook request = new RequestWebHook();
        request.setAssinatura(UUID.randomUUID().toString());
        request.setDataTransacao(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).toString());
        request.setIdTransacao("TRANSACTION#".concat(requestTransacao.id()));

        return request;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public void setIdTransacao(String idTransacao) {
        this.idTransacao = idTransacao;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }
}
