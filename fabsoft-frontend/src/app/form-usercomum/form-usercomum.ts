import { Component } from '@angular/core';
import { Usercomum } from '../model/usercomum';
import { UsercomumService } from '../service/usercomum.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-form-usercomum',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-usercomum.html',
  styleUrl: './form-usercomum.css',
  providers:[UsercomumService, Router]
})
export class FormUsercomum {
  usercomum: Usercomum = new Usercomum();

  constructor(
    private usercomumService:UsercomumService,
    private router:Router
  ){}

  salvar(){
    this.usercomumService.saveUsercomum(this.usercomum)
      .subscribe(resultado => {
        this.router.navigate(['usercomum'])
      })
  }
}
