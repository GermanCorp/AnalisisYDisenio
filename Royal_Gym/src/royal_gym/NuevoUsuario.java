package royal_gym;

import java.sql.PreparedStatement;

public class NuevoUsuario {

    //metodo para insertar un nuevo usuario a la base de datos
    public void nuevoUser(String nombre, String user, String pass, String miMascota, String miMadre) {
        try {
            String sql = "insert into login (nombre, usuario, contrasena, miMascota, miMadre) values (?,?,?,?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, nombre);
            consulta.setString(2, user);
            consulta.setString(3, pass);
            consulta.setString(4, miMascota);
            consulta.setString(5, miMadre);
            consulta.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
