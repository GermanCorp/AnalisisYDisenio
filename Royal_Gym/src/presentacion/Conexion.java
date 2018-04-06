package presentacion;

import royal_gym.*;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    static private Connection conexion;
    private static Statement statement;
    static ResultSet resultado;

    //conectarse a la base de datos
    public static Connection conectar() {
        
        Connection cn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite://localhost/gimnasio","root","1234");
            conexion = DriverManager.getConnection("jdbc:sqlite:gimnasio.db");
            statement = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }

    // método para cerrar la base de datos
    public static void cerrar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection(){ 
        Connection cn = null; 
        try { 
         Class.forName("org.sqlite.JDBC");
         cn = DriverManager.getConnection("jdbc:sqlite://localhost/gimnasio","root","1234");
        } catch (SQLException e) 
        { 
            System.out.println("Error: " + e.getMessage()); 
        } catch(Exception e1){ 
            System.out.println("Error: " +e1.getMessage()); 
        } return cn; 
    } 
}﻿
   
}
