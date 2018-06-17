import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-card-alerta',
  templateUrl: './card-alerta.component.html',
  styleUrls: ['./card-alerta.component.css']
})
export class CardAlertaComponent implements OnInit {

  constructor() { }

  @Input() alerta: any;

  ngOnInit() {
  }

}
