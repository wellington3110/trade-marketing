package com.involves.selecao.service;

import com.involves.selecao.dominio.alerta.Alerta;
import com.involves.selecao.dominio.pesquisa.Pesquisa;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.involves.selecao.factory.AlertaFactory.*;
import static com.involves.selecao.factory.AlertaFactory.criaAlertaComRuptura;
import static com.involves.selecao.factory.AlertaFactory.criaAlertaDePrecoMenorQueEstipulado;
import static com.involves.selecao.factory.PesquisaFactory.*;
import static com.involves.selecao.factory.RespostaFactory.*;
import static com.involves.selecao.factory.RespostaFactory.criaRespostaComRuptura;
import static com.involves.selecao.factory.RespostaFactory.criaRespostaDePrecoDeProdutoComMargemDe;
import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AlertaServiceTest {

    @Autowired
    private AlertaService alertaService;

    private final int margemMenorQueEstipulado = 2;
    private final int margemMaiorQueEstipulado = -margemMenorQueEstipulado;

    @Before
    public void setup() { }

    @Test
    public void deveCriarUmAlertaDeRuptura() {
        Pesquisa pesquisa = criaPesquisaComUmaPerguntaQueGeraAlertaDeRuptura();
        List<Alerta> alertas = alertaService.criaAlertas(pesquisa);

        assertThat(alertas.size()).isEqualTo(1);
        assertThat(alertas.get(0)).isEqualTo(criaAlertaComRuptura(pesquisa));
    }

    @Test
    public void deveCriarUmAlertaDePrecoMaiorQueEstipulado() {

        Pesquisa pesquisa = criaPesquisaComUmaPerguntaDePrecoDeProdutoComMargemDe(margemMaiorQueEstipulado);
        List<Alerta> alertas = alertaService.criaAlertas(pesquisa);

        assertThat(alertas.size()).isEqualTo(1);
        assertThat(alertas.get(0)).isEqualTo(criaAlertaDePrecoMaiorQueEstipulado(pesquisa, margemMaiorQueEstipulado));
    }

    @Test
    public void deveCriarUmAlertaDePrecoMenorQueEstipulado() {

        Pesquisa pesquisa = criaPesquisaComUmaPerguntaDePrecoDeProdutoComMargemDe(margemMenorQueEstipulado);
        List<Alerta> alertas = alertaService.criaAlertas(pesquisa);

        assertThat(alertas.size()).isEqualTo(1);
        assertThat(alertas.get(0)).isEqualTo(criaAlertaDePrecoMenorQueEstipulado(pesquisa, margemMenorQueEstipulado));
    }

    @Test
    public void deveCriarUmAlertaDeParticipacaoInferiorAoEstipulado() {
        Pesquisa pesquisa = criaPesquisaComUmaPerguntaDeParticipacaoDeProdutoComMargemDe(margemMenorQueEstipulado);
        List<Alerta> alertas = alertaService.criaAlertas(pesquisa);

        assertThat(alertas.size()).isEqualTo(1);
        assertThat(alertas.get(0)).isEqualTo(criaAlertaDeParticipacaoDeProdutoInferiorAoEstipulado(pesquisa, margemMenorQueEstipulado));
    }
    @Test
    public void deveCriarUmAlertaDeParticipacaoSuperiorAoEstipulado() {
        Pesquisa pesquisa = criaPesquisaComUmaPerguntaDeParticipacaoDeProdutoComMargemDe(margemMaiorQueEstipulado);
        List<Alerta> alertas = alertaService.criaAlertas(pesquisa);

        assertThat(alertas.size()).isEqualTo(1);
        assertThat(alertas.get(0)).isEqualTo(criaAlertaDeParticipacaoDeProdutoSuperiorAoEstipulado(pesquisa, margemMaiorQueEstipulado));
    }




    @Test
    public void deveCriarTodosOsTiposDeAlertasDeProduto() {

        Pesquisa pesquisa = criaPesquisaDeProdutoSemRespostas()
                                        .comResposta(criaRespostaComRuptura())
                                        .comResposta(criaRespostaDePrecoDeProdutoComMargemDe(margemMenorQueEstipulado, PRECO_ESTIPULADO_DEFAULT))
                                        .comResposta(criaRespostaDePrecoDeProdutoComMargemDe(margemMaiorQueEstipulado, PRECO_ESTIPULADO_DEFAULT))
                                        .build();

        List<Alerta> alertas = alertaService.criaAlertas(pesquisa);

        assertThat(alertas.size()).isEqualTo(3);
        assertThat(alertas).contains(criaAlertaComRuptura(pesquisa),
                                     criaAlertaDePrecoMenorQueEstipulado(pesquisa, margemMenorQueEstipulado),
                                     criaAlertaDePrecoMaiorQueEstipulado(pesquisa, margemMaiorQueEstipulado));

    }

    @Test
    public void deveCriarTodosOsTiposDeAlertasDeParticipacao() {
        Pesquisa pesquisa = criaPesquisaDeParticipacaoSemRespostas()
                                        .comResposta(criaRespostaDeParticipacaoDeProdutoComMargemDe(margemMenorQueEstipulado, PARTICIPACAO_ESTIPULADA_DEFAULT))
                                        .comResposta(criaRespostaDeParticipacaoDeProdutoComMargemDe(margemMaiorQueEstipulado, PARTICIPACAO_ESTIPULADA_DEFAULT))
                                        .build();

        List<Alerta> alertas = alertaService.criaAlertas(pesquisa);

        assertThat(alertas.size()).isEqualTo(2);
        assertThat(alertas).contains(criaAlertaDeParticipacaoDeProdutoInferiorAoEstipulado(pesquisa, margemMenorQueEstipulado),
                                     criaAlertaDeParticipacaoDeProdutoSuperiorAoEstipulado(pesquisa, margemMaiorQueEstipulado));
    }

    @Test
    public void naoDeveCriarAlertaParaRespostaDeProdutoComSituacaoNaGondula() {
        Pesquisa pesquisa = criaPesquisaDeProdutoSemRespostas()
                                        .comResposta(criaRespostaQueNaoGeraAlertaPelaSituacaoDoProduto())
                                        .build();

        List<Alerta> alertas = alertaService.criaAlertas(pesquisa);

        assertThat(alertas.size()).isZero();
    }

    @Test
    public void naoDeveCriarAlertaDeProdutoSeCasoOPrecoEstiverConformeEstipulado() {
        Pesquisa pesquisa = criaPesquisaDeProdutoSemRespostas()
                                        .comResposta(criaRespostaDePesquisaDePrecoDeProdutoQueNaoGeraAlerta(PRECO_ESTIPULADO_DEFAULT.toString()))
                                        .build();

        List<Alerta> alertas = alertaService.criaAlertas(pesquisa);

        assertThat(alertas.size()).isZero();
    }

    @Test
    public void naoDeveCriarNenhumAlertaReferenteAPesquisaDeProduto() {
        Pesquisa pesquisa = criaPesquisaDeProdutoSemRespostas()
                                        .comResposta(criaRespostaQueNaoGeraAlertaPelaSituacaoDoProduto())
                                        .comResposta(criaRespostaDePesquisaDePrecoDeProdutoQueNaoGeraAlerta(PRECO_ESTIPULADO_DEFAULT.toString()))
                                        .build();

        List<Alerta> alertas = alertaService.criaAlertas(pesquisa);

        assertThat(alertas.size()).isZero();
    }

    @Test
    public void naoDeveCriarAlertaDeParticipacaoSeCasoAParticipacaoEstiverConformeEstipulado() {
        Pesquisa pesquisa = criaPesquisaDeParticipacaoSemRespostas()
                                                    .comResposta(criaRespostaDePesquisaDeParticipacaoQueNaoGeraAlerta(PARTICIPACAO_ESTIPULADA_DEFAULT.toString()))
                                                    .build();

        List<Alerta> alertas = alertaService.criaAlertas(pesquisa);

        assertThat(alertas.size()).isZero();
    }

    @Test
    public void deveGerarDoisAlertasDentreQuatroPerguntas() {
        Pesquisa pesquisa = criaPesquisaDeProdutoSemRespostas()
                                        .comResposta(criaRespostaQueNaoGeraAlertaPelaSituacaoDoProduto())
                                        .comResposta(criaRespostaDePesquisaDePrecoDeProdutoQueNaoGeraAlerta(PRECO_ESTIPULADO_DEFAULT.toString()))
                                        .comResposta(criaRespostaComRuptura())
                                        .comResposta(criaRespostaDePrecoDeProdutoComMargemDe(margemMaiorQueEstipulado, PRECO_ESTIPULADO_DEFAULT))
                                        .build();

        List<Alerta> alertas = alertaService.criaAlertas(pesquisa);
        assertThat(alertas.size()).isEqualTo(2);
        assertThat(alertas).contains(criaAlertaComRuptura(pesquisa), criaAlertaDePrecoMaiorQueEstipulado(pesquisa, margemMaiorQueEstipulado));
    }
}
