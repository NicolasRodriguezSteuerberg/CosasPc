package pruebamongo;

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
import java.util.Arrays;
import static java.util.Arrays.asList;
import org.bson.types.ObjectId;


public class Metodos {
    private MongoClient mongoClient;
    private MongoDatabase database;
    
    public void conect(String db){
        mongoClient = MongoClients.create();
        database = mongoClient.getDatabase(db);
    }
    
    public void verEstudiantePuntuacionExamenesTest(){
        MongoCollection<Document> coll = database.getCollection("datos");
        // primero incluimos los campos que queremos
        // y excluimos el id(si no lo queremos tener)
        Bson fields = Projections.fields(
            Projections.include("estudiante", "puntuacion"),
            Projections.excludeId()
        );
        
        // ahora hacemos la condicion de la busqueda
        Bson eq = eq("exame","test");
        
        FindIterable<Document> preResult = coll
                .find(eq)
                .projection(fields)
                .sort(Sorts.descending("puntuacion"))
        ;
        // Si quieres coger el primer resultado
        // System.out.println(preResult.first());
        MongoCursor<Document> result = preResult.iterator();
        Document doc;
        while(result.hasNext()){
            // coges la fila
            doc = result.next();
            System.out.println("estudiante: " + doc.getInteger("estudiante") + ", puntuacion:" + doc.getInteger("puntuacion"));
        }
    }
    
    public void updatePuntuationEstudiante(int id, int puntuation, int estudiante){
        MongoCollection<Document> coll = database.getCollection("datos");
        Bson query = eq("_id", 1);
        Bson change = Updates.combine(
                Updates.set("puntuacion", puntuation),
                Updates.set("estudiante", estudiante)
        );
        // condicion y cambios
        coll.updateOne(query, change);
    }
    
    public void crearDato(){
        Document doc_ins = new Document("_id",11)
            .append("puntuacion", 8)
            .append("exame", "test")
            .append("estudiante", 71)
        ;
        
        MongoCollection<Document> coll = database.getCollection("datos");
        coll.insertOne(doc_ins);
    }
    
    public void cerrarCliente(){
        mongoClient.close();
    }
    
}
