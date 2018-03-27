package royal_gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static royal_gym.Conexion.resultado;


public class Clientes {
    
    // variables
    private static Statement statement;
    static ResultSet resultado;

    public Clientes() {
        
    }
    
    
    // Modelo de la tabla de Clientes
    public void modeloTablaCliente(String[] columnas, JTable tabla) {
        DefaultTableModel modeloTablaClientes = new DefaultTableModel(getCliente(), columnas);
        tabla.setModel(modeloTablaClientes);
    }


    // <editor-fold defaultstate="collapsed" desc="Método para Obtener Clientes">                
    public Object[][] getCliente() {
        Object[][] datosCliente = null;
        try {
            String consulta = "Select nombres ||' '||apellidos as NombreCompleto, fechaNacimiento, altura, peso, Peso / (Altura * Altura) as imc FROM cliente AS a ORDER BY nombres";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);

            int numeroLista = 1;
            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("NombreCompleto"),
                            resultado.getString("FechaNacimiento"),
                            formatearNumero(resultado.getDouble("Altura")) + " mt",
                            formatearNumero(resultado.getDouble("Peso")) + " kg",
                            formatearNumero(resultado.getDouble("imc")),
                            clasificaciónIMC(resultado.getDouble("imc"))
                        }
                );
            }
            datosCliente = new Object[filas.size()][];
            filas.toArray(datosCliente);

            datosCliente = new Object[filas.size()][];
            filas.toArray(datosCliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosCliente;
    } // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Método, Clasificación de acuerdo al IMC">
    public String clasificaciónIMC(double imc) {
        String tipoIMC = "";
        if (imc < 16) {
            tipoIMC = "Delgadez Severa";
        } else if (imc >= 16 && imc <= 16.99) {
            tipoIMC = "Delgadez Moderada";
        } else if (imc >= 17 && imc <= 18.49) {
            tipoIMC = "Delgadez Aceptable";
        } else if (imc >= 18.50 && imc <= 24.99) {
            tipoIMC = "Peso Normal";
        } else if (imc >= 25 && imc <= 29.99) {
            tipoIMC = "Sobrepeso";
        } else if (imc >= 30 && imc <= 34.99) {
            tipoIMC = "Obeso Tipo I";
        } else if (imc >= 35 && imc <= 40) {
            tipoIMC = "Obeso Tipo II";
        } else {
            tipoIMC = "Obeso Tipo III";
        }
        return tipoIMC;
    }// </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Método para formatear los numeros de tipo Double">
    public String formatearNumero(double numero) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(numero);
    }// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Método para insertar un cliente">  
    public void insertarCliente(String nombres, String apellidos, String fechaNacimiento, String altura, String peso) {
        try {
            String sql = "insert into cliente (nombres, apellidos, fechaNacimiento, altura, peso) values (?,?,?,?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, nombres);
            consulta.setString(2, apellidos);
            consulta.setString(3, fechaNacimiento);
            consulta.setString(4, altura);
            consulta.setString(5, peso);
            consulta.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Método para buscar un clientes">  
    public Object[][] buscarCliente(String nombres, String apellidos) {
        Object[][] datosCliente = null;
        try {
            String consulta = "SELECT nombres ||' '||apellidos as NombreCompleto, fechaNacimiento, altura, peso, Peso / (Altura * Altura) as imc FROM cliente WHERE nombres ||' '||apellidos LIKE '%' || ? || '%' ORDER BY nombres";
            PreparedStatement statement = Conexion.getConexion().prepareStatement(consulta);
            statement.setString(1, nombres);
            //statement.setString(2, apellidos);

            resultado = statement.executeQuery();
            int numeroLista = 1;
            DecimalFormat df = new DecimalFormat("0.00");

            ArrayList<Object[]> filas = new ArrayList<>();
            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("NombreCompleto"),
                            resultado.getString("FechaNacimiento"),
                            resultado.getString("Altura"),
                            resultado.getString("Peso"),
                            df.format(resultado.getDouble("imc")),
                            clasificaciónIMC(resultado.getDouble("imc"))
                        }
                );
            }
            datosCliente = new Object[filas.size()][];
            filas.toArray(datosCliente);
        } catch (Exception e) {
            System.out.println("buscarCliente:" + e.getMessage());
        }
        return datosCliente;
    }// </editor-fold>
    
    public void eliminarCliente(String nombreCliente) {

        try {
            String sql = "Delete from cliente where nombres ||' '|| apellidos as nombreCompleto = ?";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, nombreCliente);
            consulta.execute();

        } catch (Exception e) {
            System.out.println("Eliminar Cliente" + e.getMessage());
        }
    }
}
