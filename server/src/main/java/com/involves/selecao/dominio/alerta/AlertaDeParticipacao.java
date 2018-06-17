package com.involves.selecao.dominio.alerta;

import com.involves.selecao.dominio.alerta.enums.AlertaParamsOf;
import com.involves.selecao.dominio.pesquisa.Pesquisa;
import org.springframework.data.mongodb.core.mapping.Field;

public class AlertaDeParticipacao extends Alerta {

    @Field("respondida_em")
    private String respondidaEm;
    private int margem;

    public AlertaDeParticipacao(){}

    public AlertaDeParticipacao(Pesquisa pesquisa, AlertaParamsOf params, int margem) {
        super(pesquisa.getCategoria(), params.getDescricao(), pesquisa.getPontoDeVenda(), params.getFlTipo());
        this.respondidaEm = pesquisa.getRespondidaEm();
        this.margem = margem;
    }
}
