package produtosjava;

import java.sql.*;


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
        String busqueda = "select *, (ci).* from produtos";
        ResultSet obxRes = obxStatement.executeQuery(busqueda);
        
        String codigo,descricion, cidade;
        int prezo, cp;
        
        
        while(obxRes.next()){
            codigo = obxRes.getString("codigo");
            descricion = obxRes.getString("descripcion");
            prezo = obxRes.getInt("prezo");
            cidade = obxRes.getString("cidade");
            cp = obxRes.getInt("cp");
            
            System.out.println(codigo + ", " + descricion + ", " + prezo + ", " + cidade + ", " + cp);
        }
        
        obxStatement.close();
    }
    
    
    public void engadir(Connection conn, String codigo, String desc, int prezo, String cidade, int cp) throws SQLException{
        String insert = "insert into produtos(codigo,descripcion, prezo, ci.cidade, ci.cp) VALUES(?,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(insert);
        
        statement.setString(1, codigo);
        statement.setString(2, desc);
        statement.setDouble(3, prezo);
        statement.setString(4, cidade);
        statement.setInt(5, cp);
        
        statement.executeUpdate();
        
        statement.close();
        
        System.out.println("Insert añadido");

    }
    
     public void modificar(Connection conn, String codigo, String cidade) throws SQLException{
        String busqueda = "UPDATE produtos set ci.cidade = ? where codigo=?";
        PreparedStatement statement = conn.prepareStatement(busqueda);
        
        statement.setString(1, cidade);
        statement.setString(2, codigo);
        
        statement.executeUpdate();
        
        statement.close();
        System.out.println("Modificado");
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
