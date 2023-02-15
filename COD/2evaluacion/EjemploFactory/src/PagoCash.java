public class PagoCash extends Tienda{

    /**
     * Extiende de Tienda,
     * @return el objeto de tipo de pago (Credito en este caso)
     */
    @Override
    public Pago hacerPago() {
        return new Cash();
    }
}
