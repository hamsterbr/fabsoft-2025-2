import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('fabsoft-frontend');

  constructor(
    private router: Router
  ){}

  irParaUsercomum() {
    this.router.navigate(['/usercomum']);
  }

  irParaUseradm() {
    this.router.navigate(['/useradm']);
  }

}
