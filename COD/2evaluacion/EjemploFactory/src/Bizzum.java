public class Bizzum implements Pago{
    @Override
    public void tipoPago() {
        EntradaSalida.salida("Pago con Bizzum", EntradaSalida.SALIDA_WINDOW);
    }
}
