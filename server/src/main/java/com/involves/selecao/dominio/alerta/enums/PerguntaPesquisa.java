package com.involves.selecao.dominio.alerta.enums;

public enum PerguntaPesquisa {

    SITUACAO_PRODUTO("Qual a situação do produto?"),
    PRECO_PRODUTO("Qual o preço do produto?"),
    SHARE("%Share");

    private String pergunta;

    PerguntaPesquisa(String pergunta) {

        this.pergunta = pergunta;
    }

    public String getPergunta() {
        return pergunta;
    }
}
