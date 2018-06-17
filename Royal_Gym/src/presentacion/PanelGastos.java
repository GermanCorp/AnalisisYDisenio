package presentacion;

import java.util.Date;
import javax.swing.table.DefaultTableModel;
import static presentacion.PanelRegistroClientes.tablaClientes;
import royal_gym.Conexion;
import royal_gym.Conexion;
import royal_gym.Gastos;
import royal_gym.Gastos;

public class PanelGastos extends javax.swing.JPanel {

    Conexion conexion = new Conexion();
    Gastos gastos = new Gastos();
    java.util.Date date = new Date();
    java.sql.Date fechaActual = new java.sql.Date(date.getTime());
    private final String[] columnasGastos = {"Id", "Fecha", "Descripción", "Monto"};

    public PanelGastos() {
        initComponents();
        gastos.modeloTablaGastos(tablaGastos);
        ocultarColumna();
    }

    public void ocultarColumna() {
        tablaGastos.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaGastos.getColumnModel().getColumn(0).setMinWidth(0);
        tablaGastos.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    public void limpiar() {
        jtfDescripcionGasto.setText("");
        jtfMontoGasto.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatosGasto = new javax.swing.JPanel();
        btnCancelarRegistroGasto = new javax.swing.JButton();
        jlDescripcionGAsto = new javax.swing.JLabel();
        jlmontoGasto = new javax.swing.JLabel();
        jtfDescripcionGasto = new javax.swing.JTextField();
        jtfMontoGasto = new javax.swing.JTextField();
        btnAceptarRegistroGasto = new javax.swing.JButton();
        jlIconoGasto = new javax.swing.JLabel();
        PanelTablaGastos = new javax.swing.JPanel();
        scrollTablaClientes1 = new javax.swing.JScrollPane();
        tablaGastos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jtfBuscarGasto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(85, 96, 128));

        panelDatosGasto.setBackground(new java.awt.Color(85, 96, 128));
        panelDatosGasto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Registro de Gastos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        panelDatosGasto.setToolTipText("");
        panelDatosGasto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelDatosGastoFocusGained(evt);
            }
        });

        btnCancelarRegistroGasto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btn_limpiar_02.png"))); // NOI18N
        btnCancelarRegistroGasto.setText("Cancelar");
        btnCancelarRegistroGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRegistroGastoActionPerformed(evt);
            }
        });

        jlDescripcionGAsto.setBackground(new java.awt.Color(255, 255, 255));
        jlDescripcionGAsto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlDescripcionGAsto.setForeground(new java.awt.Color(255, 255, 255));
        jlDescripcionGAsto.setText("Descripción:");

        jlmontoGasto.setBackground(new java.awt.Color(255, 255, 255));
        jlmontoGasto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlmontoGasto.setForeground(new java.awt.Color(255, 255, 255));
        jlmontoGasto.setText("Monto:");

        jtfDescripcionGasto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfDescripcionGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescripcionGastoActionPerformed(evt);
            }
        });
        jtfDescripcionGasto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDescripcionGastoKeyTyped(evt);
            }
        });

        jtfMontoGasto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfMontoGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMontoGastoActionPerformed(evt);
            }
        });
        jtfMontoGasto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMontoGastoKeyTyped(evt);
            }
        });

        btnAceptarRegistroGasto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btn_guardar_2.png"))); // NOI18N
        btnAceptarRegistroGasto.setText("Guardar");
        btnAceptarRegistroGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarRegistroGastoActionPerformed(evt);
            }
        });
        btnAceptarRegistroGasto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAceptarRegistroGastoKeyPressed(evt);
            }
        });

        jlIconoGasto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Gasto.png"))); // NOI18N

        javax.swing.GroupLayout panelDatosGastoLayout = new javax.swing.GroupLayout(panelDatosGasto);
        panelDatosGasto.setLayout(panelDatosGastoLayout);
        panelDatosGastoLayout.setHorizontalGroup(
            panelDatosGastoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosGastoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelDatosGastoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfDescripcionGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlmontoGasto)
                    .addComponent(jtfMontoGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDatosGastoLayout.createSequentialGroup()
                        .addComponent(btnAceptarRegistroGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnCancelarRegistroGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlDescripcionGAsto))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosGastoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlIconoGasto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosGastoLayout.setVerticalGroup(
            panelDatosGastoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosGastoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlIconoGasto)
                .addGap(31, 31, 31)
                .addComponent(jlDescripcionGAsto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jtfDescripcionGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jlmontoGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jtfMontoGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosGastoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarRegistroGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarRegistroGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        PanelTablaGastos.setBackground(new java.awt.Color(85, 96, 128));
        PanelTablaGastos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Gastos Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        tablaGastos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaGastos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaGastos.setAutoscrolls(true);
        tablaGastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaGastosMouseClicked(evt);
            }
        });
        scrollTablaClientes1.setViewportView(tablaGastos);

        jtfBuscarGasto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfBuscarGastoCaretUpdate(evt);
            }
        });
        jtfBuscarGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarGastoActionPerformed(evt);
            }
        });
        jtfBuscarGasto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfBuscarGastoKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Buscar Gasto:");

        javax.swing.GroupLayout PanelTablaGastosLayout = new javax.swing.GroupLayout(PanelTablaGastos);
        PanelTablaGastos.setLayout(PanelTablaGastosLayout);
        PanelTablaGastosLayout.setHorizontalGroup(
            PanelTablaGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaGastosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTablaGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTablaGastosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfBuscarGasto))
                    .addComponent(scrollTablaClientes1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        PanelTablaGastosLayout.setVerticalGroup(
            PanelTablaGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaGastosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTablaGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBuscarGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTablaClientes1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelDatosGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(PanelTablaGastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelTablaGastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDatosGasto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarRegistroGastoActionPerformed(java.awt.event.ActionEvent evt) {
        limpiar();
        btnAceptarRegistroGasto.setText("Guardar");
        btnAceptarRegistroGasto.setIcon(new ImageIcon(Class.class.getResource("/iconos/btn_guardar_2.png")));
        btnCancelarRegistroGasto.setText("Limpiar");
        btnCancelarRegistroGasto.setIcon(new ImageIcon(Class.class.getResource("/iconos/btn_limpiar_02.png")));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarRegistroGastoActionPerformed

    private void jtfDescripcionGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescripcionGastoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescripcionGastoActionPerformed

    private void jtfDescripcionGastoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescripcionGastoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescripcionGastoKeyTyped

    private void jtfMontoGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMontoGastoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMontoGastoActionPerformed

    private void jtfMontoGastoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMontoGastoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMontoGastoKeyTyped

    private void btnAceptarRegistroGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarRegistroGastoActionPerformed
        if (jtfDescripcionGasto.getText().isEmpty()
                && jtfMontoGasto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ingrese Toda la Información", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfDescripcionGasto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar la descripción del gasto", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfMontoGasto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el monto del producto", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            if (evt.getActionCommand().equals("Guardar")) {
                gastos.insertarGasto(jtfDescripcionGasto.getText(), jtfMontoGasto.getText(), String.valueOf(fechaActual));
                gastos.modeloTablaGastos(tablaGastos);
                royal_gym.VP.jlMensajes.setText("Gasto registrado exitosamente");
                limpiar();
                actualizarTablaProductos();
            } else if (evt.getActionCommand().equals("Modificar")) {
                gastos.modificarGasto(jtfDescripcionGasto.getText(), jtfMontoGasto.getText(), idGasto);
                royal_gym.VP.jlMensajes.setText("Gasto modificado exitosamente");
                btnAceptarRegistroGasto.setText("Guardar");
                btnAceptarRegistroGasto.setIcon(new ImageIcon(Class.class.getResource("/iconos/btn_guardar_2.png")));
                btnCancelarRegistroGasto.setText("Limpiar");
                btnCancelarRegistroGasto.setIcon(new ImageIcon(Class.class.getResource("/iconos/btn_limpiar_02.png")));
                btnEliminarGasto.setEnabled(true);
                limpiar();
                actualizarTablaProductos();
            }
        }
            gastos.insertarGasto(jtfDescripcionGasto.getText(), jtfMontoGasto.getText(), String.valueOf(fechaActual));
            gastos.modeloTablaGastos(tablaGastos);
    }//GEN-LAST:event_btnAceptarRegistroGastoActionPerformed

    private void btnAceptarRegistroGastoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarRegistroGastoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarRegistroGastoKeyPressed

    private void panelDatosGastoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelDatosGastoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_panelDatosGastoFocusGained

    private void tablaGastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGastosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaGastosMouseClicked

    private void jtfBuscarGastoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfBuscarGastoCaretUpdate
        DefaultTableModel modeloTablaBuscarGasto = new DefaultTableModel(gastos.buscarGasto(jtfBuscarGasto.getText()), columnasGastos);
        tablaGastos.setModel(modeloTablaBuscarGasto);
        ocultarColumna();
    }//GEN-LAST:event_jtfBuscarGastoCaretUpdate

    private void jtfBuscarGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarGastoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarGastoActionPerformed

    private void jtfBuscarGastoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarGastoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarGastoKeyPressed
    private void btnEliminarGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarGastoActionPerformed
        int filaSeleccionada = tablaGastos.getSelectedRow();

        if (filaSeleccionada == -1) {
            royal_gym.VP.jlMensajes.setText("Seleccione un gasto");
        } else {
            String nombres = tablaGastos.getValueAt(filaSeleccionada, 2).toString();
            int mjs = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar " + nombres + "?");
            if (mjs == JOptionPane.YES_OPTION) {
                gastos.eliminarGasto(idGasto);
                actualizarTablaProductos();
                royal_gym.VP.jlMensajes.setText("Eliminado exitosamente");
            }

        }
    }//GEN-LAST:event_btnEliminarGastoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTablaGastos;
    private javax.swing.JButton btnAceptarRegistroGasto;
    private javax.swing.JButton btnCancelarRegistroGasto;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jlDescripcionGAsto;
    private javax.swing.JLabel jlIconoGasto;
    private javax.swing.JLabel jlmontoGasto;
    private javax.swing.JTextField jtfBuscarGasto;
    private javax.swing.JTextField jtfDescripcionGasto;
    private javax.swing.JTextField jtfMontoGasto;
    private javax.swing.JPanel panelDatosGasto;
    private javax.swing.JScrollPane scrollTablaClientes1;
    private javax.swing.JTable tablaGastos;
    // End of variables declaration//GEN-END:variables
}
