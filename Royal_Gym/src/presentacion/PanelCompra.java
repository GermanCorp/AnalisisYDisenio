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
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static presentacion.PanelVentas.descuento;
import static presentacion.PanelVentas.isv;
import static presentacion.PanelVentas.jtablaProductosAVender;
import static presentacion.PanelVentas.numeroFactura;
import static presentacion.PanelVentas.subTotal;
import static presentacion.PanelVentas.total;
import royal_gym.Conexion;

/**
 *
 * @author Jazmin Vargas
 */
public class PanelCompra extends javax.swing.JPanel {

    public static double totalCompra = 0;
    public static double subTotalCompra = 0;
    public static double isvCompra = 0;
    public static double descuentoCompra = 0;
    static ResultSet resultado;
    java.util.Date date = new Date();
    java.sql.Date fechaActual = new java.sql.Date(date.getTime());
    
    
    private static Statement statement;
    DecimalFormat df = new DecimalFormat("#,##0.00");
    DecimalFormat fac = new DecimalFormat("00000000");
    int nfac = numeroFactura();
    
    public PanelCompra() {
        initComponents();
    }
    
     public PanelCompra(double totalCompra, double subTotalCompra, double isvCompra, double descuentoCompra) {
        this.totalCompra = totalCompra;
        this.subTotalCompra= subTotalCompra;
        this.isvCompra = isvCompra;
        this.descuentoCompra = descuentoCompra;
    }

    public static double getTotalCompra() {
        return totalCompra;
    }

    public static void setTotalCompra(double totalCompra) {
        PanelCompra.totalCompra = totalCompra;
    }

    public static double getSubTotalCompra() {
        return subTotalCompra;
    }

    public static void setSubTotalCompra(double subTotalCompra) {
        PanelCompra.subTotalCompra = subTotalCompra;
    }

    public static double getIsvCompra() {
        return isvCompra;
    }

    public static void setIsvCompra(double isvCompra) {
        PanelCompra.isvCompra = isvCompra;
    }

    public static double getDescuentoCompra() {
        return descuentoCompra;
    }

    public static void setDescuentoCompra(double descuentoCompra) {
        PanelCompra.descuentoCompra = descuentoCompra;
    }
      
