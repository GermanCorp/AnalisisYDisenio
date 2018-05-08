package presentacion;

import javax.swing.JOptionPane;
import static presentacion.PanelLogin.contraseña;
import static presentacion.PanelLogin.usuario;
import static presentacion.PanelNuevoUsuario.txtClave;
import static presentacion.PanelNuevoUsuario.txtUser;

public class PanelNuevaContraseña extends javax.swing.JFrame {

    public PanelNuevaContraseña() {
        initComponents();
        setLayout(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelNuevaContraseña = new javax.swing.JPanel();
        lblNuevoUsuario = new javax.swing.JLabel();
        lblClaveActual = new javax.swing.JLabel();
        lblClaveNueva = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtContraseñaActual = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtContraseñaNueva = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelNuevaContraseña.setBackground(new java.awt.Color(85, 96, 128));
        PanelNuevaContraseña.setPreferredSize(new java.awt.Dimension(490, 512));

        lblNuevoUsuario.setFont(new java.awt.Font("Yu Gothic", 3, 36)); // NOI18N
        lblNuevoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNuevoUsuario.setText("Nueva Contraseña");

        lblClaveActual.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblClaveActual.setForeground(new java.awt.Color(255, 255, 255));
        lblClaveActual.setText("Contraseña Actual");

        lblClaveNueva.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblClaveNueva.setForeground(new java.awt.Color(255, 255, 255));
        lblClaveNueva.setText("Contraseña Nueva");

        btnCancelar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jPanel1.setFocusCycleRoot(true);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/login_contraseña.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContraseñaActual))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtContraseñaActual)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
        );

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/login_contraseña.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContraseñaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
            .addComponent(txtContraseñaNueva)
        );

        javax.swing.GroupLayout PanelNuevaContraseñaLayout = new javax.swing.GroupLayout(PanelNuevaContraseña);
        PanelNuevaContraseña.setLayout(PanelNuevaContraseñaLayout);
        PanelNuevaContraseñaLayout.setHorizontalGroup(
            PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNuevaContraseñaLayout.createSequentialGroup()
                .addGroup(PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNuevaContraseñaLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblClaveNueva)
                            .addGroup(PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(PanelNuevaContraseñaLayout.createSequentialGroup()
                                    .addComponent(btnAceptar)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCancelar))
                                .addGroup(PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblClaveActual, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(PanelNuevaContraseñaLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        PanelNuevaContraseñaLayout.setVerticalGroup(
            PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNuevaContraseñaLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblClaveActual, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblClaveNueva)
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelNuevaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelNuevaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        txtContraseñaActual.setText("");
        txtContraseñaNueva.setText("");
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        if (txtContraseñaActual.getText().equals("") && txtContraseñaNueva.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la Contraseña Actual/Contraseña Nueva", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (txtContraseñaActual.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar la Contraseña actual", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (txtContraseñaNueva.getPassword().length==0) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar la Contraseña nueva", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        txtContraseñaActual.setText("");
        txtContraseñaNueva.setText("");
            
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelNuevaContraseña;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblClaveActual;
    private javax.swing.JLabel lblClaveNueva;
    private javax.swing.JLabel lblNuevoUsuario;
    private javax.swing.JPasswordField txtContraseñaActual;
    private javax.swing.JPasswordField txtContraseñaNueva;
    // End of variables declaration//GEN-END:variables
}
