package presentacion;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static presentacion.JDExpediente.jlFotoPerfil;
import royal_gym.Conexion;

public class OpcionFotoPefil extends javax.swing.JDialog {

    public OpcionFotoPefil(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Elija una Opción");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/Herramientas_configuracion_3.png"));
        setIconImage(icon);
        setLocationRelativeTo(null);
        btnArchivo.setFocusable(false);
        btnCamara.setFocusable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnArchivo = new javax.swing.JButton();
        btnCamara = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/seleccinarArchivo.png"))); // NOI18N
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        btnCamara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/tomarFoto.png"))); // NOI18N
        btnCamara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCamaraActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccinar Archivo");

        jLabel2.setText("Tomar Foto");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Elija una Opción");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(btnCamara, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCamara, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCamaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCamaraActionPerformed
        dispose();
        new Camara(new javax.swing.JDialog(), true).setVisible(true);

    }//GEN-LAST:event_btnCamaraActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
         File archivo;
        
        JFileChooser abrir = new JFileChooser();
       
        abrir.setFileFilter(new FileNameExtensionFilter("JPG, PNG, GIF", "jpg", "png", "gif"));
      
        int respuesta = abrir.showOpenDialog(this);
      
        if (respuesta == JFileChooser.APPROVE_OPTION) {
 
        archivo = abrir.getSelectedFile();
         
       Image foto = getToolkit().getImage(archivo.getAbsolutePath());
        
        foto = foto.getScaledInstance(275, jlFotoPerfil.getHeight(), Image.SCALE_DEFAULT);
          
        jlFotoPerfil.setIcon(new ImageIcon(foto));
        
        
        
        
         
        try {
            String sql = "UPDATE cliente set foto = ? where idCliente = ?";
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sql);
            pst.setBytes(1, readFile(archivo.getAbsolutePath()));
            pst.setString(2, PanelRegistroClientes.getIdCliente());
            pst.execute();

            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Captura Exitosa");
                //Conexion.cerrar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al tomar Foto " + e);
        }
        
        }
/*
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
        }*/
    }//GEN-LAST:event_btnArchivoActionPerformed

    public static byte [ ] readFile ( String file ) {
         ByteArrayOutputStream bos = null ;
         try {
             File f = new File ( file ) ;
             FileInputStream fis = new FileInputStream ( f ) ;
             byte [ ] buffer = new byte [ 1024 ] ;
             bos = new ByteArrayOutputStream ( ) ;
             for ( int len ; ( len = fis . read ( buffer ) ) != - 1 ; ) {
                 bos . write ( buffer , 0 , len ) ;
             }
         } catch ( FileNotFoundException e ) {
             System . err . println ( e . getMessage ( ) ) ;
         } catch ( IOException e2 ) {
             System . err . println ( e2 . getMessage ( ) ) ;
         }
         return bos != null ? bos . toByteArray ( ) : null ;
     }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnCamara;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
