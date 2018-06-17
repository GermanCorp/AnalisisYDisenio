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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import static presentacion.PanelVentas.descuento;
import static presentacion.PanelVentas.isv;
import static presentacion.PanelVentas.jtablaProductosAVender;
import static presentacion.PanelVentas.subTotal;
import static presentacion.PanelVentas.total;
import royal_gym.Conexion;
import royal_gym.Productos;

/**
 *
 * @author Jazmin Vargas
 */
public class PanelCompras extends javax.swing.JPanel {
public static double total = 0;
    public static double subTotal = 0;
    public static double isv = 0;
    public static double descuento = 0;
    
    
    private static Statement statement;
    DecimalFormat df = new DecimalFormat("#,##0.00");
    
    public PanelCompras() {
        initComponents();
        jbagregarcompra.setHorizontalTextPosition( SwingConstants.CENTER );
        jbagregarcompra.setVerticalTextPosition( SwingConstants.BOTTOM );
        jbguardarcompra.setHorizontalTextPosition( SwingConstants.CENTER );
        jbguardarcompra.setVerticalTextPosition( SwingConstants.BOTTOM );
        jbeliminarcompra.setHorizontalTextPosition( SwingConstants.CENTER );
        jbeliminarcompra.setVerticalTextPosition(SwingConstants.BOTTOM);    
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
        jtfsubtotalcompra.setText("L. " + df.format(subTotal));
        jtfISVcompra.setText("L." + df.format(isv));
        jtfdescuentocompra.setText("- L. " + df.format(descuento));
        jtftotalcompra.setText("L. " + df.format(total));
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
        jLabel5 = new javax.swing.JLabel();
        jtfNumeoFactura = new javax.swing.JTextField();
        jtftotalcompra = new javax.swing.JTextField();
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
        setPreferredSize(new java.awt.Dimension(1223, 484));

        panelagregarcompra.setBackground(new java.awt.Color(85, 96, 128));

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
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sub Total");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DESCUENTO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ISV %");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TOTAL");

        jtfsubtotalcompra.setEditable(false);
        jtfsubtotalcompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfsubtotalcompra.setText("L.0.00");
        jtfsubtotalcompra.setPreferredSize(new java.awt.Dimension(41, 21));

        jtfdescuentocompra.setEditable(false);
        jtfdescuentocompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfdescuentocompra.setText("L.0.00");
        jtfdescuentocompra.setPreferredSize(new java.awt.Dimension(41, 21));

        jtfISVcompra.setEditable(false);
        jtfISVcompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfISVcompra.setText("L.0.00");
        jtfISVcompra.setPreferredSize(new java.awt.Dimension(41, 21));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("FACTURA No.:");

        jtfNumeoFactura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jtftotalcompra.setEditable(false);
        jtftotalcompra.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jtftotalcompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtftotalcompra.setText("L.0.00");

        javax.swing.GroupLayout panelagregarcompraLayout = new javax.swing.GroupLayout(panelagregarcompra);
        panelagregarcompra.setLayout(panelagregarcompraLayout);
        panelagregarcompraLayout.setHorizontalGroup(
            panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelagregarcompraLayout.createSequentialGroup()
                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelagregarcompraLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfNumeoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelagregarcompraLayout.createSequentialGroup()
                        .addComponent(jbagregarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jbguardarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addComponent(jbeliminarcompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelagregarcompraLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfsubtotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelagregarcompraLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfdescuentocompra, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelagregarcompraLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfISVcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelagregarcompraLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtftotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelagregarcompraLayout.setVerticalGroup(
            panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelagregarcompraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbeliminarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelagregarcompraLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfsubtotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(8, 8, 8)
                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfdescuentocompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfISVcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtftotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)))
            .addGroup(panelagregarcompraLayout.createSequentialGroup()
                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfNumeoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelagregarcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbguardarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbagregarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
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
                    .addComponent(panelagregarcompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(9, 9, 9)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelagregarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbeliminarcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbeliminarcompraActionPerformed
        DefaultTableModel modelo;
        int filaSeleccinada = tablacompras.getSelectedRow();
        
        if(filaSeleccinada == -1){
            JOptionPane.showMessageDialog(null, "Seleccione un producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }else{
            Double totalPorProducto = (Double.parseDouble(tablacompras.getValueAt(filaSeleccinada, 7).toString()));
        Double descuentoPorProducto = (Double.parseDouble(tablacompras.getValueAt(filaSeleccinada, 4).toString()));

        total = total - totalPorProducto;
        descuento = descuento - descuentoPorProducto;
        isv = total*0.15;
        subTotal = total - isv;
        
        
        modelo = (DefaultTableModel) tablacompras.getModel();
        modelo.removeRow(filaSeleccinada);
        
        setValoresCompra();
        }
    }//GEN-LAST:event_jbeliminarcompraActionPerformed

    private void jbguardarcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardarcompraActionPerformed
       DefaultTableModel modelo;
        if(total == 0){
           JOptionPane.showMessageDialog(null, "No hay ninguna venta que guardar");
        }else
           
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
        new ListaProductosCompra(new javax.swing.JDialog(), true).setVisible(true);
    }//GEN-LAST:event_jbagregarcompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.toedter.components.JLocaleChooser jLocaleChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbagregarcompra;
    private javax.swing.JButton jbeliminarcompra;
    private javax.swing.JButton jbguardarcompra;
    public static javax.swing.JTextField jtfISVcompra;
    private javax.swing.JTextField jtfNumeoFactura;
    public static javax.swing.JTextField jtfdescuentocompra;
    public static javax.swing.JTextField jtfsubtotalcompra;
    public static javax.swing.JTextField jtftotalcompra;
    private javax.swing.JPanel panelagregarcompra;
    public static javax.swing.JTable tablacompras;
    // End of variables declaration//GEN-END:variables
}
