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
import javax.swing.JOptionPane;

public class Conexion {

    private Connection conexion;
    private static Statement statement;
    static ResultSet resultado;

    // método para conectarse a la base de datos
    public void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:gimnasio.db");
            statement = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // método para cerrar la base de datos
    public void cerrar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String clasificaciónIMC(double imc){
       String tipoIMC = "";
       if (imc <16){
           tipoIMC = "Delgadez Severa";
       } else if (imc >=16 && imc <=16.99){
           tipoIMC = "Delgadez Moderada";
       }else if (imc >=17 && imc <=18.49){
           tipoIMC = "Delgadez Aceptable";
       }else if (imc >=18.50 && imc <=24.99){
           tipoIMC = "Peso Normal";
       }else if (imc >=25 && imc <=29.99){
           tipoIMC = "Sobrepeso";
       }else if (imc >=30 && imc <=34.99){
           tipoIMC = "Obeso Tipo I";
       }else if (imc >=35 && imc <=40){
           tipoIMC = "Obeso Tipo II";
       }else{
           tipoIMC = "Obeso Tipo III";
       }
       return tipoIMC;
    }
        
    // método para insertar pagos a la base de datos
    public void insertarPagos(String cliente, String monto, String tiempo, String tipotiempo, String tipoplan, String fecha) {
        try {
            String sql = "insert into Pagos(cliente, monto, tiempo , tipo_tiempo, tpo_plan,fecha_pago ) values(?,?,?,?,?,?)";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, cliente);
            consulta.setString(2, monto);
            consulta.setString(3, tiempo);
            consulta.setString(4, tipotiempo);
            consulta.setString(5, tipoplan);
            consulta.setString(6, fecha);
            consulta.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }// fin de insertar pago

