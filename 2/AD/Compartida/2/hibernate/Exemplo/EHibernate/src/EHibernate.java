import org.hibernate.SessionFactory;
import java.util.logging.Level;


public class EHibernate {

    public static void main(String[] args) {
        // TODO code application logic here
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Metodos obx = new Metodos();
        SessionFactory sf = obx.objSessionFactory();
        obx.añadir(sf);
        obx.actualizar(sf);
        obx.leerPersonas(sf);
        obx.borrar(sf);
        obx.leerPersonas(sf);
    }
    
}
