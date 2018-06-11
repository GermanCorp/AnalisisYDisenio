package royal_gym;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginEntrar {

    static ResultSet resultado;

    public static int ingreso(String usuario, String clave) {
        int res = 0;
        try {
            String SSQL = "SELECT * FROM Login WHERE usuario = ? AND contraseña =?";
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
