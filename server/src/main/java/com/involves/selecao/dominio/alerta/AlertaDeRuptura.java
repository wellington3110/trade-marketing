package com.involves.selecao.dominio.alerta;

import com.involves.selecao.dominio.alerta.enums.AlertaParamsOf;
import com.involves.selecao.dominio.pesquisa.Pesquisa;

public class AlertaDeRuptura extends Alerta {

    public AlertaDeRuptura(Pesquisa pesquisa, AlertaParamsOf params) {
        super(pesquisa.getProduto(), params.getDescricao(), pesquisa.getPontoDeVenda(), params.getFlTipo(), params.getLabel());
    }

    public AlertaDeRuptura() {}
}
