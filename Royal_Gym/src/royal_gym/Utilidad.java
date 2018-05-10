package royal_gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static royal_gym.Conexion.resultado;

public class Utilidad {
    
    private Connection conexion;
    private static Statement statement;
    public double totalIngresos = 0;
    public double totalGastos = 0;
    
    
    public Utilidad(){
        try {
            
            conexion = DriverManager.getConnection("jdbc:sqlite:gimnasio.db");
            } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    //metodo para llenar la tabla con los ingresos(pagos) segun el rango de fecha seleccionado
    public Object[][] getUtilidad(String fechaInicio, String fechaFin) {
        Object[][] datosPago = null;

        try {
            String consulta = "SELECT fecha_pago  , cliente  , monto  from pagos where fecha_pago between ? and ? "
                    + "UNION "
                    + "SELECT Fecha ,Descripcion , monto  from gasto where Fecha between ? and ? ";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, fechaInicio);
            statement.setString(2, fechaFin);
            resultado = statement.executeQuery();
            int numeroLista = 1;

            ArrayList<Object[]> filas = new ArrayList<>();
           
            while (resultado.next()) {
                
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("fecha_pago"),
                            resultado.getString("cliente"),
                            resultado.getString("monto"),
                            
                            }
                );
            }
            datosPago = new Object[filas.size()][];
            filas.toArray(datosPago);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosPago;
    }
    
    
    //metodo para llenar la tabla con los gastos  que hubieron  segun el rango de fecha seleccionado
    public Object[][] getGastosSeleccionados(String fechaInicio, String fechaFin) {
        Object[][] datosPago = null;

        try {
            String consulta = "Select Fecha, Descripcion, Monto from gasto where Fecha between ? and ?";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, fechaInicio);
            statement.setString(2, fechaFin);
            resultado = statement.executeQuery();
            int numeroLista = 1;

            ArrayList<Object[]> filas = new ArrayList<>();
          
            while (resultado.next()) {
                totalGastos += resultado.getDouble("Monto");
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("Fecha"),
                            resultado.getString("Descripcion"),
                            resultado.getString("Monto")

                        }
                );
            }
            datosPago = new Object[filas.size()][];
            filas.toArray(datosPago);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosPago;
    }

    //metodo para llenar la tabla con los ingresos(pagos) segun el rango de fecha seleccionado
    public Object[][] getIngresosSeleccinados(String fechaInicio, String fechaFin) {
        Object[][] datosPago = null;

        try {
            String consulta = "Select fecha_pago, cliente, monto from pagos where fecha_pago between ? and ? ";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, fechaInicio);
            statement.setString(2, fechaFin);
            resultado = statement.executeQuery();
            int numeroLista = 1;

            ArrayList<Object[]> filas = new ArrayList<>();
           
            while (resultado.next()) {
                totalIngresos += resultado.getDouble("monto");
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("fecha_pago"),
                            resultado.getString("cliente"),
                            resultado.getString("monto"),}
                );
            }
            datosPago = new Object[filas.size()][];
            filas.toArray(datosPago);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosPago;
    }

//    public String formatearNumero(double totalg) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    
    
    
}
