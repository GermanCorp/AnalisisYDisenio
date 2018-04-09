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
import javax.swing.JDialog;
import static royal_gym.Pagos.resultado;

/**
 *
 * @author Jazmin Vargas
 */
public class Expediente {
    private static Statement statement;
    static ResultSet resultado;

  
   /*  
    // método para insertar pagos a la base de datos
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
    */
    
    public void insertarCambiosCorporales(String peso,String imc, String grasa, String musculo,String calorias, String edad, String grasaviceral) {
        try {
            String sql = "insert into cambioscorporales(peso, imc, porcentajedegrasa , porcentajedemusculo, edad , grasaviceral,calorias) values(?,?,?,?,?,?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            
            consulta.setString(1, peso);
            consulta.setString(2, imc);
            consulta.setString(4, grasa);
                consulta.setString(5, musculo);
            consulta.setString(6, edad);
            consulta.setString(7, grasaviceral);
            consulta.setString(8, calorias);
            consulta.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }// fin de insertar pago

     public Object[][] getCambios() {
        Object[][] datosPago = null;

        try {
            String consulta = "SELECT peso,imc,porcentajedegrasa,porcentajedemusculo,calorias,edad,grasaviceral  FROM cambioscorporales ";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);
            //String numeroLista = "";

            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                    new Object[]{
                   // numeroLista,
                    resultado.getDouble("peso"),
                    resultado.getDouble("imc"),
                    resultado.getDouble("porcentajedegrasa"),
                    resultado.getDouble("porcentajedemusculo"),
                    resultado.getDouble("calorias"),
                    resultado.getInt("edad"),
                    resultado.getInt("grasaviceral"),}
                );
            }
            datosPago = new Object[filas.size()][];
            filas.toArray(datosPago);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosPago;
    }
    
}
