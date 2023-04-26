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
     * Coger un coche
     * @param matricula
     * @return Coche
     */
    public Coche getCoche(String matricula){
        Coche aux = null;
        for (Coche e:parking){
            if(e.getMatricula().equalsIgnoreCase(matricula)){
                 aux = e;
            }
        }
        return aux;
    }

    public Integer cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad= v;
        // retorna la nueva velocidad
        return getCoche(matricula).velocidad;
    }

    public Integer getVelocidad(String matricula){
        return getCoche(matricula).velocidad;
    }


}
