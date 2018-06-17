package com.involves.selecao.dominio.alerta.margem;

import com.involves.selecao.dominio.pesquisa.Pesquisa;
import com.involves.selecao.dominio.pesquisa.Resposta;

public class CalculadorDeMargemPeloPrecoEstipulado implements CalculadorDeMargem {

    @Override
    public Integer calcula(Pesquisa pesquisa, Resposta resposta) {
        return pesquisa.getPrecoEstipuladoInt() - Integer.parseInt(resposta.getResposta());
    }

}
