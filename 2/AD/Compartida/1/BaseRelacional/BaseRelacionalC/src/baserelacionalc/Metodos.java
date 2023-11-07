package baserelacionalc;

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
    
    public void insert(Connection conn, String codigo, String descricion, int prezo) throws SQLException{
        String insert = "insert into produtos(codigo, descricion, prezo) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(insert);
        
        ps.setString(1, codigo);
        ps.setString(2, descricion);
        ps.setInt(3, prezo);
        
        ps.executeUpdate();
        
        System.out.println("Insert añadido");
    }
    
    public void update(Connection conn, String codigo, String descricion) throws SQLException{
        String update = "update produtos SET descricion = ? where codigo = ?";
        PreparedStatement ps = conn.prepareStatement(update);
        
        ps.setString(1, descricion);
        ps.setString(2, codigo);
        
        int verificacion = ps.executeUpdate();
        if(verificacion == 0){
            System.out.println("Error: Produto no encontrado o modificacion no permitida");
        } else{
            System.out.println("Modificacion exitosa");
        }
        
        ps.close();
    }
    
    public void select(Connection conn) throws SQLException{
        String select = "select * from produtos";
        PreparedStatement ps = conn.prepareStatement(select);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            System.out.println(rs.getString("codigo") + " "
                    + rs.getString("descricion") + " "
                            + rs.getInt("prezo"));
        }
        
        ps.close();
    }
    
}
