package royal_gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Usuarios {

    private Connection conexion;
    private static Statement statement;
    static ResultSet resultado;

    public String formatearNumero(double numero) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(numero);
    }

    //metodo para insertar un nuevo usuario a la base de datos
    public void nuevoUser(String nombre, String User, String Pass, String PreguntaA, String PreguntaB) {
        try {
            String sql = "insert into login (nombre,usuario, contraseña, mascota, madre) values (?,?,?,?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, nombre);
            consulta.setString(2, User);
            consulta.setString(3, Pass);
            consulta.setString(4, PreguntaA);
            consulta.setString(5, PreguntaB);
            consulta.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Object[][] getUsuarios() {
        Object[][] datosUsuarios = null;
        try {
            String consulta = "SELECT id_usuario, nombre, usuario FROM login";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);

            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);
            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            resultado.getString("id_usuario"),
                            resultado.getString("nombre"),
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
    public Object[][] buscarUsuarios(String Nombre) {
        Object[][] datosUsuarios = null;
        try {
            String consulta = "SELECT id_usuario, nombre, usuario FROM Login where nombre like'%' || ? || '%'";
            PreparedStatement statement = Conexion.getConexion().prepareStatement(consulta);
            statement.setString(1, Nombre);

            resultado = statement.executeQuery();

            ArrayList<Object[]> filas = new ArrayList<>();
            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            resultado.getString("id_usuario"),
                            resultado.getString("nombre"),
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
    

    public void eliminarUsuarios(String id) {

        try {
            String sql = "Delete from login where id_usuario = ?";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, id);
            consulta.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
