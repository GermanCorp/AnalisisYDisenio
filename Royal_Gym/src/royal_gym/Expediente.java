/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package royal_gym;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static royal_gym.Pagos.resultado;

/**
 *
 * @author Jazmin Vargas
 */
public class Expediente {
    private static Statement statement;
    static ResultSet resultado;
    
   
    public void insertarProblemasdeSalud(String problema) {
        try {
            String sql = "insert into Pagos(cliente) values(?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            
            consulta.setString(1, problema);
            consulta.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }// fin de insertar pago
    
    
    public void insertarCambiosCorporales(String peso,String imc, String grasa, String musculo,String calorias, String edad, String grasaviceral) {
        try {
            String sql = "insert into cambioscorporales(peso, imc, porcentajedegrasa , porcentajedemusculo, calorias, edad , grasaviceral) values(?,?,?,?,?,?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            
            consulta.setString(1, peso);
            consulta.setString(2, imc);
            consulta.setString(3, grasa);
            consulta.setString(4, musculo);
            consulta.setString(5, calorias);
            consulta.setString(6, edad);
            consulta.setString(7, grasaviceral);
            consulta.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }// fin de insertar pago

     public Object[][] getCambios() {
        Object[][] datosPago = null;

        try {
            String consulta = "SELECT peso,imc,porcentajedegrasa,porcentajedemusculo,calorias,edad,grasaviceral"
                    + "FROM cambioscorporales  ";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);
            
             ArrayList<Object[]> filas = new ArrayList<>();
             for( int i= 0; i<filas.size(); i++)
            
                while (resultado.next()) {
                    filas.add(
                    new Object[]{
                    resultado.getDouble("peso"),
                    resultado.getDouble("imc"),
                    resultado.getDouble("porcentajedegrasa"),
                    resultado.getDouble("porcentajedemusculo"),
                    resultado.getDouble("calorias"),
                    resultado.getInt("edad"),
                    resultado.getInt("grasaviceral"),}
                     );
            }  
            //i - i+1
            datosPago = new Object[filas.size()][];
            filas.toArray(datosPago);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosPago;
    }
    
}//order by id_cambio DESC
