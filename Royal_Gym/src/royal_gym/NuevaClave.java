package royal_gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NuevaClave 
{
    static private Connection conexion;
    private static Statement statement;
    static ResultSet resultado;
    
    //conectarse a la base de datos
    public static void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:gimnasio.db");
            statement = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // método para cerrar la base de datos
    public static void cerrar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConexion(){
        return conexion;
    }
    
    public static void nuevaContra(String PreguntaA,String PreguntaB)
    {
        int resultado = 0;
        String SSQL = "SELECT * from Login Where Cual es el nombre de tu mascota = ? AND Cual es el nombre de tu madre = ?";
        Connection conect = null;
        
        try{
            conect = DriverManager.getConnection("jdbc:sqlite:gimnasio.db");
            PreparedStatement st = conect.prepareStatement(SSQL);
            
            st.setString(1, PreguntaA);
            st.setString(1, PreguntaB);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                resultado = 1;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            
        }finally{
            try{
                conect.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
    }
    
}
