// fabsoft-frontend/src/app/useradm/useradm.component.ts

import { Component, OnInit } from '@angular/core';
import { Useradm } from '../model/useradm';
import { UseradmService } from '../service/useradm.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router, ActivatedRoute, RouterLink } from '@angular/router';

@Component({
  selector: 'app-useradm',
  standalone: true, 
  imports: [HttpClientModule, CommonModule, RouterLink], 
  templateUrl: './useradm.html',
  styleUrl: './useradm.css',
  providers: [UseradmService]
})
export class UseradmComponent implements OnInit{

  listaUseradm: Useradm[] = []
  feedbackMessage: { type: 'success' | 'danger', message: string } | null = null; 

  constructor(
    private useradmService: UseradmService, 
    private router: Router, 
    private activatedRoute: ActivatedRoute
  ){} 

  ngOnInit(){
    this.carregarLista();
    
    this.activatedRoute.queryParams.subscribe(params => {
      if (params['success'] === 'true') {
        this.feedbackMessage = { type: 'success', message: 'Usuário Administrativo salvo com sucesso!' };
        this.router.navigate([], {
          queryParams: { success: null },
          queryParamsHandling: 'merge'
        });
        setTimeout(() => this.feedbackMessage = null, 5000);
      }
    });
  }

  carregarLista(){
    this.useradmService.getAll().subscribe({
      next: (useradms) => {
        this.listaUseradm = useradms;
      },
      error: (err) => {
        this.feedbackMessage = { type: 'danger', message: `Falha ao carregar a lista: ${err.message}` };
      }
    });
  }

  deleteUseradm(matricula: number){
    if(confirm('Tem certeza que deseja remover o usuário administrativo com a matrícula: ' + matricula + '?')){
      this.useradmService.delete(matricula).subscribe({
        next: () => {
          this.feedbackMessage = { type: 'success', message: `Usuário Administrativo ${matricula} removido com sucesso.` };
          this.carregarLista();
          setTimeout(() => this.feedbackMessage = null, 5000);
        },
        error: (err) => {
          this.feedbackMessage = { type: 'danger', message: `Falha ao remover: ${err.message}` };
        }
      });
    }
  }

  novo(){
    this.router.navigate(['useradm/novo'])
  }
}