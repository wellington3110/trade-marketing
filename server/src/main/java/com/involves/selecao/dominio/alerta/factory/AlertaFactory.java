package com.involves.selecao.dominio.alerta.factory;

import com.involves.selecao.dominio.alerta.Alerta;
import com.involves.selecao.dominio.pesquisa.Pesquisa;
import com.involves.selecao.dominio.pesquisa.Resposta;

import java.util.Optional;

public interface AlertaFactory {

    Optional<Alerta> criaAlertaSePossivel(Pesquisa pesquisa, Resposta resposta);
}
