import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { HomeComponent} from "./home/home.component";
// HomeComponent es como llamaremos a nuestro componente

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HomeComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Nicolás Rodríguez Steuerberg';
  course = "DAM";
  contador = 0;
}
