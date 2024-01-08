package tortugaYLiebre;  

import java.util.Random; 

public class Animal extends Thread {  // Define la clase Animal que extiende la clase Thread
    
    public int posicion = 1;  // Posición inicial del animal en la carrera
    public int[] moverse;  // Array que define cuánto se moverá el animal en cada paso
    public int[] probabilidad;  // Array que define la probabilidad de cada movimiento en el array moverse

    public Animal(String nombre, int[] moverse, int[] probabilidad) {  
        super(nombre);  // Llama al constructor de la clase padre (Thread) con el nombre del animal
        this.moverse = moverse;  // Asigna el array moverse a la variable de instancia correspondiente
        this.probabilidad = probabilidad;  // Asigna el array probabilidad a la variable de instancia correspondiente
    }

    @Override
    public void run() {  
        while (posicion < Carrera.linea && !Carrera.finCarrera) {  
            try {
                Thread.sleep(500);  // Hace una pausa de 500 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();  // Imprime la traza de la excepción si se produce una
            }
            if (!Carrera.finCarrera) {  // Si la carrera no ha terminado
                seMueve();  // El animal se mueve
                printPosition();  // Imprime la posición del animal
                checkForWinner();  // Comprueba si el animal ha ganado
            }
        }
    }
    
    protected void seMueve() {  // Método que mueve al animal
        int roll = new Random().nextInt(100) + 1;  // Genera un número aleatorio entre 1 y 100
        int cumulativeProbability = 0;  // Inicializa la probabilidad acumulada
        for (int i = 0; i < probabilidad.length; i++) {  // Recorre el array probabilidad
            cumulativeProbability += probabilidad[i];  // Acumula la probabilidad
            if (roll <= cumulativeProbability) {  // Si el número aleatorio es menor o igual que la probabilidad acumulada
                posicion += moverse[i];  // El animal se mueve
                break;  // Rompe el bucle
            }
        }
        if (posicion < 1) {  // Si la posición del animal es menor que 1
            posicion = 1;  // La posición se establece en 1
        }
    }

    protected void printPosition() {  // Método que imprime la posición del animal
        System.out.println(getName() + " está na posición " + posicion);  // Imprime la posición del animal
    }

    protected synchronized void checkForWinner() {  // Método que comprueba si el animal ha ganado
        if (posicion >= Carrera.linea && !Carrera.finCarrera) {  // Si la posición del animal es mayor o igual que la línea de meta y la carrera no ha terminado
            Carrera.finCarrera = true;  // La carrera termina
            System.out.println(getName() + " ganhou a corrida!");  // Imprime que el animal ha ganado
        }
    }
}
