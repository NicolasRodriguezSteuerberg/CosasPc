public class Credito implements Pago{
    @Override
    public void tipoPago() {
        EntradaSalida.salida("Pago con crédito", EntradaSalida.SALIDA_WINDOW);
    }
}
