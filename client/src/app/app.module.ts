import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { CardAlertaComponent } from './card-alerta/card-alerta.component';
import { DashAlertaComponent } from './dash-alerta/dash-alerta.component';


@NgModule({
  declarations: [
    AppComponent,
    CardAlertaComponent,
    DashAlertaComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
