package com.involves.selecao.dominio.alerta.factory;

import com.involves.selecao.dominio.alerta.margem.CalculadorDeMargem;
import com.involves.selecao.dominio.alerta.margem.CalculadorDeMargemPelaParticipacaoEstipulada;
import com.involves.selecao.dominio.alerta.margem.CalculadorDeMargemPeloPrecoEstipulado;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class BeanConfigurator {

    @Bean
    public List<AlertaFactory> alertaFactories() {

        CalculadorDeMargem calculadorDeMargemPeloPrecoEstipulado = new CalculadorDeMargemPeloPrecoEstipulado();
        CalculadorDeMargem calculadorDeMargemPelaParticipacaoEstipulada = new CalculadorDeMargemPelaParticipacaoEstipulada();

        return Arrays.asList(new AlertaDeRupturaFactory(),
                             new AlertaMaiorQuePrecoEstipuladoFactory(calculadorDeMargemPeloPrecoEstipulado),
                             new AlertaMenorQuePrecoEstipuladoFactory(calculadorDeMargemPeloPrecoEstipulado),
                             new AlertaParticipacaoInferiorAoEstipuladoFactory(calculadorDeMargemPelaParticipacaoEstipulada),
                             new AlertaParticipacaoSuperiorAoEstipuladoFactory(calculadorDeMargemPelaParticipacaoEstipulada));
    }
}
