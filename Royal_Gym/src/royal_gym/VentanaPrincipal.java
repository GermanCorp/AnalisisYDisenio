package royal_gym;

public class VentanaPrincipal extends javax.swing.JFrame {

// Constructor
    public VentanaPrincipal() {
        initComponents();
        setTitle("Royal Gym");
       }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelRegistroPagos1 = new presentacion.PanelRegistroPagos();
        panelRegistroClientes1 = new presentacion.PanelRegistroClientes();
        panelInventarioMaquinaria1 = new presentacion.PanelInventarioMaquinaria();
        panelCumpleaneros1 = new presentacion.PanelCumpleaneros();
        panelGastos1 = new presentacion.PanelGastos();
        panelUtilidad1 = new presentacion.PanelUtilidad();
        panelVentas1 = new presentacion.PanelVentas();
        panelRegistroProductos1 = new presentacion.PanelRegistroProductos();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        panelCompras1 = new presentacion.PanelCompras();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });
        jTabbedPane1.addTab("tab1", new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistrarPago_3.png")), panelRegistroPagos1); // NOI18N
        jTabbedPane1.addTab("Clientes", new javax.swing.ImageIcon(getClass().getResource("/iconos/AgregarNuevo_3.png")), panelRegistroClientes1); // NOI18N
        jTabbedPane1.addTab("Maquinaria", new javax.swing.ImageIcon(getClass().getResource("/iconos/Inventario_2.png")), panelInventarioMaquinaria1); // NOI18N
        jTabbedPane1.addTab("Cumpleañeros", panelCumpleaneros1);
        jTabbedPane1.addTab("Gastos", panelGastos1);
        jTabbedPane1.addTab("Utilidad", panelUtilidad1);
        jTabbedPane1.addTab("Vender", new javax.swing.ImageIcon(getClass().getResource("/iconos/Agregar_Producto.png")), panelVentas1); // NOI18N
        jTabbedPane1.addTab("Productos", panelRegistroProductos1);

        jTabbedPane2.addTab("tab1", panelCompras1);

        jTabbedPane1.addTab("Agregar Compra", jTabbedPane2);

        jMenu1.setText("File");

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

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Configuración");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1081, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Registrar Pago");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
       
    }//GEN-LAST:event_jTabbedPane1FocusGained
        
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

    // <editor-fold defaultstate="collapsed" desc="Elementos de Ventana Principal">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private presentacion.PanelCompras panelCompras1;
    private presentacion.PanelCumpleaneros panelCumpleaneros1;
    private presentacion.PanelGastos panelGastos1;
    private presentacion.PanelInventarioMaquinaria panelInventarioMaquinaria1;
    private presentacion.PanelRegistroClientes panelRegistroClientes1;
    private presentacion.PanelRegistroPagos panelRegistroPagos1;
    private presentacion.PanelRegistroProductos panelRegistroProductos1;
    private presentacion.PanelUtilidad panelUtilidad1;
    private presentacion.PanelVentas panelVentas1;
    // End of variables declaration//GEN-END:variables
} // </editor-fold> 
