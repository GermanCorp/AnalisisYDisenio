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
        
        prp.setVisible(false);
    }
    
    

    public PanelCompras(double total, double subTotal, double isv, double descuento) {
        this.total = total;
        this.subTotal = subTotal;
        this.isv = isv;
        this.descuento = descuento;
    }

    public JTextField getJtfISVcompra() {
        return jtfISVcompra;
    }

    public void setJtfISVcompra(JTextField jtfISVcompra) {
        this.jtfISVcompra = jtfISVcompra;
    }

    public JTextField getJtfdescuentocompra() {
        return jtfdescuentocompra;
    }

    public void setJtfdescuentocompra(JTextField jtfdescuentocompra) {
        this.jtfdescuentocompra = jtfdescuentocompra;
    }

    public JTextField getJtfsubtotalcompra() {
        return jtfsubtotalcompra;
    }

    public void setJtfsubtotalcompra(JTextField jtfsubtotalcompra) {
        this.jtfsubtotalcompra = jtfsubtotalcompra;
    }

    public JTextField getJtftotalcompra() {
        return jtftotalcompra;
    }

    public void setJtftotalcompra(JTextField jtftotalcompra) {
        this.jtftotalcompra = jtftotalcompra;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIsv() {
        return isv;
    }

    public void setIsv(double isv) {
        this.isv = isv;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
        
    public void setValoresCompra(){
        jtfsubtotalcompra.setText("L. " + df.format(getSubTotal()));
        jtfISVcompra.setText("L." + df.format(getIsv()));
        jtfdescuentocompra.setText("- L. " + df.format(getDescuento()));
        jtftotalcompra.setText("L. " + df.format(getTotal()));
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
        botonagregarproducto = new javax.swing.JButton();
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

        setBackground(new java.awt.Color(85, 96, 128));
        setPreferredSize(new java.awt.Dimension(1223, 576));

        jbagregarcompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/iconos/Agregar_Producto.png"))); // NOI18N
        jbagregarcompra.setText("Agregar Compra");
        jbagregarcompra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbagregarcompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbagregarcompraActionPerformed(evt);
            }
        });

        jbguardarcompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/iconos/Guardar.png"))); // NOI18N
        jbguardarcompra.setText("Guardar");
        jbguardarcompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardarcompraActionPerformed(evt);
            }
        });

        jbeliminarcompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/iconos/Eliminar_fila.png"))); // NOI18N
        jbeliminarcompra.setText("Eliminar Fila");
        jbeliminarcompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbeliminarcompraActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Sub Total");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("DESCUENTO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("ISV %");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("TOTAL");

        botonagregarproducto.setText("Agregar Nuevo  Producto");
        botonagregarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonagregarproductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelagregarcompraLayout = new javax.swing.GroupLayout(panelagregarcompra);
        panelagregarcompra.setLayout(panelagregarcompraLayout);
        panelagregarcompraLayout.setHorizontalGroup(
            panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelagregarcompraLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jbagregarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jbguardarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jbeliminarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelagregarcompraLayout.createSequentialGroup()
                        .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfdescuentocompra, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfISVcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(botonagregarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(panelagregarcompraLayout.createSequentialGroup()
                        .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfsubtotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtftotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelagregarcompraLayout.setVerticalGroup(
            panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelagregarcompraLayout.createSequentialGroup()
                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelagregarcompraLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbagregarcompra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbguardarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbeliminarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelagregarcompraLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfsubtotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelagregarcompraLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfdescuentocompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfISVcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(panelagregarcompraLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(botonagregarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jtftotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );

        tablacompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cantidad", "Descripcion", "Precio Unitario", "Descuento", "Sub-total", "ISV%", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablacompras);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(panelagregarcompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelagregarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonagregarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonagregarproductoActionPerformed
        // TODO add your handling code here:
        prp.setVisible(true);

    }//GEN-LAST:event_botonagregarproductoActionPerformed

    private void jbeliminarcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbeliminarcompraActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) tablacompras.getModel(); //TableProducto es el nombre de mi tabla ;)
        dtm.removeRow(tablacompras.getSelectedRow());
    }//GEN-LAST:event_jbeliminarcompraActionPerformed

    private void jbguardarcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardarcompraActionPerformed
        DefaultTableModel modelo;

        try {
            for (int i = 0 ; i <tablacompras.getRowCount(); i++){
                Statement statement = Conexion.getConexion().createStatement();
                String consulta = "select cantidad from productos where idproducto = '" + tablacompras.getValueAt(i, 0).toString() + "'";
                ResultSet resultado = statement.executeQuery(consulta);

                String sql = "update productos set cantidad = ? where idproducto = '" + tablacompras.getValueAt(i, 0).toString() + "'";
                PreparedStatement psts = Conexion.getConexion().prepareStatement(sql);

                String cantidadTotal = resultado.getString("cantidad");
                double total = ((Double.parseDouble(cantidadTotal)) + (Double.parseDouble(tablacompras.getValueAt(i, 1).toString())));
                psts.setString(1,String.valueOf(total));
                psts.execute();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        modelo = (DefaultTableModel) tablacompras.getModel();
        for (int i = tablacompras.getRowCount() -1; i >= 0; i--){
            modelo.removeRow(i);
        }
        setValoresCompra();
    }//GEN-LAST:event_jbguardarcompraActionPerformed

    private void jbagregarcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbagregarcompraActionPerformed
        // TODO add your handling code here:
        new ListaProductosComprar(new javax.swing.JDialog(), true).setVisible(true);
    }//GEN-LAST:event_jbagregarcompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonagregarproducto;
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
    public static javax.swing.JTable tablacompras;
    // End of variables declaration//GEN-END:variables
}
