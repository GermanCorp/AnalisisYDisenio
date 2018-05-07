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

/**
 *
 * @author Jazmin Vargas
 */
public class Proveedores {
    
      
    private static Statement statement;
    static ResultSet resultado;
    
      
    // método para insertar pagos a la base de datos
    public void insertarProveedores(String nombre, String cuentaBancaria, String telefono , String tipoProveedor, String correo, String direccion,String contacto,String telefonoContacto) {
        try {
            String sql = "insert into proveedores(Nombre, CuentaBancaria, Telefono , TipoDeProveedor, Correo, Direcion, Contacto, TelefonoContacto ) values(?,?,?,?,?,?,?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            
            consulta.setString(1, nombre);
            consulta.setString(2, cuentaBancaria);
            consulta.setString(3, telefono);
            consulta.setString(4, tipoProveedor);
            consulta.setString(5, correo);
            consulta.setString(6, direccion);
            consulta.setString(7, contacto);
            consulta.setString(8, telefonoContacto);
            consulta.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }// fin de insertar pago
    
    
    // método para llenar la tabla de pagos
    public Object[][] getProveedor() {
        Object[][] datos = null;

        try {
            String consulta = "SELECT Nombre, CuentaBancaria, Telefono , TipoDeProveedor, Correo, Direcion, Contacto, TelefonoContacto  FROM proveedores order by Nombre ASC ";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);
            int numeroLista = 1;

            ArrayList<Object[]> filas = new ArrayList<>();
            while (resultado.next()) {
                filas.add(
                    new Object[]{
                    numeroLista++,
                    resultado.getString("Nombre"),
                    resultado.getString("CuentaBancaria"),
                    resultado.getString("Telefono"),
                    resultado.getString("TipoDeProveedor"),
                    resultado.getString("Correo"),
                    resultado.getString("Direcion"),
                    resultado.getString("Contacto"),
                    resultado.getString("TelefonoContacto"),
                    }
                );
                
            }
            datos = new Object[filas.size()][];
            filas.toArray(datos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
    
  
    
    //metodo para buscar en la tabla pagos
    public Object[][] buscarProveedor(String nombre) {
        Object[][] datos = null;
        try {
            String consulta = "SELECT *  FROM proveedores WHERE  Nombre LIKE '%' || ? || '%' ORDER BY Nombre";
            PreparedStatement statement = Conexion.getConexion().prepareStatement(consulta);
            statement.setString(1, nombre);

            resultado = statement.executeQuery();
            int numeroLista = 1;

            ArrayList<Object[]> filas = new ArrayList<>();
            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("Nombre"),
                    resultado.getString("CuentaBancaria"),
                    resultado.getString("Telefono"),
                    resultado.getString("TipoDeProveedor"),
                    resultado.getString("Correo"),
                    resultado.getString("Direcion"),
                    resultado.getString("Contacto"),
                    resultado.getString("TelefonoContacto"),});
            }
            datos= new Object[filas.size()][];
            filas.toArray(datos);
        } catch (Exception e) {
            System.out.println("buscar:" + e.getMessage());
        }
        return datos;
    }
    
    public void eliminarProveedor(String nombre) {

        try {
            String sql = "Delete from proveedores where Nombre = ? ";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, nombre);
            
            consulta.execute();

        } catch (Exception e) {
            System.out.println("error en Eliminar Cliente" + e.getMessage());
        }
    
    }
}
