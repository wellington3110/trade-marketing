package com.involves.selecao.dominio.alerta.margem;

import com.involves.selecao.dominio.pesquisa.Pesquisa;
import com.involves.selecao.dominio.pesquisa.Resposta;

public interface CalculadorDeMargem {


    Integer calcula(Pesquisa pesquisa, Resposta resposta);
}
