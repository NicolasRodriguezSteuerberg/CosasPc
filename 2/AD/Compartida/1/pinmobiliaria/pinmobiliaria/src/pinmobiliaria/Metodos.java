package pinmobiliaria;

import java.io.BufferedWriter;
import java.io.FileInputStream;
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
    String rutaEsc = null;
    
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
    
    public void leerSerializado(Connection con, String rutaSerializado, String rutaEsc) throws IOException, ClassNotFoundException, SQLException{
        ObjectInputStream lecStream = new ObjectInputStream(new FileInputStream(rutaSerializado));
        Listap obxClave = null;
        this.rutaEsc = rutaEsc;
        String nif, nomp;
        do{
            obxClave = (Listap) lecStream.readObject();
            if(obxClave!=null){
                nif = obxClave.getNifp();
                nomp = obxClave.getNomp();
                System.out.println(nif + ": " + nomp);
                leerPisos(con, nif);
            }
        }while(obxClave != null);
        lecStream.close();
    }
    
    public void leerPisos(Connection con, String nif) throws SQLException, IOException{
        String select = "select m2, codz from pisos where nif = ?";
        // creamos el statement
        PreparedStatement ps = con.prepareStatement(select);
        // añadimos la variable a la sentencia
        ps.setString(1, nif);
        
        ResultSet rs = ps.executeQuery();
        int m2, prezom2;
        int sumatotal = 0;
        int numeroPisos = 0;
        int prezoParcial;
        
        while(rs.next()){
            m2 = rs.getInt("m2");
            prezom2 = getPrezoM2(con, rs.getString("codz"));
            prezoParcial = prezom2 * m2;
            sumatotal += prezoParcial;
            System.out.println("\tMetros cuadrados: " + m2 + ", codz: " + rs.getString("codz") + ", prezoM2: " + prezom2 + ", prezo parcial: " + prezoParcial);
            numeroPisos++;
        }
        System.out.println("\tNumero de pisos: " + numeroPisos + ", Prezo total dos seus pisos: " + sumatotal + "\n");
        escribirDelimitado(nif, numeroPisos, sumatotal);
    }
    
    
    public int getPrezoM2(Connection con, String codz) throws SQLException{
        String select = "select prezom2 from zonas where codz = ?";
        
        PreparedStatement ps = con.prepareStatement(select);
        
        ps.setString(1, codz);
        
        ResultSet rs = ps.executeQuery();
        
        rs.next();
        
        int prezom2 = rs.getInt("prezom2");
        
        return prezom2;
    }
    
    
    public void escribirDelimitado(String nif, int numeroPisos, int sumatotal) throws IOException{
        PrintWriter esc =  new PrintWriter(new BufferedWriter(new FileWriter(rutaEsc,true)));
        esc.println(nif + ">"+numeroPisos+">"+sumatotal);
        esc.close();
    }
}
