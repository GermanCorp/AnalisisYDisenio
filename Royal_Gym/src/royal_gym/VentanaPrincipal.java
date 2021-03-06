package royal_gym;

import javax.swing.ImageIcon;
import presentacion.Configuracion;
import presentacion.PanelNuevoUsuario;
import presentacion.PanelUsuariosExistentes;

public class VentanaPrincipal extends javax.swing.JFrame 
{

// Constructor
    public VentanaPrincipal() {
        initComponents();
        //setTitle("Royal Gym");
        //setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/LOGO_ROYALGYM_04.png")));
        //setIconImage(new ImageIcon(getClass().getResource("/iconos/LOGO_ROYALGYM_03.png")).getImage());
       }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelRegistroClientes1 = new presentacion.PanelRegistroClientes();
        panelCumpleaneros1 = new presentacion.PanelCumpleaneros();
        panelInventarioMaquinaria1 = new presentacion.PanelInventarioMaquinaria();
        panelRegistroProductos1 = new presentacion.PanelRegistroProductos();
        panelVentas1 = new presentacion.PanelVentas();
        panelUtilidad1 = new presentacion.PanelUtilidad();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemConfiguracion = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Clientes.png")), panelRegistroClientes1); // NOI18N
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Cumpleañeros.png")), panelCumpleaneros1); // NOI18N

        panelInventarioMaquinaria1.setPreferredSize(new java.awt.Dimension(919, 584));
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Maquinaria.png")), panelInventarioMaquinaria1); // NOI18N

        panelRegistroProductos1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelRegistroProductos1FocusGained(evt);
            }
        });
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Productos.png")), panelRegistroProductos1); // NOI18N

        panelVentas1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                panelVentas1FocusLost(evt);
            }
        });
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Vender.png")), panelVentas1); // NOI18N
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Utilidad.png")), panelUtilidad1); // NOI18N

        jMenu1.setText("Archivo");

        jMenuItemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Archivo_Salir.png"))); // NOI18N
        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemSalirMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemSalirMousePressed(evt);
            }
        });
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Herramientas");

        jMenuItemConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Herramientas_configuracion.png"))); // NOI18N
        jMenuItemConfiguracion.setText("Configuración");
        jMenuItemConfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemConfiguracionMousePressed(evt);
            }
        });
        jMenu2.add(jMenuItemConfiguracion);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Herramientas_Usuarios.png"))); // NOI18N
        jMenu3.setText("Usuarios");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Nuevo Usuario");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Usuario Registrados");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MousePressed(evt);
            }
        });
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenu2.add(jMenu3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1196, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void jMenuItemSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemSalirMouseClicked

    }//GEN-LAST:event_jMenuItemSalirMouseClicked

    private void jMenuItemSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemSalirMousePressed
        // TODO add your handling code here:
               System.exit(0);
    }//GEN-LAST:event_jMenuItemSalirMousePressed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed

    // TODO add your handling code here:
    this.dispose();
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        new PanelNuevoUsuario(new javax.swing.JDialog(), true).setVisible(true);    
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
      new PanelUsuariosExistentes(new javax.swing.JDialog(), true).setVisible(true);
         
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItemConfiguracionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemConfiguracionMousePressed
        new Configuracion(new javax.swing.JDialog(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItemConfiguracionMousePressed

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
        // TODO add your handling code here:
        new PanelNuevoUsuario(new javax.swing.JDialog(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItem2MousePressed

    private void jMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MousePressed
        // TODO add your handling code here:
        new PanelUsuariosExistentes(new javax.swing.JDialog(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItem3MousePressed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void panelVentas1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelVentas1FocusLost

    }//GEN-LAST:event_panelVentas1FocusLost

    private void panelRegistroProductos1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelRegistroProductos1FocusGained

    }//GEN-LAST:event_panelRegistroProductos1FocusGained

    // <editor-fold defaultstate="collapsed" desc="Elementos de Ventana Principal">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemConfiguracion;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JTabbedPane jTabbedPane1;
    private presentacion.PanelCumpleaneros panelCumpleaneros1;
    private presentacion.PanelInventarioMaquinaria panelInventarioMaquinaria1;
    private presentacion.PanelRegistroClientes panelRegistroClientes1;
    private presentacion.PanelRegistroProductos panelRegistroProductos1;
    private presentacion.PanelUtilidad panelUtilidad1;
    private presentacion.PanelVentas panelVentas1;
    // End of variables declaration//GEN-END:variables

public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Conexion conectar = new Conexion();
    conectar.conectar();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
    
} // </editor-fold> 


