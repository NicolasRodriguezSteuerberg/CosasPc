package postgressql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NSteuerberg
 */
public class ConexionSQL {
    Connection obxConectar = null;
    java.sql.Statement obxStatement;
    ResultSet obxResultado;
    
    
    String url="jdbc:postgresql://localhost:5432/prueba"; 
    //local -> ip de nuestro servidor
    //exemploBD -> el nombre de la base de datos
    
    String user="postgres"; //usuario de la base de datos
    String password="postgres";//su contraseña
    

    public Connection conectar(){
        //returno un String para poder mandar un mensaje de si se pudo conectar 
        //o no en la UI (podría ser void mismamente)
        try{
            Class.forName("org.postgresql.Driver");
            obxConectar = DriverManager.getConnection(url,user,password);
            
        }catch(Exception e){
            System.out.println("Error");
        }
        return obxConectar;
    }
    
    public void cerrarConexion(){
        //devuelvo un String por la misma razón que antes
        try{
            obxConectar.close();//Cerrar la conexión
            System.out.println("Desconexión exitosa");
        }catch(Exception e){
            System.out.println("Desconexión errónea");
        }
    }
    
    
    public String insertarLibros(int id, String titulo){
        try{
            Connection conexion = conectar();
            obxStatement = obxConectar.createStatement();
            String insert = "insert into libros values(" + id + ",'"+ titulo + "');";
            obxStatement.execute(insert);//Ejecuta en la base de datos, insertando el libro
            obxStatement.close();
            conexion.close();            
            return "Insert añadido";
        }catch(Exception e){
            return "Insert fallido";
        }
    }
    
    /**
     * 
     * @param id
     * @param tabla 
     */
    public void selectLibrosID(int id, JTable tabla,JLabel texto){
        eliminarFilas(tabla);
        try {
            conectar();
            obxStatement = obxConectar.createStatement();
            String busqueda = "select * from libros where id=" + id + ";";
            obxResultado = obxStatement.executeQuery(busqueda);
            while(obxResultado.next()){
                Object[] fila = {obxResultado.getString("id"), obxResultado.getString("titulo")};
                DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                model.addRow(fila);
            }
        } catch (SQLException ex) {
            texto.setText("Error en la busqueda");
            texto.setVisible(true);
        }
    }
    
    public void selectLibrosTitulo(String titulo, JTable tabla,JLabel texto){
        eliminarFilas(tabla);
        try {
            conectar();
            obxStatement = obxConectar.createStatement();
            String busqueda = "select * from libros where titulo='" + titulo + "';";
            obxResultado = obxStatement.executeQuery(busqueda);
            while(obxResultado.next()){
                Object[] fila = {obxResultado.getString("id"), obxResultado.getString("titulo")};
                DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                model.addRow(fila);
            }
        } catch (SQLException ex) {
            texto.setText("Error en la busqueda");
            texto.setVisible(true);
        }
    }
    
    public void selectLibros(JTable tabla, JLabel texto){
        eliminarFilas(tabla);
        try {
            conectar();
            obxStatement = obxConectar.createStatement();
            String busqueda = "select * from libros;";
            obxResultado = obxStatement.executeQuery(busqueda);
            while(obxResultado.next()){
                Object[] fila = {obxResultado.getString("id"), obxResultado.getString("titulo")};
                DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                model.addRow(fila);
            }
        } catch (SQLException ex) {
            texto.setText("Error en la busqueda");
            texto.setVisible(true);
        }
    }
    
    public void eliminarFilas(JTable tabla){
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        for(int i=0;i<tabla.getRowCount();i++){
            model.removeRow(i);
        }
    }
    
}
