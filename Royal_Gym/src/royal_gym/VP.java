package royal_gym;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import presentacion.Configuracion;
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelVentas1 = new presentacion.PanelVentas();
        panelRegistroClientes1 = new presentacion.PanelRegistroClientes();
        panelUtilidad1 = new presentacion.PanelUtilidad();
        panelGastos1 = new presentacion.PanelGastos();
        panelInventarioMaquinaria1 = new presentacion.PanelInventarioMaquinaria();
        panelRegistroProductos1 = new presentacion.PanelRegistroProductos();
        jlMensajes = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Vender.png")), panelVentas1); // NOI18N
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Clientes.png")), panelRegistroClientes1); // NOI18N
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Utilidad.png")), panelUtilidad1); // NOI18N
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Gastos.png")), panelGastos1); // NOI18N
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Maquinaria.png")), panelInventarioMaquinaria1); // NOI18N
        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/Pestaña_Productos.png")), panelRegistroProductos1); // NOI18N

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jlMensajes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlMensajes.setForeground(new java.awt.Color(255, 0, 0));
        jlMensajes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMensajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlMensajesMouseClicked(evt);
            }
        });
        getContentPane().add(jlMensajes, java.awt.BorderLayout.PAGE_END);

        jMenu1.setText("Archivo");

        jMenuItem5.setText("Cerar Sesión");
        jMenu1.add(jMenuItem5);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Archivo_Salir.png"))); // NOI18N
        jMenuItem4.setText("Salir");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem4MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

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
        // TODO add your handling code here:
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

    private void jMenuItem4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4MousePressed

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
        new PanelNuevoUsuario(new javax.swing.JDialog(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItem2MousePressed

    private void jMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MousePressed
        new PanelUsuariosExistentes(new javax.swing.JDialog(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItem3MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //UIManager.setLookAndFeel(javax.swing.plaf.nimbus.NimbusLookAndFeel.class.getName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /* Create and display the form */
        Conexion conectar = new Conexion();
        conectar.conectar();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JLabel jlMensajes;
    private presentacion.PanelGastos panelGastos1;
    private presentacion.PanelInventarioMaquinaria panelInventarioMaquinaria1;
    private presentacion.PanelRegistroClientes panelRegistroClientes1;
    private presentacion.PanelRegistroProductos panelRegistroProductos1;
    private presentacion.PanelUtilidad panelUtilidad1;
    private presentacion.PanelVentas panelVentas1;
    // End of variables declaration//GEN-END:variables
}
