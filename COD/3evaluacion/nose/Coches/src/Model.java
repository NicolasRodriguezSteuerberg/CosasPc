import java.util.ArrayList;

public class Model {
    static ArrayList<Coche> parking = new ArrayList();

    /**
     * @param modelo
     * @param matricula
     * @return Coche
     */
    public Coche crearCoche(String modelo,String matricula){
        Coche obxC = new Coche(modelo,matricula);
        parking.add(obxC);
        return obxC;
    }

    /**
     * @param matricula
     * @return Coche
     */
    public Coche getCoche(String matricula){
        Integer aVelocidad;
        String aMatricula = null;
        String aModelo = null;
        for (Coche e:parking){
            if(e.getMatricula().equalsIgnoreCase(matricula)){
                 aVelocidad = e.getVelocidad();
                 aMatricula = e.getMatricula();
                 aModelo = e.getModelo();
            }
        }
        return new Coche(aModelo,aMatricula);
    }


}
