package com.involves.selecao.dominio.alerta;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

@Document(collection = "Alertas")
public abstract class Alerta {

    @Id
    private String id;
    private String sobre;
    private String descricao;

    @Field("ponto_de_venda")
    private String pontoDeVenda;

    @Field("fl_tipo")
    private Integer flTipo;

    public Alerta() {}

    public Alerta(String sobre, String descricao, String pontoDeVenda, Integer flTipo) {
        this.sobre = sobre;
        this.descricao = descricao;
        this.pontoDeVenda = pontoDeVenda;
        this.flTipo = flTipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alerta alerta = (Alerta) o;
        return Objects.equals(id, alerta.id) &&
                Objects.equals(sobre, alerta.sobre) &&
                Objects.equals(descricao, alerta.descricao) &&
                Objects.equals(pontoDeVenda, alerta.pontoDeVenda) &&
                Objects.equals(flTipo, alerta.flTipo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, sobre, descricao, pontoDeVenda, flTipo);
    }
}
