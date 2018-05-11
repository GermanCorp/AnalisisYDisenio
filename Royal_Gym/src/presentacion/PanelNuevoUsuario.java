package presentacion;

import javax.swing.JOptionPane;
import royal_gym.Conexion;
import royal_gym.NuevoUsuario;

public class PanelNuevoUsuario extends javax.swing.JDialog {
    
    NuevoUsuario nu = new NuevoUsuario();
    Conexion con = new Conexion();
    
    


    public PanelNuevoUsuario(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.dispose();
        this.nu = new NuevoUsuario();

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNuevoUsuario = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelUsuario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        panelContraseña = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        lblUsuario1 = new javax.swing.JLabel();
        lblUsuario2 = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblUsuario3 = new javax.swing.JLabel();
        txtPregunta1 = new javax.swing.JTextField();
        lblUsuario4 = new javax.swing.JLabel();
        txtPregunta2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(85, 96, 128));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblNuevoUsuario.setFont(new java.awt.Font("Yu Gothic", 3, 36)); // NOI18N
        lblNuevoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNuevoUsuario.setText("Nuevo Usuario");

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btn_guardar.png"))); // NOI18N
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

        panelUsuario.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/login_usuario.png"))); // NOI18N

        txtUser.setBorder(null);
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUsuarioLayout = new javax.swing.GroupLayout(panelUsuario);
        panelUsuario.setLayout(panelUsuarioLayout);
        panelUsuarioLayout.setHorizontalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuarioLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        panelUsuarioLayout.setVerticalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
            .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        panelContraseña.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/login_contraseña.png"))); // NOI18N

        txtClave.setBorder(null);

        javax.swing.GroupLayout panelContraseñaLayout = new javax.swing.GroupLayout(panelContraseña);
        panelContraseña.setLayout(panelContraseñaLayout);
        panelContraseñaLayout.setHorizontalGroup(
            panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContraseñaLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClave))
        );
        panelContraseñaLayout.setVerticalGroup(
            panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
            .addComponent(txtClave, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        lblUsuario1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario1.setText("Nombre:");

        lblUsuario2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblUsuario2.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario2.setText("Cual es el nombre de tu madre?");

        lblusuario.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblusuario.setForeground(new java.awt.Color(255, 255, 255));
        lblusuario.setText("Usuario:");

        lblNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/AgregarNuevo_2.png"))); // NOI18N
        lblNombre.setText("jLabel3");

        txtNombre.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)
                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        );

        lblUsuario3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblUsuario3.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario3.setText("Contraseña:");

        lblUsuario4.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblUsuario4.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario4.setText("Cual es el nombre de tu mascota?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPregunta1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnAceptar)
                            .addGap(45, 45, 45)
                            .addComponent(btnCancelar))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuario3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblUsuario2)
                                .addComponent(lblUsuario1)
                                .addComponent(panelContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblusuario)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPregunta2)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lblUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lblUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPregunta1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPregunta2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
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

        if (txtNombre.getText().equals("") && txtUser.getText().equals("") && txtClave.getPassword().length==0 && txtPregunta1.getText().equals("")
            && txtPregunta2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el Nombre", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (txtUser.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el Usuario", "Error!", JOptionPane.ERROR_MESSAGE);
        }else if (txtClave.getPassword().length ==0) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar la contrasena", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if(txtPregunta1.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe ingresar la pregunta 1");
        }else if(txtPregunta2.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe ingresar la pregunta 2");
        }
       
        else{
            con.nuevoUser(txtNombre.getText(),txtUser.getText(),txtPregunta1.getText(),txtPregunta2.getText(),
                String.valueOf(txtClave.getPassword()));
            
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNuevoUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JLabel lblUsuario3;
    private javax.swing.JLabel lblUsuario4;
    private javax.swing.JLabel lblusuario;
    private javax.swing.JPanel panelContraseña;
    private javax.swing.JPanel panelUsuario;
    public static javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPregunta1;
    private javax.swing.JTextField txtPregunta2;
    public static javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
