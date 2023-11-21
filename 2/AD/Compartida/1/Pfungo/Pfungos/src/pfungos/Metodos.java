package pfungos;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Metodos {
    
    public Connection conexion() throws SQLException{
        String driver = "jdbc:postgresql:";
        String host = "//localhost:";
        String porto = "5432";
        String sid = "postgres";
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host+ porto + "/" + sid;
        
        Connection con = DriverManager.getConnection(url,usuario,password);
        
        return con;
    }
    
    public void leerDetectadosSerializado(Connection con, String rutaSerializado, String rutaDelimitado) throws FileNotFoundException, FileNotFoundException, IOException, IOException, ClassNotFoundException, SQLException{
        Detectados obx = null;
        ObjectInputStream lec = new ObjectInputStream(new FileInputStream(rutaSerializado));
        // objeto escribir serializado
        PrintWriter esc = new PrintWriter(new BufferedWriter(new FileWriter(rutaDelimitado)));
        
        double superficie, humLimite, hummedia, porcentaxeDanos;
        int coda;
        String select, nomArea, nomFungo;
        do{
            obx = (Detectados) lec.readObject();
            if(obx != null){
                aumentarFungoArea(con, obx.getCodarea());
                
                // fungo area
                    select = "select noma,hummedia,superficie,numerofungos from areas where codarea = ?";
                    PreparedStatement ps = con.prepareStatement(select);

                    ps.setInt(1, obx.getCodarea());

                    ResultSet rs = ps.executeQuery();

                    rs.next();
                    
                    superficie = rs.getFloat("superficie");
                    hummedia = rs.getFloat("hummedia");
                    nomArea = rs.getString("noma");
                    
                    System.out.println("Nombre area: " + nomArea 
                            + ", Hummedia: "+ hummedia 
                            + ", Superficie: " + superficie
                            + ", Numerofungos: " + rs.getFloat("numerofungos")
                            + "\n"
                    );

                    ps.close();
                    
                // propiedades fungo
                    select = "select nomef,humlimite from fungos where id=?";
                    ps = con.prepareStatement(select);

                    ps.setInt(1, obx.getCodfungo());

                    rs = ps.executeQuery();

                    rs.next();
                    
                    humLimite = rs.getFloat("humlimite");
                    nomFungo = rs.getString("nomef");
                    
                    System.out.println("Id fungo: " + rs.getInt("id")
                            + ", Nombre fungo: " + nomFungo
                            + ", Humedad limite: " + humLimite
                            + "\n"
                    );


                    ps.close();
                // escribir delimitado
                    if(hummedia > humLimite){
                        porcentaxeDanos = obx.getSuperficie()*100/superficie;
                        System.out.println("Porcentaxe danos: " + porcentaxeDanos);
                        esc.println(obx.getCodarea() + "_" + nomArea + "_" + nomFungo + "_" + obx.getSuperficie() + "_" + porcentaxeDanos);
                    }
                    
            } else{
                System.out.println("Objeto nulo");
            }
        }while(obx != null);
            
        lec.close();   
    }
    
    
    public void aumentarFungoArea(Connection con, int codarea) throws SQLException{
        String update = "update areas SET numerofungos=numerofungos+1 where coda = ?";
        PreparedStatement ps = con.prepareStatement(update);
        
        ps.setInt(1, codarea);
        
        int verificacion = ps.executeUpdate();
        if(verificacion == 0){
            System.out.println("Error: Produto no encontrado o modificacion no permitida");
        } else{
            System.out.println("Aumentado en 1 en el area: " + codarea);
        }
        
        ps.close();
    }
    
}
