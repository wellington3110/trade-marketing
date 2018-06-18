import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardAlertasComponent } from './dashboard-alertas.component';

describe('DashboardAlertasComponent', () => {
  let component: DashboardAlertasComponent;
  let fixture: ComponentFixture<DashboardAlertasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashboardAlertasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardAlertasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
});
