package com.involves.selecao.dominio.alerta.enums;

import com.involves.selecao.dominio.alerta.Alerta;
import com.involves.selecao.dominio.alerta.AlertaDeParticipacao;
import com.involves.selecao.dominio.alerta.AlertaDePreco;
import com.involves.selecao.dominio.alerta.AlertaDeRuptura;

public enum AlertaParamsOf {

    RUPTURA ("Ruptura detectada!", 1),
    PRECO_MAIOR_QUE_ESTIPULADO("Preço acima do estipulado!", 2),
    PRECO_MENOR_QUE_ESTIPULADO("Preço abaixo do estipulado!", 3),
    PARTICIPACAO_SUPERIOR_AO_ESTIPULADO("Participacão superior ao estipulado!", 4),
    PARTICIPACAO_INFERIOR_AO_ESTIPULADO("Participacão inferior ao estipulado!", 5);

    private String descricao;
    private int flTipo;

    AlertaParamsOf(String descricao, int flTipo) {
        this.descricao = descricao;
        this.flTipo = flTipo;
    }
    public String getDescricao() {
        return descricao;
    }

    public int getFlTipo() {
        return flTipo;
    }
}
