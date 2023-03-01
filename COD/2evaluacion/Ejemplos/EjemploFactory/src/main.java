import javax.swing.*;

public class main {
    private static Tienda miTienda;

    public static void main(String[] args) {

        int numero = EntradaSalida.entradaInt("Con que quieres pagar:\n1-->Metalico\n2-->Credito\n3-->Bizzum");

        switch (numero){
            case 1:
                miTienda = new PagoCredito();
                miTienda.hacerPago();
                miTienda.comprarAlgo();
                break;
            case 2:
                miTienda = new PagoCash();
                miTienda.hacerPago();
                miTienda.comprarAlgo();
                break;
            case 3:
                miTienda = new PagoBizzum();
                miTienda.hacerPago();
                miTienda.comprarAlgo();
            default:
                System.out.println("OpcionIncorrecta");
        }

    }
}
