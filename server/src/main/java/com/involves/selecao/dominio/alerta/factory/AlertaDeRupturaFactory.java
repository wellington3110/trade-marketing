package com.involves.selecao.dominio.alerta.factory;

import com.involves.selecao.dominio.alerta.AlertaDeRuptura;
import com.involves.selecao.dominio.pesquisa.Pesquisa;
import com.involves.selecao.dominio.pesquisa.Resposta;
import com.involves.selecao.dominio.alerta.enums.AlertaParamsOf;
import com.involves.selecao.dominio.alerta.enums.PerguntaPesquisa;
import com.involves.selecao.dominio.alerta.enums.RespostaPesquisa;

public class AlertaDeRupturaFactory extends AbstractAlertaFactory {

    @Override
    public boolean podeCriarAlerta(Pesquisa pesquisa, Resposta resposta) {

        return resposta.perguntaIsEqualTo(PerguntaPesquisa.SITUACAO_PRODUTO) && resposta.respostaIsEqualTo(RespostaPesquisa.AUSENTE_NA_GONDULA);
    }

    @Override
    protected AlertaDeRuptura criaAlerta(Pesquisa pesquisa, Resposta resposta) {
        return new AlertaDeRuptura(pesquisa, AlertaParamsOf.RUPTURA);
    }
}
