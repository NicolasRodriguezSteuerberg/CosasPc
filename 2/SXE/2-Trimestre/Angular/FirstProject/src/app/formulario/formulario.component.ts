import { Component } from '@angular/core';
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-formulario',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css'
})
export class FormularioComponent {
  nombre: string ="";
  password: string ="";
  isLogged = false;
  togglePasswordVisibility() {
    var password = document.getElementById('password') as HTMLInputElement;
    var toggleButton = document.getElementById('toggleButton') as HTMLButtonElement;
    if(password.type==="password"){
      password.type="text";
      toggleButton.textContent = "🙈";
    } else{
      password.type="password";
      toggleButton.textContent = "👁️";
    }
  }
  myAlert(){
    this.isLogged = !this.isLogged;
    alert(`Tu nombre: ${this.nombre} y tu contraseña es: ${this.password}`);
  }
}
