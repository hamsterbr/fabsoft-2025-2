import { Component } from '@angular/core';
import { Usercomum } from '../model/usercomum';
import { UsercomumService } from '../service/usercomum.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { NgForm, FormsModule } from '@angular/forms';
import { Router } from '@angular/router';



@Component({
  selector: 'app-form-usercomum',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-usercomum.html',
  styleUrl: './form-usercomum.css',
  providers:[UsercomumService]
})
export class FormUsercomum {
  usercomum: Usercomum = new Usercomum();

  feedbackMessage: { type: string, message: string } | null = null; 

  constructor(
    private usercomumService:UsercomumService,
    private router:Router
  ){}

  salvar(form: NgForm){
    if (form.valid) { 
        this.usercomumService.saveUsercomum(this.usercomum)
          .subscribe(resultado => {
            this.router.navigate(['/usercomum'], { queryParams: { success: true } }); 
            
            form.reset(); 
          })
    } else {
        console.error("Formulário inválido. Preencha todos os campos obrigatórios.");
    }
  }
}
