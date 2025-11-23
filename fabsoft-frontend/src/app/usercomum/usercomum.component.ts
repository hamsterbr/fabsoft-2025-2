import { Component } from '@angular/core';
import { Usercomum } from '../model/usercomum';
import { UsercomumService } from '../service/usercomum.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-usercomum',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './usercomum.html',
  styleUrl: './usercomum.css',
  providers: [UsercomumService, Router]
})
export class UsercomumComponent{

  listaUsercomum: Usercomum[] = []

  constructor(
    private UsercomumService: UsercomumService, 
    private router: Router
  ){}

  ngOnInit(){
    console.log('Carregando usuarios comuns...')
    this.UsercomumService.getUsercomum().subscribe(usercomuns => {
      this.listaUsercomum = usercomuns
    })
  }

  novo(){
    this.router.navigate(['usercomum/novo'])
  }

}
