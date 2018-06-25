package presentacion;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static presentacion.JDExpediente.jlFotoPerfil;
import royal_gym.Conexion;

public class Camara extends javax.swing.JDialog {

    public Camara(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        setTitle("Cámara");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/camarita.png"));
        setIconImage(icon);
        initComponents();
        setLocationRelativeTo(null);
        btnCapturarFoto.setFocusable(false);
        btnSalir.setFocusable(false);
    }

    public void tomarFoto() {
        //Conexion.conectar();
        byte[] imagen = panelCamara.getBytes();
        try {
            String sql = "UPDATE cliente set foto = ? where idCliente = ?";
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sql);
            pst.setBytes(1, imagen);
            pst.setString(2, PanelRegistroClientes.getIdCliente());
            pst.execute();

            //if (pst.executeUpdate() > 0) {
                //JOptionPane.showMessageDialog(null, "Captura Exitosa");
                //Conexion.cerrar();
            //}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al tomar Foto: \n" + e);
        }

        try {
            String consulta = "select foto from cliente where idCliente = ?";
            PreparedStatement pst = Conexion.getConexion().prepareStatement(consulta);
            pst.setString(1, PanelRegistroClientes.getIdCliente());
            ResultSet st = pst.executeQuery();

            while (st.next()) {
                byte[] imagen2 = st.getBytes("foto");
                //jlFotoPerfil.setIcon(new ImageIcon(imagen));

                ImageIcon fot = new ImageIcon(imagen2);
                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(275, jlFotoPerfil.getHeight(), Image.SCALE_DEFAULT));
                jlFotoPerfil.setIcon(icono);
                this.repaint();
            }
        } catch (Exception ex) {
            jlFotoPerfil.setIcon(new ImageIcon(Class.class.getResource("/iconos/sinFoto.png")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCamara = new JPanelWebCam.JPanelWebCam();
        btnSalir = new javax.swing.JButton();
        btnCapturarFoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelCamara.setBackground(new java.awt.Color(85, 96, 128));
        panelCamara.setFONDO(false);
        panelCamara.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCamaraMouseClicked(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camara_Cancelar.png"))); // NOI18N
        btnSalir.setText(" ");
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camara_cancelar2.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnCapturarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camara.png"))); // NOI18N
        btnCapturarFoto.setText(" ");
        btnCapturarFoto.setBorder(null);
        btnCapturarFoto.setBorderPainted(false);
        btnCapturarFoto.setContentAreaFilled(false);
        btnCapturarFoto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icono camaara2.png"))); // NOI18N
        btnCapturarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapturarFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCamaraLayout = new javax.swing.GroupLayout(panelCamara);
        panelCamara.setLayout(panelCamaraLayout);
        panelCamaraLayout.setHorizontalGroup(
            panelCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamaraLayout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(20, 20, 20)
                .addComponent(btnCapturarFoto)
                .addContainerGap(211, Short.MAX_VALUE))
        );
        panelCamaraLayout.setVerticalGroup(
            panelCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamaraLayout.createSequentialGroup()
                .addContainerGap(357, Short.MAX_VALUE)
                .addGroup(panelCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapturarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCamara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCamara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCapturarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturarFotoActionPerformed
        tomarFoto();
    }//GEN-LAST:event_btnCapturarFotoActionPerformed

    private void panelCamaraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCamaraMouseClicked

    }//GEN-LAST:event_panelCamaraMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapturarFoto;
    private javax.swing.JButton btnSalir;
    private JPanelWebCam.JPanelWebCam panelCamara;
    // End of variables declaration//GEN-END:variables
}
