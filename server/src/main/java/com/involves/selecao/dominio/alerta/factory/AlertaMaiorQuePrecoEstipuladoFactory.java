package com.involves.selecao.dominio.alerta.factory;

import com.involves.selecao.dominio.alerta.AlertaDePreco;
import com.involves.selecao.dominio.alerta.margem.CalculadorDeMargem;
import com.involves.selecao.dominio.pesquisa.Pesquisa;
import com.involves.selecao.dominio.pesquisa.Resposta;
import com.involves.selecao.dominio.alerta.enums.AlertaParamsOf;
import com.involves.selecao.dominio.alerta.enums.PerguntaPesquisa;

public class AlertaMaiorQuePrecoEstipuladoFactory extends AbstractAlertaFactory {

    private final CalculadorDeMargem calculadorDeMargem;

    public AlertaMaiorQuePrecoEstipuladoFactory(CalculadorDeMargem calculadorDeMargem){

        this.calculadorDeMargem = calculadorDeMargem;
    }

    @Override
    public boolean podeCriarAlerta(Pesquisa pesquisa, Resposta resposta) {
        return resposta.perguntaIsEqualTo(PerguntaPesquisa.PRECO_PRODUTO) && pesquisa.temPrecoMaiorQueEstipulado(resposta);
    }

    @Override
    protected AlertaDePreco criaAlerta(Pesquisa pesquisa, Resposta resposta) {
        return new AlertaDePreco(pesquisa, AlertaParamsOf.PRECO_MAIOR_QUE_ESTIPULADO, calculadorDeMargem.calcula(pesquisa, resposta));
    }
}
