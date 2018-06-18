package presentacion;

import javax.swing.JOptionPane;
import royal_gym.LoginEntrar;

/**
 *
 * @author alxcr
 */
public class RecuperarContraseña extends javax.swing.JDialog {
    
    public static String usuario = "";
    
    public RecuperarContraseña(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelNuevaContraseña = new javax.swing.JPanel();
        lblClaveActual = new javax.swing.JLabel();
        lblClaveNueva = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        txtPregunta1 = new javax.swing.JTextField();
        txtPregunta2 = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        PanelNuevaContraseña.setBackground(new java.awt.Color(85, 96, 128));
        PanelNuevaContraseña.setPreferredSize(new java.awt.Dimension(490, 512));

        lblClaveActual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblClaveActual.setForeground(new java.awt.Color(255, 255, 255));
        lblClaveActual.setText("Cual es el nombre de tu mascota?");

        lblClaveNueva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblClaveNueva.setForeground(new java.awt.Color(255, 255, 255));
        lblClaveNueva.setText("Cual es el nombre de tu madre?");

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

        txtPregunta1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPregunta2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Usuario");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout PanelNuevaContraseñaLayout = new javax.swing.GroupLayout(PanelNuevaContraseña);
        PanelNuevaContraseña.setLayout(PanelNuevaContraseñaLayout);
        PanelNuevaContraseñaLayout.setHorizontalGroup(
            PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNuevaContraseñaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelNuevaContraseñaLayout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addGap(28, 28, 28)
                        .addComponent(btnCancelar))
                    .addGroup(PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblUsuario)
                        .addComponent(txtPregunta2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPregunta1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblClaveNueva)
                        .addComponent(lblClaveActual)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        PanelNuevaContraseñaLayout.setVerticalGroup(
            PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNuevaContraseñaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblUsuario)
                .addGap(0, 0, 0)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblClaveActual)
                .addGap(0, 0, 0)
                .addComponent(txtPregunta1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblClaveNueva)
                .addGap(0, 0, 0)
                .addComponent(txtPregunta2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelNuevaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelNuevaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtPregunta1.setText("");
        txtPregunta2.setText("");
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (txtPregunta1.getText().equals("") && txtPregunta2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe responder la pregunta1/pregunta 2", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (txtPregunta1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe responder la pregunta 1", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (txtPregunta2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe responder la pregunta 2", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (LoginEntrar.recuperarPass(txtUsuario.getText(), txtPregunta1.getText(), txtPregunta2.getText()) == 1) {
            JOptionPane.showMessageDialog(null, "Se cambiara la contraseña");
        } else {
            JOptionPane.showMessageDialog(null, "Los datos no coinciden");
        }

    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelNuevaContraseña;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblClaveActual;
    private javax.swing.JLabel lblClaveNueva;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtPregunta1;
    private javax.swing.JTextField txtPregunta2;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
