/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package numerosrandomnorepetibles;

/**
 *
 * @author nicol
 */
public class Random {
     
    public Random(){
        
    }

    public Ataque[] atac = new Ataque[4];
        
    public void generarAtaques(Ataque[] atac){
        Ataque[] ataq = {Ataque.PISTOLA_AGUA, Ataque.HIDROBOMBA, Ataque.RAYO_BURBUJA, Ataque.SURF, Ataque.CASCADA, Ataque.BOLA_VOLTIO, Ataque.IMPACTRUENO, Ataque.RAYO, Ataque.TRUENO, Ataque.ELECTROCANON, Ataque.ASCUAS, Ataque.GIRO_FUEGO, Ataque.LANZALLAMAS, Ataque.HUMAREDA, Ataque.LLAMARADA, Ataque.HOJA_AFILADA, Ataque.LATIGO_CEPA, Ataque.HOJA_AGUDA, Ataque.ENERGIBOLA, Ataque.DANZA_PETALO};
        int num;
        for(int i = 0; i < atac.length ; i++){
            int numero = (int) (Math.random()*((20) - 15))+15;
            if(i>0){
                for(int j = i; j > -1; j--){
                    while(atac[j] == ataq[numero]){
                        numero = (int) (Math.random()*((20) - 15))+15;
                        j = i;
                    }
                }
            }
            atac[i] = ataq[numero];
            System.out.println((i+1) + ". " + atac[i].getNome());
        }
    }
}
