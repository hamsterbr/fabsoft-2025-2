// fabsoft-frontend/src/app/service/useradm.service.ts

import { Injectable } from '@angular/core';
import { Useradm } from '../model/useradm';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UseradmService {
  getUseradm() {
    throw new Error('Method not implemented.');
  }
  // Baseado no UserAdmController.java @RequestMapping("/api/v1/usersadm")
  apiURL = "http://localhost:8080/api/v1/usersadm"

  constructor(private http:HttpClient) {}

  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Ocorreu um erro desconhecido!';
    if (error.error instanceof ErrorEvent) {
      errorMessage = `Erro de Rede: ${error.error.message}`;
    } else {
      const backendError = error.headers.get('Erro');
      if (backendError) {
          errorMessage = `Erro de Validação: ${backendError}`;
      } else {
          errorMessage = `Erro do Servidor: Código ${error.status}`;
      }
    }
    console.error('Erro detalhado:', errorMessage, error);
    return throwError(() => new Error(errorMessage));
  }

  getAll(): Observable<Useradm[]>{
    return this.http.get<Useradm[]>(this.apiURL).pipe(
      catchError(this.handleError)
    )
  }

  save(useradm:Useradm): Observable<any>{
    return this.http.post(this.apiURL, useradm).pipe(
      catchError(this.handleError)
    )
  }
  
  delete(matricula: number): Observable<any>{
    return this.http.delete(`${this.apiURL}/${matricula}`).pipe(
      catchError(this.handleError)
    )
  }
}