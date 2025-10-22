import { Injectable } from '@angular/core';
import { Usercomum } from '../model/usercomum';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsercomumService {
  apiURL = "http://localhost:8080/api/v1/usercomum"

  constructor(private http:HttpClient) {}

  getUsercomum(){
    return this.http.get<Usercomum[]>(this.apiURL)
  }

  saveUsercomum(usercomum:Usercomum){
    return this.http.post(this.apiURL, usercomum)
  }

}
