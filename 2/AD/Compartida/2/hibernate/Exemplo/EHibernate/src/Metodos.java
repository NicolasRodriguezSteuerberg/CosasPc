import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.MetadataSources;


public class Metodos {
    
    public SessionFactory objSessionFactory(){
        /* Esto no va
        Configuration configuration = new Configuration().configure();
        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(sr);
        */
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        return sessionFactory;
    }
    
    public void añadir(SessionFactory sessionFactory){
        BigDecimal salario = new BigDecimal(4533.2);
        Persona persona = new Persona(4,"Nico", "Steuerberg", salario);
        
        Session session = sessionFactory.openSession();
        // transaccion
        Transaction tx = session.beginTransaction();
        // que hace la transaccion
        session.save(persona);
        // cerrar transaccion
        tx.commit();
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
        BigDecimal salario = new BigDecimal(10);
        persona.setSalario(salario);
        Session session = sessionFactory.openSession();
        
        Transaction tx = session.beginTransaction();
        session.update(persona);
        // Si queremos que se guarde si no existe la persona
        //session.saveOrUpdate(persona);
        tx.commit();
        session.close();
    }
    
    public void leerPersonas(SessionFactory sessionFactory){
        /* Para leer uno en especifico
        System.out.println(getPersona(sessionFactory, 1).toString());
        System.out.println(getPersona(sessionFactory, 2).toString());
        System.out.println(getPersona(sessionFactory, 3).toString());
        System.out.println(getPersona(sessionFactory, 4).toString());
        */
        // leer todos
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        // le puedes poner una condicion si quieres
        List<Persona> personas = session.createQuery("FROM Persona").list();
        tx.commit();
        session.close();
        for(Persona persona: personas){
            System.out.println(persona);
        }
        System.out.println("");
    }
    
    public void borrar(SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        Persona persona = getPersona(sessionFactory,2);
        Transaction tx = session.beginTransaction();
        session.delete(persona);
        tx.commit();
        session.close();
    }
    
}
