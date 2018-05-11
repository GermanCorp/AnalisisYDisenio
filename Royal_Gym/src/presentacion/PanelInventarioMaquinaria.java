package presentacion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import royal_gym.Conexion;
import royal_gym.InventarioMaquinaria;
import royal_gym.Validaciones;

public class PanelInventarioMaquinaria extends javax.swing.JPanel {
    

    Validaciones ValidarLetras = new Validaciones();
    Validaciones ValidarNumeros = new Validaciones();
     InventarioMaquinaria im = new InventarioMaquinaria();
     Conexion con = new Conexion();
    
    // columnas de la tabla Inventario
    private final String[] columnasInventario = {
        "Id",
        "Nombres",
        "Cantidad",
        "Descripción"
    };
   
    
    public PanelInventarioMaquinaria() {
        initComponents();
        this.im = new InventarioMaquinaria();
        
        // Modelo de la tabla de Inventario
        DefaultTableModel modeloTablaInventario = new DefaultTableModel(im.getInventario(), columnasInventario);
        tablaInventarioEquipo.setModel(modeloTablaInventario);
      
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

        btnAceptarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btn_guardar.png"))); // NOI18N
        btnAceptarInventario.setText("Aceptar");
        btnAceptarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarInventarioActionPerformed(evt);
            }
        });

        btnCancelarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btn_limpiar.png"))); // NOI18N
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

        taDescripcionEquipo.setColumns(20);
        taDescripcionEquipo.setRows(5);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosLayout.createSequentialGroup()
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(PanelDatosLayout.createSequentialGroup()
                                .addComponent(btnAceptarInventario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addComponent(btnCancelarInventario))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCantidadEquipo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNombreEquipo))
                        .addGap(20, 20, 20))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 31, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jtfBuscarInventario, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jbEliminar)))
                        .addGap(20, 20, 20))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jtfBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
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

        ValidarLetras.soloLetras(evt);
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

        int limit = 4;
        if (jtfCantidadEquipo.getText().length() == limit) {
            evt.consume();

        }

        ValidarNumeros.soloNumeros(evt);

        if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 47
            || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
            || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            evt.consume();

            jtfCantidadEquipo.setCursor(null);
        }
    }//GEN-LAST:event_jtfCantidadEquipoKeyTyped

    private void btnAceptarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarInventarioActionPerformed
        
          //validaciones para los JTextField 1,2 y textArea1 para campos vacios
        if (jtfNombreEquipo.getText().equals("") && jtfCantidadEquipo.getText().equals("") && taDescripcionEquipo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (jtfNombreEquipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el nombre del Equipo", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfCantidadEquipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar la cantidad de Equipo", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (taDescripcionEquipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar la descripcion del Equipo", "Error!", JOptionPane.ERROR_MESSAGE);
        } else 
        {
            //metodogo para insertar datos de inventario equipo
            im.insertarInventario(
                jtfNombreEquipo.getText(),
                jtfCantidadEquipo.getText(),
                taDescripcionEquipo.getText());
            
            //vacia los JTextField
            jtfNombreEquipo.setText("");
            jtfCantidadEquipo.setText("");
            taDescripcionEquipo.setText("");
            
             DefaultTableModel modeloTablaInventario = new DefaultTableModel(im.getInventario(), columnasInventario);
            tablaInventarioEquipo.setModel(modeloTablaInventario);
            
        }

        int r = tablaInventarioEquipo.getSelectedRow();

        if (r == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un articulo", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            int mjs  = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea modificar el articulo seleccionado?");
            if(mjs == JOptionPane.YES_OPTION){
                String nombremaquina = tablaInventarioEquipo.getValueAt(r, 1).toString();
                
               //Metodo para modoficar los inventarios de equipos
             im.ModificarInventario(jtfNombreEquipo.getText(),
                     jtfCantidadEquipo.getText(), 
                     taDescripcionEquipo.getText());
                     
             
            DefaultTableModel modeloTablaInventario = new DefaultTableModel(im.getInventario(), columnasInventario);
            tablaInventarioEquipo.setModel(modeloTablaInventario);
            JOptionPane.showMessageDialog(null, "Registro modificado con exito");
            
            jtfNombreEquipo.setText("");
            jtfCantidadEquipo.setText("");
            taDescripcionEquipo.setText("");
                  
            }
           
        }
      
    }//GEN-LAST:event_btnAceptarInventarioActionPerformed

    private void btnCancelarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarInventarioActionPerformed
        jtfNombreEquipo.setText("");
        jtfCantidadEquipo.setText("");
        taDescripcionEquipo.setText("");
    }//GEN-LAST:event_btnCancelarInventarioActionPerformed

    private void tablaInventarioEquipoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaInventarioEquipoFocusGained

    }//GEN-LAST:event_tablaInventarioEquipoFocusGained

    private void tablaInventarioEquipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaInventarioEquipoFocusLost

    }//GEN-LAST:event_tablaInventarioEquipoFocusLost

    private void tablaInventarioEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaInventarioEquipoMouseClicked
        // TODO add your handling code here:
         if(evt.getClickCount()==2)
         {
             int filaseleccionada = tablaInventarioEquipo.getSelectedRow();
        jtfNombreEquipo.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 1).toString());
        jtfCantidadEquipo.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 2).toString());
        taDescripcionEquipo.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 3).toString());
        
        }
      
        
    }//GEN-LAST:event_tablaInventarioEquipoMouseClicked

    private void jtfBuscarInventarioCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfBuscarInventarioCaretUpdate
        // TODO add your handling code here:
        DefaultTableModel modeloTablaBuscarInventario = new DefaultTableModel(im.buscarInventario(jtfBuscarInventario.getText()), columnasInventario);
        tablaInventarioEquipo.setModel(modeloTablaBuscarInventario);
    }//GEN-LAST:event_jtfBuscarInventarioCaretUpdate

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
          // TODO add your handling code here:
        int r = tablaInventarioEquipo.getSelectedRow();

        if (r == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            
            
            int mjs = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar la fila seleccionada?");
            if(mjs == JOptionPane.YES_OPTION){
               String nombremaquina = tablaInventarioEquipo.getValueAt(r, 1).toString();
               
            im.eliminarInventario(nombremaquina);
            DefaultTableModel modeloTablaInventario = new DefaultTableModel(im.getInventario(), columnasInventario);
            tablaInventarioEquipo.setModel(modeloTablaInventario);
                JOptionPane.showMessageDialog(this, "Articulo eliminado exitosamente");
            }

        }  
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jtfBuscarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarInventarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JButton btnAceptarInventario;
    private javax.swing.JButton btnCancelarInventario;
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
