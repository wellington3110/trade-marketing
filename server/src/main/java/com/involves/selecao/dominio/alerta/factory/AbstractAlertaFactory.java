package com.involves.selecao.dominio.alerta.factory;

import com.involves.selecao.dominio.alerta.Alerta;
import com.involves.selecao.dominio.pesquisa.Pesquisa;
import com.involves.selecao.dominio.pesquisa.Resposta;

import java.util.Optional;

public abstract class AbstractAlertaFactory implements AlertaFactory {

    @Override
    public Optional<Alerta> criaAlertaSePossivel(Pesquisa pesquisa, Resposta resposta) {
        if (!podeCriarAlerta(pesquisa, resposta)) {
            return Optional.empty();
        }

        return Optional.of(criaAlerta(pesquisa, resposta));
    }

    protected abstract boolean podeCriarAlerta(Pesquisa pesquisa, Resposta resposta);
    protected abstract Alerta criaAlerta(Pesquisa pesquisa, Resposta resposta);


}
