/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemon;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Pokemon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner obxSca = new Scanner(System.in);
        
        int estado1 = 1; //1 vivo--0 muerto
        int estado2 = 1;
        int pok1, pok2, ata1, ata2;
        String nPoke1 = ""; 
        String nPoke2 = "";
        String nAta1 = "";
        String nAta2 = "";
        
        System.out.println("Jugador 1 escoge tu pokemon:\n1. Pickachu\n2. Bulbasaur\n3. Charmander\n4. Squirtle");
        pok1 = obxSca.nextInt();
        switch(pok1){
            case 1:
                Pickachu Pika1 = new Pickachu("Pikachu", 35, 54, 50, 911);
                System.out.println("Jugador 2 escoge tu pokemon:\n1. Pickachu\n2. Bulbasaur\n3. Charmander\n4. Squirtle");
                pok2 = obxSca.nextInt();
            
                switch(pok2){
                    case 1:
                        Pickachu Pika2 = new Pickachu("Pikachu", 35, 55, 50, 90);
                        nPoke2 = Pika2.getNombre();
                        do{
                            System.out.println("Jugador 1 elige tu ataque");
                            Pika1.verAtaques();
                            ata1 = obxSca.nextInt();
                            switch(ata1){
                                case 1:
                                    Pika1.arañazo();
                                    nAta1 = "Arañazo";
                                    break;
                                case 2:
                                    Pika1.impactrueno();
                                    nAta1 = "Impactrueno";
                                    break;                                    
                                case 3:  
                                    Pika1.rayo();
                                    nAta1 = "Rayo";
                                    break;
                                case 4:
                                    Pika1.arañazo();
                                    nAta1 = "Puño trueno";
                                    break;
                            }
                            
                            System.out.println("Jugador 2 elige tu ataque");
                            Pika2.verAtaques();
                            ata2 = obxSca.nextInt();
                            switch(ata2){
                                case 1:
                                    Pika2.arañazo();
                                    nAta2 = "Arañazo";
                                    break;
                                case 2:
                                    Pika2.impactrueno();
                                    nAta2 = "Impactrueno";
                                    break;                                    
                                case 3:  
                                    Pika2.rayo();
                                    nAta2 = "Rayo";
                                    break;
                                case 4:
                                    Pika2.arañazo();
                                    nAta2 = "Puño trueno";
                                    break;
                            }
                            
                            if(Pika1.getVelocidad()>Pika2.getVelocidad()){
                                System.out.println("El pikachu del jugador 1 ha usado: " + nAta1);
                                float ps2 = Pika2.getPs()-(Pika1.getDaño()/(25*Pika2.getDefensa()));
                                Pika2.setPs(ps2);
                                System.out.println("El pikachu del jugador 2 se ha quedado a " + Pika2.getPs());
                                if(Pika2.getPs()<=0){
                                    estado2 = 0;
                                    System.out.println("El pikachu del jugador 1 ha quedado fuera de combate\nHa ganado el jugador 2");
                                    break;
                                }
                                
                                System.out.println("El pikachu del jugador 2 ha usado: " + nAta2);
                                float ps1 = Pika1.getPs()-(Pika2.getDaño()/(25*Pika1.getDefensa()));
                                Pika1.setPs(ps1);
                                System.out.println("El pikachu del jugador 1 se ha quedado a " + Pika1.getPs());
                                if(Pika1.getPs()<=0){
                                    estado1 = 0;
                                    System.out.println("El pikachu del jugador 1 ha quedado fuera de combate\nHa ganado el jugador 2");
                                    break;
                                }
                                
                            }
                            else{
                                
                            }
                            
                            
                        }while(estado1==1 && estado2==1);
                         break;
                
                    case 2:
                        Bulbasaur obxB = new Bulbasaur("Bulbasaur", 45, 49, 65, 45);
                        nPoke2 = obxB.getNombre();
                        break;
                    case 3:
                        Charmander obxC = new Charmander("Charmander", 39, 60, 50, 65);
                        nPoke2 = obxC.getNombre();
                        break;
                    case 4:
                        Squirtle obxS = new Squirtle("Squirtle", 44, 50, 65, 43);
                        nPoke2 = obxS.getNombre();
                        break;
                }
                
                    System.out.println("Jugador 1 ha escogido a ");
                    break;
                
            case 2:
                Bulbasaur obxB = new Bulbasaur("Bulbasaur", 45, 49, 65, 45);
                nPoke1 = obxB.getNombre();
                break;
            case 3:
                Charmander obxC = new Charmander("Charmander", 39, 60, 50, 65);
                nPoke1 = obxC.getNombre();
                break;
            case 4:
                Squirtle obxS = new Squirtle("Squirtle", 44, 50, 65, 43);
                nPoke1 = obxS.getNombre();
                break;
        }
        
        
      

                
    }
    
}
