import com.nicosteuerberg.datos.PedirDatos;

public class Controller {
    public static void main(String[] args) {
        View obxV = new View();
        Model obxM = new Model();

        obxM.crearCoche("Seat","BXK 3214");
        obxM.crearCoche("Renault","COC 1111");
        obxM.crearCoche("LaFerrari","RTS 222");

        obxM.cambiarVelocidad("BXK 3214", 239);

        obxV.verVelocidad("BXK 3214", obxM.getVelocidad("BXK 3214"));
    }
}
