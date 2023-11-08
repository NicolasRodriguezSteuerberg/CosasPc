

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;       
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Metodos {
    
    public SessionFactory objSessionFactory(){
        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        return sessionFactory;
    }
    
    public void añadir(SessionFactory sessionFactory){
        Persona persona = new Persona(4,"Nico", "Steuerberg", 4533.4f);
        
        Session session = sessionFactory.openSession();
        // transaccion
        session.beginTransaction();
        // que hace la transaccion
        session.save(persona);
        // cerrar transaccion
        session.getTransaction().commit();
        
        // cerrar sesion
        session.close();
    }
    
    public Persona getPersona(SessionFactory sessionFactory, int id){
        Session session = sessionFactory.openSession();
        Persona persona = (Persona)session.get(Persona.class,id);
        session.close();
        return persona;
    }
    
    public void actualizar(SessionFactory sessionFactory){
        Persona persona = getPersona(sessionFactory,1);
        persona.setSalario(10);
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        session.update(persona);
        // Si queremos que se guarde si no existe la persona
        //session.saveOrUpdate(persona);
        session.getTransaction().commit();
        
        session.close();
    }
    
    public void leerPersonas(SessionFactory sessionFactory){
        System.out.println(getPersona(sessionFactory, 1).toString());
        System.out.println(getPersona(sessionFactory, 2).toString());
        System.out.println(getPersona(sessionFactory, 3).toString());
        System.out.println(getPersona(sessionFactory, 4).toString());
    }
    
    public void borrar(SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        Persona persona = getPersona(sessionFactory,2);
        session.beginTransaction();
        session.delete(persona);
        session.getTransaction().commit();
        
        session.close();
    }
    
}
