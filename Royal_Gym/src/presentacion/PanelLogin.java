package presentacion;

import java.sql.Connection;
import javax.swing.JOptionPane;
import royal_gym.Conexion;
import royal_gym.Validaciones;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import royal_gym.LoginEntrar;
import royal_gym.VentanaPrincipal;
import static sun.security.jgss.GSSUtil.login;

public class PanelLogin extends javax.swing.JFrame {

    static private Connection conexion;
    private static Statement statement;
    Conexion cn = new Conexion();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection conn = null;
    LoginEntrar LE = new LoginEntrar();
    

    public PanelLogin() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Acceso al sistema");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.LE = new LoginEntrar();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        lblAcceso = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        lblContrasena = new javax.swing.JLabel();
        contraseña = new javax.swing.JPasswordField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnIcono = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelLogin.setBackground(new java.awt.Color(85, 96, 128));
        panelLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblAcceso.setFont(new java.awt.Font("Times New Roman", 3, 32)); // NOI18N
        lblAcceso.setForeground(new java.awt.Color(255, 255, 255));
        lblAcceso.setText("Acceso Al Sistema");

        lblUsuario.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Usuario:");

        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });

        lblContrasena.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        lblContrasena.setForeground(new java.awt.Color(255, 255, 255));
        lblContrasena.setText("Contraseña:");

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
        btnCancelar.setText("Salir");
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
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContrasena)
                            .addComponent(lblUsuario)
                            .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblAcceso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                .addComponent(usuario, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(contraseña, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLoginLayout.createSequentialGroup()
                                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(btnIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblAcceso)
                .addGap(35, 35, 35)
                .addComponent(btnIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lblUsuario)
                .addGap(18, 18, 18)
                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblContrasena)
                .addGap(18, 18, 18)
                .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(35, 35, 35))
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
         usuario.setText("");
        contraseña.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed

     //conectarse a la base de datos
    public static void conectarr() {
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:gimnasio.db");
            statement = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    //Evento de boton aceptar para acceso a pantalla principal
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        
         if (usuario.getText().equals("") && contraseña.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el Usuario y Contrasena", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (usuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el nombre de usuario", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (contraseña.getPassword().length==0) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar la contrasena", "Error!", JOptionPane.ERROR_MESSAGE);
        }
         if (LoginEntrar.ingreso(usuario.getText(),String.valueOf(contraseña.getPassword())) == 1) {
				VentanaPrincipal pnu = new VentanaPrincipal();
				pnu.setVisible(true);
                                dispose();
                                
        usuario.setText("");
        contraseña.setText("");
                                         
	} 
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked

    }//GEN-LAST:event_btnAceptarMouseClicked

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelLogin().setVisible(true);
                
                 try {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        //UIManager.setLookAndFeel(javax.swing.plaf.nimbus.NimbusLookAndFeel.class.getName());
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(PanelLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIcono;
    public static javax.swing.JPasswordField contraseña;
    private javax.swing.JLabel lblAcceso;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelLogin;
    public static javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables

}
