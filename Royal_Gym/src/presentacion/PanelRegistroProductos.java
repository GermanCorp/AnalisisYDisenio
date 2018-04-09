package presentacion;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import royal_gym.Clientes;
import royal_gym.Productos;

public class PanelRegistroProductos extends javax.swing.JPanel {
    Productos productos = new Productos();
    
    //Columnas de la tabla Clientes
    private final String[] columnasProductos = { "Código", "Descripción", "Medida", "Costo", "Precio de Venta", "Cantidad en Inventario"};
   
    //Constructor
    public PanelRegistroProductos() {
        initComponents();
        productos.modeloTablaProductos(columnasProductos, tablaProductos);
    }
    
   public void actualizarTablaProductos(){
       productos.modeloTablaProductos(columnasProductos, tablaProductos);
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItemModificar = new javax.swing.JMenuItem();
        jMenuItemEliminar = new javax.swing.JMenuItem();
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
        PanelTabla = new javax.swing.JPanel();
        scrollTablaClientes = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jtfBuscarProductos = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jMenuItemModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/jpop_modificar.png"))); // NOI18N
        jMenuItemModificar.setText("Modificar");
        jMenuItemModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemModificarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemModificarMousePressed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemModificar);

        jMenuItemEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/jpop_eliminar.png"))); // NOI18N
        jMenuItemEliminar.setText("Eliminar");
        jMenuItemEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemEliminarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemEliminarMousePressed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemEliminar);

        setBackground(new java.awt.Color(85, 96, 128));

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
                        .addComponent(jtfDescripcionProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
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
                .addContainerGap(57, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarRegistroProducto)
                    .addComponent(btnCancelarRegistroProducto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTabla.setBackground(new java.awt.Color(85, 96, 128));
        PanelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Productos Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        tablaProductos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProductos.setAutoscrolls(true);
        tablaProductos.setComponentPopupMenu(jPopupMenu1);
        tablaProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaProductosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaProductosMouseReleased(evt);
            }
        });
        scrollTablaClientes.setViewportView(tablaProductos);

        jtfBuscarProductos.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jtfBuscarProductos.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfBuscarProductosCaretUpdate(evt);
            }
        });
        jtfBuscarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarProductosActionPerformed(evt);
            }
        });
        jtfBuscarProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfBuscarProductosKeyPressed(evt);
            }
        });

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTablaLayout = new javax.swing.GroupLayout(PanelTabla);
        PanelTabla.setLayout(PanelTablaLayout);
        PanelTablaLayout.setHorizontalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTablaLayout.createSequentialGroup()
                .addGroup(PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelTablaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(PanelTablaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollTablaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                            .addComponent(jtfBuscarProductos))))
                .addGap(20, 20, 20))
        );
        PanelTablaLayout.setVerticalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfBuscarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTablaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(PanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarRegistroProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRegistroProductoActionPerformed
        jtfDescripcionProducto.setText("");
        jtfPrecioProducto.setText("");
        jtfCostoProducto.setText("");
    }//GEN-LAST:event_btnCancelarRegistroProductoActionPerformed

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
        productos.modeloTablaProductos(columnasProductos, tablaProductos);
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

    private void panelDatosClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelDatosClienteFocusGained

    }//GEN-LAST:event_panelDatosClienteFocusGained

    private void jtfBuscarProductosCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfBuscarProductosCaretUpdate
        DefaultTableModel modeloTablaBuscarProductos = new DefaultTableModel(productos.buscarProductos(jtfBuscarProductos.getText()), columnasProductos);
        tablaProductos.setModel(modeloTablaBuscarProductos);
    }//GEN-LAST:event_jtfBuscarProductosCaretUpdate

    private void jtfBuscarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarProductosActionPerformed

    private void jtfBuscarProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarProductosKeyPressed

    }//GEN-LAST:event_jtfBuscarProductosKeyPressed

    private void tablaProductosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseReleased

    }//GEN-LAST:event_tablaProductosMouseReleased

    private void tablaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMousePressed
            Point point = evt.getPoint();
            int currentRow = tablaProductos.rowAtPoint(point);
            tablaProductos.setRowSelectionInterval(currentRow, currentRow);
            
            
            
    }//GEN-LAST:event_tablaProductosMousePressed

    private void jMenuItemModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemModificarMouseClicked
        
    }//GEN-LAST:event_jMenuItemModificarMouseClicked

    private void jMenuItemEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemEliminarMouseClicked
            
    }//GEN-LAST:event_jMenuItemEliminarMouseClicked

    private void jMenuItemModificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemModificarMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItemModificarMousePressed

    private void jMenuItemEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemEliminarMousePressed
        // TODO add your handling code here:
        jPopupMenu1.setVisible(false);
        int filaSeleccionada = tablaProductos.getSelectedRow();
            String idProducto = tablaProductos.getValueAt(filaSeleccionada, 0).toString();
            String nombreProducto = tablaProductos.getValueAt(filaSeleccionada, 1).toString();
            int mjs = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar el producto "+ nombreProducto+" ?");
            if(mjs == JOptionPane.YES_OPTION){
                productos.eliminarProducto(idProducto);
                productos.modeloTablaProductos(columnasProductos, tablaProductos);
                JOptionPane.showMessageDialog(this, "Producto eliminado exitosamente");
            }
            
    }//GEN-LAST:event_jMenuItemEliminarMousePressed

    private void jtfCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCantidadActionPerformed

    private void jtfCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCantidadKeyReleased

    private void jtfCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCantidadKeyTyped

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          actualizarTablaProductos();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTabla;
    private javax.swing.JButton btnAceptarRegistroProducto;
    private javax.swing.JButton btnCancelarRegistroProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItemEliminar;
    private javax.swing.JMenuItem jMenuItemModificar;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JComboBox<String> jcbMedidaProducto;
    private javax.swing.JTextField jtfBuscarProductos;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfCostoProducto;
    private javax.swing.JTextField jtfDescripcionProducto;
    private javax.swing.JTextField jtfPrecioProducto;
    private javax.swing.JPanel panelDatosCliente;
    private javax.swing.JScrollPane scrollTablaClientes;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
