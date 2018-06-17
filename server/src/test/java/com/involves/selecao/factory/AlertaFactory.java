package com.involves.selecao.factory;

import com.involves.selecao.dominio.alerta.AlertaDeParticipacao;
import com.involves.selecao.dominio.alerta.AlertaDePreco;
import com.involves.selecao.dominio.alerta.AlertaDeRuptura;
import com.involves.selecao.dominio.pesquisa.Pesquisa;
import com.involves.selecao.dominio.alerta.enums.AlertaParamsOf;

public class AlertaFactory {

    public static AlertaDeRuptura criaAlertaComRuptura(Pesquisa pesquisa) {
        return new AlertaDeRuptura(pesquisa, AlertaParamsOf.RUPTURA);
    }

    public static AlertaDePreco criaAlertaDePrecoMaiorQueEstipulado(Pesquisa pesquisa, int margem) {
        return new AlertaDePreco(pesquisa, AlertaParamsOf.PRECO_MAIOR_QUE_ESTIPULADO, margem);
    }
    public static AlertaDePreco criaAlertaDePrecoMenorQueEstipulado(Pesquisa pesquisa, int margem) {
        return new AlertaDePreco(pesquisa, AlertaParamsOf.PRECO_MENOR_QUE_ESTIPULADO, margem);
    }

    public static AlertaDeParticipacao criaAlertaDeParticipacaoDeProdutoInferiorAoEstipulado(Pesquisa pesquisa, int margem) {
        return new AlertaDeParticipacao(pesquisa, AlertaParamsOf.PARTICIPACAO_INFERIOR_AO_ESTIPULADO, margem);
    }

    public static AlertaDeParticipacao criaAlertaDeParticipacaoDeProdutoSuperiorAoEstipulado(Pesquisa pesquisa, int margem) {
        return new AlertaDeParticipacao(pesquisa, AlertaParamsOf.PARTICIPACAO_SUPERIOR_AO_ESTIPULADO, margem);
    }
}
