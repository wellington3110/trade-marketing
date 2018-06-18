package com.involves.selecao.dominio.alerta;

import com.involves.selecao.dominio.alerta.enums.AlertaParamsOf;
import com.involves.selecao.dominio.pesquisa.Pesquisa;
import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

public class AlertaDeParticipacao extends Alerta {

    private int margem;

    public AlertaDeParticipacao(){}

    public AlertaDeParticipacao(Pesquisa pesquisa, AlertaParamsOf params, int margem) {
        super(pesquisa.getCategoria(), params.getDescricao(), pesquisa.getPontoDeVenda(), params.getFlTipo(), params.getLabel());
        this.margem = margem;
    }

    public int getMargem() {
        return margem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlertaDeParticipacao)) return false;
        if (!super.equals(o)) return false;
        AlertaDeParticipacao that = (AlertaDeParticipacao) o;
        return margem == that.margem;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), margem);
    }
}
