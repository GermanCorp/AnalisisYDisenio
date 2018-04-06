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
import static royal_gym.Pagos.resultado;

/**
 *
 * @author Jazmin Vargas
 */
public class Expediente {
    private static Statement statement;
    static ResultSet resultado;
    
   
    
     
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
    
    
    public void insertarCambiosCorporales(String peso,String imc, String grasa, String musculo,
            String calorias, String edad, String grasaviceral) {
        try {
            String sql = "insert into cambioscorporales(peso, imc, grasa , musculo, calorias, edad , grasaviceral) values(?,?,?,?,?,?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            
            consulta.setString(1, peso);
            consulta.setString(1, imc);
            consulta.setString(1, grasa);
            consulta.setString(1, musculo);
            consulta.setString(1, calorias);
            consulta.setString(1, edad);
            consulta.setString(1, grasaviceral);
             
            consulta.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }// fin de insertar pago

     public Object[][] getCambios() {
        Object[][] datosPago = null;

        try {
            String consulta = "SELECT peso,imc,porcentajedegrasa,porcentajedemusculo,calorias,edad,grasaviceral  FROM cambioscorporales order by id_cambio DESC ";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);
            String numeroLista = "";

            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                    new Object[]{
                    numeroLista,
                    resultado.getString("peso"),
                    resultado.getString("imc"),
                    resultado.getString("porcentajedegrasa"),
                    resultado.getString("porcentajedemusculo"),
                    resultado.getString("calorias"),
                    resultado.getString("edad"),
                    resultado.getString("grasaviceral"),}
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