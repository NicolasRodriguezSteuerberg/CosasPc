package baerelacionalb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
    
    public void listadoCompleto(Connection conn) throws SQLException{
        Statement obxStatement = conn.createStatement();
        String busqueda = "select * from produtos";
        ResultSet obxRes = obxStatement.executeQuery(busqueda);
        
        String codigo,descricion;
        int prezo;
        Date data;
        
        while(obxRes.next()){
            codigo = obxRes.getString("codigo");
            descricion = obxRes.getString("descricion");
            prezo = obxRes.getInt("prezo");
            data = obxRes.getDate("datac");
            System.out.println(codigo + ", " + descricion + ", " + prezo + ", " + data);
        }
        
        obxStatement.close();
    }
    
    public void modificar(Connection conn, String codMod, int prezMod) throws SQLException{
        Statement obxStatement = conn.createStatement(
                                  ResultSet.TYPE_SCROLL_INSENSITIVE,
                                  ResultSet.CONCUR_UPDATABLE);
        String busqueda = "select * from produtos";
        ResultSet obxRes = obxStatement.executeQuery(busqueda);
        
        String codigo;
        obxRes.beforeFirst();
        while(obxRes.next()){
            if(obxRes.getString("codigo").equals(codMod)){
                obxRes.updateInt("prezo", prezMod);
                obxRes.updateRow();
                System.out.println("Precio cambiado de " + obxRes.getString("codigo") + " a " + prezMod);
            }
        }        
        obxStatement.close();
    }
    
    public void engadir(Connection conn, String codEng, String descEng, int prezEng) throws SQLException{
        Statement obxStatement = conn.createStatement(
                                  ResultSet.TYPE_SCROLL_INSENSITIVE,
                                  ResultSet.CONCUR_UPDATABLE);
        String busqueda = "select * from produtos";
        ResultSet obxRes = obxStatement.executeQuery(busqueda);

        obxRes.moveToInsertRow();
                
        obxRes.updateString("codigo", codEng);
        obxRes.updateString("descricion", descEng);
        obxRes.updateInt("prezo", prezEng);
                
        obxRes.insertRow();
     
        obxStatement.close();
    }
    
    public void borrar(Connection conn, String codBorrar) throws SQLException{
        Statement obxStatement = conn.createStatement(
                                  ResultSet.TYPE_SCROLL_INSENSITIVE,
                                  ResultSet.CONCUR_UPDATABLE);
        String busqueda = "select * from produtos";
        ResultSet obxRes = obxStatement.executeQuery(busqueda);
        
        while(obxRes.next()){
            if(obxRes.getString("codigo").equals(codBorrar)){
                obxRes.deleteRow();
            }
            
        }
        
        obxStatement.close();
    }
    
}
