package com.example.demo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MobileStrategy implements OrigemStrategy{

    @Value("${callback.url}")
    private String callbackUrl;

    private static final Logger log = LoggerFactory.getLogger(MobileStrategy.class);

    @Override
    public String definirOrigem(Origem origem) {
        log.info("Strategy definido com sucesso : {}", origem.name());
        return callbackUrl;
    }
}
