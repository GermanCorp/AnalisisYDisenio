package royal_gym;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Gastos {
    
    private Connection conexion;
    private Statement statement; 
    private ResultSet resultado;

     
    // columnas de la tabla Gastos
    private final String[] columnasGastos = {
        "N°",
        "Descripcion",
        "Monto",
        "Fecha"
    };
  
    
    // formatea los numeros doubles
    public String formatearNumero(double numero) {
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        return df.format(numero);
    }

  
    // método para llenar la tabla de gastos
    public Object[][] getGasto() {
        Object[][] datosCliente = null;

        try {
            String consulta = "Select Descripcion, Monto, Fecha FROM gasto ORDER BY fecha desc";
            statement = conexion.createStatement();
            resultado = statement.executeQuery(consulta);

            int numeroLista = 1;
            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("Descripcion"),
                            formatearNumero(resultado.getDouble("Monto")),
                            resultado.getString("Fecha")
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
    
    // Modelo de la tabla de Gastos
    public void modeloTablaGastos(JTable tabla){
        DefaultTableModel modeloTablaGastos = new DefaultTableModel(getGasto(), columnasGastos);
        tabla.setModel(modeloTablaGastos);
    }
}
