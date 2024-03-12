# FirstProject

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 17.2.1.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.


----
## Craar uu componente
Para crear un componente tenemos que ir a nuestra terminal y poner lo siguiente:
```shell
ng generate component nombreComponente
```

## Como tener un contador que suba al pulsar un boton:
Nos dirigimos al archivo nombreComponente.component.ts y añadimos lo siguiente:
```typescript
export class HomeComponent {
  // inicializar contador
  counter = 0;

  // método que se llamara en nuestro boton
  increasCounter(){
    this.counter++;
  }
}
```
Ahora en nuestro html del componente en el boton llamamos a nuestra funcion:
```html
<!-- (click) es la funcion que hace que puedes asociar la funcion del typescript -->
<button id="botton" (click)="increasCounter()">
  Button clicker
</button>
```
### Como hacer un if para que salga texto dependiendo de alguna variable:
En mi caso solo voy a mostrar el contador cuando este sea mayor que 0
```html
<!-- podemos llamar directamente a las variables del typescript -->
@if (counter>0){
<!-- para añadir una variable a un texto tendremos que meterla entre {{}} -->
<p>Has marcado: {{counter}} goles</p>
}
```

## Como poner eventos
En nuestro archivo typescript podemos crear una funcion en la que dentro cogamos una referencia al elemento del evento y añadirselo, este es un ejemplo para que cada vez que se pulsa un boton se mueva aleatoriamente y que su color de fondo tambien sea aleatorio:
```typescript
  ngAfterViewInit() {
    // coger la referencia del boton
    const button = document.getElementById('randomButton') as HTMLButtonElement;
    // añadirle un evento que haga lo de dentro cada vez que se pulse
    button.addEventListener('click', () => {
      // coger los elementos aleatorios
      const x = Math.floor(Math.random() * window.innerWidth);
      const y = Math.floor(Math.random() * window.innerHeight);
      const r = Math.floor(Math.random() * 256);
      const g = Math.floor(Math.random() * 256);
      const b = Math.floor(Math.random() * 256);
      // ponerle estilo
      button.style.position = 'absolute';
      // le ponemos cuanto se mueve a partir de la izquierda y de arriba
      button.style.left = `${x}px`;
      button.style.top = `${y}px`;
      button.style.backgroundColor = `rgb(${r}, ${g}, ${b})`;
      // aumento un contador diferente
      this.contador++;
    });
  }
```
