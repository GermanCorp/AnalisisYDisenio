package royal_gym;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static royal_gym.Clientes.resultado;

public class Productos {
    
    private static Statement statement;
    static ResultSet resultado;
    
    public void modeloTablaProductos(String[] columnas, JTable tabla) {
        DefaultTableModel modeloTablaProductos = new DefaultTableModel(getProductos(), columnas);
        tabla.setModel(modeloTablaProductos);
    }
    
    public String formatearNumero(double numero) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(numero);
    }
        
    public Object[][] getProductos() {
        Object[][] datosProductos = null;
        try {
            String consulta = "select idproducto, descripcion, unidad, costo, precioventa, cantidad from productos";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);

            //int numeroLista = 1;
            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            //numeroLista++,
                            resultado.getInt("idproducto"),
                            resultado.getString("descripcion"),
                            resultado.getString("unidad"),
                            formatearNumero(resultado.getDouble("costo")),
                            formatearNumero(resultado.getDouble("precioventa")),
                            formatearNumero(resultado.getDouble("cantidad")),
                        }
                );
            }
            datosProductos= new Object[filas.size()][];
            filas.toArray(datosProductos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosProductos;
    }
    
    public Object[][] getListaProductos() {
        Object[][] datosProductos = null;
        try {
            String consulta = "select idproducto, descripcion, precioventa from productos";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);

            //int numeroLista = 1;
            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            //numeroLista++,
                            resultado.getInt("idproducto"),
                            resultado.getString("descripcion"),
                            resultado.getDouble("precioventa")
                        }
                );
            }
            datosProductos= new Object[filas.size()][];
            filas.toArray(datosProductos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosProductos;
    }
    
    //lista de productos para la compra
    public Object[][] getListaProductos1() {
        Object[][] datosProductos = null;
        try {
            String consulta = "select idproducto, descripcion, costo from productos";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);

            //int numeroLista = 1;
            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            //numeroLista++,
                            resultado.getInt("idproducto"),
                            resultado.getString("descripcion"),
                            resultado.getDouble("costo")
                        }
                );
            }
            datosProductos= new Object[filas.size()][];
            filas.toArray(datosProductos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosProductos;
    }
    
    public Object[][] buscarProductos(String descripcion) {
        Object[][] datosProductos = null;
        try {
            String consulta = "select * FROM productos WHERE descripcion LIKE '%' || ? || '%'";
            PreparedStatement statement = Conexion.getConexion().prepareStatement(consulta);
            statement.setString(1, descripcion);

            resultado = statement.executeQuery();
            
            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            //numeroLista++,
                            resultado.getInt("idproducto"),
                            resultado.getString("descripcion"),
                            resultado.getString("unidad"),
                            formatearNumero(resultado.getDouble("costo")),
                            formatearNumero(resultado.getDouble("precioventa")),
                            formatearNumero(resultado.getDouble("cantidad"))
                        }
                );
            }
            datosProductos= new Object[filas.size()][];
            filas.toArray(datosProductos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosProductos;
    }
    
     public Object[][] buscarListaProductos(String descripcion) {
        Object[][] datosProductos = null;
        try {
            String consulta = "select idproducto, descripcion, precioventa FROM productos WHERE descripcion LIKE '%' || ? || '%'";
            PreparedStatement statement = Conexion.getConexion().prepareStatement(consulta);
            statement.setString(1, descripcion);

            resultado = statement.executeQuery();
            
            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            //numeroLista++,
                            resultado.getInt("idproducto"),
                            resultado.getString("descripcion"),
                            formatearNumero(resultado.getDouble("precioventa"))
                        }
                );
            }
            datosProductos= new Object[filas.size()][];
            filas.toArray(datosProductos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosProductos;
    }
    
    public void eliminarProducto(String id) {

        try {
            String sql = "Delete from productos where idproducto = ?";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, id);
            consulta.execute();

        } catch (Exception e) {
            System.out.println("error en Eliminar producto" + e.getMessage());
        }
    }
    
    public void insertarProducto(String descripcion, String unidad, String costo, String precioventa, String cantidad) {
        try {
            String sql = "insert into productos (descripcion, unidad, costo, precioventa, cantidad) values (?,?,?,?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, descripcion);
            consulta.setString(2, unidad);
            consulta.setString(3, costo);
            consulta.setString(4, precioventa);
            consulta.setString(5, cantidad);
            consulta.execute();
        } catch (Exception e) {
            System.out.println("Error en Insertar Producuto "+e.getMessage());
        }
    }
    
    public String getPrecioProducto() {
        String datosProductos = "";
        try {
            String consulta = "select precioventa from productos";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);
            
            while(resultado.next()){
                datosProductos= resultado.getString("precioventa");
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datosProductos;
    }
    
        public void modificarProducto(String descripcion, String unidad, String costo, String precioventa, String cantidad, String id) {
        try {
            String sql = "update productos set descripcion = ?, unidad = ?, costo = ?, precioventa = ?, cantidad = ? where idproducto = ?";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, descripcion);
            consulta.setString(2, unidad);
            consulta.setString(3, costo);
            consulta.setString(4, precioventa);
            consulta.setString(5, cantidad);
            consulta.setString(6, id);
            consulta.execute();

        } catch (Exception e) {
            System.out.println("error en Modificar Cliente" + e.getMessage());
        }
    }
    
}
