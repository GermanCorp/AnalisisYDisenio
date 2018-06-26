package presentacion;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import royal_gym.Conexion;
import royal_gym.InventarioMaquinaria;
import royal_gym.Validaciones;

public class PanelInventarioMaquinaria extends javax.swing.JPanel {

    Validaciones ValidarLetras = new Validaciones();
    Validaciones ValidarNumeros = new Validaciones();
    InventarioMaquinaria maquinaria = new InventarioMaquinaria();
    Conexion con = new Conexion();
    private String idMaquina;

    // columnas de la tabla Inventario
    private final String[] columnasInventario = {
        "Id",
        "Nombre",
        "Descripción",
        "Cantidad"
    };

    public PanelInventarioMaquinaria() {
        initComponents();
        actualizarTabla();
    }

    public void limpiar() {
        jtfNombreEquipo.setText("");
        jtfCantidadEquipo.setText("");
        taDescripcionEquipo.setText("");
    }

    public void actualizarTabla() {
        // Modelo de la tabla de Inventario
        DefaultTableModel modeloTablaInventario = new DefaultTableModel(maquinaria.getInventario(), columnasInventario);
        tablaInventarioEquipo.setModel(modeloTablaInventario);
        ocultarColumna();
    }

    private void ocultarColumna() {
        tablaInventarioEquipo.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaInventarioEquipo.getColumnModel().getColumn(0).setMinWidth(0);
        tablaInventarioEquipo.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelDatos = new javax.swing.JPanel();
        jlNombreEquipo = new javax.swing.JLabel();
        jtfNombreEquipo = new javax.swing.JTextField();
        jlCantidadEquipo = new javax.swing.JLabel();
        jtfCantidadEquipo = new javax.swing.JTextField();
        jlDescripcionEquipo = new javax.swing.JLabel();
        btnAceptarInventario = new javax.swing.JButton();
        btnCancelarInventario = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taDescripcionEquipo = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventarioEquipo = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jtfBuscarInventario = new javax.swing.JTextField();
        jbEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(85, 96, 128));

        PanelDatos.setBackground(new java.awt.Color(85, 96, 128));
        PanelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Datos de inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        PanelDatos.setPreferredSize(new java.awt.Dimension(350, 503));

        jlNombreEquipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlNombreEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jlNombreEquipo.setText("Nombre");

        jtfNombreEquipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfNombreEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreEquipoActionPerformed(evt);
            }
        });
        jtfNombreEquipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfNombreEquipoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNombreEquipoKeyTyped(evt);
            }
        });

        jlCantidadEquipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlCantidadEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jlCantidadEquipo.setText("Cantidad");

        jtfCantidadEquipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfCantidadEquipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantidadEquipoKeyTyped(evt);
            }
        });

        jlDescripcionEquipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlDescripcionEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jlDescripcionEquipo.setText("Descripcion");

        btnAceptarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btn_guardar_2.png"))); // NOI18N
        btnAceptarInventario.setText("Guardar");
        btnAceptarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarInventarioActionPerformed(evt);
            }
        });

        btnCancelarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btn_limpiar_02.png"))); // NOI18N
        btnCancelarInventario.setText("Limpiar");
        btnCancelarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarInventarioActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistroNuevoInventario.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("<html> <center>Inventario de<center> <center> Equipo<center>");

        jScrollPane4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jScrollPane4KeyTyped(evt);
            }
        });

        taDescripcionEquipo.setColumns(20);
        taDescripcionEquipo.setRows(5);
        taDescripcionEquipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                taDescripcionEquipoKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(taDescripcionEquipo);

        javax.swing.GroupLayout PanelDatosLayout = new javax.swing.GroupLayout(PanelDatos);
        PanelDatos.setLayout(PanelDatosLayout);
        PanelDatosLayout.setHorizontalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCantidadEquipo)
                    .addComponent(jlDescripcionEquipo)
                    .addComponent(jlNombreEquipo)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jtfNombreEquipo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelDatosLayout.createSequentialGroup()
                            .addComponent(btnAceptarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addComponent(jtfCantidadEquipo, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(20, 20, 20))
        );
        PanelDatosLayout.setVerticalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jlNombreEquipo)
                .addGap(0, 0, 0)
                .addComponent(jtfNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jlCantidadEquipo)
                .addGap(0, 0, 0)
                .addComponent(jtfCantidadEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jlDescripcionEquipo)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel4.setBackground(new java.awt.Color(85, 96, 126));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Inventario Registrado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        tablaInventarioEquipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaInventarioEquipo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaInventarioEquipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaInventarioEquipoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tablaInventarioEquipoFocusLost(evt);
            }
        });
        tablaInventarioEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaInventarioEquipoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaInventarioEquipo);

        jtfBuscarInventario.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfBuscarInventarioCaretUpdate(evt);
            }
        });
        jtfBuscarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarInventarioActionPerformed(evt);
            }
        });

        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btn_eliminar.png"))); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar Maquinaria");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfBuscarInventario))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNombreEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreEquipoActionPerformed

    private void jtfNombreEquipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreEquipoKeyTyped
        if (evt.isControlDown() && evt.isAltDown() && evt.isShiftDown()) {
            evt.consume();
        }
        
        if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            evt.consume();

            jtfNombreEquipo.setCursor(null);
        }
    }//GEN-LAST:event_jtfNombreEquipoKeyTyped

    private void jtfCantidadEquipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadEquipoKeyTyped
        if (evt.isControlDown() && evt.isAltDown() && evt.isShiftDown()) {
            evt.consume();
        }
        
        
         if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

         } 
         
           
            

    }//GEN-LAST:event_jtfCantidadEquipoKeyTyped

    private void btnAceptarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarInventarioActionPerformed
        //validaciones para los JTextField 1,2 y textArea1 para campos vacios
       if (String.valueOf(jtfNombreEquipo.getText().charAt(1)).equals(" ")){
            JOptionPane.showMessageDialog(null,"Los primeros digitos en el Nombre es un espacio en blanco");
        }else if(jtfNombreEquipo.getText().equals("") && jtfCantidadEquipo.getText().equals("") && taDescripcionEquipo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (jtfNombreEquipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el nombre del Equipo", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfCantidadEquipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar la cantidad de Equipo", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (String.valueOf(taDescripcionEquipo.getText().charAt(1)).equals(" ")){
            JOptionPane.showMessageDialog(null,"Los primeros digitos en la Descripcion es un espacio en blanco");    
        }else if(taDescripcionEquipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar la descripcion del Equipo", "Error!", JOptionPane.ERROR_MESSAGE);
       
        } else if (evt.getActionCommand().equals("Guardar")) {
            maquinaria.insertarInventario(
                    jtfNombreEquipo.getText().trim(),
                    jtfCantidadEquipo.getText(),
                    taDescripcionEquipo.getText().trim());
            limpiar();
            actualizarTabla();

        } else if (evt.getActionCommand().equals("Modificar")) {
            maquinaria.ModificarInventario(
                    jtfNombreEquipo.getText().trim(),
                    jtfCantidadEquipo.getText(),
                    taDescripcionEquipo.getText().trim(),
                    idMaquina);

            btnAceptarInventario.setText("Guardar");
            btnAceptarInventario.setIcon(new ImageIcon(Class.class.getResource("/iconos/btn_guardar_2.png")));
            btnAceptarInventario.setText("Limpiar");
            btnAceptarInventario.setIcon(new ImageIcon(Class.class.getResource("/iconos/btn_limpiar_02.png")));
            actualizarTabla();
            limpiar();
            JOptionPane.showMessageDialog(null, "Registro modificado con exito");
        }
    }//GEN-LAST:event_btnAceptarInventarioActionPerformed

    private void btnCancelarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarInventarioActionPerformed
        limpiar();
        jbEliminar.setEnabled(true);
        btnAceptarInventario.setText("Guardar");
        btnAceptarInventario.setIcon(new ImageIcon(Class.class.getResource("/iconos/btn_guardar_2.png")));
        btnCancelarInventario.setText("Limpiar");
        btnCancelarInventario.setIcon(new ImageIcon(Class.class.getResource("/iconos/btn_limpiar_02.png")));
    }//GEN-LAST:event_btnCancelarInventarioActionPerformed

    private void tablaInventarioEquipoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaInventarioEquipoFocusGained

    }//GEN-LAST:event_tablaInventarioEquipoFocusGained

    private void tablaInventarioEquipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaInventarioEquipoFocusLost

    }//GEN-LAST:event_tablaInventarioEquipoFocusLost

    private void tablaInventarioEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaInventarioEquipoMouseClicked
        int filaseleccionada = tablaInventarioEquipo.getSelectedRow();
        idMaquina = tablaInventarioEquipo.getValueAt(filaseleccionada, 0).toString();

        if (evt.getClickCount() == 2) {
            filaseleccionada = tablaInventarioEquipo.getSelectedRow();

            jbEliminar.setEnabled(false);
            btnAceptarInventario.setText("Modificar");
            btnAceptarInventario.setIcon(new ImageIcon(Class.class.getResource("/iconos/btn_modificar.png")));
            btnCancelarInventario.setText("Cancelar");
            btnCancelarInventario.setIcon(new ImageIcon(Class.class.getResource("/iconos/Cancelar.png")));

            idMaquina = tablaInventarioEquipo.getValueAt(filaseleccionada, 0).toString();
            jtfNombreEquipo.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 1).toString());
            jtfCantidadEquipo.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 3).toString());
            taDescripcionEquipo.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 2).toString());
            jbEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_tablaInventarioEquipoMouseClicked

    private void jtfBuscarInventarioCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfBuscarInventarioCaretUpdate
        DefaultTableModel modeloTablaBuscarInventario = new DefaultTableModel(maquinaria.buscarInventario(jtfBuscarInventario.getText().trim()), columnasInventario);
        tablaInventarioEquipo.setModel(modeloTablaBuscarInventario);
        ocultarColumna();
    }//GEN-LAST:event_jtfBuscarInventarioCaretUpdate

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        int r = tablaInventarioEquipo.getSelectedRow();
        if (r == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            int mjs = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar la fila seleccionada?");
            if (mjs == JOptionPane.YES_OPTION) {
                maquinaria.eliminarInventario(idMaquina);
                actualizarTabla();
                JOptionPane.showMessageDialog(this, "Articulo eliminado exitosamente");
            }
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jtfBuscarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarInventarioActionPerformed

    private void jtfNombreEquipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreEquipoKeyPressed
        
    }//GEN-LAST:event_jtfNombreEquipoKeyPressed

    private void jScrollPane4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane4KeyTyped
        
    }//GEN-LAST:event_jScrollPane4KeyTyped

    private void taDescripcionEquipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taDescripcionEquipoKeyTyped
          
        if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            evt.consume();
        }
    }//GEN-LAST:event_taDescripcionEquipoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JButton btnAceptarInventario;
    private javax.swing.JButton btnCancelarInventario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JLabel jlCantidadEquipo;
    private javax.swing.JLabel jlDescripcionEquipo;
    private javax.swing.JLabel jlNombreEquipo;
    private javax.swing.JTextField jtfBuscarInventario;
    private javax.swing.JTextField jtfCantidadEquipo;
    private javax.swing.JTextField jtfNombreEquipo;
    private javax.swing.JTextArea taDescripcionEquipo;
    private javax.swing.JTable tablaInventarioEquipo;
    // End of variables declaration//GEN-END:variables
}
