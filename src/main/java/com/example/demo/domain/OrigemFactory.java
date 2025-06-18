package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrigemFactory {

    private final Map<Origem, OrigemStrategy> strategies = new HashMap<>();

    @Autowired
    public OrigemFactory(List<OrigemStrategy> strategyList) {
        for (OrigemStrategy strategy : strategyList) {
            if (strategy instanceof DesktopStrategy) {
                strategies.put(Origem.DESKTOP, strategy);
            } else if (strategy instanceof MobileStrategy) {
                strategies.put(Origem.MOBILE, strategy);
            }
        }
    }

    public OrigemStrategy getStrategy(Origem origem) {
        return strategies.getOrDefault(origem, dados -> {
            throw new IllegalArgumentException("Origem nao suportada: " + origem);
        });
    }
}
