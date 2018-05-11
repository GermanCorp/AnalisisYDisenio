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
import royal_gym.PreguntasContrasenas;

public class PanelPreguntasContrasena extends javax.swing.JFrame
{
    PreguntasContrasenas NC;
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
        txtPregunta1 = new javax.swing.JTextField();
        txtPregunta2 = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();

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

        lblUsuario.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Usuario");

        javax.swing.GroupLayout PanelNuevaContraseñaLayout = new javax.swing.GroupLayout(PanelNuevaContraseña);
        PanelNuevaContraseña.setLayout(PanelNuevaContraseñaLayout);
        PanelNuevaContraseñaLayout.setHorizontalGroup(
            PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNuevaContraseñaLayout.createSequentialGroup()
                .addGroup(PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelNuevaContraseñaLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addGroup(PanelNuevaContraseñaLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPregunta2)
                            .addComponent(txtPregunta1)
                            .addComponent(lblNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClaveNueva)
                            .addComponent(lblClaveActual, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))))
                .addContainerGap())
        );
        PanelNuevaContraseñaLayout.setVerticalGroup(
            PanelNuevaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNuevaContraseñaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblClaveActual, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtPregunta1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblClaveNueva)
                .addGap(20, 20, 20)
                .addComponent(txtPregunta2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
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
                .addComponent(PanelNuevaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelNuevaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        
        
        if (txtPregunta1.getText().equals("") && txtPregunta2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe responder la pregunta1/pregunta 2", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (txtPregunta1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe responder la pregunta 1", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (txtPregunta2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe responder la pregunta 2", "Error!", JOptionPane.ERROR_MESSAGE);
        }  
        
        
        else if(con.preguntasContrasena(txtPregunta1.getText(), txtPregunta2.getText(),txtUsuario.getText()) == 1)
        {
            txtPregunta1.setText("");
            txtPregunta2.setText("");
            txtUsuario.setText("");
            PanelModificarContrasena PNC = new PanelModificarContrasena();
            PNC.setVisible(true);
            
        }
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelNuevaContraseña;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblClaveActual;
    private javax.swing.JLabel lblClaveNueva;
    private javax.swing.JLabel lblNuevoUsuario;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtPregunta1;
    private javax.swing.JTextField txtPregunta2;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
