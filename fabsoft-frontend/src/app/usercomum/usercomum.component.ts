import { Component, OnInit } from '@angular/core';
import { Usercomum } from '../model/usercomum';
import { UsercomumService } from '../service/usercomum.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-usercomum',
  imports: [HttpClientModule, CommonModule, RouterLink],
  templateUrl: './usercomum.html',
  styleUrl: './usercomum.css',
  providers: [UsercomumService]
})
export class UsercomumComponent implements OnInit{
deleteUsuario(arg0: any) {
throw new Error('Method not implemented.');
}

listaUsercomum: Usercomum[] = []
feedbackMessage: any;
listaUsuarios: any;

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
