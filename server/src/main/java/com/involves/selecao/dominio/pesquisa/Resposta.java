package com.involves.selecao.dominio.pesquisa;

import com.involves.selecao.dominio.alerta.enums.PerguntaPesquisa;
import com.involves.selecao.dominio.alerta.enums.RespostaPesquisa;

public class Resposta {
	
	private String pergunta;
	private String resposta;

	public Resposta(){}

    public Resposta(PerguntaPesquisa pergunta, RespostaPesquisa resposta) {
    	this.pergunta = pergunta.getPergunta();
    	this.resposta = resposta.getResposta();
    }

    public Resposta(PerguntaPesquisa pergunta, String resposta) {
		this.pergunta = pergunta.getPergunta();
		this.resposta = resposta;
	}

    public String getPergunta() {
		return pergunta;
	}
	public String getResposta() {
		return resposta;
	}

	public boolean perguntaIsEqualTo(PerguntaPesquisa pergunta) {
		return pergunta.getPergunta().equals(this.pergunta);
	}

    public boolean respostaIsEqualTo(RespostaPesquisa resposta) {
		return resposta.getResposta().equals(this.resposta);
    }
}
