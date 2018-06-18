package royal_gym;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class InventarioMaquinaria {

    private static Statement statement;
    static ResultSet resultado;

    // formatea lo numeros doubles
    public String formatearNumero(double numero) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(numero);
    }

    //Método para insertar artículos al inventario
    public void insertarInventario(String nombreEquipo, String cantidadEquipo, String descripcion) {
        try {
            String sql = "insert into inventario (nombre, cantidad, descripcion) values (?,?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, nombreEquipo);
            consulta.setString(2, cantidadEquipo);
            consulta.setString(3, descripcion);
            consulta.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// fin del metodo para insertar inventario

    // método para llenar la tabla de Inventario
    public Object[][] getInventario() {
        Object[][] datosInventario = null;

        try {
            String consulta = "SELECT * FROM inventario ORDER BY nombre";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);
            //int numeroLista = 1;

            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            //numeroLista++,
                            resultado.getString("cod_equipo"),
                            resultado.getString("nombre"),
                            resultado.getString("descripcion"),
                            resultado.getString("cantidad")
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
            String consulta = "SELECT * FROM inventario where nombre like'%' || ? || '%' ORDER BY nombre";
            PreparedStatement statement = Conexion.getConexion().prepareStatement(consulta);
            statement.setString(1, nombresmaquina);

            resultado = statement.executeQuery();
            //int numeroLista = 1;

            ArrayList<Object[]> filas = new ArrayList<>();
            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            //numeroLista++,
                            resultado.getString("cod_equipo"),
                            resultado.getString("nombre"),
                            resultado.getString("descripcion"),
                            resultado.getString("cantidad")
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
    public void ModificarInventario(String nombre, String cantidad, String descripcion, String id) {
        try {
            String sql = "update inventario set nombre = ?, cantidad = ?, descripcion = ? where cod_equipo = ?";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, nombre);
            consulta.setString(2, cantidad);
            consulta.setString(3, descripcion);
            consulta.setString(4, id);
            consulta.execute();

        } catch (Exception e) {
            System.out.println("error en Modificar Inventario" + e.getMessage());
        }
    }

    // método para eliminar
    public void eliminarInventario(String id) {
        try {
            String sql = "Delete from inventario where cod_equipo = ?";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, id);
            consulta.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
