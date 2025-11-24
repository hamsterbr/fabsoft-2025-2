import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('fabsoft-frontend');

  constructor(
    private router: Router
  ){}

  testarNavegacao() {
    this.router.navigate(['/usercomum']);
  }
}
