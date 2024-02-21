package pinvasoras;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.mongodb.ConnectionString;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import static com.mongodb.client.model.Filters.*;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.conversions.Bson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.List;
import org.bson.types.ObjectId;


public class Metodos {
    // objectDB
    EntityManagerFactory emf;
    EntityManager em;
    
    // mongoDB
    MongoClient mongoClient;
    MongoDatabase database;
    
    // postgres
    Connection conn;
    
    // variables necesarias
    String nomeZona, nomeInvasora;
    int codZona, tempMedia, tempBarrera;
    double extensionEncontrada, superficieZona;
    
    public void connection(String mongoDB) throws SQLException{
        objectdbConnection();
        mongoDBConnection(mongoDB);
        postgresConnection();
    }
    
    private void objectdbConnection(){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/encontradasezonas.odb");
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
    
    public void seeEncontradas() throws SQLException{
        TypedQuery<Encontradas> query = em.createQuery("SELECT z from Encontradas z", Encontradas.class);
        List<Encontradas> results = query.getResultList();
        for (Encontradas e : results) {
            System.out.println(
                    "id: " + emf.getPersistenceUnitUtil().getIdentifier(e) + //mostrar el id
                    "->" + e // mostrar el punto
            );
            codZona = e.getCodzona();
            extensionEncontrada = e.getExtension();
            increaseInvasora(codZona);
            getZona();
            getBarrera(e.getCodespecie());
            if(tempMedia > tempBarrera){
                writeResumo();
            }
        }
    }
    
    private void writeResumo() throws SQLException{
        String insert = "insert into resumo(codz,nomez,nomei,danos.extensiondanada,danos.porcentaxedanos) VALUES(?,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(insert);
        
        statement.setInt(1, codZona);
        statement.setString(2, nomeZona);
        statement.setString(3, nomeInvasora);
        statement.setDouble(4, extensionEncontrada);
        statement.setDouble(5, (extensionEncontrada*100/superficieZona));
        
        int ejecutado = statement.executeUpdate();
        
        if (ejecutado>0){
            System.out.println("EJECUTADO EL INSERT");
        }
        
        statement.close();
    }
    
    private void getZona(){
        Zonas zona = em.find(Zonas.class, codZona);
        if (zona != null){
            nomeZona = zona.getNomz();
            superficieZona = zona.getSuperficie();
            tempMedia = zona.getTempmedia();
        } else {
            System.out.println("ZONA NO ENCONTRADA");
        }
    }
    
    private void getBarrera(int codEspecie){
        MongoCollection<Document> coll = database.getCollection("especiesinvasoras");
        Bson eq = eq("_id", codEspecie);
        FindIterable<Document> preResult = coll.find(eq);
        MongoCursor<Document> result = preResult.iterator();
        Document doc = result.next();
        nomeInvasora = doc.getString("nomei");
        tempBarrera = doc.getInteger("tempbarrera");
    }
    
    private void increaseInvasora(int codz){
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
