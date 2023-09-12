public abstract class Tienda {
    /**
     * método abstracto para realizar pagos
     * @return la Interfaz de tipo Pago
     */
    public abstract Pago hacerPago();

    /**
     * Para comprar algo, lama al metodo hacerPago()
     * Con el objeto pago utiliza su método tipo de pago
     */
    public void comprarAlgo(){
        Pago oPago = hacerPago();
        oPago.tipoPago();;
    }
}
