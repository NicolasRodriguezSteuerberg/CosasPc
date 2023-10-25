package exa15brevep;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
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
        
        Connection conn = DriverManager.getConnection(url,usuario,password);
        
        return conn;
    }
    
    public void lecturaSerializada(String ruta) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        Connection con = conexion();
        ObjectInputStream lec = null;
        Platos obx = null;

        lec = new ObjectInputStream(new FileInputStream(ruta));
        
        do{
            obx = (Platos) lec.readObject();
            if(obx != null){
                System.out.println(obx.getCodigop() + "\n" + obx.getNomep());
                lecturaDatos(con,obx.getCodigop());
            }
            else{
                System.out.println("Objeto nulo");
            }
        }while(obx != null);
            
        lec.close();
    }
    
    public void lecturaDatos(Connection con,String codp) throws SQLException{
        int peso;
        int graxa;
        String codc;
        String select = "select codc,peso from composicion where codp=?";
        PreparedStatement ps = con.prepareStatement(select);
                
        ps.setString(1, codp);
        
        ResultSet rs = ps.executeQuery();
        int graxa_total = 0;
        while(rs.next()){
            peso = rs.getInt("peso");
            codc = rs.getString("codc");
            
            select = "select graxa from componentes where codc=?";
            ps = con.prepareStatement(select);
        
            ps.setString(1, codc);
        
            ResultSet rs2 = ps.executeQuery();
    
            rs2.next();
            graxa = rs2.getInt("graxa");
            graxa_total+=(peso/100*graxa);
            
        }
        System.out.println("graxatotal: " + graxa_total);
        
    }
}
