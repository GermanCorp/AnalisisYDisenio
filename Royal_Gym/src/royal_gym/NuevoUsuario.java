package royal_gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

public class NuevoUsuario 
{
     private Connection conexion;
    private static Statement statement;
    static ResultSet resultado;
    
    public String formatearNumero(double numero) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(numero);
    }
    
    //metodo para insertar un nuevo usuario a la base de datos
    public void nuevoUser(String nombre,String User, String Pass,String PreguntaA,String PreguntaB ) {
        try {
            String sql = "insert into login (nombre,usuario, contraseña,cual es el nombre de tu mascota,cual es el nombre de tu madre) values (?,?,?,?,?)";
            Connection con = DriverManager.getConnection("jdbc:sqlite:gimnasio.db");
            PreparedStatement consulta = con.prepareStatement(sql);
            consulta.setString(1, nombre);
            consulta.setString(2, User);
            consulta.setString(3,Pass);
            consulta.setString(4, PreguntaA);
            consulta.setString(5, PreguntaB);
            consulta.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
}
    
}
