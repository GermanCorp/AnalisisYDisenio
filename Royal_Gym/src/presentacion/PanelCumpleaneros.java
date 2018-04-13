package presentacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import royal_gym.Conexion;
import royal_gym.Cumpleaneros;

public class PanelCumpleaneros extends javax.swing.JPanel {
    
    Conexion con = new Conexion();
     static private Connection conexion;
    private static Statement statement;
    static ResultSet resultado;
  
    
    // columnas de la tabla Cumpleaneros
    private final String[] columnasCumpleaneros = {
        "No.",
        "Nombre",
        "Fecha de Nacimiento",
        "Edad a Cumplir"
    };

    public PanelCumpleaneros() {
        initComponents();
        this.con = new Conexion();
        con.conectar();
         
         // Modelo de la tabla de cumpleaneros
        DefaultTableModel modeloTablaCumpleaneros = new DefaultTableModel(con.getEdadClientes(), columnasCumpleaneros);
        tablaDeCumpleaneros.setModel(modeloTablaCumpleaneros);
        
        
    }
    
    // método para llenar la tabla de edad de los clientes
    public Object[][] getEdadClientes() {
        Object[][] datosCliente = null;

        try {
            String consulta = "Select * FROM Edad";
            statement = Conexion.getConexion().createStatement();
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

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDeCumpleaneros = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };

        jPanel6.setBackground(new java.awt.Color(85, 96, 128));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Cumpleaneros Del Mes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        tablaDeCumpleaneros.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaDeCumpleaneros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaDeCumpleaneros);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaDeCumpleaneros;
    // End of variables declaration//GEN-END:variables
}
