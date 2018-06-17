package com.involves.selecao.dominio.alerta.factory;

import com.involves.selecao.dominio.alerta.Alerta;
import com.involves.selecao.dominio.alerta.AlertaDeParticipacao;
import com.involves.selecao.dominio.alerta.enums.AlertaParamsOf;
import com.involves.selecao.dominio.alerta.enums.PerguntaPesquisa;
import com.involves.selecao.dominio.alerta.margem.CalculadorDeMargem;
import com.involves.selecao.dominio.pesquisa.Pesquisa;
import com.involves.selecao.dominio.pesquisa.Resposta;


public class AlertaParticipacaoSuperiorAoEstipuladoFactory extends AbstractAlertaFactory {

    private CalculadorDeMargem calculadorDeMargem;

    public AlertaParticipacaoSuperiorAoEstipuladoFactory(CalculadorDeMargem calculadorDeMargem) {

        this.calculadorDeMargem = calculadorDeMargem;
    }

    @Override
    protected boolean podeCriarAlerta(Pesquisa pesquisa, Resposta resposta) {
        return resposta.perguntaIsEqualTo(PerguntaPesquisa.SHARE) && pesquisa.temParticipacaoSuperiorAoEstipulado(resposta);
    }

    @Override
    protected Alerta criaAlerta(Pesquisa pesquisa, Resposta resposta) {
        return new AlertaDeParticipacao(pesquisa, AlertaParamsOf.PARTICIPACAO_SUPERIOR_AO_ESTIPULADO, calculadorDeMargem.calcula(pesquisa, resposta));
    }
}
