package royal_gym;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static royal_gym.Conexion.resultado;

public class Cumpleaneros {
   
     private Connection conexion;
    private static Statement statement;
    static ResultSet resultado;
    Conexion con = new Conexion();
    
     // método para cerrar la base de datos
    public void cerrar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // formatea lo numeros doubles
    public String formatearNumero(double numero) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(numero);
    }
    
     // método para llenar la tabla de edad de los clientes
    public Object[][] getEdadClientes() {
        Object[][] datosCliente = null;

        try {
            String consulta = "Select * FROM Edad";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);

            int numeroLista = 1;
            ArrayList<Object[]> filas = new ArrayList<>();
            DecimalFormat df = new DecimalFormat("###");

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("Nombre"),
                            resultado.getString("fechaNacimiento"),
                            df.format(resultado.getDouble("Edad")) + " años"
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
    
    
    
    
}
