/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.KeyStroke;
import static presentacion.ListaProductos.RET_CANCEL;
import royal_gym.Productos;

/**
 *
 * @author Jazmin Vargas
 */
public class AgregarNuevoProducto  extends javax.swing.JDialog {
    Productos productos = new Productos();
    PanelCompras panelcompras;
    
    private final String[] columnasProductos = { "Código", "Descripción", "Medida", "Costo", "Precio de Venta", "Cantidad en Inventario"};
    
    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;
    
    public AgregarNuevoProducto(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(panelcompras);

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
         
    }

    public int getReturnStatus() {
        return returnStatus;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatosCliente = new javax.swing.JPanel();
        btnCancelarRegistroProducto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfDescripcionProducto = new javax.swing.JTextField();
        jtfCostoProducto = new javax.swing.JTextField();
        btnAceptarRegistroProducto = new javax.swing.JButton();
        jtfPrecioProducto = new javax.swing.JTextField();
        jcbMedidaProducto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jtfCantidad = new javax.swing.JTextField();

        panelDatosCliente.setBackground(new java.awt.Color(85, 96, 128));
        panelDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Datos de producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        panelDatosCliente.setToolTipText("");
        panelDatosCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelDatosClienteFocusGained(evt);
            }
        });

        btnCancelarRegistroProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cancelar.png"))); // NOI18N
        btnCancelarRegistroProducto.setText("Cancelar");
        btnCancelarRegistroProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRegistroProductoActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Descripción:");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Medida:");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Costo:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio de venta:");

        jtfDescripcionProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfDescripcionProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescripcionProductoActionPerformed(evt);
            }
        });
        jtfDescripcionProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDescripcionProductoKeyTyped(evt);
            }
        });

        jtfCostoProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfCostoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCostoProductoActionPerformed(evt);
            }
        });
        jtfCostoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCostoProductoKeyTyped(evt);
            }
        });

        btnAceptarRegistroProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Aceptar.png"))); // NOI18N
        btnAceptarRegistroProducto.setText("Aceptar");
        btnAceptarRegistroProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarRegistroProductoActionPerformed(evt);
            }
        });
        btnAceptarRegistroProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAceptarRegistroProductoKeyPressed(evt);
            }
        });

        jtfPrecioProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfPrecioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPrecioProductoActionPerformed(evt);
            }
        });
        jtfPrecioProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPrecioProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfPrecioProductoKeyTyped(evt);
            }
        });

        jcbMedidaProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gramo", "Kilogramo", "Libra", "Onza", "Unidad" }));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cantidad en inventario:");

        jtfCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCantidadActionPerformed(evt);
            }
        });
        jtfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelDatosClienteLayout = new javax.swing.GroupLayout(panelDatosCliente);
        panelDatosCliente.setLayout(panelDatosClienteLayout);
        panelDatosClienteLayout.setHorizontalGroup(
            panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfDescripcionProducto)
                        .addComponent(jLabel2)
                        .addGroup(panelDatosClienteLayout.createSequentialGroup()
                            .addComponent(btnAceptarRegistroProducto)
                            .addGap(65, 65, 65)
                            .addComponent(btnCancelarRegistroProducto))
                        .addComponent(jLabel1)
                        .addComponent(jcbMedidaProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtfCantidad, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfPrecioProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                        .addComponent(jtfCostoProducto, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosClienteLayout.setVerticalGroup(
            panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jtfDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jcbMedidaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(jtfCostoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(jtfPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarRegistroProducto)
                    .addComponent(btnCancelarRegistroProducto)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(panelDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarRegistroProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRegistroProductoActionPerformed
        jtfDescripcionProducto.setText("");
        jtfPrecioProducto.setText("");
        jtfCostoProducto.setText("");
        
        doClose(RET_CANCEL);
    }//GEN-LAST:event_btnCancelarRegistroProductoActionPerformed

     private void closeDialog(java.awt.event.WindowEvent evt) {                             
        doClose(RET_CANCEL);
    }         
    
    private void jtfDescripcionProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescripcionProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescripcionProductoActionPerformed

    private void jtfDescripcionProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescripcionProductoKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnAceptarRegistroProducto.doClick();
        }
    }//GEN-LAST:event_jtfDescripcionProductoKeyTyped

    private void jtfCostoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCostoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCostoProductoActionPerformed

    private void jtfCostoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCostoProductoKeyTyped

        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnAceptarRegistroProducto.doClick();
        }
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && jtfCostoProducto.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfCostoProductoKeyTyped

    private void btnAceptarRegistroProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarRegistroProductoActionPerformed
        productos.insertarProducto(jtfDescripcionProducto.getText(), jcbMedidaProducto.getSelectedItem().toString(), jtfCostoProducto.getText(), jtfPrecioProducto.getText(), jtfCantidad.getText());
        //productos.modeloTablaProductos(columnasProductos, tablaProductos);
        jtfDescripcionProducto.setText("");
        jcbMedidaProducto.setSelectedItem(null);
        jtfCostoProducto.setText("");
        jtfPrecioProducto.setText("");
        jtfCantidad.setText("");
    }//GEN-LAST:event_btnAceptarRegistroProductoActionPerformed

    private void btnAceptarRegistroProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarRegistroProductoKeyPressed

    }//GEN-LAST:event_btnAceptarRegistroProductoKeyPressed

    private void jtfPrecioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPrecioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPrecioProductoActionPerformed

    private void jtfPrecioProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPrecioProductoKeyReleased
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && jtfCostoProducto.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfPrecioProductoKeyReleased

    private void jtfPrecioProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPrecioProductoKeyTyped

        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnAceptarRegistroProducto.doClick();
        }
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && jtfPrecioProducto.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfPrecioProductoKeyTyped

    private void jtfCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCantidadActionPerformed

    private void jtfCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCantidadKeyReleased

    private void jtfCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCantidadKeyTyped

    private void panelDatosClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelDatosClienteFocusGained

    }//GEN-LAST:event_panelDatosClienteFocusGained
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarRegistroProducto;
    private javax.swing.JButton btnCancelarRegistroProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> jcbMedidaProducto;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfCostoProducto;
    private javax.swing.JTextField jtfDescripcionProducto;
    private javax.swing.JTextField jtfPrecioProducto;
    private javax.swing.JPanel panelDatosCliente;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_CANCEL;
}
