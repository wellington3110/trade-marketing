package com.involves.selecao.dominio.alerta.enums;

public enum AlertaParamsOf {

    RUPTURA ("Ruptura detectada!", 1, "Alerta de ruptura"),
    PRECO_MAIOR_QUE_ESTIPULADO("Preço acima do estipulado!", 2, "Alerta de preço inferior"),
    PRECO_MENOR_QUE_ESTIPULADO("Preço abaixo do estipulado!", 3, "Alerta de preço superior"),
    PARTICIPACAO_SUPERIOR_AO_ESTIPULADO("Participacão superior ao estipulado!", 4, "Alerta de participação superior"),
    PARTICIPACAO_INFERIOR_AO_ESTIPULADO("Participacão inferior ao estipulado!", 5, "Alerta de participação inferior");

    private String descricao;
    private int flTipo;
    private String label;

    AlertaParamsOf(String descricao, int flTipo, String label) {
        this.descricao = descricao;
        this.flTipo = flTipo;
        this.label = label;
    }
    public String getDescricao() {
        return descricao;
    }

    public int getFlTipo() {
        return flTipo;
    }

    public String getLabel() {
        return label;
    }
}