    // Método para insertar nuevo clinte
    public void insertarCliente(String nombres, String apellidos, String fechaNacimiento, String altura, String peso) {
        try {
            String sql = "insert into cliente (nombres, apellidos, fechaNacimiento, altura, peso) values (?,?,?,?,?)";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, nombres);
            consulta.setString(2, apellidos);
            consulta.setString(3, fechaNacimiento);
            consulta.setString(4, altura);
            consulta.setString(5, peso);
            consulta.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// fin del metodo para insertar cliente

    //Método para insertar artículos al inventario
    public void insertarInventario(String NombreEquipo, String CantidadEquipo, String Descripcion) {
        try {
            String sql = "insert into inventario (nombre, cantidad, descripcion) values (?,?,?)";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, NombreEquipo);
            consulta.setString(2, CantidadEquipo);
            consulta.setString(3, Descripcion);
            consulta.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// fin del metodo para insertar inventario

    void insertarPagos(String text, String text0, Object selectedItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // método para llenar la tabla de pagos
    public Object[][] getPago() {
        Object[][] datosPago = null;

        try {
            String consulta = "SELECT cliente,monto,tiempo,tipo_tiempo,tpo_plan,fecha_pago  FROM pagos order by id_pago DESC ";
            statement = conexion.createStatement();
            resultado = statement.executeQuery(consulta);

            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            resultado.getString("Cliente"),
                            resultado.getDouble("Monto"),
                            resultado.getInt("Tiempo"),
                            resultado.getString("tipo_tiempo"),
                            resultado.getString("tpo_plan"),
                            resultado.getString("fecha_pago"),}
                );
            }
            datosPago = new Object[filas.size()][];
            filas.toArray(datosPago);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosPago;
    }

    // método para llenar combobox de clientes
    public static ArrayList<String> llenarCombo() {
        ArrayList<String> lista = new ArrayList<String>();
        String q = "Select * from cliente ORDER BY Nombres ASC";
        //String q = "SELECT CONCAT(nombres,', ',apellidos) AS NombreCompleto FROM cliente";

        try {
            resultado = statement.executeQuery(q);
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("No Correcto");
        }

        try {
            while (resultado.next()) {
                lista.add(resultado.getString("nombres"));
            }
        } catch (Exception e) {

        }
        return lista;
    }

    // método para llenar la tabla de clientes                
     public Object[][] getCliente(){
         Object[][] datosCliente = null;
         
         try {
             String consulta = "Select nombres, apellidos, fechaNacimiento, altura, peso FROM cliente AS a ORDER BY nombres";
             statement = conexion.createStatement();
             resultado = statement.executeQuery(consulta);

             int numeroLista = 1;
             double imc = 0;
             DecimalFormat df = new DecimalFormat("0.00");
             
             ArrayList<Object[]> filas = new ArrayList<>();
             
             while (resultado.next()) {
                 filas.add(
                 new Object[]{
                     numeroLista++,
                     resultado.getString("Nombres") + " " +
                     resultado.getString("Apellidos"),
                     resultado.getString("FechaNacimiento"),
                     resultado.getDouble("Altura"),
                     resultado.getDouble("Peso"),
                     df.format(resultado.getDouble("Peso") / (resultado.getDouble("Altura")  * resultado.getDouble("Altura"))),
                     clasificaciónIMC((resultado.getDouble("Peso") / (resultado.getDouble("Altura") * resultado.getDouble("Altura"))))
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

    // método para llenar la tabla de Inventario
    public Object[][] getInventario() {
        Object[][] datosInventario = null;

        try {
            String consulta = "SELECT nombre, cantidad, descripcion FROM inventario";
            statement = conexion.createStatement();
            resultado = statement.executeQuery(consulta);

            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            resultado.getString("nombre"),
                            resultado.getInt("cantidad"),
                            resultado.getString("descripcion")
                        }
                );
            }
            datosInventario = new Object[filas.size()][];
            filas.toArray(datosInventario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosInventario;
    }
 // método para llenar la tabla de clientes
    public Object[][] buscarCliente(String nombres, String apellidos) {
        Object[][] datosCliente = null;

        try {
            String consulta = "SELECT nombres, apellidos, fechaNacimiento, altura, peso FROM cliente WHERE nombres LIKE '%" + nombres + "%' OR apellidos LIKE '%" + apellidos + "%' ORDER BY nombres";
            statement = conexion.createStatement();
            resultado = statement.executeQuery(consulta);
            int numeroLista = 1;

            DecimalFormat df = new DecimalFormat("0.00");

            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("Nombres") + " " +
                            resultado.getString("Apellidos"),
                            resultado.getString("FechaNacimiento"),
                            resultado.getDouble("Altura"),
                            resultado.getDouble("Peso"),
                            df.format(resultado.getDouble("Peso") / (resultado.getDouble("Altura") * resultado.getDouble("Altura"))),
                            clasificaciónIMC((resultado.getDouble("Peso") / (resultado.getDouble("Altura") * resultado.getDouble("Altura"))))
                        }
                );
            }
            datosCliente = new Object[filas.size()][];
            filas.toArray(datosCliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosCliente;
    }
    

    public Object[][] getNombreCliente(String nombre) {

        Object[][] datos = null;
        try {
            String sql = "Select * from pagos where cliente LIKE '%" + nombre + "%'";
            PreparedStatement consulta = conexion.prepareStatement(sql); // PrepareStatement se utiliza cuando se utilizan consultas que llevan signo de ?
            consulta.setString(1, nombre);
            ResultSet res = consulta.executeQuery();

            ArrayList<Object[]> d = new ArrayList<>();

            while (res.next()) {
                d.add(new Object[]{
                    res.getString("Cliente"),
                    res.getDouble("Monto"),
                    res.getInt("Tiempo"),
                    res.getString("tipo_tiempo"),
                    res.getString("tpo_plan"),
                    res.getString("fecha_pago"),});
            }

            datos = new Object[d.size()][];
            d.toArray(datos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
}
