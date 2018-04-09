package royal_gym;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import static royal_gym.Clientes.resultado;

public class Ventas {
    
    private static Statement statement;
    static ResultSet resultado;
    
    public String formatearNumero(double numero) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(numero);
    }
    
    public Object[][] getVentaTemporal() {
        Object[][] datosVenta = null;
        try {
            String consulta = "Select cantidad, descripcion, preciounitario FROM temporalventa";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);

            int numeroLista = 1;
            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("cantidad"),
                            resultado.getString("descripcion"),
                            formatearNumero(resultado.getDouble("preciounitario"))
                        }
                );
            }
            datosVenta = new Object[filas.size()][];
            filas.toArray(datosVenta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosVenta;
    }
    
    public void insertarVentaTemporal(String cantidad, String descripcion, String precioUnitario) {
        try {
            String sql = "insert into temporalventa (cantidad, descripcion, preciounitario) values (?,?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, cantidad);
            consulta.setString(2, descripcion);
            consulta.setString(3, precioUnitario);
            consulta.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
