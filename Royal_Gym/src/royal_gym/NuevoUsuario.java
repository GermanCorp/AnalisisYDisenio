/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public void nuevoUser(String User, String Pass)
    {
        try {
            String sql = "Insert into Login (usuario, contraseña) values (?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, User);
            consulta.setString(2, Pass);
            consulta.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 }
    
