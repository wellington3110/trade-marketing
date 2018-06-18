import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { IAlerta } from '../../../shared/IAlerta';
import { map } from 'rxjs/operators'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlertaService {

  private readonly alertaUrl = `${environment.API_URL}/alertas`;
  constructor(private http: HttpClient) { }

  private converteParaIAlerta(res: any[]): IAlerta[] {
    res.forEach(item => item.dataCadastro = new Date(item.dataCadastro));
    return res;
  }

  buscaTodosOsAlertas(): Observable<IAlerta[]> {
    return this.http.get(this.alertaUrl)
                    .pipe(map((this.converteParaIAlerta)));
                    
  }
  
  processarAlertas(): Observable<any> {
    return this.http.get(`${this.alertaUrl}/processar`);
  }
}
