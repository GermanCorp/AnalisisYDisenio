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

/**
 *
 * @author Jazmin Vargas
 */
public class Compras {
    
    private Connection conexion;
    private Statement statement; 
    private ResultSet resultado;
    
   
    public void actualizarInventario(String valor, String nombre){
        try{
        String consulta = ("UPDATE invetarioProducto set cantidad ='"+ valor +"' where producto ='"+ nombre +"'");
            PreparedStatement statement = Conexion.getConexion().prepareStatement(consulta); 
            
           statement.executeUpdate();
        
        
        } catch (Exception e) {
            System.out.println("buscar:" + e.getMessage());
        }
     }
    
    

    
    
}
