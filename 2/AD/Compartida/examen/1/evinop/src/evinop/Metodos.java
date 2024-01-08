package evinop;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
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
        
        Connection con = DriverManager.getConnection(url,usuario,password);
        
        return con;
    }
    
    
    public void leerAnalisis(Connection con, String rutaTxt, String rutaSerializado) throws FileNotFoundException, IOException, SQLException, ClassNotFoundException{
        BufferedReader lec = null;
        String uvas[];
        try {
            lec = new BufferedReader(new FileReader(rutaTxt));
            String lectura = null;
            String codigoA = null;
            String tipoUva = null;
            String nombreUva = null;
            String tratAcidez = null;;
            String dniC = null;
            int acidez;
            ArrayList <Xerado> lista = new ArrayList();
            int total = 0;
            while((lectura=lec.readLine())!= null){
                String[] analisis=lectura.split(",");
                
                codigoA = analisis[0];
                acidez = Integer.parseInt(analisis[1]);
                tipoUva = analisis[4];
                total = Integer.parseInt(analisis[5]) * 15;
                dniC = analisis[6];
                uvas = leerUvas(con, tipoUva, acidez);
                nombreUva = uvas[0];
                tratAcidez = uvas[1];
                lista.add(new Xerado(codigoA, nombreUva, tratAcidez, total));
                aumentarNumAnalisis(con, dniC);
            }
            escribirSerializado(rutaSerializado, lista);
            leerSerializado(rutaSerializado);
        }finally{
            try {
                lec.close();
            } catch (IOException ex) {
                System.out.println("Error cerrar esc");
            }
        }
    }
    
    public String[] leerUvas(Connection con, String tipoUva, int acidez) throws SQLException{
        String select = "select * from uvas where tipo=?";
        PreparedStatement ps = con.prepareStatement(select);
        
        ps.setString(1, tipoUva);
        
        ResultSet rs = ps.executeQuery();
        
        rs.next();
        
        String nombreUva = rs.getString("nomeu");
        
        int acidezmin = rs.getInt("acidezmin");
        int acidezmax = rs.getInt("acidezmax");
        
        String tratAcidez;
        if(acidez > acidezmax){
            tratAcidez = "BajarAcidez";
        } else if(acidez < acidezmin){
            tratAcidez = "SubirAcidez";
        } else {
            tratAcidez = "equilibrado";
        }
        
        String uvas[] = {nombreUva, tratAcidez};
        
        ps.close();
        
        return uvas;
    }
    
    public void escribirSerializado(String rutaSerializado, ArrayList <Xerado> lista) throws FileNotFoundException, IOException{
        
        FileOutputStream obxOS = new FileOutputStream(rutaSerializado, false);
        ObjectOutputStream obxW = new ObjectOutputStream(obxOS);
        Xerado obxX = null;
        
        for (int i = 0; i < lista.size(); i++){
            obxW.writeObject(lista.get(i));
        }
        
        obxW.writeObject(obxX);
        
        obxW.close();
        
    }
    
    public void leerSerializado(String rutaSerializado) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream lec = null;
        Xerado obxX = null;

        lec = new ObjectInputStream(new FileInputStream(rutaSerializado));
        
        do{
            obxX = (Xerado) lec.readObject();
            if(obxX != null){
                System.out.println(obxX.getNum() + "-" + obxX.getNomeuva() + "-" + obxX.getTratacidez() + "-" + obxX.getTotal());
            }
        }while(obxX != null);
            
        lec.close();
    }
    
    public void aumentarNumAnalisis(Connection con, String dni) throws SQLException{
        String update = "update clientes SET numerodeanalisis = numerodeanalisis + 1 where dni = ?";
        PreparedStatement ps = con.prepareStatement(update);
        
        ps.setString(1, dni);
        
        int verificacion = ps.executeUpdate();
        
        ps.close();
    }
}
