public class Cash implements Pago{
    @Override
    public void tipoPago() {
        EntradaSalida.salida("Pago en metalico", EntradaSalida.SALIDA_WINDOW);
    }
}
