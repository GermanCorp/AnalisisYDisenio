
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
    int contador = 0;
    
   
    public void insertarProblemasdeSalud(
        boolean gastritis,
        boolean colitis,
        boolean estreñimiento,
        boolean ulcera,
        boolean cansancio,
        boolean diabetes,
        boolean presionAlta,
        boolean colesterol,
        boolean alergias,
        boolean estres,
        boolean dolordecabeza,
        boolean dolordecuello,
        boolean doloresdeespalda,
        boolean artritis,
        boolean ansiedad,
        boolean embarazo,
        boolean retencionliquidos,
        boolean malacirculacion,
        boolean calambres,
        boolean varices,
        boolean doloresdehueso,
        boolean anemia,
        boolean problemadevesicula,
        boolean problemaderiñon,
        boolean celulitis) {
        
        try {
            String sql = "insert into problemasdesalud(Gastritis,Colitis,Estreñimiento,Ulcera,Cansancio,Diabetes,PresionAlta,"
                    + "Colesterol,Alergias,Estres,Dolordecabeza,Dolordecuello,Doloresdeespalda,Artritis,Ansiedad,EmbarazoLactancia,"
                    + "Retenciondeliquidos,Malacirculacion,Calambres,Varices,Doloresdehueso,Anemia,ProblemadeVesicula,Problemaderiñon,Celulitis)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            
 
            consulta.setBoolean(1, gastritis);
            consulta.setBoolean(2, colitis);
            consulta.setBoolean(3, estreñimiento);
            consulta.setBoolean(4, ulcera);
            consulta.setBoolean(5, cansancio);
            consulta.setBoolean(6, diabetes);
            consulta.setBoolean(7, presionAlta);
            consulta.setBoolean(8,  colesterol);
            consulta.setBoolean(9,  alergias);
            consulta.setBoolean(10, estres);
            consulta.setBoolean(11, dolordecabeza);
            consulta.setBoolean(12,  dolordecuello);
            consulta.setBoolean(13, doloresdeespalda);
            consulta.setBoolean(14, artritis);
            consulta.setBoolean(15, ansiedad);
            consulta.setBoolean(16, embarazo);
            consulta.setBoolean(17, retencionliquidos);
            consulta.setBoolean(18, malacirculacion);
            consulta.setBoolean(19, calambres);
            consulta.setBoolean(20, varices);
            consulta.setBoolean(21, doloresdehueso);
            consulta.setBoolean(22, anemia);
            consulta.setBoolean(23, problemadevesicula);
            consulta.setBoolean(24, problemaderiñon);
            consulta.setBoolean(25, celulitis);
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
                    + "FROM cambioscorporales order by id_cambio DESC ";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);
            
             ArrayList<Object[]> filas = new ArrayList<>();
            {
                
                while (resultado.next()) {
                    
                    filas.add(
                    new Object[]{
                    resultado.getDouble("peso"),
                    resultado.getDouble("imc"),
                    resultado.getDouble("porcentajedegrasa"),
                    resultado.getDouble("porcentajedemusculo"),
                    resultado.getDouble("calorias"),
                    resultado.getInt("edad"),
                    resultado.getInt("grasaviceral"),} );
                  
                    datosPago = new Object[filas.size()][];
                    filas.toArray(datosPago);} 
            }
        } catch (Exception e) {
        }
        return datosPago;
    }
    
}
