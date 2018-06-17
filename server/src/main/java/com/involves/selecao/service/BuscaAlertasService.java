package com.involves.selecao.service;

import java.util.List;

import com.involves.selecao.dominio.alerta.Alerta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.involves.selecao.gateway.AlertaGateway;

@Service
public class BuscaAlertasService {
	
	@Autowired
	private AlertaGateway gateway;
	
	public List<Alerta> buscarTodos() {
		return gateway.findAll();
	}

}
