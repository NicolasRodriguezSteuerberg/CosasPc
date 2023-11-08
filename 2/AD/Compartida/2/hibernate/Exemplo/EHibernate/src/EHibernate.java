


import org.hibernate.SessionFactory;


public class EHibernate {

    public static void main(String[] args) {
        // TODO code application logic here
        Metodos obx = new Metodos();
        SessionFactory sf = obx.objSessionFactory();
        obx.añadir(sf);
        obx.actualizar(sf);
        obx.leerPersonas(sf);
        obx.borrar(sf);
        obx.leerPersonas(sf);
    }
    
}
