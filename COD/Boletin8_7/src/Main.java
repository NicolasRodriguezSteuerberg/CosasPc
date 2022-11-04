public class Main {
    final int CUADRADO = 1;
    final int TRIANGULO = 2;
    final int CIRCUNFERENCIA = 3;

    public static void main(String[] args) {
        Funciones obx = new Funciones();
        obx.mostrarMenu();
        int opcion = obx.introducirOpcion();

        switch (opcion) {
            case 1:
                int lado = obx.introducirNumero();
                int area = obx.calcularAreaCuadrado(lado);
                obx.mostrarArea(area);
                break;
            case 2:
                int altura = obx.introducirNumero();
                int base = obx.introducirNumero();
                area = obx.calcularAreaTriangulo(base, altura);
                obx.mostrarArea(area);
                break;
            case 3:
                int radio = obx.introducirNumero();
                int pi= obx.introducirNumero();
                area = obx.calcularAreaCircunferencia(radio,pi);
                obx.mostrarArea(area);
                break;
        }
    }
}