package pasaxeirovosdelimitado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;


public class Metodos {
    
    public Connection conexion() throws SQLException{
        String driver = "jdbc:postgresql:";
        String host = "//localhost:";
        String porto = "5432";
        String sid = "postgres";
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host+ porto + "/" + sid;
        
        java.sql.Connection con = DriverManager.getConnection(url,usuario,password);
        
        return con;
    }
    
    public void lerReservas(Connection con, String ruta) throws IOException, SQLException{
        BufferedReader lec = new BufferedReader(new FileReader(ruta));
        String lectura = null;
        while((lectura=lec.readLine())!= null){
            String  lecturas[] = lectura.split(",");
            /*
                0 -> codr
                1 -> dni
                2 -> idvooida
                3 -> idvoovolta
            */
            facerReservaBD(con,lecturas);
            
        }
    }
    
    public void facerReservaBD(Connection con, String lecturas[]) throws SQLException{
        String insert = "insert into reservasfeitas(codr, dni, nome, prezoreserva) values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(insert);
        
        ps.setInt(1, Integer.parseInt(lecturas[0]));
        ps.setString(2, lecturas[1]);
        ps.setString(3, getNome(con, lecturas[1]));
        ps.setInt(4, (getPrezoVoo(con,Integer.parseInt(lecturas[2])) + getPrezoVoo(con,Integer.parseInt(lecturas[3]))) );
        
        ps.executeUpdate();
        
        increaseReservaPasaxeiro(con, lecturas[1]);
        
        System.out.println("Insert añadido");
    }
    
    public void increaseReservaPasaxeiro(Connection con, String dni) throws SQLException{
        String update = "update pasaxeiros SET nreservas = nreservas + 1 where dni = ?";
        PreparedStatement ps = con.prepareStatement(update);
        
        ps.setString(1, dni);
        
        int verificacion = ps.executeUpdate();
        if(verificacion == 0){
            System.out.println("Error: Pasaxeiro no encontrado o modificacion no permitida");
        } else{
            System.out.println("Reserva en pasaxeiro aumentado");
        }
        
        ps.close();
    }
    
    public String getNome(Connection con, String dni) throws SQLException{
        String select = "select nome from pasaxeiros where dni=?";
        PreparedStatement ps = con.prepareStatement(select);
        
        ps.setString(1, dni);
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        
        String nombre = rs.getString("nome");
        
        ps.close();
        return nombre;
    }
    
    public int getPrezoVoo(Connection con, int id) throws SQLException{
        String select = "select prezo from voos where voo=?";
        PreparedStatement ps = con.prepareStatement(select);
        
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        
        int prezo = rs.getInt("prezo");
        
        ps.close();
        return prezo;
    }
    
    
}
