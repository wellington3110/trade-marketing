package com.involves.selecao.dominio.alerta;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Document(collection = "Alertas")
public abstract class Alerta {

    @Id
    private String id;
    private String label;
    private String sobre;
    private String descricao;
    private String pontoDeVenda;

    private LocalDateTime dataCadastro;
    private Integer flTipo;

    public Alerta() {}

    public Alerta(String sobre, String descricao, String pontoDeVenda, Integer flTipo, String label) {
        this.sobre = sobre;
        this.descricao = descricao;
        this.pontoDeVenda = pontoDeVenda;
        this.flTipo = flTipo;
        this.dataCadastro = LocalDateTime.now();
        this.label = label;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alerta)) return false;
        Alerta alerta = (Alerta) o;
        return Objects.equals(sobre, alerta.sobre) &&
                Objects.equals(descricao, alerta.descricao) &&
                Objects.equals(pontoDeVenda, alerta.pontoDeVenda) &&
                Objects.equals(dataCadastro, alerta.dataCadastro) &&
                Objects.equals(flTipo, alerta.flTipo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sobre, descricao, pontoDeVenda, dataCadastro, flTipo);
    }

    public String getId() {
        return id;
    }

    public String getSobre() {
        return sobre;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPontoDeVenda() {
        return pontoDeVenda;
    }

    public Integer getFlTipo() {
        return flTipo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public String getLabel() {
        return label;
    }
}
