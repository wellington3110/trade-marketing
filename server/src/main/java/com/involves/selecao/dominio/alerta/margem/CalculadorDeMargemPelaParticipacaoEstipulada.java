package com.involves.selecao.dominio.alerta.margem;

import com.involves.selecao.dominio.pesquisa.Pesquisa;
import com.involves.selecao.dominio.pesquisa.Resposta;

public class CalculadorDeMargemPelaParticipacaoEstipulada implements CalculadorDeMargem {

    @Override
    public Integer calcula(Pesquisa pesquisa, Resposta resposta) {
        return pesquisa.getParticipacaoEstipuladaInt() - Integer.parseInt(resposta.getResposta());
    }
}
