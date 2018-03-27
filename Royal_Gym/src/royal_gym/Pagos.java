package royal_gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static royal_gym.Conexion.resultado;

public class Pagos {
    
    
    private static Statement statement;
    static ResultSet resultado;
    
   
    
     
    // método para insertar pagos a la base de datos
    public void insertarPagos(String cliente, String monto, String tiempo, String tipotiempo, String tipoplan, String fecha) {
        try {
            String sql = "insert into Pagos(cliente, monto, tiempo , tipo_tiempo, tpo_plan,fecha_pago ) values(?,?,?,?,?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            
            consulta.setString(1, cliente);
            consulta.setString(2, monto);
            consulta.setString(3, tiempo);
            consulta.setString(4, tipotiempo);
            consulta.setString(5, tipoplan);
            consulta.setString(6, fecha);
            consulta.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }// fin de insertar pago
    
    
    // método para llenar la tabla de pagos
    public Object[][] getPago() {
        Object[][] datosPago = null;

        try {
            String consulta = "SELECT cliente,monto,tiempo,tipo_tiempo,tpo_plan,fecha_pago  FROM pagos order by id_pago DESC ";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);
            int numeroLista = 1;

            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                    new Object[]{
                    numeroLista++,
                    resultado.getString("Cliente"),
                    resultado.getDouble("Monto"),
                    resultado.getString("Tiempo"),
                    resultado.getString("tipo_tiempo"),
                    resultado.getString("tpo_plan"),
                    resultado.getString("fecha_pago"),}
                );
            }
            datosPago = new Object[filas.size()][];
            filas.toArray(datosPago);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosPago;
    }
    
    // método para llenar combobox de clientes
    public static ArrayList<String> llenarCombo() {
        ArrayList<String> lista = new ArrayList<String>();
        String q = "Select nombres ||' '|| apellidos as nombreCompleto from cliente ORDER BY nombres ||' '|| apellidos ASC";
        //String q = "SELECT CONCAT(nombres,', ',apellidos) AS NombreCompleto FROM cliente";

        try {
            resultado = statement.executeQuery(q);
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("No Correcto");
        }

        try {
            while (resultado.next()) {
                lista.add(resultado.getString("nombreCompleto"));
            }
        } catch (Exception e) {

        }
        return lista;
    }
    
    //metodo para buscar en la tabla pagos
    public Object[][] buscarPago(String nombre) {
        Object[][] datosCliente = null;
        try {
            String consulta = "SELECT *  FROM pagos WHERE  cliente LIKE '%' || ? || '%' ORDER BY cliente";
            PreparedStatement statement = Conexion.getConexion().prepareStatement(consulta);
            statement.setString(1, nombre);

            resultado = statement.executeQuery();
            int numeroLista = 1;

            ArrayList<Object[]> filas = new ArrayList<>();
            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("Cliente"),
                            resultado.getString("Monto"),
                            resultado.getString("Tiempo"),
                            resultado.getString("tipo_tiempo"),
                            resultado.getString("tpo_plan"),
                            resultado.getString("fecha_pago"),});
            }
            datosCliente = new Object[filas.size()][];
            filas.toArray(datosCliente);
        } catch (Exception e) {
            System.out.println("buscar:" + e.getMessage());
        }
        return datosCliente;
    }

    public Object[][] getClienteTipoPlan(String tipo) {

		Object[][] datos = null;

		try {
			String sql = "Select * from pagos where tpo_plan = ?";
			PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql); // PrepareStatement se utiliza cuando se utilizan consultas que llevan signo de ?
			consulta.setString(1, tipo); 
			ResultSet resultado = consulta.executeQuery();
                        
                        int numeroLista = 1;
			ArrayList<Object[]> d = new ArrayList<>();

			while (resultado.next()) {
				d.add(new Object[] { 
                                    numeroLista++,
						resultado.getString("Cliente"),
                            resultado.getString("Monto"),
                            resultado.getString("Tiempo"),
                            resultado.getString("tipo_tiempo"),
                            resultado.getString("tpo_plan"),
                            resultado.getString("fecha_pago"),
                                });
						
			}

			datos = new Object[d.size()][];
			d.toArray(datos); 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return datos;
	}

    
    
    
    
}
