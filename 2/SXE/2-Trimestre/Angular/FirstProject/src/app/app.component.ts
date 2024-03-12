import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { HomeComponent} from "./home/home.component";
import {FormularioComponent} from "./formulario/formulario.component";
// HomeComponent es como llamaremos a nuestro componente

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HomeComponent,
    FormularioComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Nicolás Rodríguez Steuerberg';
  course = "DAM";
  contador = 0;

  ngAfterViewInit() {
    const button = document.getElementById('randomButton') as HTMLButtonElement;
    button.addEventListener('click', () => {
      const x = Math.floor(Math.random() * window.innerWidth);
      const y = Math.floor(Math.random() * window.innerHeight);
      const r = Math.floor(Math.random() * 256);
      const g = Math.floor(Math.random() * 256);
      const b = Math.floor(Math.random() * 256);
      button.style.position = 'absolute';
      button.style.left = `${x}px`;
      button.style.top = `${y}px`;
      button.style.backgroundColor = `rgb(${r}, ${g}, ${b})`;
      this.contador++;
    });
  }
}
