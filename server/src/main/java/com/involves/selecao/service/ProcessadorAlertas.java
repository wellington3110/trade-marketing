package com.involves.selecao.service;
import com.involves.selecao.dominio.pesquisa.Pesquisa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.involves.selecao.gateway.AlertaGateway;

@Service
public class ProcessadorAlertas {

	@Autowired
	private AlertaGateway gateway;

	@Autowired
	private AlertaService alertaService;

	@Autowired
	private IntegracaoPesquisasService integracaoPesquisasService;
	
	public void processa() {

		Pesquisa[] pesquisas = integracaoPesquisasService.getPesquisas();

		for (Pesquisa pesquisa : pesquisas) {
			alertaService.criaAlertas(pesquisa)
					     .forEach(gateway::save);
		}

		System.out.println("ALERTAS PROCESSADOS");
	}

}

