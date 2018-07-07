package royal_gym;

import java.awt.Image;
import java.awt.Toolkit;
import presentacion.Configuracion;
import presentacion.PanelLogin;
import presentacion.PanelNuevoUsuario;
import presentacion.PanelUsuariosExistentes;

/**
 *
 * @author alxcr
 */
public class VP extends javax.swing.JFrame {

    public VP() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/LOGO_ROYALGYM_05.png"));
        setIconImage(icon);
        setTitle("Royal Gym");
        initComponents();
        panelRegistroClientes1.setPermiso(LoginEntrar.isADMIN());
        panelRegistroProductos1.setPermiso(LoginEntrar.isADMIN());
        jMenu2.setVisible(LoginEntrar.isADMIN());
        jTabbedPane1.setEnabledAt(jTabbedPane1.indexOfComponent(panelUtilidad1), LoginEntrar.isADMIN());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelRegistroClientes1 = new presentacion.PanelRegistroClientes();
        panelRegistroPagos1 = new presentacion.PanelRegistroPagos();
        panelVentas1 = new presentacion.PanelVentas();
        panelRegistroProductos1 = new presentacion.PanelRegistroProductos();
        panelGastos1 = new presentacion.PanelGastos();
        panelInventarioMaquinaria1 = new presentacion.PanelInventarioMaquinaria();
        panelUtilidad1 = new presentacion.PanelUtilidad();
        panelCompra1 = new presentacion.PanelCompra();
        jlMensajes = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuCerrarSesion = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Clientes.png")), panelRegistroClientes1); // NOI18N
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Pagos.png")), panelRegistroPagos1); // NOI18N
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Vender.png")), panelVentas1); // NOI18N
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Productos.png")), panelRegistroProductos1); // NOI18N
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Gastos.png")), panelGastos1); // NOI18N
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Maquinaria.png")), panelInventarioMaquinaria1); // NOI18N
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Utilidad.png")), panelUtilidad1); // NOI18N
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Compras.png")), panelCompra1); // NOI18N

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jlMensajes.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jlMensajes.setForeground(new java.awt.Color(255, 0, 0));
        jlMensajes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMensajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlMensajesMouseClicked(evt);
            }
        });
        getContentPane().add(jlMensajes, java.awt.BorderLayout.PAGE_END);

        jMenu1.setText("Archivo");

        jMenuCerrarSesion.setIcon(new javax.swing.ImageIcon("C:\\Users\\alxcr\\Documents\\GitHub\\AnalisisYDisenio\\Royal_Gym\\src\\iconos\\Cambiar_usuario.png")); // NOI18N
        jMenuCerrarSesion.setText("Cerrar Sesión");
        jMenuCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuCerrarSesionMousePressed(evt);
            }
        });
        jMenu1.add(jMenuCerrarSesion);

        jMenuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Archivo_Salir.png"))); // NOI18N
        jMenuSalir.setText("Salir");
        jMenuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuSalirMousePressed(evt);
            }
        });
        jMenu1.add(jMenuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Herramientas");

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Herramientas_Usuarios.png"))); // NOI18N
        jMenu5.setText("Usuarios");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevoUsuario.png"))); // NOI18N
        jMenuItem2.setText("Nuevo Usuario");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/usuariosRegistrados.png"))); // NOI18N
        jMenuItem3.setText("Usuarios Registrados");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MousePressed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenu2.add(jMenu5);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Herramientas_configuracion_2.png"))); // NOI18N
        jMenuItem1.setText("Configuración");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlMensajesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMensajesMouseClicked
        royal_gym.VP.jlMensajes.setText("");
    }//GEN-LAST:event_jlMensajesMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
        // TODO add your handling code here:
        new Configuracion(new javax.swing.JDialog(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItem1MousePressed

    private void jMenuSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSalirMousePressed
        // TODO add your handling code here:
        Conexion.cerrar();
        System.exit(0);
    }//GEN-LAST:event_jMenuSalirMousePressed

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
        new PanelNuevoUsuario(new javax.swing.JDialog(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItem2MousePressed

    private void jMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MousePressed
        new PanelUsuariosExistentes(new javax.swing.JDialog(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItem3MousePressed

    private void jMenuCerrarSesionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuCerrarSesionMousePressed
        this.dispose();
        PanelLogin vp = new PanelLogin();
        vp.setVisible(true);
        vp.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuCerrarSesionMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCerrarSesion;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JLabel jlMensajes;
    private presentacion.PanelCompra panelCompra1;
    private presentacion.PanelGastos panelGastos1;
    private presentacion.PanelInventarioMaquinaria panelInventarioMaquinaria1;
    private presentacion.PanelRegistroClientes panelRegistroClientes1;
    private presentacion.PanelRegistroPagos panelRegistroPagos1;
    private presentacion.PanelRegistroProductos panelRegistroProductos1;
    private presentacion.PanelUtilidad panelUtilidad1;
    private presentacion.PanelVentas panelVentas1;
    // End of variables declaration//GEN-END:variables
}
