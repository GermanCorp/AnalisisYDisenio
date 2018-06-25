/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

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
import static presentacion.ListaProductos.RET_CANCEL;
import static presentacion.ListaProductosCompra.RET_CANCEL;
import royal_gym.Productos;

/**
 *
 * @author Jazmin Vargas
 */
public class ListaProductosComprar extends javax.swing.JDialog {
    static double total;
    static double descuentoTotal;
    
    Productos productos = new Productos();
    PanelCompra panelcompra;
    
    
     private final String[] columnasProductos = {
        "Codigo",
        "Descripción",
        "Costo"};

    /**
     * Creates new form ListaProductosComprar
     */
     
    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;
     
    public ListaProductosComprar(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        okButton.setHorizontalTextPosition( SwingConstants.CENTER );
        okButton.setVerticalTextPosition( SwingConstants.BOTTOM );
        cancelButton.setHorizontalTextPosition( SwingConstants.CENTER );
        cancelButton.setVerticalTextPosition( SwingConstants.BOTTOM );
        setLocationRelativeTo(panelcompra);

       
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
           
            public void actionPerformed(ActionEvent e) {
              doClose(RET_CANCEL);
            }
        });
        
        DefaultTableModel modeloTablaProductos = new DefaultTableModel(productos.getListaProductos1(), columnasProductos);
        tablaProductos.setModel(modeloTablaProductos);
    }
    
     public int getReturnStatus() {
        return returnStatus;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfBuscarProductos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jLabel2 = new javax.swing.JLabel();
        jtfCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfDescuento = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setTitle("Productos");
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(657, 516));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Buscar Producto:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

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
        getContentPane().add(jtfBuscarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 490, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 590, 240));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Cantidad:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jtfCantidad.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jtfCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfCantidad.setText("1");
        getContentPane().add(jtfCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 100, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Descuento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        jtfDescuento.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jtfDescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfDescuento.setText("0");
        getContentPane().add(jtfDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 100, -1));

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Agregar_Cliente_2.png"))); // NOI18N
        okButton.setText("Agregar");
        okButton.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, -1, -1));
        getRootPane().setDefaultButton(okButton);

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Eliminar_fila.png"))); // NOI18N
        cancelButton.setText("Salir");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jtfBuscarProductosCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfBuscarProductosCaretUpdate
        DefaultTableModel modeloTablaBuscarProductos = new DefaultTableModel(productos.buscarListaProductos(jtfBuscarProductos.getText()), columnasProductos);
        tablaProductos.setModel(modeloTablaBuscarProductos);
    }//GEN-LAST:event_jtfBuscarProductosCaretUpdate

    private void jtfBuscarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarProductosActionPerformed

    private void jtfBuscarProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarProductosKeyPressed

    }//GEN-LAST:event_jtfBuscarProductosKeyPressed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        if(evt.getClickCount()==2){
             new CantidadAVender(new javax.swing.JDialog(), true).setVisible(true);
            }
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void tablaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMousePressed

    }//GEN-LAST:event_tablaProductosMousePressed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
         double calcula;
         double des;
        
        DefaultTableModel modelo;
        int filaSeleccinada = tablaProductos.getSelectedRow();
        String codigo;
        String descripcion;
        String precioCompra;
        String cantidad;
        String importe;
        String descuento;

        if(filaSeleccinada == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccinar un producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }else{
            modelo = (DefaultTableModel) tablaProductos.getModel();
            codigo = tablaProductos.getValueAt(filaSeleccinada, 0).toString();
            descripcion = tablaProductos.getValueAt(filaSeleccinada, 1).toString();
            precioCompra = tablaProductos.getValueAt(filaSeleccinada, 2).toString();
            cantidad = jtfCantidad.getText();
            descuento = jtfDescuento.getText();

            DecimalFormat df = new DecimalFormat("#,##0.00");
            double totalPorProductoCompra = ((Double.parseDouble(precioCompra) * Integer.parseInt(cantidad)) - Double.parseDouble(descuento));
            double isv = (totalPorProductoCompra-(totalPorProductoCompra/1.15));
            double subTotal = (totalPorProductoCompra/1.15);
            //importe = String.valueOf(totalPorProductoCompra);
            //double pv = (Double.parseDouble(precioVenta)/1.15);

            modelo = (DefaultTableModel) panelcompra.tablaCompras.getModel();
            String elementosFila [] = {codigo, cantidad, descripcion, df.format(Double.parseDouble(precioCompra)/1.15)
                    ,descuento,  df.format(subTotal),   df.format(isv), df.format(totalPorProductoCompra)};
            modelo.addRow(elementosFila);

            calcula  = (Double.parseDouble(precioCompra)* Integer.parseInt(jtfCantidad.getText()));
            des = (Double.parseDouble(descuento));

           // descuentoTotal = descuentoTotal + des;
            //total = total + calcula - des;

            
            PanelCompra.totalCompra =  PanelCompra.totalCompra + calcula - des;
            PanelCompra.subTotalCompra =  PanelCompra.totalCompra/1.15;
            PanelCompra.isvCompra =  PanelCompra.totalCompra-( PanelCompra.totalCompra/1.15);
            PanelCompra.descuentoCompra = PanelVentas.descuento + des;
            
            panelcompra = new PanelCompra(PanelCompra.totalCompra, PanelCompra.subTotalCompra, PanelCompra.isvCompra, PanelCompra.descuentoCompra);
            panelcompra.setValoresCompra();

            jtfCantidad.setText("1");
            jtfDescuento.setText("0");
        }
    }//GEN-LAST:event_okButtonActionPerformed

  
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {                             
        doClose(RET_CANCEL);
    }    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

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
