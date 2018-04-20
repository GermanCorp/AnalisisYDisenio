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
    public void nuevoUser(String nombre,String User, String Pass ) {
        try {
            String sql = "insert into login (nombre,usuario, contraseña) values (?,?,?)";
            Connection con = DriverManager.getConnection("jdbc:sqlite:gimnasio.db");
            PreparedStatement consulta = con.prepareStatement(sql);
            consulta.setString(1, nombre);
            consulta.setString(2, User);
            consulta.setString(3,Pass);
            consulta.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
}
    
}
