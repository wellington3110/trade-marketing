import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dash-alerta',
  templateUrl: './dash-alerta.component.html',
  styleUrls: ['./dash-alerta.component.css']
})
export class DashAlertaComponent implements OnInit {


  alertas: any[];

  constructor() {
    this.alertas = [ {
      ponto_de_venda: 'Angeloni',
      respondida_em: new Date(),
      descricao: 'alerta de ruptura',
      titulo: 'Alerta de ruptura'
    },
    {
      ponto_de_venda: 'Angel one',
      respondida_em: new Date(),
      descricao: 'descrição um pouco maior que a anterior',
      titulo: 'Alerta de venda'
    },
    {
      ponto_de_venda: 'Angel one',
      respondida_em: new Date(),
      descricao: 'um pouco maior ainda de boa?',
      titulo: 'Alerta de venda'
    }];
  }

  ngOnInit() {
  }

}
