package com.involves.selecao.factory;

import com.involves.selecao.dominio.pesquisa.Resposta;
import com.involves.selecao.dominio.alerta.enums.PerguntaPesquisa;
import com.involves.selecao.dominio.alerta.enums.RespostaPesquisa;

public class RespostaFactory {

    public static Resposta criaRespostaComRuptura() {
        return new Resposta(PerguntaPesquisa.SITUACAO_PRODUTO, RespostaPesquisa.AUSENTE_NA_GONDULA);
    }

    public static Resposta criaRespostaDePrecoDeProdutoComMargemDe(int margem, int precoDoProduto) {
        return new Resposta(PerguntaPesquisa.PRECO_PRODUTO, calculaMargemMenosValor(margem, precoDoProduto));
    }

    public static Resposta criaRespostaQueNaoGeraAlertaPelaSituacaoDoProduto() {
        return new Resposta(PerguntaPesquisa.SITUACAO_PRODUTO, RespostaPesquisa.PRODUTO_NA_GONDOLA);
    }

    public static Resposta criaRespostaDePesquisaDePrecoDeProdutoQueNaoGeraAlerta(String precoEstipulado) {
        return new Resposta(PerguntaPesquisa.PRECO_PRODUTO, precoEstipulado);
    }

    public static Resposta criaRespostaDeParticipacaoDeProdutoComMargemDe(int margem, int participacao) {
        return new Resposta(PerguntaPesquisa.SHARE, calculaMargemMenosValor(margem, participacao));
    }

    private static String calculaMargemMenosValor(int margem, int valor) {
        return String.valueOf(-margem + valor);
    }

    public static Resposta criaRespostaDePesquisaDeParticipacaoQueNaoGeraAlerta(String participacaoEstipulada) {
        return new Resposta(PerguntaPesquisa.SHARE, participacaoEstipulada);
    }
}
