public class PagoBizzum extends Tienda{
    @Override
    public Pago hacerPago() {
        return new Bizzum();
    }
}
