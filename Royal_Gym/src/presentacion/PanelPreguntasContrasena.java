package presentacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import static presentacion.PanelLogin.contraseña;
import static presentacion.PanelLogin.usuario;
import static presentacion.PanelNuevoUsuario.txtClave;
import static presentacion.PanelNuevoUsuario.txtUser;
import royal_gym.Conexion;
import royal_gym.NuevaClave;

public class PanelPreguntasContrasena extends javax.swing.JFrame
{
    NuevaClave NC;
    static private Connection conex;
    Conexion con;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection conn = null;
    
    public PanelPreguntasContrasena() {
        initComponents();
        setLayout(null);
        setTitle("Preguntas de recuperacion de Clave");
        setResizable(false);
        
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
        txtPregunta1 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        txtPregunta2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelNuevaContraseña.setBackground(new java.awt.Color(85, 96, 128));
        PanelNuevaContraseña.setPreferredSize(new java.awt.Dimension(490, 512));

        lblNuevoUsuario.setFont(new java.awt.Font("Yu Gothic", 3, 18)); // NOI18N
        lblNuevoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNuevoUsuario.setText("Preguntas de recuperacion de Clave");

        lblClaveActual.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblClaveActual.setForeground(new java.awt.Color(255, 255, 255));
        lblClaveActual.setText("Cual es el nombre de tu mascota?");

        lblClaveNueva.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
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

        jPanel1.setFocusCycleRoot(true);

        txtPregunta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPregunta1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtPregunta1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPregunta1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtPregunta2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPregunta2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelNuevaContraseñaLayout = new javax.swing.GroupLayout(PanelNuevaContraseña);
        PanelNuevaContraseña.setLayout(PanelNuevaContraseñaLayout);
        PanelNuevaContraseñaLayout.setHorizontalGroup(
            PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNuevaContraseñaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClaveNueva)
                    .addGroup(PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PanelNuevaContraseñaLayout.createSequentialGroup()
                            .addComponent(btnAceptar)
                            .addGap(18, 18, 18)
                            .addComponent(btnCancelar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblClaveActual, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        PanelNuevaContraseñaLayout.setVerticalGroup(
            PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNuevaContraseñaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblClaveActual, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblClaveNueva)
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelNuevaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelNuevaContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        txtPregunta1.setText("");
        txtPregunta2.setText("");
        dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        
        
        if (txtPregunta1.getText().equals("") && txtPregunta2.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe responder la pregunta1/pregunta 2", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (txtPregunta1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe responder la pregunta 1", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (txtPregunta2.getPassword().length==0) {
            JOptionPane.showMessageDialog(this, "Debe responder la pregunta 2", "Error!", JOptionPane.ERROR_MESSAGE);
        }  
        
        /*
        if(Conexion.nuevaContraseña(txtPregunta1.getText(), txtPregunta2.getText() == 1)))
        {
            txtPregunta1.setText("");
            txtPregunta2.setText("");
            PanelNuevaClave PNC = new PanelNuevaClave();
            PNC.setVisible(true);
            
        }
        */ 
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtPregunta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPregunta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPregunta1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelNuevaContraseña;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblClaveActual;
    private javax.swing.JLabel lblClaveNueva;
    private javax.swing.JLabel lblNuevoUsuario;
    private javax.swing.JPasswordField txtPregunta1;
    private javax.swing.JPasswordField txtPregunta2;
    // End of variables declaration//GEN-END:variables
}
