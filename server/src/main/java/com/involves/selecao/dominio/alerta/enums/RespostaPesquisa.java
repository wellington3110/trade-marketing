package com.involves.selecao.dominio.alerta.enums;

public enum RespostaPesquisa {

    PRODUTO_NA_GONDOLA("Produto esta na gondola"),
    AUSENTE_NA_GONDULA("Produto ausente na gondola");

    private String resposta;

    RespostaPesquisa(String resposta) {
        this.resposta = resposta;
    }

    public String getResposta() {
        return resposta;
    }
}
