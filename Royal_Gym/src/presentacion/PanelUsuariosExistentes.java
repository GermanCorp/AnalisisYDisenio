package presentacion;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import royal_gym.Conexion;
import royal_gym.UsuariosExistentes;

public class PanelUsuariosExistentes extends javax.swing.JFrame {
    
    
    UsuariosExistentes UE = new UsuariosExistentes();
    Conexion con = new Conexion();
    
    // columnas de la tabla usuarios existentes
    private final String[] columnasUsuarios = {
        "N°",
        "Usuarios Existentes"
    };
            
    public PanelUsuariosExistentes() {
        initComponents();
        this.con = new Conexion();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        con.conectar();
        
       
        
            // Modelo de la tabla de cumpleaneros
        DefaultTableModel modeloTablaUsuarios = new DefaultTableModel(con.getUsuarios(), columnasUsuarios);
        tablaUsuariosExistentes.setModel(modeloTablaUsuarios);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelUsuariosExistentes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuariosExistentes = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        PanelBusquedaUsuarios = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        lblbuscar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelUsuariosExistentes.setBackground(new java.awt.Color(85, 96, 128));
        PanelUsuariosExistentes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuarios Registrados", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Century", 3, 24), new java.awt.Color(255, 255, 255))); // NOI18N

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

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Eliminar_fila.png"))); // NOI18N
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

        txtBuscar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBuscarCaretUpdate(evt);
            }
        });

        lblbuscar.setBackground(new java.awt.Color(255, 255, 255));
        lblbuscar.setFont(new java.awt.Font("Century", 3, 18)); // NOI18N
        lblbuscar.setForeground(new java.awt.Color(255, 255, 255));
        lblbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Buscar.png"))); // NOI18N

        javax.swing.GroupLayout PanelBusquedaUsuariosLayout = new javax.swing.GroupLayout(PanelBusquedaUsuarios);
        PanelBusquedaUsuarios.setLayout(PanelBusquedaUsuariosLayout);
        PanelBusquedaUsuariosLayout.setHorizontalGroup(
            PanelBusquedaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaUsuariosLayout.createSequentialGroup()
                .addComponent(txtBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblbuscar))
        );
        PanelBusquedaUsuariosLayout.setVerticalGroup(
            PanelBusquedaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBusquedaUsuariosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PanelBusquedaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout PanelUsuariosExistentesLayout = new javax.swing.GroupLayout(PanelUsuariosExistentes);
        PanelUsuariosExistentes.setLayout(PanelUsuariosExistentesLayout);
        PanelUsuariosExistentesLayout.setHorizontalGroup(
            PanelUsuariosExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuariosExistentesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelUsuariosExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelUsuariosExistentesLayout.createSequentialGroup()
                        .addGap(0, 301, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addGap(36, 36, 36)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelUsuariosExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                        .addComponent(PanelBusquedaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        PanelUsuariosExistentesLayout.setVerticalGroup(
            PanelUsuariosExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuariosExistentesLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(PanelBusquedaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(PanelUsuariosExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUsuariosExistentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUsuariosExistentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    //boton de busqueda de usuarios
    private void txtBuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarCaretUpdate
        // TODO add your handling code here:
         DefaultTableModel modeloTablaBuscarUsuarios = new DefaultTableModel(con.buscarUsuarios(txtBuscar.getText()), columnasUsuarios);
        tablaUsuariosExistentes.setModel(modeloTablaBuscarUsuarios);
    }//GEN-LAST:event_txtBuscarCaretUpdate

    // boton de eliminar usuarios existentes
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
         int r = tablaUsuariosExistentes.getSelectedRow();

        if (r == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            
            
            int mjs = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar la fila seleccionada?");
            if(mjs == JOptionPane.YES_OPTION){
               String nombremaquina = tablaUsuariosExistentes.getValueAt(r, 1).toString();
               
            UE.eliminarUsuarios(nombremaquina);
            DefaultTableModel modeloTablaInventario = new DefaultTableModel(UE.getUsuarios(), columnasUsuarios);
            tablaUsuariosExistentes.setModel(modeloTablaInventario);
                JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente");
            }

        }  
    }//GEN-LAST:event_btnEliminarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelUsuariosExistentes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBusquedaUsuarios;
    private javax.swing.JPanel PanelUsuariosExistentes;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblbuscar;
    private javax.swing.JTable tablaUsuariosExistentes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
