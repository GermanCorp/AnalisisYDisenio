package presentacion;

import javax.swing.JOptionPane;

public class PanelLogin extends javax.swing.JFrame {
    

    public PanelLogin() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        jlAccesoAlSistema = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jlContrasena = new javax.swing.JLabel();
        jpfContrasena = new javax.swing.JPasswordField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnIcono = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelLogin.setBackground(new java.awt.Color(85, 96, 128));
        panelLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlAccesoAlSistema.setFont(new java.awt.Font("Arial", 3, 32)); // NOI18N
        jlAccesoAlSistema.setForeground(new java.awt.Color(255, 255, 255));
        jlAccesoAlSistema.setText("Acceso Al Sistema");

        jlUsuario.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jlUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jlUsuario.setText("Usuario");

        jlContrasena.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jlContrasena.setForeground(new java.awt.Color(255, 255, 255));
        jlContrasena.setText("Contrasena");

        btnAceptar.setBackground(new java.awt.Color(85, 96, 128));
        btnAceptar.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(85, 96, 128));
        btnCancelar.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnIcono.setBackground(new java.awt.Color(85, 96, 128));
        btnIcono.setForeground(new java.awt.Color(0, 51, 102));
        btnIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Login.png"))); // NOI18N

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(btnIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlContrasena)
                    .addComponent(jlUsuario)
                    .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelLoginLayout.createSequentialGroup()
                            .addGap(98, 98, 98)
                            .addComponent(btnAceptar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                            .addComponent(btnCancelar))
                        .addComponent(jlAccesoAlSistema, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jpfContrasena, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(70, 70, 70))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jlAccesoAlSistema)
                .addGap(35, 35, 35)
                .addComponent(btnIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jlUsuario)
                .addGap(15, 15, 15)
                .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jlContrasena)
                .addGap(15, 15, 15)
                .addComponent(jpfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        if (jtfUsuario.getText().equals("") && jpfContrasena.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el Usuario y Contrasena", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (jtfUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el nombre de usuario", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jpfContrasena.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar la contrasena", "Error!", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:
        String usuario = "Admin";
        String contrasena = "1234";
        String password = new String(jpfContrasena.getPassword());
        
    }//GEN-LAST:event_btnAceptarMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelLogin().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIcono;
    private javax.swing.JLabel jlAccesoAlSistema;
    private javax.swing.JLabel jlContrasena;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JPasswordField jpfContrasena;
    private javax.swing.JTextField jtfUsuario;
    private javax.swing.JPanel panelLogin;
    // End of variables declaration//GEN-END:variables
}
