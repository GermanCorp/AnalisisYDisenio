package presentacion;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import royal_gym.Usuarios;

public class PanelNuevoUsuario extends javax.swing.JDialog {

    Usuarios usuario = new Usuarios();

    public PanelNuevoUsuario(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/Herramientas_configuracion_3.png"));
        setIconImage(icon);
        setTitle("Registro de usuarios");
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblUsuario1 = new javax.swing.JLabel();
        lblUsuario2 = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();
        lblUsuario3 = new javax.swing.JLabel();
        txtPregunta1 = new javax.swing.JTextField();
        lblUsuario4 = new javax.swing.JLabel();
        txtPregunta2 = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        lblUsuario5 = new javax.swing.JLabel();
        jcbTipoUsuario = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(85, 96, 128));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btn_guardar_2.png"))); // NOI18N
        btnAceptar.setText("Guardar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblUsuario1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario1.setText("Nombre:");

        lblUsuario2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuario2.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario2.setText("Cual es el nombre de tu madre?");

        lblusuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblusuario.setForeground(new java.awt.Color(255, 255, 255));
        lblusuario.setText("Usuario:");

        lblUsuario3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuario3.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario3.setText("Contraseña:");

        txtPregunta1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblUsuario4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuario4.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario4.setText("Cual es el nombre de tu mascota?");

        txtPregunta2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.setBorder(null);

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUser.setBorder(null);
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        txtClave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtClave.setBorder(null);

        lblUsuario5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuario5.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario5.setText("Tipo de usuario:");

        jcbTipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Invitado", "Administrador" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblUsuario5)
                    .addComponent(txtPregunta1)
                    .addComponent(lblUsuario4)
                    .addComponent(lblUsuario2)
                    .addComponent(txtPregunta2)
                    .addComponent(txtClave)
                    .addComponent(txtNombre)
                    .addComponent(lblUsuario1)
                    .addComponent(txtUser)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuario3)
                            .addComponent(lblusuario))
                        .addGap(225, 225, 225))
                    .addComponent(jcbTipoUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblUsuario5)
                .addGap(3, 3, 3)
                .addComponent(jcbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblUsuario1)
                .addGap(0, 0, 0)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblusuario)
                .addGap(0, 0, 0)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblUsuario3)
                .addGap(0, 0, 0)
                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblUsuario4)
                .addGap(0, 0, 0)
                .addComponent(txtPregunta1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblUsuario2)
                .addGap(0, 0, 0)
                .addComponent(txtPregunta2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        if (txtNombre.getText().equals("") && txtUser.getText().equals("") && txtClave.getPassword().length == 0 && txtPregunta1.getText().equals("")
                && txtPregunta2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el Nombre", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (txtUser.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el Usuario", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (txtClave.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar la contrasena", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (txtPregunta1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la pregunta 1");
        } else if (txtPregunta2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la pregunta 2");
        } else {
            usuario.nuevoUser(
                    txtNombre.getText(), 
                    txtUser.getText(), 
                    String.valueOf(txtClave.getPassword()),
                    txtPregunta1.getText(), 
                    txtPregunta2.getText(),
                    jcbTipoUsuario.getSelectedItem().toString()
                    
            );

            txtNombre.setText("");
            txtUser.setText("");
            txtClave.setText("");
            txtPregunta1.setText("");
            txtPregunta2.setText("");
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcbTipoUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JLabel lblUsuario3;
    private javax.swing.JLabel lblUsuario4;
    private javax.swing.JLabel lblUsuario5;
    private javax.swing.JLabel lblusuario;
    public static javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPregunta1;
    private javax.swing.JTextField txtPregunta2;
    public static javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
