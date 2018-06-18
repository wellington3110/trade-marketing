import { Component, OnInit } from '@angular/core';
import { IAlerta } from '../../shared/IAlerta';
import { Select2OptionData } from 'ng2-select2';
import { AlertaService } from '../services/alerta-service/alerta-service.service';
import { AlertaTituloCores } from '../../shared/AlertaTituloCores';
import { ArrayUtils } from '../../shared/ArrayUtils';
import { Select2Utils } from '../../shared/Select2Utils';

type Filtro = {atributo: string, data: any[]}

@Component({
  selector: 'app-dashboard-alertas',
  templateUrl: './dashboard-alertas.component.html',
  styleUrls: ['./dashboard-alertas.component.css']
})
export class DashboardAlertasComponent implements OnInit {

  alertasCard: IAlerta[]
  todosOsAlertas: IAlerta[];

  mostrarMensagemDeSucesso = false;

  pontosDeVenda: Select2OptionData[];
  tiposDeAlerta: Select2OptionData[];

  filtrosPontoDeVenda = { atributo: "pontoDeVenda", data: [] };
  filtrosTiposDeAlerta = { atributo: "label", data: [] };

  optionsPontosDeVenda: Select2Options = { multiple: true, placeholder: "Pontos de venda" };
  optionsTipoDeAlerta: Select2Options = { multiple: true, placeholder: "Tipos de alerta" };


  constructor(private alertaService: AlertaService) { }

  ngOnInit() {
    this.carregarAlertas();
  }

  private carregarAlertas() {
    this.alertaService.buscaTodosOsAlertas().subscribe((alertas: IAlerta[]) => {
      this.todosOsAlertas = alertas;
      this.alertasCard = this.defineCoresDosTitulos(alertas);
      this.pontosDeVenda = this.mapPontosDeVenda(alertas);
      this.tiposDeAlerta = this.mapTiposDeAlerta(alertas);
    });
  }

  private mapTiposDeAlerta(alertas: IAlerta[]): Select2OptionData[] {
    const tiposDeAlerta = ArrayUtils.unique(alertas.map(alerta => alerta.label));
    return Select2Utils.transformaStringsEmSelectOptions(tiposDeAlerta);
  }

  private mapPontosDeVenda(alertas: IAlerta[]): Select2OptionData[] {
    const pontosDeVenda = ArrayUtils.unique(alertas.map(alerta => alerta.pontoDeVenda));
    return Select2Utils.transformaStringsEmSelectOptions(pontosDeVenda);
  }

  private defineCoresDosTitulos(alertas: IAlerta[]): IAlerta[] {
    return alertas.map(alerta => {
      alerta.corTitulo = AlertaTituloCores.getCor(alerta.flTipo);
      return alerta;
    });
  }

  private getTodosOsFiltrosComItens(): any[] {
    return [this.filtrosPontoDeVenda, this.filtrosTiposDeAlerta].filter(filtro => !ArrayUtils.isEmpty(filtro.data));
  }

  private filtrarPeloAtributo(filtro: Filtro, alertas: IAlerta[]): IAlerta[] {
    return alertas.filter(alerta => filtro.data.includes(alerta[filtro.atributo]));
  }


  private filtrar() {
    const todosOsFiltros = this.getTodosOsFiltrosComItens();
    this.alertasCard = todosOsFiltros.reduce((previous, current) => this.filtrarPeloAtributo(current, previous), this.todosOsAlertas);

  }

  private getTextoDoFiltro(event) {
    return event.data.map(item => item.text);
  }
  
  private fecharMensagemDeSucesso() {
    this.mostrarMensagemDeSucesso = false;
  }

  private abrirMensagemDeSucesso() {
    this.mostrarMensagemDeSucesso = true;
  }

  filtrarPelosTiposDeAlerta(event: any) {
    this.filtrosTiposDeAlerta.data = this.getTextoDoFiltro(event);
    this.filtrar();
  }

  filtrarPeloPontoDeVenda(event: any) {
    this.filtrosPontoDeVenda.data = this.getTextoDoFiltro(event);
    this.filtrar();
  }

  processarAlertas() {
    this.alertaService.processarAlertas().subscribe(() => {
      this.carregarAlertas();
      this.abrirMensagemDeSucesso();
    })
  }

}
