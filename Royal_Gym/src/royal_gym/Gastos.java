package royal_gym;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static royal_gym.Clientes.resultado;

public class Gastos {

    private Statement statement;
    private ResultSet resultado;

    // columnas de la tabla Gastos
    private final String[] columnasGastos = {"Id", "Fecha", "Descripción", "Monto"};

    // Modelo de la tabla de Gastos
    public void modeloTablaGastos(JTable tabla) {
        DefaultTableModel modeloTablaGastos = new DefaultTableModel(getGasto(), columnasGastos);
        tabla.setModel(modeloTablaGastos);
    }

    // método para llenar la tabla de gastos
    public Object[][] getGasto() {
        Object[][] datosCliente = null;

        try {
            String consulta = "Select * FROM gasto ORDER BY fecha desc";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);

            int numeroLista = 1;
            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            resultado.getString("id_gasto"),
                            resultado.getString("Fecha"),
                            resultado.getString("Descripcion"),
                            formatearNumero(resultado.getDouble("Monto")),

                        }
                );
            }
            datosCliente = new Object[filas.size()][];
            filas.toArray(datosCliente);

            datosCliente = new Object[filas.size()][];
            filas.toArray(datosCliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosCliente;
    }

// formatea los numeros doubles
    public String formatearNumero(double numero) {
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        return df.format(numero);
    }

    // insertar gastos    
    public void insertarGasto(String descripcion, String monto, String fecha) {
        try {
            String sql = "insert into gasto (Descripcion, Monto, Fecha) values (?,?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, descripcion);
            consulta.setString(2, monto);
            consulta.setString(3, fecha);
            consulta.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar porque ocurrio un\nerror en la base de datos\n" + e.getMessage());
        }
    }

    //buscar gastos
    public Object[][] buscarGasto(String descripcion) {
        Object[][] datosCliente = null;
        try {
            String consulta = "SELECT * FROM gasto WHERE descripcion LIKE '%' || ? || '%' ORDER BY fecha desc";
            PreparedStatement pst = Conexion.getConexion().prepareStatement(consulta);
            pst.setString(1, descripcion);

            resultado = pst.executeQuery();

            ArrayList<Object[]> filas = new ArrayList<>();
            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            resultado.getString("id_gasto"),
                            resultado.getString("Fecha"),
                            resultado.getString("Descripcion"),
                            formatearNumero(resultado.getDouble("Monto"))
                            
                        }
                );
            }

            datosCliente = new Object[filas.size()][];
            filas.toArray(datosCliente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en la conexion a la base de datos\nal intentar buscar\n" + e.getMessage());
        }
        return datosCliente;
    }

    // eliminar gasto
    public void eliminarGasto(String id) {
        try {
            String sql = "Delete from gasto where id_Gasto = ?";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, id);
            consulta.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en la conexion a la base de datos\nal intentar eliminar\n" + e.getMessage());
        }
    }

    // modificar gasto
    public void modificarGasto(String descripcion, String monto, String id) {
        try {
            String sql = "update gasto set descripcion = ?, Monto = ? where id_gasto = ?";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, descripcion);
            consulta.setString(2, monto);
            consulta.setString(3, id);
            consulta.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en la conexion a la base de datos\nal intentar Modificar\n" + e.getMessage());
        }
    }
}
