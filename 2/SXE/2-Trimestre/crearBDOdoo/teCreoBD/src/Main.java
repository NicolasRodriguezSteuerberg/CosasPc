import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        String driver = "jdbc:postgresql:"; // Tipo de driver
        String host = "//localhost:"; // Host
        String porto = "5432"; // Puerto
        String url = driver + host + porto + "/";
        String nombreBaseDatos = "odoo"; // Nombre de la nueva base de datos
        String usuario = "postgres"; // Usuario de la base de datos
        String contraseña = "postgres"; // Contraseña del usuario

        Connection connection = null;
        Statement statement = null;

        try {
            // Establecer la conexión
            connection = DriverManager.getConnection(url, usuario, contraseña);

            // Crear una declaración
            statement = connection.createStatement();

            // Crear la nueva base de datos
            String sql = "CREATE DATABASE " + nombreBaseDatos;
            statement.executeUpdate(sql);

            System.out.println("Base de datos creada con éxito.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}