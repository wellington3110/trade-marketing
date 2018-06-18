import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatCardModule, MatDividerModule, MatButtonModule, MatSnackBarModule} from '@angular/material'
import { AppComponent } from './app.component';
import { DashboardAlertasComponent } from './dashboard-alertas/dashboard-alertas.component';
import { CardAlertaComponent } from './card-alerta/card-alerta.component';
import { CommonModule } from '@angular/common';
import { Select2Module } from 'ng2-select2';
import { HttpClientModule } from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    DashboardAlertasComponent,
    CardAlertaComponent,
  ],
  imports: [
    HttpClientModule,
    Select2Module,
    MatCardModule,
    MatDividerModule,
    BrowserModule,
    CommonModule,
    MatButtonModule,
    MatSnackBarModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
