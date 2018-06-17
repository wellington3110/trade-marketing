package com.involves.selecao.dominio.pesquisa;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Pesquisa {

	private int id;
	private String rotulo;
	private String notificante;

	@JsonProperty("ponto_de_venda")
	private String pontoDeVenda;
	private String produto;
	@JsonProperty("preco_estipulado")
	private String precoEstipulado;
	private List<Resposta> respostas;

	@JsonProperty("participacao_estipulada")
	private String participacaoEstipulada;

	private String categoria;

	@JsonProperty("respondidade_em")
	private String respondidaEm;

	public Pesquisa() {}

	public Pesquisa(String rotulo, String notificante, String pontoDeVenda, String produto, String precoEstipulado, List<Resposta> respostas, String participacaoEstipulada, String categoria, String respondidaEm) {
		this.rotulo = rotulo;
		this.notificante = notificante;
		this.pontoDeVenda = pontoDeVenda;
		this.produto = produto;
		this.precoEstipulado = precoEstipulado;
		this.respostas = respostas;
		this.participacaoEstipulada = participacaoEstipulada;
		this.categoria = categoria;
		this.respondidaEm = respondidaEm;
	}

	public boolean temParticipacaoSuperiorAoEstipulado(Resposta resposta) {
		return Integer.parseInt(resposta.getResposta()) > Integer.parseInt(this.participacaoEstipulada);
	}

	public boolean temParticipacaoInferiorAoEstipulado(Resposta resposta) {
		return Integer.parseInt(resposta.getResposta()) < Integer.parseInt(this.participacaoEstipulada);
	}

	public boolean temPrecoMaiorQueEstipulado(Resposta resposta) {
		return Integer.parseInt(resposta.getResposta()) > Integer.parseInt(this.precoEstipulado);
	}

	public boolean temPrecoMenorQueEstipulado(Resposta resposta) {
		return Integer.parseInt(resposta.getResposta()) < Integer.parseInt(this.precoEstipulado);
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public String getNotificante() {
		return notificante;
	}

	public void setNotificante(String notificante) {
		this.notificante = notificante;
	}

	public String getPontoDeVenda() {
		return pontoDeVenda;
	}

	public void setPontoDeVenda(String pontoDeVenda) {
		this.pontoDeVenda = pontoDeVenda;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getPrecoEstipulado() {
		return precoEstipulado;
	}

	public void setPrecoEstipulado(String precoEstipulado) {
		this.precoEstipulado = precoEstipulado;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public Integer getPrecoEstipuladoInt() {
		return Integer.valueOf(this.precoEstipulado);
	}

	public String getParticipacaoEstipulada() {
		return participacaoEstipulada;
	}

	public Integer getParticipacaoEstipuladaInt() {
		return Integer.valueOf(this.participacaoEstipulada);
	}

	public void setParticipacaoEstipulada(String participacaoEstipulada) {
		this.participacaoEstipulada = participacaoEstipulada;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getRespondidaEm() {
		return respondidaEm;
	}

	public void setRespondidaEm(String respondidaEm) {
		this.respondidaEm = respondidaEm;
	}
}
