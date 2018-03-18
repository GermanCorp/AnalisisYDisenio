package royal_gym;

import com.toedter.calendar.JDateChooser;
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
    double totalIngresos = 0;
    double totalGastos = 0;

    //conectarse a la base de datos
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

    // formatea lo numeros doubles
        public String formatearNumero(double numero){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(numero);
    }
    
    // Clasifica el peso de acuerdo al imc
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

    //void insertarPagos(String text, String text0, Object selectedItem) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    // método para llenar la tabla de pagos
    public Object[][] getPago() {
        Object[][] datosPago = null;

        try {
            String consulta = "SELECT cliente,monto,tiempo,tipo_tiempo,tpo_plan,fecha_pago  FROM pagos order by id_pago DESC ";
            statement = conexion.createStatement();
            resultado = statement.executeQuery(consulta);
            int numeroLista = 1;

            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            numeroLista++,
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
                     formatearNumero(resultado.getDouble("Altura")),
                     formatearNumero(resultado.getDouble("Peso")),
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

    // método para llenar la tabla de Inventario
    public Object[][] getInventario() {
        Object[][] datosInventario = null;

        try {
            String consulta = "SELECT nombre, cantidad, descripcion,cod_equipo FROM inventario";
            statement = conexion.createStatement();
            resultado = statement.executeQuery(consulta);
            int numeroLista = 1;

            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("nombre"),
                            resultado.getInt("cantidad"),
                            resultado.getString("descripcion"),
                            resultado.getString("cod_equipo")
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
            String consulta = "SELECT nombres ||' '||apellidos as NombreCompleto, fechaNacimiento, altura, peso, Peso / (Altura * Altura) as imc FROM cliente WHERE nombres ||' '||apellidos LIKE '%' || ? || '%' ORDER BY nombres";
            PreparedStatement statement = conexion.prepareStatement(consulta);
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
                            resultado.getDouble("Altura"),
                            resultado.getDouble("Peso"),
                            df.format(resultado.getDouble("imc")),
                            clasificaciónIMC(resultado.getDouble("imc"))
                        }
                );
            }
            datosCliente = new Object[filas.size()][];
            filas.toArray(datosCliente);
        } catch (Exception e) {
            System.out.println("buscarCliente:"+e.getMessage());
        }
        return datosCliente;
    }
    
    
    //metodo para buscar en la tabla pagos
    public Object[][] buscarPago(String nombre) {
        Object[][] datosCliente = null;
        try {
            String consulta = "SELECT *  FROM pagos WHERE  cliente LIKE '%' || ? || '%' ORDER BY cliente";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            
            resultado = statement.executeQuery();
            int numeroLista = 1;
            
            ArrayList<Object[]> filas = new ArrayList<>();
            while (resultado.next()) {
                filas.add(
                    new Object[]{
                        numeroLista++,
                        resultado.getString("Cliente"),
                        resultado.getDouble("Monto"),
                        resultado.getInt("Tiempo"),
                        resultado.getString("tipo_tiempo"),
                        resultado.getString("tpo_plan"),
                        resultado.getString("fecha_pago"),
	           });
            }
            datosCliente = new Object[filas.size()][];
            filas.toArray(datosCliente);
        } catch (Exception e) {
            System.out.println("buscar:"+e.getMessage());
        }
        return datosCliente;
    }
    
     //metodo para buscar inventario
    public Object[][] buscarInventario(String nombresmaquina) {
        Object[][] datosInventario = null;
        try {
            String consulta = "SELECT nombre, cantidad, descripcion FROM inventario where nombre like'%' || ? || '%'";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombresmaquina);

            resultado = statement.executeQuery();
            int numeroLista = 1;

            ArrayList<Object[]> filas = new ArrayList<>();
            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("nombre"),
                            resultado.getString("cantidad"),
                            resultado.getString("descripcion")
                        }
                );
            }
            datosInventario = new Object[filas.size()][];
            filas.toArray(datosInventario);
        } catch (Exception e) {
        }
        return datosInventario;
    }
    
    // modificar Inventario
    public void ModificarInventario(String nombremaquina, String cantidad, String descripcion,String codigoEquipo) {

        try {
            String sql = "update inventario set nombre = ?, cantidad = ?, descripcion = ? where cod_equipo = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, nombremaquina);
            consulta.setString(2, cantidad);
            consulta.setString(3, descripcion);
            consulta.setString(4, codigoEquipo);
            consulta.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
        // método para eliminar
    public void eliminarInventario(String nombremaquina) {

        try {
            String sql = "Delete from inventario where nombre = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, nombremaquina);
            consulta.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
         // método para llenar la tabla de clientes                
    public Object[][] getEdadClientes() {
        Object[][] datosCliente = null;

        try {
            String consulta = "Select * FROM Edad";
            statement = conexion.createStatement();
            resultado = statement.executeQuery(consulta);

            int numeroLista = 1;
            ArrayList<Object[]> filas = new ArrayList<>();
            DecimalFormat df = new DecimalFormat("###");

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            numeroLista++,
                            resultado.getString("Nombre"),
                            resultado.getString("fechaNacimiento"),
                            df.format(resultado.getDouble("Edad")) + " años"
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

    
    public Object[][] getNombreCliente(String nombre) {

        Object[][] datos = null;
        try {
            String sql = "Select * from pagos where cliente LIKE '%' | ? |'%'";
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
            System.out.println("getNombreCliente:"+e.getMessage());
        }
        return datos;
    }
    
            public Object[][] getNombreClientepago(String nombre) {

	    Object[][] datos = null;

	    try { 
                 String filtro = ""+nombre+"_%";
	         String sql = "Select * from pagos where cliente LIKE "+'"'+ filtro +'"';
                 //String sql = "Select * from pagos where cliente LIKE '"+ nombre +"%'";
                 System.out.println(sql);
                 PreparedStatement consulta = conexion.prepareStatement(sql); // PrepareStatement se utiliza cuando se utilizan consultas que llevan signo de ?
                 ResultSet res = consulta.executeQuery();

	         ArrayList<Object[]> d = new ArrayList<>();

		while (res.next()) {
                   d.add(new Object[] { 
		   res.getString("Cliente"),
                   res.getDouble("Monto"),
                   res.getInt("Tiempo"),
                   res.getString("tipo_tiempo"),
                   res.getString("tpo_plan"),
                   res.getString("fecha_pago"),
	           });
	       }

		datos = new Object[d.size()][];
		d.toArray(datos); 
	    } catch (Exception e) {
		System.out.println(e.getMessage());
	        }
	        return datos;

       }
            
            public Object[][] getIngresosGastos(String fechaInicio, String fechaFinal) {
        Object[][] datosPago = null;
 
        try {
            String consulta = "select Nombres,monto from cliente join pagos ";
            statement = conexion.createStatement();
            resultado = statement.executeQuery(consulta);

            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            resultado.getString("Nombres"),
                            resultado.getDouble("Monto"),
                            }
                );
            }
            datosPago = new Object[filas.size()][];
            filas.toArray(datosPago);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosPago;
    }

            // método para llenar la tabla de gastos
 public Object[][] getGasto(){
         Object[][] datosCliente = null;
         
         try {
             String consulta = "Select Descripcion, Monto, Fecha FROM gasto ORDER BY fecha desc";
             statement = conexion.createStatement();
             resultado = statement.executeQuery(consulta);

             int numeroLista = 1;
             ArrayList<Object[]> filas = new ArrayList<>();
             
             while (resultado.next()) {
                 filas.add(
                 new Object[]{
                     numeroLista++,
                     resultado.getString("Descripcion"),
                     formatearNumero(resultado.getDouble("Monto")),
                     resultado.getString("Fecha")
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
 
 // Método para insertar nuevo gasto
    public void insertarGasto(String descripcion, String monto, String fecha) {
        try {
            String sql = "insert into gasto (Descripcion, Monto, Fecha) values (?,?,?)";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, descripcion);
            consulta.setString(2, monto);
            consulta.setString(3, fecha);
            consulta.execute();
        } catch (Exception e) {
            System.out.println("Metodo Insertar gasto" + e.getMessage());
        }
    }// fin del metodo para insertar cliente

 //metodo para llenar la tabla con los gastos  que hubieron  segun el rango de fecha seleccionado
    public Object[][] getGastos( String fechaInicio , String fechaFin) {
        Object[][] datosPago = null;

        try {
            String consulta = "Select g.Fecha,sum(g.Monto) as montoGasto from gasto as g where g.Fecha between ? and ? group by g.Fecha";
            
           PreparedStatement statement  = conexion.prepareStatement(consulta);
           statement.setString(1, fechaInicio);
           statement.setString(2, fechaFin);
            resultado = statement.executeQuery();
            int numeroLista = 1;
            
            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                totalGastos +=resultado.getDouble("montoGasto");
                filas.add(
                        new Object[]{
                    numeroLista++,  
                    resultado.getString("Fecha"),        
                    resultado.getDouble("montoGasto"),       
                    
                   }
                );
            }
            datosPago = new Object[filas.size()][];
            filas.toArray(datosPago);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosPago;
    }
    
    //metodo para llenar la tabla con los ingresos(pagos) segun el rango de fecha seleccionado
    public Object[][] getIngresos( String fechaInicio , String fechaFin) {
        Object[][] datosPago = null;

        try {
            String consulta ="Select i.fecha_pago,sum(i.monto) as montoIngreso from pagos "
                    + "as i where i.fecha_pago between ? and ? group by i.fecha_pago"; 
           
            PreparedStatement statement  = conexion.prepareStatement(consulta);
           statement.setString(1, fechaInicio);
           statement.setString(2, fechaFin);
            resultado = statement.executeQuery();
            int numeroLista = 1;
           
            
            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                totalIngresos +=resultado.getDouble("montoIngreso");
                filas.add(
                    new Object[]{
                    numeroLista++,
                    resultado.getString("fecha_pago"),
                    resultado.getDouble("montoIngreso"),       
                    
                   }
                );
            }
            datosPago = new Object[filas.size()][];
            filas.toArray(datosPago);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosPago;
    }
    
    }


