import { Component, OnInit, Input } from '@angular/core';
import { IAlerta } from '../../shared/IAlerta';

@Component({
  selector: 'app-card-alerta',
  templateUrl: './card-alerta.component.html',
  styleUrls: ['./card-alerta.component.css']
})
export class CardAlertaComponent implements OnInit {

  @Input() alerta: IAlerta;
  constructor() { }

  getCor() {
    return this.alerta.corTitulo;
  }

  ngOnInit() {
  }

}
