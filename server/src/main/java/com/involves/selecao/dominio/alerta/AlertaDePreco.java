package com.involves.selecao.dominio.alerta;

import com.involves.selecao.dominio.alerta.enums.AlertaParamsOf;
import com.involves.selecao.dominio.pesquisa.Pesquisa;

import java.util.Objects;

public class AlertaDePreco extends Alerta {

	private Integer margem;

	public AlertaDePreco(Pesquisa pesquisa, AlertaParamsOf params, int margem) {
		super(pesquisa.getProduto(), params.getDescricao(), pesquisa.getPontoDeVenda(), params.getFlTipo(), params.getLabel());
	}

    public AlertaDePreco() { }

	public Integer getMargem() {
		return margem;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		AlertaDePreco that = (AlertaDePreco) o;
		return Objects.equals(margem, that.margem);
	}

	@Override
	public int hashCode() {

		return Objects.hash(super.hashCode(), margem);
	}


}
