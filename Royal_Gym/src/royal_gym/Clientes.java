package royal_gym;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Clientes {
    
    // variables
    private static Statement statement;
    static ResultSet resultado;
    private Connection conexion;
 
    //Columnas de la tabla Clientes
        private final String[] columnasClientes = {
        "No.",
        "Nombres",
        "Fecha de Nacimiento",
        "Altura",
        "Peso",
        "Masa Corporal",
        "Clasificación"
    };
        
    // Modelo de la tabla de Clientes
    public void modeloTablaCliente(JTable tabla){
        DefaultTableModel modeloTablaClientes = new DefaultTableModel(getCliente(), columnasClientes);
        tabla.setModel(modeloTablaClientes);
    }
    
     // método para llenar la tabla de clientes                
    public Object[][] getCliente() {
        Object[][] datosCliente = null;
        try {
            String consulta = "Select nombres ||' '||apellidos as NombreCompleto, fechaNacimiento, altura, peso, Peso / (Altura * Altura) as imc FROM cliente AS a ORDER BY nombres";
            statement = conexion.createStatement();
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
    }
    
    // Clasifica el peso de acuerdo al imc
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
    }
    
    // formatea lo numeros doubles
    public String formatearNumero(double numero) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(numero);
    }
    
}
