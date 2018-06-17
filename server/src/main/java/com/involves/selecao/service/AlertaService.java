package com.involves.selecao.service;

import com.involves.selecao.dominio.alerta.Alerta;
import com.involves.selecao.dominio.alerta.factory.*;
import com.involves.selecao.dominio.pesquisa.Pesquisa;
import com.involves.selecao.dominio.pesquisa.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlertaService {

    @Autowired
    private List<AlertaFactory> alertaFactories;

    public List<Alerta> criaAlertas(Pesquisa pesquisa) {

        return pesquisa.getRespostas()
                       .stream()
                       .map(resposta -> this.criaAlerta(pesquisa, resposta))
                       .filter(Optional::isPresent)
                       .map(Optional::get)
                       .collect(Collectors.toList());

    }

    public Optional<Alerta> criaAlerta(Pesquisa pesquisa, Resposta resposta) {
        return alertaFactories
                            .stream()
                            .map(alertaFactory -> alertaFactory.criaAlertaSePossivel(pesquisa, resposta))
                            .filter(Optional::isPresent)
                            .map(Optional::get)
                            .findFirst();
    }
}
