package pfincas;

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
import com.mongodb.client.result.UpdateResult;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class Metodos {
    // objectDB
    EntityManagerFactory emf;
    EntityManager em;
    // mongoDB
    MongoClient mongoClient;
    MongoDatabase database;
    // postgres
    Connection conn;
    
    String codf;
    String dni;
    String nombreArbol;
    int numArbol;
    double prezoKilo;
    int producionMedia;
    double totalParcial;
    
    
    public void connection(String mongoDB) throws SQLException{
        objectdbConnection();
        mongoDBConnection(mongoDB);
        postgresConnection();
    }
    
    private void objectdbConnection(){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/fincas.odb");
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
        
        conn = DriverManager.getConnection(url,usuario,password);
    }
    
    public void getFincas() throws SQLException{
        TypedQuery<Finca> query = em.createQuery("SELECT f from Finca f", Finca.class);
        List<Finca> results = query.getResultList();
        for (Finca f : results) {
            codf = f.getCodf();
            dni = f.getDni();
            System.out.println(codf + ", " + dni);
            getArbol();
            totalParcial = numArbol * producionMedia * prezoKilo;
            System.out.println("total parcial: " + totalParcial);
            updateTotal();
            System.out.println("");
        }
    }
    
    private void getArbol() throws SQLException{
        String consulta = "select (arbol).* from producion where codf=?";
        PreparedStatement ps = conn.prepareStatement(consulta);
        
        ps.setString(1, codf);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            nombreArbol = rs.getString("nomea");
            numArbol = rs.getInt("numa");
            System.out.println("Nombre arbol: " + nombreArbol + ", numero arboles:" + numArbol);
            getPrezoKiloArbol();
            getProducionMediaAnterior();
        }
    }
    
    private void getPrezoKiloArbol() throws SQLException{
        String consulta = "select prezok from prezoskilo where nomear=?";
        PreparedStatement ps = conn.prepareStatement(consulta);
        
        ps.setString(1, nombreArbol);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            prezoKilo = rs.getDouble("prezok");
            System.out.println("Prezo kilo: " + prezoKilo);
        }
    }
    
    private void getProducionMediaAnterior(){
        MongoCollection<Document> coll = database.getCollection("arbores");
        Bson fields = Projections.fields(
                Projections.include("orixe","prezo"),
                Projections.excludeId()
        );
        
        Bson eq = eq("_id", nombreArbol);
        FindIterable<Document> preResult = coll.find(eq);
        MongoCursor<Document> result = preResult.iterator();
        
        // primera consulta
        Document doc = result.next();
        producionMedia = doc.getInteger("prodm");
        System.out.println("producion media: " + producionMedia);
    }
    
    private void updateTotal(){
        MongoCollection<Document> coll = database.getCollection("propietarios");
        Bson query = eq("_id",dni);
        Bson change = Updates.combine(
                Updates.inc("total", totalParcial)
        );
        UpdateResult result = coll.updateOne(query, change);
        long modificado = result.getModifiedCount();
        if(modificado > 0){
            System.out.println("incrementado el campo total del documento mongo correspondiente");
        }
    }
    
    public void close() throws SQLException{
        conn.close();
        mongoClient.close();
        em.close();
        emf.close();
    }
}
