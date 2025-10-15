import { Component } from '@angular/core';
import { Usercomum } from '../model/usercomum';
import { UsercomumService } from '../service/usercomum.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-usercomum',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './usercomum.html',
  styleUrl: './usercomum.css',
  providers: [UsercomumService]
})
export class UsercomumComponent{

  listaUsercomum: Usercomum[] = []

  constructor(private UsercomumService: UsercomumService){}

  ngOnInit(){
    console.log('Carregando clientes...')
    this.UsercomumService.getUsercomum().subscribe(usercomuns => {
      this.listaUsercomum = usercomuns
    })
  }

}
