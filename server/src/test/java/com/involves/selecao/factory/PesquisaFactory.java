package com.involves.selecao.factory;


import com.involves.selecao.dominio.pesquisa.Pesquisa;
import com.involves.selecao.builder.PesquisaBuilder;

public class PesquisaFactory {

    public static final Integer PRECO_ESTIPULADO_DEFAULT = 3;
    public static final Integer PARTICIPACAO_ESTIPULADA_DEFAULT = 50;

    public static PesquisaBuilder criaPesquisaDeProdutoSemRespostas() {
        return new PesquisaBuilder()
                .comRotulo("Campanha de pascoa")
                .comNotificante("Joao")
                .comPontoDeVenda("Angeloni")
                .comProduto("Arroz ligeirinho 1kg")
                .comPrecoEstipulado(PRECO_ESTIPULADO_DEFAULT.toString());
    }

    public static PesquisaBuilder criaPesquisaDeParticipacaoSemRespostas() {
        return new PesquisaBuilder()
                .comRotulo("Acompanhamento de evoluçao dos refrigerantes")
                .comRespostaNaData("2012-04-23T18:25:43.511Z")
                .comNotificante("Joao")
                .comPontoDeVenda("Angeloni Capoeiras")
                .comCategoria("Refrigerantes")
                .comParticipacaoEstipulada(PARTICIPACAO_ESTIPULADA_DEFAULT.toString());
    }

    public static Pesquisa criaPesquisaComUmaPerguntaQueGeraAlertaDeRuptura() {
        return criaPesquisaDeProdutoSemRespostas()
                .comResposta(RespostaFactory.criaRespostaComRuptura())
                .build();
    }

    public static Pesquisa criaPesquisaComUmaPerguntaDePrecoDeProdutoComMargemDe(int margem) {
        return criaPesquisaDeProdutoSemRespostas()
                .comResposta(RespostaFactory.criaRespostaDePrecoDeProdutoComMargemDe(margem, PRECO_ESTIPULADO_DEFAULT))
                .build();
    }

    public static Pesquisa criaPesquisaComUmaPerguntaDeParticipacaoDeProdutoComMargemDe(int margem) {
        return criaPesquisaDeParticipacaoSemRespostas()
                .comResposta(RespostaFactory.criaRespostaDeParticipacaoDeProdutoComMargemDe(margem, PARTICIPACAO_ESTIPULADA_DEFAULT))
                .build();
    }


}
