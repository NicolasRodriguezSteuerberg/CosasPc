package pasaxeirosvoosserializadooracle_3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Metodos {
    
    public Connection conexion() throws SQLException{
        String driver = "jdbc:postgresql:";
        String host = "//localhost:";
        String porto = "5432";
        String sid = "postgres";
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host+ porto + "/" + sid;
        
        java.sql.Connection conn = DriverManager.getConnection(url,usuario,password);
        
        return conn;
    }
    
    public void lecturaSerializada(String ruta, Connection con) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        ObjectInputStream lec = null; 
        Reserva obx = null;
        String dni;

        lec = new ObjectInputStream(new FileInputStream(ruta));
        
        do{
            obx = (Reserva) lec.readObject();
            if(obx != null){
                System.out.println(obx.toString());
                aumentoNReserva(obx.getDni(),con);
                reservaFeita(con, obx.getCodr(), obx.getDni(),obx.getIdvooida(), obx.getIdvoovolta());
            }
            else{
                System.out.println("Objeto nulo");
            }
        }while(obx != null);
            
        lec.close();
    }
    
    public void aumentoNReserva(String dni, Connection con) throws SQLException{
        String update = "update pasaxeiros SET nreservas = ? where dni = ?";
        PreparedStatement ps = con.prepareStatement(update);
        
        ps.setInt(1, (cogerNReserva(dni, con) + 1));
        ps.setString(2, dni);
        
        int verificacion = ps.executeUpdate();
        if(verificacion == 0){
            System.out.println("Error: Pasaxeiro no encontrado o modificacion no permitida");
        } else{
            System.out.println("Modificacion exitosa");
        }
        
        ps.close();
        
    }
    
    public int cogerNReserva(String dni, Connection con) throws SQLException{
        // primero cogemos el n de reserva
        String select = "select nreservas from pasaxeiros where dni=?";
        PreparedStatement ps = con.prepareStatement(select);
        
        ps.setString(1, dni);
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        
        int nreservas = rs.getInt("nreservas");
        
        ps.close();
        return nreservas;
    }
    
    public void reservaFeita(Connection con, int codr, String dni, int idIda, int idVolta) throws SQLException{
        String insert = "insert into reservasfeitas(codr, dni, nome, prezoreserva) values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(insert);
        
        ps.setInt(1, codr);
        ps.setString(2, dni);
        ps.setString(3, nombrePasaxeiro(con, dni));
        ps.setInt(4, (prezoVoo(con,idIda) + prezoVoo(con,idVolta)) );
        
        ps.executeUpdate();
        
        System.out.println("Insert añadido");
    }
    
    public int prezoVoo(Connection con, int id) throws SQLException{
        String select = "select prezo from voos where voo=?";
        PreparedStatement ps = con.prepareStatement(select);
        
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        
        int prezo = rs.getInt("prezo");
        
        ps.close();
        return prezo;
    }
    
    public String nombrePasaxeiro(Connection con, String dni) throws SQLException{
        String select = "select nome from pasaxeiros where dni=?";
        PreparedStatement ps = con.prepareStatement(select);
        
        ps.setString(1, dni);
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        
        String nombre = rs.getString("nome");
        
        ps.close();
        return nombre;
    }
    
}