    public void setValoresCompra(){
        jTextFieldSubTotalCompra.setText("L. " + df.format(subTotalCompra));
        jTextFieldISVCompra.setText("L." + df.format(isvCompra));
        jTextFieldDescuentoCompra.setText("- L. " + df.format(descuentoCompra));
        jTextFieldTotalCompra.setText("L. " + df.format(totalCompra));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCompras = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfNumeoFactura = new javax.swing.JTextField();
        botonAgregarCompra = new javax.swing.JButton();
        botonGuardarCompra = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSubTotalCompra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDescuentoCompra = new javax.swing.JTextField();
        jTextFieldISVCompra = new javax.swing.JTextField();
        jTextFieldTotalCompra = new javax.swing.JTextField();

        setBackground(new java.awt.Color(85, 96, 128));
        setPreferredSize(new java.awt.Dimension(1223, 484));

        tablaCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cantidad", "Descripcion", "Precio Unitario", "Descuento", "Sub-total", "ISV%", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaCompras);

        jPanel1.setBackground(new java.awt.Color(85, 96, 128));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FACTURA No.:");

        botonAgregarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Agregar_Producto.png"))); // NOI18N
        botonAgregarCompra.setText("Agregar Compra");
        botonAgregarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarCompraActionPerformed(evt);
            }
        });

        botonGuardarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Guardar.png"))); // NOI18N
        botonGuardarCompra.setText("Guardar Compra");
        botonGuardarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarCompraActionPerformed(evt);
            }
        });

        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Eliminar_fila.png"))); // NOI18N
        botonEliminar.setText("Eliminar Fila");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sub Total");

        jTextFieldSubTotalCompra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldSubTotalCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSubTotalCompra.setText("L.0.00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DESCUENTO");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ISV %");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TOTAL");

        jTextFieldDescuentoCompra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldDescuentoCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDescuentoCompra.setText("L.0.00");

        jTextFieldISVCompra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldISVCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldISVCompra.setText("L.0.00");
        jTextFieldISVCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldISVCompraActionPerformed(evt);
            }
        });

        jTextFieldTotalCompra.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldTotalCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotalCompra.setText("L.0.00");
        jTextFieldTotalCompra.setPreferredSize(new java.awt.Dimension(6, 31));
        jTextFieldTotalCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonAgregarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(botonGuardarCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                        .addComponent(botonEliminar)
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfNumeoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldISVCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(jTextFieldDescuentoCompra, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldSubTotalCompra, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldTotalCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfNumeoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonAgregarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonGuardarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSubTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDescuentoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldISVCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarCompraActionPerformed
        DefaultTableModel modelo;
        if(totalCompra == 0){
           JOptionPane.showMessageDialog(null, "No hay ninguna compra que guardar");
            //royal_gym.VP.jlMensajes.setText("No hay ninguna compra que guardar");
        }else
            
              try {
                for (int i = 0; i < jtablaProductosAVender.getRowCount(); i++) {
                    PreparedStatement pStatement = Conexion.getConexion().prepareStatement("insert into detalleFacturaCompra(fecha, factura, idProducto, cantidad, descuento) values (?, ?,?,?,?)");
                    pStatement.setString(1, String.valueOf(fechaActual));
                    pStatement.setString(2, String.valueOf(nfac));
                    pStatement.setString(3, jtablaProductosAVender.getValueAt(i, 0).toString());
                    pStatement.setString(4, jtablaProductosAVender.getValueAt(i, 1).toString());
                    pStatement.setString(5, jtablaProductosAVender.getValueAt(i, 4).toString());
                    pStatement.execute();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }


           
           try {
            for (int i = 0 ; i <tablaCompras.getRowCount(); i++){
                Statement statement = Conexion.getConexion().createStatement();
                String consulta = "select cantidad from productos where idproducto = '" + tablaCompras.getValueAt(i, 0).toString() + "'";
                ResultSet resultado = statement.executeQuery(consulta);

                String sql = "update productos set cantidad = ? where idproducto = '" + tablaCompras.getValueAt(i, 0).toString() + "'";
                PreparedStatement psts = Conexion.getConexion().prepareStatement(sql);

                String cantidadTotal = resultado.getString("cantidad");
                double total = ((Double.parseDouble(cantidadTotal)) + (Double.parseDouble(tablaCompras.getValueAt(i, 1).toString())));
                psts.setString(1,String.valueOf(total));
                psts.execute();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        modelo = (DefaultTableModel) tablaCompras.getModel();
        for (int i = tablaCompras.getRowCount() -1; i >= 0; i--){
            modelo.removeRow(i);
        }
        total = 0;
            subTotal = 0;
            isv = 0;
            descuento = 0;
            setValoresCompra();
            royal_gym.VP.jlMensajes.setText("¡Compra registrada exitosamente!");
            nfac += 1;
            jtfNumeoFactura.setText(fac.format(nfac));
    }//GEN-LAST:event_botonGuardarCompraActionPerformed

    private void jTextFieldTotalCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalCompraActionPerformed

    private void jTextFieldISVCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldISVCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldISVCompraActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        DefaultTableModel modelo;
        int filaSeleccinada = tablaCompras.getSelectedRow();
        
        if(filaSeleccinada == -1){
            JOptionPane.showMessageDialog(null, "Seleccione un producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            //royal_gym.VP.jlMensajes.setText("Seleccione un Producto");
        }else{
            Double totalPorProducto = (Double.parseDouble(tablaCompras.getValueAt(filaSeleccinada, 7).toString()));
            Double descuentoPorProducto = (Double.parseDouble(tablaCompras.getValueAt(filaSeleccinada, 4).toString()));

        totalCompra = totalCompra - totalPorProducto;
        descuentoCompra = descuentoCompra - descuentoPorProducto;
        isvCompra = totalCompra *0.15;
        subTotalCompra = totalCompra - isvCompra;
        
        
        modelo = (DefaultTableModel) tablaCompras.getModel();
        modelo.removeRow(filaSeleccinada);
        
        setValoresCompra();
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonAgregarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarCompraActionPerformed
        new ListaProductosComprar(new javax.swing.JDialog(), true).setVisible(true);
    }//GEN-LAST:event_botonAgregarCompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarCompra;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardarCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldDescuentoCompra;
    private javax.swing.JTextField jTextFieldISVCompra;
    private javax.swing.JTextField jTextFieldSubTotalCompra;
    private javax.swing.JTextField jTextFieldTotalCompra;
    private javax.swing.JTextField jtfNumeoFactura;
    public static javax.swing.JTable tablaCompras;
    // End of variables declaration//GEN-END:variables
}
