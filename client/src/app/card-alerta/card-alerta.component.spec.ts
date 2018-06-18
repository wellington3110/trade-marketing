import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CardAlertaComponent } from './card-alerta.component';
import { IAlerta } from '../../shared/IAlerta';

describe('CardAlertaComponent', () => {
  let component: CardAlertaComponent;
  let fixture: ComponentFixture<CardAlertaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CardAlertaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CardAlertaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

});
