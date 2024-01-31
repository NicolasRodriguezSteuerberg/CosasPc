package prueba;

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
        emf = Persistence.createEntityManagerFactory("$objectdb/db/p2.odb");
        em = emf.createEntityManager();
    }
    
    public void insert(){
        em.getTransaction().begin();
        for (int i = 0; i < 10; i++) {
            Point p = new Point(i, i);
            em.persist(p);
        }
        em.getTransaction().commit();
    }
    
    public void selectTotalPoints(){
        // Find the number of Point objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
        System.out.println("Total Points: " + q1.getSingleResult());
    }
    
    public void selectAvg(){
        // Find the average X value:
        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
        System.out.println("Average X: " + q2.getSingleResult());
    }
    
    public void selectPoints(){
        // Retrieve all the Point objects from the database:
        TypedQuery<Point> query =
            em.createQuery("SELECT p FROM Point p", Point.class);
        List<Point> results = query.getResultList();
        for (Point p : results) {
            System.out.println(
                    "id: " + emf.getPersistenceUnitUtil().getIdentifier(p) + //mostrar el id
                    "->" + p // mostrar el punto
            );
        }
    }
    
    public void selectPointForId(int id){
        Point result = em.find(Point.class, id);
        System.out.println("Busqueda por id: " + id);
        if (result != null) {
            System.out.println(result.toString());
        } else {
            System.out.println("No se encontró un punto con el ID: " + id);
        }
    }
    
    public void updatePointForId(int id){
        em.getTransaction().begin();
        int updatedCount = em.createQuery("UPDATE Point p SET p.y = p.y + 2 WHERE p.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();
        if (updatedCount > 0) {
            em.refresh(em.find(Point.class, id));
            System.out.println("actualizado: ");
            selectPointForId(id);
        } else {
            System.out.println("No se encontró un punto con el ID: " + id);
        }
    }
    
    public void massiveUpdate(int y){
        em.getTransaction().begin();
        int updatedCount = em.createQuery("UPDATE Point p SET p.y = 1000 WHERE p.y < :y")
                .setParameter("y", y)
                .executeUpdate();
        em.getTransaction().commit();
        if (updatedCount > 0) {
            em.clear();
            System.out.println("actualizado: ");
            selectPoints();
        } else {
            System.out.println("No se encontró ningun punto que tenga el punto y < " + y);
        }
    }
    
    public void massiveDelete(int y){
        em.getTransaction().begin();
        int deleted = em.createQuery("DELETE FROM Point p WHERE p.y < :y")
                .setParameter("y", y)
                .executeUpdate();
        em.getTransaction().commit();
        if (deleted > 0) {
            System.out.println("Borrado: ");
            selectPoints();
        } else {
            System.out.println("No se encontró un punto con el punto y < " + y);
        }
    }
    
    public void removeAll(){
        em.getTransaction().begin();
        TypedQuery<Point> query =
            em.createQuery("SELECT p FROM Point p", Point.class);
        List<Point> results = query.getResultList();
        for (Point p : results) {
            em.remove(p);
        }
        em.getTransaction().commit();
    }
    
    public void deleteForId(int id){
        em.getTransaction().begin();
        int deleted = em.createQuery("DELETE FROM Point p WHERE p.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();
        if (deleted > 0) {
            System.out.println("Borrado: ");
            selectPoints();
        } else {
            System.out.println("No se encontró un punto con el ID: " + id);
        }
    }
    
    public void closingConection(){
        em.close();
        emf.close();
    }
}
