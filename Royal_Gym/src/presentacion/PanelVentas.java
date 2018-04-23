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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import royal_gym.Clientes;
import royal_gym.Conexion;

/**
 *
 * @author Alexis
 */
public class PanelVentas extends javax.swing.JPanel {
    public double total;
    private double subTotal;
    private double isv;
    private double descuento;
    private String cliente;
    private static Statement statement;
    DecimalFormat df = new DecimalFormat("#,##0.00");
   
    public PanelVentas() {
        initComponents();
        jbAgregarCliente.setHorizontalTextPosition( SwingConstants.CENTER );
        jbAgregarCliente.setVerticalTextPosition( SwingConstants.BOTTOM );
        jbAgregarProducto.setHorizontalTextPosition( SwingConstants.CENTER );
        jbAgregarProducto.setVerticalTextPosition( SwingConstants.BOTTOM );
        jbAGuardarVenta.setHorizontalTextPosition( SwingConstants.CENTER );
        jbAGuardarVenta.setVerticalTextPosition( SwingConstants.BOTTOM );
        jbEliminarFila.setHorizontalTextPosition( SwingConstants.CENTER );
        jbEliminarFila.setVerticalTextPosition(SwingConstants.BOTTOM);        
    }
    
    public PanelVentas(String cliente) {
        this.cliente = cliente;
    }
    
    public PanelVentas (double total, double subTotal, double isv, double descuento){
        this.total = total;
        this.subTotal = subTotal;
        this.isv = isv;
        this.descuento = descuento;
    }

    public static JTextField getJtfDescuento() {
        return jtfDescuento;
    }

    public static void setJtfDescuento(JTextField jtfDescuento) {
        PanelVentas.jtfDescuento = jtfDescuento;
    }

    public static JTextField getJtfISV() {
        return jtfISV;
    }

    public static void setJtfISV(JTextField jtfISV) {
        PanelVentas.jtfISV = jtfISV;
    }

    public static JTextField getJtfSubTotal() {
        return jtfSubTotal;
    }

    public static void setJtfSubTotal(JTextField jtfSubTotal) {
        PanelVentas.jtfSubTotal = jtfSubTotal;
    }

    public static JTextField getJtfTotalVenta() {
        return jtfTotalVenta;
    }

