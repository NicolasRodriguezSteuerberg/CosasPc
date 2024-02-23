package pavions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.mongodb.client.FindIterable;
import static com.mongodb.client.model.Filters.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import java.sql.*;
import java.util.List;


public class Metodos {
    // objectDB
    EntityManagerFactory emf;
    EntityManager em;
    
    // mongoDB
    MongoClient mongoClient;
    MongoDatabase database;
    
    // postgres
    Connection con;
    
    //
    String orixeIda;
    String orixeVolta;
    
    public void connection(String mongoDB) throws SQLException{
        objectdbConnection();
        mongoDBConnection(mongoDB);
        postgresConnection();
    }
    
    private void objectdbConnection(){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/resultado.odb");
        em = emf.createEntityManager();
    }
    
    private void mongoDBConnection(String mongoDB){
        mongoClient = MongoClients.create();
        database = mongoClient.getDatabase(mongoDB);
    }
    
    private void postgresConnection() throws SQLException{
        String driver = "jdbc:postgresql:";
        String host = "//localhost:";
        String porto = "5432";
        String sid = "postgres";
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host+ porto + "/" + sid;
        
        con = DriverManager.getConnection(url,usuario,password);
    }
    
    // postgres
    public void leerReservas() throws SQLException{
        String consulta = "select *, (voos).* from reservas";
        PreparedStatement ps = con.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        int codR, idVooIda, idVooVolta, prezoVoos;
        String dni;
        while(rs.next()){
            codR = rs.getInt("codr");
            dni = rs.getString("dni");
            idVooIda = rs.getInt("idvooida");
            idVooVolta = rs.getInt("idvoovolta");
            System.out.println("codr=" +codR + "\ndni=" + dni + "\nidvooida=" + idVooIda + "\nidvoovolta=" + idVooVolta);
            increasePasaxeiro(dni);
            prezoVoos = getInfoVoos(idVooIda, idVooVolta);
            insertarConfirmada(codR, dni, orixeIda, orixeVolta, prezoVoos);
            System.out.println("");
        }
        
    }
    
    public void close() throws SQLException{
        con.close();
        mongoClient.close();
        em.close();
        emf.close();
    }
    
    private void increasePasaxeiro(String dni){
        MongoCollection<Document> coll = database.getCollection("pasaxeiros");
        Bson query = eq("_id",dni);
        Bson change = Updates.combine(
                Updates.inc("nreservas", 1)
        );
        coll.updateOne(query, change);
    }
    
    private int getInfoVoos(int idVooIda, int idVooVolta){
        int prezoIda, prezoVolta;
        MongoCollection<Document> coll = database.getCollection("voos");
        Bson fields = Projections.fields(
                Projections.include("orixe","prezo"),
                Projections.excludeId()
        );
        
        Bson eq = eq("_id", idVooIda);
        FindIterable<Document> preResult = coll.find(eq);
        MongoCursor<Document> result = preResult.iterator();
        
        // primera consulta
        Document doc = result.next();
        orixeIda = doc.getString("orixe");
        prezoIda = doc.getInteger("prezo");
        System.out.println("Orixe ida: " + orixeIda + ", Prezo: " + prezoIda);
        
        // segunda consulta
        eq = eq("_id", idVooVolta);
        preResult = coll.find(eq);
        result = preResult.iterator();
        doc = result.next();
        orixeVolta = doc.getString("orixe");
        prezoVolta = doc.getInteger("prezo");
        int prezoFinal = prezoVolta+prezoIda;
        System.out.println("Orixe volta: " + orixeVolta + ", Prezo: " + prezoVolta + ", Prezo final: "+prezoFinal);
        
        return prezoFinal;
    }
    
    private void insertarConfirmada(int codR, String dni, String orixeIda, String orixeVolta, double prezoVoos){
        em.getTransaction().begin();
        Confirmada c = new Confirmada(codR,dni,orixeIda,orixeVolta,prezoVoos);
        em.persist(c);
        em.getTransaction().commit();
    }
    
    public void seeConfirmadas(){
        TypedQuery<Confirmada> query = em.createQuery("SELECT c FROM Confirmada c", Confirmada.class);
        List<Confirmada> results = query.getResultList();
        
        for(Confirmada c: results){
            System.out.println(c.toString());
        }
    }
}
