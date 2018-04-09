package royal_gym;

import java.sql.Connection;
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
    
    public void nuevoUser(String User, String Pass) {
        try {
            String sql = "insert into login (usuario, contraseña) values (?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, User);
            consulta.setString(2, Pass);
            consulta.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
