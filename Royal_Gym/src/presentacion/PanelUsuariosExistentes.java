package presentacion;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import royal_gym.Conexion;
import royal_gym.Usuarios;

public class PanelUsuariosExistentes extends javax.swing.JDialog {

    Usuarios usuarios = new Usuarios();

    // columnas de la tabla usuarios existentes
    private final String[] columnasUsuarios = {
        "id",
        "Nombre",
        "Usuario",
        "Contraseña",
        "Pregunta A",
        "Pregunta B",
        "Cargo"
    };

    public PanelUsuariosExistentes(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Usuarios");
        setLocationRelativeTo(null);
        setResizable(false);
        actualizarTabla();

        // Modelo de la tabla de usuarios existentes
    }

    private void actualizarTabla() {
        DefaultTableModel modeloTablaUsuarios = new DefaultTableModel(usuarios.buscarUsuarios(RecuperarContraseña.usuario), columnasUsuarios);
        tablaUsuariosExistentes.setModel(modeloTablaUsuarios);
        ocultarColumna();
    }

    private void ocultarColumna() {
        tablaUsuariosExistentes.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaUsuariosExistentes.getColumnModel().getColumn(0).setMinWidth(0);
        tablaUsuariosExistentes.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUsuarios = new javax.swing.JPanel();
        PanelUsuariosExistentes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuariosExistentes = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        PanelUsuariosExistentes.setBackground(new java.awt.Color(85, 96, 128));

        tablaUsuariosExistentes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaUsuariosExistentes);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btn_eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Archivo_Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtBuscar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBuscarCaretUpdate(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar Usuario");

        javax.swing.GroupLayout PanelUsuariosExistentesLayout = new javax.swing.GroupLayout(PanelUsuariosExistentes);
        PanelUsuariosExistentes.setLayout(PanelUsuariosExistentesLayout);
        PanelUsuariosExistentesLayout.setHorizontalGroup(
            PanelUsuariosExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelUsuariosExistentesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelUsuariosExistentesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelUsuariosExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelUsuariosExistentesLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        PanelUsuariosExistentesLayout.setVerticalGroup(
            PanelUsuariosExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuariosExistentesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelUsuariosExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(PanelUsuariosExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout panelUsuariosLayout = new javax.swing.GroupLayout(panelUsuarios);
        panelUsuarios.setLayout(panelUsuariosLayout);
        panelUsuariosLayout.setHorizontalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUsuariosExistentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelUsuariosLayout.setVerticalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUsuariosExistentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int r = tablaUsuariosExistentes.getSelectedRow();

        if (r == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {

            int mjs = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar la fila seleccionada?");
            if (mjs == JOptionPane.YES_OPTION) {
                String id = tablaUsuariosExistentes.getValueAt(r, 0).toString();
                usuarios.eliminarUsuarios(id);
                actualizarTabla();
                JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente");
            }

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtBuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarCaretUpdate
        // TODO add your handling code here:
        DefaultTableModel modeloTablaBuscarUsuarios = new DefaultTableModel(usuarios.buscarUsuarios(txtBuscar.getText()), columnasUsuarios);
        tablaUsuariosExistentes.setModel(modeloTablaBuscarUsuarios);
        ocultarColumna();
    }//GEN-LAST:event_txtBuscarCaretUpdate

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelUsuariosExistentes;
    public javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelUsuarios;
    private javax.swing.JTable tablaUsuariosExistentes;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
