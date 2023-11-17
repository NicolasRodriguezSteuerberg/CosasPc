package pcidades2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Metodos {
    
    int cuenta = 0;
    
    public Connection conexion() throws SQLException{
        String driver = "jdbc:postgresql:";
        String host = "//localhost:";
        String porto = "5432";
        String sid = "postgres";
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host+ porto + "/" + sid;
        
        Connection conn = DriverManager.getConnection(url,usuario,password);
        
        return conn;
    }
    
    public void leerDelimitado(Connection con, String rutaBuf, String rutaEsc) throws FileNotFoundException, IOException, SQLException{
        BufferedReader lecBuf = new BufferedReader(new FileReader(rutaBuf));
        
        String lectura = null;
        String codZona,nomZona;
        int prezoM2, numeroTotalPisos;
        
        // crear el objeto para escribir serializado
        ObjectOutputStream obxW = new ObjectOutputStream(new FileOutputStream(rutaEsc));
        
        while((lectura=lecBuf.readLine())!= null){
            cuenta = 0;
            codZona = lectura.split("_")[0];
            nomZona = lectura.split("_")[1];
            prezoM2 = Integer.parseInt(lectura.split("_")[2]);
            System.out.println("codz: " + codZona + ", nomz: " + nomZona + ", prezoM2: " + prezoM2);
            numeroTotalPisos = getCodPiso(con, codZona, prezoM2);
            System.out.println(
                    "Numero pisos da zona " + 
                            nomZona + 
                            ": " + numeroTotalPisos +
                            " = " + cuenta + "\n"                          
            );
            // escribimos el serializado
            obxW.writeObject(new Listaz2(codZona, nomZona, cuenta));
        }
        obxW.writeObject(null);
        lecBuf.close();
        obxW.close();
        con.close();
    }
    
    public void leeSerializado(String rutaSerializado) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream lec = null;
        Listaz2 obx = null;

        lec = new ObjectInputStream(new FileInputStream(rutaSerializado));
        
        do{
            obx = (Listaz2) lec.readObject();
            if(obx != null){
                System.out.println(obx.toString());
            }
            else{
                System.out.println("Objeto nulo");
            }
        }while(obx != null);
            
        lec.close();

    }
    
    public int getCodPiso(Connection con, String codZona, int prezoM2) throws SQLException, SQLException{
        String select = "select codp from propiedades where codz = ?";
        PreparedStatement ps = con.prepareStatement(select);
        
        ps.setString(1, codZona);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            getCostePiso(con,rs.getString("codp"), prezoM2);
        }
        
        ps.close();
        return getTotalPisos(con, codZona);
    }
    
    public void getCostePiso(Connection con, String codPiso, int prezoM2) throws SQLException{
        String select = "select m2,ano from pisos where codp = ?";
        PreparedStatement ps = con.prepareStatement(select);
        int coste;
        int ano, resta;
        ps.setString(1, codPiso);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            ano = 2023 - rs.getInt("ano");
            if (ano>30){
                resta = 20000;
            } else if(ano > 20 && ano <= 30){
                resta = 10000;
            } else if(ano > 10 && ano <= 20){
                resta = 5000;
            } else{
                resta = 0;
            }
            coste = (rs.getInt("m2")*prezoM2 - resta);
            cuenta += coste;
            System.out.println(codPiso + ", m2: " +  rs.getInt("m2") + ", prezo piso: " + coste);
            
        }
        ps.close();
    }
    
    public int getTotalPisos(Connection con, String codZona) throws SQLException{
        int pisos;
        String select = "select count(*) from propiedades where codz = ?";
        PreparedStatement ps = con.prepareStatement(select);
        
        ps.setString(1, codZona);
        
        ResultSet rs = ps.executeQuery();
        
        rs.next();
        
        pisos = rs.getInt(1);
        
        ps.close();
        return pisos;
    }
    
}
