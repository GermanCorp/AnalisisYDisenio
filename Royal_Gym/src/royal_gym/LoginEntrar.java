package royal_gym;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginEntrar {

    static ResultSet resultado;
    private static boolean ADMIN = false;
    
    public static boolean  isADMIN(){
        return ADMIN;
    }
    
    public static int ingreso(String usuario, String clave) {
        int res = 0;
        try {
            String SSQL = "SELECT cargo FROM Login WHERE usuario = ? AND contraseña =?";
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SSQL);
            pst.setString(1, usuario);
            pst.setString(2, clave);
            resultado = pst.executeQuery();

            if (resultado.next()) {
                ADMIN = resultado.getString("cargo").equals("Administrador");
                res = 1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //esAdministrador(usuario);
                
        return res;
    }
        
    public static int recuperarPass(String usuario, String preguntaA, String preguntaB) {
        int res = 0;
        try {
            String SSQL = "SELECT * FROM Login WHERE usuario = ? AND mascota = ? AND madre = ?";
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SSQL);
            pst.setString(1, usuario);
            pst.setString(2, preguntaA);
            pst.setString(3, preguntaB);
            resultado = pst.executeQuery();

            if (resultado.next()) {
                res = 1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
    public void setPass(String pass, String user){
        try {
            String sSQL = "UPDATE Login SET contraseña = ? WHERE usuario = ?";
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sSQL);
            pst.setString(1, pass);
            pst.setString(2, user);
            pst.execute();
        } catch (Exception e) {
        }
    }
}
