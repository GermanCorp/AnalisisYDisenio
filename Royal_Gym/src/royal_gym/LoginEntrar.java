/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author julio
 */
public class LoginEntrar 
{
    static private Connection conexion;
    private static Statement statement;
    static ResultSet resultado;
    
    //conectarse a la base de datos
    public static void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:gimnasio.db");
            statement = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // método para cerrar la base de datos
    public static void cerrar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConexion(){
        return conexion;
    }
    
    // formatea lo numeros doubles
    public String formatearNumero(double numero) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(numero);
    }
    
    public static int ingreso(String usuario, String clave) {

		int resultado = 0;
		String SSQL = "SELECT * FROM Login WHERE usuario= ? AND contraseña =sha1(?)";
		Connection conect = null;

		try {
                       conectar();
                    conect = DriverManager.getConnection("jdbc:sqlite:gimnasio.db");
			PreparedStatement st = conect.prepareStatement(SSQL);

			// Statement st = conect.createStatement();

			st.setString(1, usuario);
			st.setString(2, clave);
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
