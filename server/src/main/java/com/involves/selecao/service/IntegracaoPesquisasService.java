package com.involves.selecao.service;

import com.involves.selecao.dominio.pesquisa.Pesquisa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IntegracaoPesquisasService {

    public static final String URI_GET_PESQUISAS = "https://selecao-involves.agilepromoter.com/pesquisas";

    @Autowired
    private RestTemplate restTemplate;

    public Pesquisa[] getPesquisas() {
        return restTemplate.getForObject(URI_GET_PESQUISAS, Pesquisa[].class);
    }
}
