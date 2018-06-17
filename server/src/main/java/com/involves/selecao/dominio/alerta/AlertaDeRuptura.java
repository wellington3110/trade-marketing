package com.involves.selecao.dominio.alerta;

import com.involves.selecao.dominio.alerta.enums.AlertaParamsOf;
import com.involves.selecao.dominio.pesquisa.Pesquisa;

public class AlertaDeRuptura extends Alerta {

    public AlertaDeRuptura(Pesquisa pesquisa, AlertaParamsOf params) {
        this(pesquisa.getPontoDeVenda(), params.getDescricao(), pesquisa.getProduto(), params.getFlTipo());
    }

    public AlertaDeRuptura(String pontoDeVenda, String descricao, String produto, Integer flTipo) {
        super(produto, descricao, pontoDeVenda, flTipo);
    }

    public AlertaDeRuptura() {}
}
