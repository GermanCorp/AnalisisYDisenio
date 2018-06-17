package royal_gym;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginEntrar {

    static ResultSet resultado;

    public static int ingreso(String usuario, String clave) {
        int res = 0;
        try {
            String SSQL = "SELECT * FROM Login WHERE usuario = ? AND contrasena =?";
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SSQL);
            pst.setString(1, usuario);
            pst.setString(2, clave);
            resultado = pst.executeQuery();

            if (resultado.next()) {
                res = 1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
}