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
    
    /**
     * insertar libros
     * @param id
     * @param titulo
     * @return retorna si el insert es fallido o si se añade
     */
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
     * Buscar libros el id
     * @param id -> el id a buscar
     * @param tabla -> tabla donde vamos a hacer inserts
     * @param texto -> le doy una etiqueta con texto solo para cuando haya errores poder notificarlos
     */
    public void selectLibrosID(int id, JTable tabla,JLabel texto){
        eliminarFilas(tabla);
        try {
            conectar();
            obxStatement = obxConectar.createStatement();
            
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            
            String busqueda = "select * from libros where id=" + id + ";";
            obxResultado = obxStatement.executeQuery(busqueda);
            while(obxResultado.next()){
                Object[] fila = {obxResultado.getString("id"), obxResultado.getString("titulo")};
                model.addRow(fila);
            }
            obxStatement.close();
            cerrarConexion();
            
            encontroSelect(model,texto);
        } catch (SQLException ex) {
            texto.setText("Error en la busqueda");
            texto.setVisible(true);
        }
        
    }
    
    /**
     * Buscar libros el titulo
     * @param titulo -> el titulo a buscar
     * @param tabla -> tabla donde vamos a hacer inserts
     * @param texto -> le doy una etiqueta con texto solo para cuando haya errores poder notificarlos
     */
    public void selectLibrosTitulo(String titulo, JTable tabla,JLabel texto){
        eliminarFilas(tabla);
        try {
            conectar();
            obxStatement = obxConectar.createStatement();
            
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            
            String busqueda = "select * from libros where titulo='" + titulo + "';";
            obxResultado = obxStatement.executeQuery(busqueda);
            while(obxResultado.next()){
                Object[] fila = {obxResultado.getString("id"), obxResultado.getString("titulo")};
                model.addRow(fila);
            }
            obxStatement.close();
            cerrarConexion();
            
            encontroSelect(model,texto);
            
        } catch (SQLException ex) {
            texto.setText("Error en la busqueda");
            texto.setVisible(true);
        }
    }
    
    /**
     * Buscar todos los libros
     * @param tabla -> tabla donde vamos a hacer inserts
     * @param texto -> le doy una etiqueta con texto solo para cuando haya errores poder notificarlos
     */
    public void selectLibros(JTable tabla, JLabel texto){
        eliminarFilas(tabla);
        try {
            conectar();
            obxStatement = obxConectar.createStatement();
            
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            
            String busqueda = "select * from libros;";
            obxResultado = obxStatement.executeQuery(busqueda);
            while(obxResultado.next()){
                Object[] fila = {obxResultado.getString("id"), obxResultado.getString("titulo")};
                model.addRow(fila);
            }
            obxStatement.close();
            cerrarConexion();
        } catch (SQLException ex) {
            texto.setText("Error en la busqueda");
            texto.setVisible(true);
        }
    }
    
    public void encontroSelect(DefaultTableModel model, JLabel texto){
        if(model.getRowCount()==0){
            texto.setText("Libros no encontrados");
            texto.setVisible(true);
        }
        else{
            texto.setVisible(false);
        }
    }
    
    /**
     * elimino las filas para que no se repitan las filas
     * @param tabla 
     */
    public void eliminarFilas(JTable tabla){
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        System.out.println(tabla.getRowCount());
        for(int i=(model.getRowCount()-1);i>=0;i--){
            model.removeRow(i);
        }
    }
    
    public void actualizarNombre(int ID, String nombreNuevo, JLabel errores, JLabel texto){
        try{
            conectar();
            obxStatement = obxConectar.createStatement();
            String busqueda = "update libros set titulo='" + nombreNuevo + "' where id=" + ID + ";";
            int numero = obxStatement.executeUpdate(busqueda);
            System.out.println(numero);
            if(numero==0){
                errores.setText("Libro no encontrado");
                errores.setVisible(true);
            }
            else{
                texto.setVisible(true);
            }
            obxStatement.close();
            cerrarConexion();
        }catch (Exception e){
            System.out.println("error en la actualizacion");
        }
    }
    
    public void borrarLibro(int ID, JLabel errores, JLabel texto){
        try{
            conectar();
            obxStatement = obxConectar.createStatement();
            String busqueda = "delete from libros where id=" + ID + ";";
            int numero = obxStatement.executeUpdate(busqueda);
            System.out.println(numero);
            if(numero==0){
                errores.setText("LIBRO NO ENCONTRADO");
                errores.setVisible(true);
            }
            else{
                texto.setVisible(true);
            }
            obxStatement.close();
            cerrarConexion();
        }catch (Exception e){
            System.out.println("error en el borrado");
        }
    }
    
}
