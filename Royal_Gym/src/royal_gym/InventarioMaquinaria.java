package royal_gym;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static royal_gym.Conexion.resultado;

public class InventarioMaquinaria 
{
    
    private Connection conexion;
    private static Statement statement;
    static ResultSet resultado;
    
    // formatea lo numeros doubles
    public String formatearNumero(double numero) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(numero);
    }
    
     //Método para insertar artículos al inventario
    public void insertarInventario(String NombreEquipo, String CantidadEquipo, String Descripcion) {
        try {
            String sql = "insert into inventario (nombre, cantidad, descripcion) values (?,?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, NombreEquipo);
            consulta.setString(2, CantidadEquipo);
            consulta.setString(3, Descripcion);
            consulta.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// fin del metodo para insertar inventario
    
     // método para llenar la tabla de Inventario
    public Object[][] getInventario() {
        Object[][] datosInventario = null;

        try {
            String consulta = "SELECT nombre, cantidad, descripcion,cod_equipo FROM inventario";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);
            int numeroLista = 1;

            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("nombre"),
                            resultado.getString("cantidad"),
                            resultado.getString("descripcion"),
                            resultado.getString("cod_equipo")
                        }
                );
            }
            datosInventario = new Object[filas.size()][];
            filas.toArray(datosInventario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosInventario;
    }

        //metodo para buscar inventario
    public Object[][] buscarInventario(String nombresmaquina) {
        Object[][] datosInventario = null;
        try {
            String consulta = "SELECT nombre, cantidad, descripcion FROM inventario where nombre like'%' || ? || '%'";
            PreparedStatement statement = Conexion.getConexion().prepareStatement(consulta);
            statement.setString(1, nombresmaquina);

            resultado = statement.executeQuery();
            int numeroLista = 1;

            ArrayList<Object[]> filas = new ArrayList<>();
            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("nombre"),
                            resultado.getString("cantidad"),
                            resultado.getString("descripcion")
                        }
                );
            }
            datosInventario = new Object[filas.size()][];
            filas.toArray(datosInventario);
        } catch (Exception e) {
        }
        return datosInventario;
    }

    // modificar Inventario
    public void ModificarInventario(String nombremaquina, String cantidad, String descripcion, String nombre) {

        try {
            String sql = "update inventario set nombre = ?, cantidad = ?, descripcion = ? where nombre = ?";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, nombremaquina);
            consulta.setString(2, cantidad);
            consulta.setString(3, descripcion);
            consulta.setString(4, nombre);
            consulta.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // método para eliminar
    public void eliminarInventario(String nombremaquina) {

        try {
            String sql = "Delete from inventario where nombre = ?";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, nombremaquina);
            consulta.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
}
