// fabsoft-frontend/src/app/form-useradm/form-useradm.ts

import { Component } from '@angular/core';
import { Useradm } from '../model/useradm';
import { UseradmService } from '../service/useradm.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-useradm',
  standalone: true,
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-useradm.html',
  styleUrl: './form-useradm.css',
  providers:[]
})
export class FormUseradm {
  useradm: Useradm = new Useradm();
  feedbackMessage: { type: 'success' | 'danger', message: string } | null = null; 

  constructor(
    private useradmService:UseradmService,
    public router:Router
  ){}

  salvar(form: NgForm){
    this.feedbackMessage = null; 

    if (form.invalid) {
      this.feedbackMessage = { type: 'danger', message: 'Por favor, preencha todos os campos obrigatórios.' };
      return;
    }
    
    this.useradmService.save(this.useradm)
      .subscribe({
        next: () => {
          this.router.navigate(['useradm'], { queryParams: { success: true } });
        },
        error: (err) => {
          this.feedbackMessage = { type: 'danger', message: `Falha ao salvar: ${err.message}` };
        }
      });
  }
}