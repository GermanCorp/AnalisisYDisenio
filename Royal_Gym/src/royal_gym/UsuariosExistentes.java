package royal_gym;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static royal_gym.InventarioMaquinaria.resultado;

public class UsuariosExistentes
{
    private Connection conexion;
    private static Statement statement;
    static ResultSet resultado;
    
     // método para llenar la tabla de Usuarios Existentes
    public Object[][] getUsuarios() {
        Object[][] datosUsuarios = null;

        try {
            String consulta = "SELECT usuario FROM Login";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);
            int numeroLista = 1;

            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("usuario")
                        }
                );
            }
            datosUsuarios = new Object[filas.size()][];
            filas.toArray(datosUsuarios);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosUsuarios;
    }

        //metodo para buscar Usuarios
    public Object[][] buscarUsuarios(String nombresUsuarios) {
        Object[][] datosUsuarios = null;
        try {
            String consulta = "SELECT usuario FROM Login where usuario like'%' || ? || '%'";
            PreparedStatement statement = Conexion.getConexion().prepareStatement(consulta);
            statement.setString(1, nombresUsuarios);

            resultado = statement.executeQuery();
            int numeroLista = 1;

            ArrayList<Object[]> filas = new ArrayList<>();
            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("usuario")
                        }
                );
            }
            datosUsuarios = new Object[filas.size()][];
            filas.toArray(datosUsuarios);
        } catch (Exception e) {
        }
        return datosUsuarios;
    }

    // método para eliminar usuarios existentes
    public void eliminarUsuarios(String nombresUsuarios) {

        try {
            String sql = "Delete from login where usuario = ?";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, nombresUsuarios);
            consulta.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
