package com.involves.selecao.gateway;

import com.involves.selecao.dominio.alerta.Alerta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlertaGateway extends MongoRepository<Alerta, String> {
}
