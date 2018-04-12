/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static presentacion.PanelVentas.jtablaProductosAVender;
import royal_gym.Conexion;
import royal_gym.Productos;

/**
 *
 * @author Jazmin Vargas
 */
public class PanelCompras extends javax.swing.JPanel {

    PanelRegistroProductos prp = new PanelRegistroProductos();
    public double total;
    private double subTotal;
    private double isv;
    private double descuento;
    
    private static Statement statement;
    DecimalFormat df = new DecimalFormat("#,##0.00");
    
    public PanelCompras() {
        initComponents();
    }
    
     public PanelCompras (double total, double subTotal, double isv, double descuento){
        this.total = total;
        this.subTotal = subTotal;
        this.isv = isv;
        this.descuento = descuento;
    }
     
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLocaleChooser1 = new com.toedter.components.JLocaleChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelagregarcompra = new javax.swing.JPanel();
        jbagregarcompra = new javax.swing.JButton();
        jbguardarcompra = new javax.swing.JButton();
        jbeliminarcompra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfsubtotalcompra = new javax.swing.JTextField();
        jtfdescuentocompra = new javax.swing.JTextField();
        jtfISVcompra = new javax.swing.JTextField();
        jtftotalcompra = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablacompras = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setPreferredSize(new java.awt.Dimension(1122, 142));

        jbagregarcompra.setText("Agregar Compra");
        jbagregarcompra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbagregarcompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbagregarcompraActionPerformed(evt);
            }
        });

        jbguardarcompra.setText("Guardar");
        jbguardarcompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardarcompraActionPerformed(evt);
            }
        });

        jbeliminarcompra.setText("Eliminar Compra");

        jLabel1.setText("Sub Total");

        jLabel2.setText("DESCUENTO");

        jLabel3.setText("ISV %");

        jLabel4.setText("TOTAL");

        jButton3.setText("Agregar Nuevo Producto");

        javax.swing.GroupLayout panelagregarcompraLayout = new javax.swing.GroupLayout(panelagregarcompra);
        panelagregarcompra.setLayout(panelagregarcompraLayout);
        panelagregarcompraLayout.setHorizontalGroup(
            panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelagregarcompraLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jbagregarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jbguardarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jbeliminarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelagregarcompraLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelagregarcompraLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfdescuentocompra, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelagregarcompraLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfsubtotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelagregarcompraLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfISVcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtftotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap())
        );
        panelagregarcompraLayout.setVerticalGroup(
            panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelagregarcompraLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jbeliminarcompra, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                        .addComponent(jbagregarcompra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbguardarcompra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelagregarcompraLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfsubtotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelagregarcompraLayout.createSequentialGroup()
                                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfdescuentocompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jtfISVcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jtftotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tablacompras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablacompras);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelagregarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panelagregarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbagregarcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbagregarcompraActionPerformed
        // TODO add your handling code here:
         new ListaProductos(new javax.swing.JDialog(), true).setVisible(true);
    }//GEN-LAST:event_jbagregarcompraActionPerformed

    private void jbguardarcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardarcompraActionPerformed
       DefaultTableModel modelo;
        
        try {
            for (int i = 0 ; i <jtablaProductosAVender.getRowCount(); i++){
                PreparedStatement pStatement = Conexion.getConexion().prepareStatement("insert into detallefactura(factura, idProducto, cantidad,descuento) values (?,?,?,?)");
                pStatement.setString(1, jtablaProductosAVender.getValueAt(i, 0).toString());
                pStatement.setString(2, jtablaProductosAVender.getValueAt(i, 1).toString());
                pStatement.setString(3, jtablaProductosAVender.getValueAt(i, 4).toString());
                pStatement.execute();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            for (int i = 0 ; i <jtablaProductosAVender.getRowCount(); i++){
                Statement statement = Conexion.getConexion().createStatement();
                String consulta2 = "select cantidad from productos where idproducto = '" + jtablaProductosAVender.getValueAt(i, 0).toString() + "'";        
                ResultSet resultado2 = statement.executeQuery(consulta2);
               
                String sql = "update productos set cantidad = ? where idproducto = '" + jtablaProductosAVender.getValueAt(i, 0).toString() + "'";  
                PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
               
                String cantidadTotal = resultado2.getString("cantidad");
                double total = ((Double.parseDouble(cantidadTotal)) - (Double.parseDouble(jtablaProductosAVender.getValueAt(i, 1).toString())));
                consulta.setString(1,String.valueOf(total));
                consulta.execute();
            }
            
            } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        modelo = (DefaultTableModel) jtablaProductosAVender.getModel();
        for (int i = jtablaProductosAVender.getRowCount() -1; i >= 0; i--){
            modelo.removeRow(i);
        }
        //setValoresVenta();
    }//GEN-LAST:event_jbguardarcompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private com.toedter.components.JLocaleChooser jLocaleChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbagregarcompra;
    private javax.swing.JButton jbeliminarcompra;
    private javax.swing.JButton jbguardarcompra;
    private javax.swing.JTextField jtfISVcompra;
    private javax.swing.JTextField jtfdescuentocompra;
    private javax.swing.JTextField jtfsubtotalcompra;
    private javax.swing.JTextField jtftotalcompra;
    private javax.swing.JPanel panelagregarcompra;
    private javax.swing.JTable tablacompras;
    // End of variables declaration//GEN-END:variables
}
