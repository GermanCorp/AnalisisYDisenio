package presentacion;


import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import royal_gym.Clientes;
import royal_gym.Conexion;
import royal_gym.Productos;

/**
 *
 * @author alxcr
 */
public class ListaProductos extends javax.swing.JDialog {
   
    static double total;
    static double descuentoTotal;
        
    Productos productos = new Productos();
    PanelVentas pventas;
    private final String[] columnasProductos = {
        "Codigo",
        "Descripción",
        "Precio de Venta"
        
    };
    
    
    
    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;

    //Constructor
    public ListaProductos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        okButton.setHorizontalTextPosition( SwingConstants.CENTER );
        okButton.setVerticalTextPosition( SwingConstants.BOTTOM );
        cancelButton.setHorizontalTextPosition( SwingConstants.CENTER );
        cancelButton.setVerticalTextPosition( SwingConstants.BOTTOM );
        //getContentPane().setBackground( new java.awt.Color(85,96,128));
        //setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
        //setSize(this.getToolkit().getScreenSize()); 
        setLocationRelativeTo(pventas);

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
        
        DefaultTableModel modeloTablaProductos = new DefaultTableModel(productos.getListaProductos(), columnasProductos);
        tablaProductos.setModel(modeloTablaProductos);
    }

    /** @return the return status of this dialog - one of RET_OK or RET_CANCEL */
    public int getReturnStatus() {
        return returnStatus;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jtfBuscarProductos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfCantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfDescuento = new javax.swing.JTextField();

        setTitle("Productos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Agregar_Cliente_2.png"))); // NOI18N
        okButton.setText("Agregar");
        okButton.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Eliminar_fila.png"))); // NOI18N
        cancelButton.setText("Salir");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaProductosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        jtfBuscarProductos.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jtfBuscarProductos.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfBuscarProductosCaretUpdate(evt);
            }
        });
        jtfBuscarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarProductosActionPerformed(evt);
            }
        });
        jtfBuscarProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfBuscarProductosKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Buscar Producto:");

        jtfCantidad.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jtfCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfCantidad.setText("1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Cantidad:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Descuento:");

        jtfDescuento.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jtfDescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfDescuento.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfBuscarProductos))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(43, 43, 43)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtfBuscarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(1, 1, 1)
                        .addComponent(jtfDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        getRootPane().setDefaultButton(okButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        //doClose(RET_OK);
        DefaultTableModel modelo;
        int filaSeleccinada = tablaProductos.getSelectedRow();
        String codigo;
        String descripcion;
        String precioVenta;
        String cantidad;
        String importe;
        String descuento;
        
        
        if(filaSeleccinada == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccinar un producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }else{
            modelo = (DefaultTableModel) tablaProductos.getModel();
            codigo = tablaProductos.getValueAt(filaSeleccinada, 0).toString();
            descripcion = tablaProductos.getValueAt(filaSeleccinada, 1).toString();
            precioVenta = tablaProductos.getValueAt(filaSeleccinada, 2).toString();
            cantidad = jtfCantidad.getText();
            descuento = jtfDescuento.getText();
                    
            DecimalFormat df = new DecimalFormat("#,##0.00");
            double x = ((Double.parseDouble(precioVenta) * Integer.parseInt(cantidad)) - Double.parseDouble(descuento));
            double isv = (x-(x/1.15));
            double subTotal = (x/1.15);
            importe = String.valueOf(x);
            double pv = (Double.parseDouble(precioVenta)/1.15);
            
            modelo = (DefaultTableModel) pventas.jtablaProductosAVender.getModel();
            String elementosFila [] = {codigo, cantidad, descripcion, df.format(pv),descuento,  df.format(subTotal),   df.format(isv), importe};
            modelo.addRow(elementosFila);
            
            double calcula  = (Double.parseDouble(precioVenta)* Integer.parseInt(jtfCantidad.getText()));
            double des = (Double.parseDouble(descuento));
            
            descuentoTotal = descuentoTotal + des;
            total = total + calcula - des;
            
            PanelVentas ventas = new PanelVentas(total, total/1.15, total-(total/1.15), descuentoTotal);
            ventas.setValoresVenta(); 
            
            jtfCantidad.setText("1");
            jtfDescuento.setText("0");
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
      //if(evt.getClickCount()==2){
      //  new CantidadAVender(new javax.swing.JDialog(), true).setVisible(true);
      // }
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void tablaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMousePressed


    }//GEN-LAST:event_tablaProductosMousePressed

    private void jtfBuscarProductosCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfBuscarProductosCaretUpdate
        DefaultTableModel modeloTablaBuscarProductos = new DefaultTableModel(productos.buscarListaProductos(jtfBuscarProductos.getText()), columnasProductos);
        tablaProductos.setModel(modeloTablaBuscarProductos);
    }//GEN-LAST:event_jtfBuscarProductosCaretUpdate

    private void jtfBuscarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarProductosActionPerformed

    private void jtfBuscarProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarProductosKeyPressed

    }//GEN-LAST:event_jtfBuscarProductosKeyPressed

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtfBuscarProductos;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfDescuento;
    private javax.swing.JButton okButton;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}