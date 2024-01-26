package evino;

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
    int acidezMin, acidezMax, acidez, cantidadUvaAnalisis;
    String nomeUva, idAnalisis, tipoUva, idClientes;
    
    private MongoClient mongoClient;
    private MongoDatabase database;
    
    public void conect(String db){
        mongoClient = MongoClients.create();
        database = mongoClient.getDatabase(db);
    }
    
    public void cerrarCliente(){
        mongoClient.close();
    }
    
    /* ANALISIS
    _id: é o codigo do analisis , componse de dous caracteres alfanuméricos
    acidez : é un número que indica a acidez da uva 
    grao: é un número que indica o grao alcoholico da uva
    taninos: é un número que indica a cantidade en taninos da uva
    tipodeuva: é unha letra que identifica a variedade de uva analizada
    cantidade: é un número que indica a cantidade de uva para a que se fai o analise ( expresada en toneladas)
    dni: é o dni do cliente que encargou o analisis
    
    {_id:'a1',acidez:6,grao:9,taninos:0,tipodeuva:'c',cantidade:2,dni:'36898976z'}
    ,{_id:'a2',acidez:15,grao:0,taninos:8,tipodeuva:'a',cantidade:3,dni:'36598767j'}
    ,{_id:'a3',acidez:8,grao:14,taninos:0,tipodeuva:'l',cantidade:20,dni:'36434321m'}
    ,{_id:'a4',acidez:6,grao:10,taninos:0,tipodeuva:'a',cantidade:10,dni:'36898976z'}

    */
    public void getAnalisis(){
        MongoCollection<Document> coll = database.getCollection("analisis");
        // primero incluimos los campos que queremos
        // y excluimos el id(si no lo queremos tener)
        Bson fields = Projections.fields(
            Projections.include(
                    "acidez",
                    "tipodeuva",
                    "cantidade",
                    "dni"
                )
        );
        
        FindIterable<Document> preResult = coll
                .find()
                .projection(fields)
                .sort(Sorts.ascending("_id"))
        ;
        // Si quieres coger el primer resultado
        // System.out.println(preResult.first());
        MongoCursor<Document> result = preResult.iterator();
        Document doc;
        while(result.hasNext()){
            // coges la fila
            doc = result.next();
            idAnalisis = doc.getString("_id");
            acidez = doc.getInteger("acidez");
            tipoUva = doc.getString("tipodeuva");
            cantidadUvaAnalisis = doc.getInteger("cantidade");
            idClientes = doc.getString("dni");
            System.out.println(idAnalisis + "," + acidez + "," + tipoUva + "," + cantidadUvaAnalisis + "," + idClientes);
            aumentarNACliente();
            getUva();
            crearXerado();
            System.out.println("");
        }
    }
    
    /*CLIENTES
    _id - identifica a un cliente
    nome - e o nome do cliente
    telf - e o telefono do cliente
    numerodeanalisis - e o número de análisis de uva que o cliente leva feitos
    
    {_id:'36598767j',nome:'luis',telf:986876565,numerodeanalisis:6},
    {_id:'36898976z',nome:'ana',telf:986212323,numerodeanalisis:16},
    {_id:'36878745p',nome:'pedro',telf:986437654,numerodeanalisis:10},
    {_id:'36434321m',nome:'jose',telf:986923412,numerodeanalisis:0}
    */
    public void aumentarNACliente(){
        MongoCollection<Document> coll = database.getCollection("clientes");
        Bson query = eq("_id", idClientes);
        Bson change = Updates.combine(
                Updates.inc("numerodeanalisis", 1)
        );
        // condicion y cambios
        coll.updateOne(query, change);
        System.out.println("CLIENTE aumentado");
    }
    
    /*UVAS
    _id  - consiste unha letra que identifica a unha uva concreta
    nomeu - é o nome da uva 
    acidezmin  - é a acidez minima que deberia ter dita uva
    acidezmax  - é a acidez maxima que debería ter dita uva
    
    {_id:'a',nomeu:'alvarinho',acidezmin:10,acidezmax:14},	  
    {_id:'m',nomeu:'mencia',acidezmin:8,acidezmax:12},
    {_id:'c',nomeu:'cainho',acidezmin:7,acidezmax:10},
    {_id:'p',nomeu:'pedral',acidezmin:8,acidezmax:11},
    {_id:'l',nomeu:'loureiro',acidezmin:6,acidezmax:10},
    {_id:'g',nomeu:'garnacha',acidezmin:8,acidezmax:14}
    */
    public void getUva(){
        MongoCollection<Document> coll = database.getCollection("uvas");
        Bson eq = eq("_id",tipoUva);
        FindIterable<Document> preResult = coll.find(eq);
        MongoCursor<Document> result = preResult.iterator();
        Document doc = result.next();
        nomeUva = doc.getString("nomeu");
        acidezMin = doc.getInteger("acidezmin");
        acidezMax = doc.getInteger("acidezmax");
    }
    
    public void crearXerado(){
        /*
        na clave _id : o código do análisis
        no par nomeuva: o nome da uva
        no par tratacidez:  un dos seguintes textos:
        o texto ‘subir acidez’  se a acidez de dita uva esta por debaixo da minima que corresponde a dita uva,
        o texto ‘baixar acidez’ se a acidez de dita uva esta por riba da maxima que corresponde a dita uva ,
        o texto ‘acidez correcta’ se a acidezde dita uva esta comprendida entre os valores mínimo e máximo que corresponde a dita uva .
        no par total : o resultado de calcular canto se debe pagar por dito análisis. Dito calculo obtense multiplicando por 15 a cantidade de uva analizada
        */
        MongoCollection<Document> coll = database.getCollection("xerado");
        String trataAcidez;
        if(acidez > acidezMax){
            trataAcidez = "baixar acidez";
        } else if (acidez < acidezMin){
            trataAcidez = "subir acidez";
        } else{
            trataAcidez = "acidez correcta";
        }
        int total = 15 * cantidadUvaAnalisis;
        Document doc_ins = new Document("_id", idAnalisis)
                .append("nomeuva", nomeUva)
                .append("trataacidez", trataAcidez)
                .append("total", total)
        ;
        coll.insertOne(doc_ins);
        System.out.println("XERADO CREADO");
    }
    
    
}
