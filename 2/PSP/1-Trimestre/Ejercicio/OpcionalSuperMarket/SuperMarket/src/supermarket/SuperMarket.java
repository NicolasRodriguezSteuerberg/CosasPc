package supermarket;

import javax.swing.JOptionPane;


public class SuperMarket {

    public static void main(String[] args) {
        //int nCajas = Integer.parseInt(JOptionPane.showInputDialog("Indique cuantas cajas hay"));
        int nCajas = 10;
        // int mClientes = Integer.parseInt(JOptionPane.showInputDialog("Indique cuantos clientes habrá"));
        int mClientes = 10;
        Supermercado miSuper = new Supermercado(nCajas);
        for (int i = 0; i < mClientes; i++) {
            new ThreadClientes((i+1), miSuper).start();
        }
    }
    
}
