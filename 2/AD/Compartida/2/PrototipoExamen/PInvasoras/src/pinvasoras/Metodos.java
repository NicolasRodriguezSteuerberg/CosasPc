package pinvasoras;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class Metodos {
    EntityManagerFactory emf;
    EntityManager em;
    
    public void connection(){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/encontradasezonas.odb");
        em = emf.createEntityManager();
    }
    
    public void seeZonas(){
        TypedQuery<Zonas> query = em.createQuery("SELECT z from Zonas z", Zonas.class);
        List<Zonas> results = query.getResultList();
        for (Zonas z : results) {
            System.out.println(
                    "id: " + emf.getPersistenceUnitUtil().getIdentifier(z) + //mostrar el id
                    "->" + z // mostrar el punto
            );
        }
    }
    
    public void seeEncontradas(){
        TypedQuery<Encontradas> query = em.createQuery("SELECT z from Encontradas z", Encontradas.class);
        List<Encontradas> results = query.getResultList();
        for (Encontradas e : results) {
            System.out.println(
                    "id: " + emf.getPersistenceUnitUtil().getIdentifier(e) + //mostrar el id
                    "->" + e // mostrar el punto
            );
            increaseInvasora(e.getCodzona());
        }
    }
    
    public void increaseInvasora(int codz){
        em.getTransaction().begin();
        int updatedCount = em.createQuery("UPDATE Zonas z SET z.numeroinvasoras = z.numeroinvasoras + 1 where z.codz = :codz")
                .setParameter("codz",codz)
                .executeUpdate();
        em.getTransaction().commit();
        if(updatedCount>0){
            em.refresh(em.find(Zonas.class, codz));
        }
    }
}
