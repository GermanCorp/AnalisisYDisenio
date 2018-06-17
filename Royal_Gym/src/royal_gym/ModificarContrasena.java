
package royal_gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ModificarContrasena 
{
    
    public static int modificarContrasena(String clave) {

		int resultado = 0;
		String SSQL = "UPDATE Login set contrasena =?";
		Connection conect = null;

		try {
               
                    conect = DriverManager.getConnection("jdbc:sqlite:gimnasio.db");
			PreparedStatement st = conect.prepareStatement(SSQL);

			st.setString(1, clave);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				resultado = 1;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
			conect.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
                return resultado;
		
	}
            
    
}
