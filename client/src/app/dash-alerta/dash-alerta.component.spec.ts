import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashAlertaComponent } from './dash-alerta.component';

describe('DashAlertaComponent', () => {
  let component: DashAlertaComponent;
  let fixture: ComponentFixture<DashAlertaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashAlertaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashAlertaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