    public static void setJtfTotalVenta(JTextField jtfTotalVenta) {
        PanelVentas.jtfTotalVenta = jtfTotalVenta;
    }

    
    public String getCliente() {
        return cliente;
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

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public void setNombreCliente(){
        jtfNombre.setText(getCliente());
    }
    
    public void setValoresVenta(){
        jtfSubTotal.setText("L. " + df.format(getSubTotal()));
        jtfISV.setText("L." + df.format(getIsv()));
        jtfDescuento.setText("- L. " + df.format(getDescuento()));
        jtfTotalVenta.setText("L. " + df.format(getTotal()));
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtfDireccion = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfTelefono = new javax.swing.JTextField();
        jtfTotalVenta = new javax.swing.JTextField();
        jtfDescuento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbAgregarProducto = new javax.swing.JButton();
        jbAgregarCliente = new javax.swing.JButton();
        jbAGuardarVenta = new javax.swing.JButton();
        jbEliminarFila = new javax.swing.JButton();
        jtfISV = new javax.swing.JTextField();
        jtfSubTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfNumeoFactura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablaProductosAVender = new javax.swing.JTable();

        setBackground(new java.awt.Color(85, 96, 128));

        jPanel1.setBackground(new java.awt.Color(85, 96, 128));

        jtfDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfDireccion.setText("DIRECCIÓN:");
        jtfDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDireccionActionPerformed(evt);
            }
        });

        jtfNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfNombre.setText("NOMBRE:");

        jtfTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfTelefono.setText("TEL:");

        jtfTotalVenta.setEditable(false);
        jtfTotalVenta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jtfTotalVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfTotalVenta.setText("L.0.00");

        jtfDescuento.setEditable(false);
        jtfDescuento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfDescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfDescuento.setText("L.0.00");
        jtfDescuento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfDescuentoFocusLost(evt);
            }
        });
        jtfDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescuentoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("DESCUENTO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TOTAL");

        jbAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Agregar_Producto.png"))); // NOI18N
        jbAgregarProducto.setText("Productos");
        jbAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarProductoActionPerformed(evt);
            }
        });

        jbAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Agregar_Cliente.png"))); // NOI18N
        jbAgregarCliente.setText("Clientes");
        jbAgregarCliente.setDisabledIcon(null);
        jbAgregarCliente.setDisabledSelectedIcon(null);
        jbAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarClienteActionPerformed(evt);
            }
        });

        jbAGuardarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Guardar.png"))); // NOI18N
        jbAGuardarVenta.setText("Guardar");
        jbAGuardarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAGuardarVentaActionPerformed(evt);
            }
        });

        jbEliminarFila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Eliminar_fila.png"))); // NOI18N
        jbEliminarFila.setText("<html>\n<center>Eliminar<center>\n <center>Producto<center>");

        jtfISV.setEditable(false);
        jtfISV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfISV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfISV.setText("L.0.00");
        jtfISV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfISVActionPerformed(evt);
            }
        });

        jtfSubTotal.setEditable(false);
        jtfSubTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfSubTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfSubTotal.setText("L.0.00");
        jtfSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSubTotalActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("ISV %");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Sub Total");

        jtfNumeoFactura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("FACTURA No.:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbAGuardarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfDireccion)
                            .addComponent(jtfTelefono)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jbEliminarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNumeoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfTotalVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(jtfSubTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfDescuento)
                    .addComponent(jtfISV)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel4)
                        .addComponent(jtfSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(jtfNumeoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfISV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(jtfTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbAGuardarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jtfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jtfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbEliminarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(85, 96, 128));

        jtablaProductosAVender.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtablaProductosAVender.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cantidad", "Descripción", "Precio Unitario", "Descuento", "Sub-total", "ISV%", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtablaProductosAVender.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtablaProductosAVenderFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtablaProductosAVenderFocusLost(evt);
            }
        });
        jtablaProductosAVender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtablaProductosAVenderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtablaProductosAVender);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescuentoActionPerformed

    private void jtfDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDireccionActionPerformed

    private void jbAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarProductoActionPerformed
        new ListaProductos(new javax.swing.JDialog(), true).setVisible(true);
    }//GEN-LAST:event_jbAgregarProductoActionPerformed

    private void jbAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarClienteActionPerformed
        //NewOkCancelDialog clientes = new ListaClientes(new javax.swing.JDialog(), true);
        //clientes.setVisible(true);
        new ListaClientes(new javax.swing.JDialog(), true).setVisible(true);
    }//GEN-LAST:event_jbAgregarClienteActionPerformed

    private void jtfISVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfISVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfISVActionPerformed

    private void jtfSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSubTotalActionPerformed

    private void jtablaProductosAVenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablaProductosAVenderMouseClicked
        
    }//GEN-LAST:event_jtablaProductosAVenderMouseClicked

    private void jtablaProductosAVenderFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtablaProductosAVenderFocusGained

    }//GEN-LAST:event_jtablaProductosAVenderFocusGained

    private void jtablaProductosAVenderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtablaProductosAVenderFocusLost

    }//GEN-LAST:event_jtablaProductosAVenderFocusLost

    private void jtfDescuentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfDescuentoFocusLost
  
    }//GEN-LAST:event_jtfDescuentoFocusLost

    private void jbAGuardarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAGuardarVentaActionPerformed
        DefaultTableModel modelo;
        
        try {
            for (int i = 0 ; i <jtablaProductosAVender.getRowCount(); i++){
                PreparedStatement pStatement = Conexion.getConexion().prepareStatement("insert into detallefactura(factura, idProducto, cantidad,descuento) values (?,?,?,?)");
                pStatement.setString(1, jtfNumeoFactura.getText());
                pStatement.setString(2, jtablaProductosAVender.getValueAt(i, 0).toString());
                pStatement.setString(3, jtablaProductosAVender.getValueAt(i, 1).toString());
                pStatement.setString(4, jtablaProductosAVender.getValueAt(i, 4).toString());
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
        setValoresVenta();
    }//GEN-LAST:event_jbAGuardarVentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAGuardarVenta;
    private javax.swing.JButton jbAgregarCliente;
    private javax.swing.JButton jbAgregarProducto;
    private javax.swing.JButton jbEliminarFila;
    public static javax.swing.JTable jtablaProductosAVender;
    private static javax.swing.JTextField jtfDescuento;
    private javax.swing.JTextField jtfDireccion;
    private static javax.swing.JTextField jtfISV;
    private static javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfNumeoFactura;
    private static javax.swing.JTextField jtfSubTotal;
    private javax.swing.JTextField jtfTelefono;
    private static javax.swing.JTextField jtfTotalVenta;
    // End of variables declaration//GEN-END:variables
}
