package com.involves.selecao.builder;

import com.involves.selecao.dominio.pesquisa.Resposta;
import com.involves.selecao.dominio.pesquisa.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class PesquisaBuilder {

    private String rotulo;
    private String notificante;
    private String pontoDeVenda;
    private String produto;
    private String precoEstipulado;
    private List<Resposta> respostas = new ArrayList<>();
    private String respondidaEm;
    private String categoria;
    private String participacaoEstipulada;

    public PesquisaBuilder comRotulo(String rotulo) {
        this.rotulo = rotulo;
        return this;
    }

    public PesquisaBuilder comNotificante(String notificante) {
        this.notificante = notificante;
        return this;
    }

    public PesquisaBuilder comPontoDeVenda(String pontoDeVenda) {
        this.pontoDeVenda = pontoDeVenda;
        return this;
    }

    public PesquisaBuilder comProduto(String produto) {
        this.produto = produto;
        return this;
    }

    public PesquisaBuilder comPrecoEstipulado(String precoEstipulado) {
        this.precoEstipulado = precoEstipulado;
        return this;
    }

    public PesquisaBuilder comResposta(Resposta resposta) {
        respostas.add(resposta);
        return this;
    }

    public PesquisaBuilder comRespostaNaData(String dataString) {
        this.respondidaEm = dataString;
        return this;
    }

    public PesquisaBuilder comCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public PesquisaBuilder comParticipacaoEstipulada(String participacaoEstipulada) {
        this.participacaoEstipulada = participacaoEstipulada;
        return this;
    }

    public Pesquisa build() {
        return new Pesquisa(rotulo, notificante, pontoDeVenda, produto, precoEstipulado, respostas, participacaoEstipulada, categoria, respondidaEm);
    }


}
