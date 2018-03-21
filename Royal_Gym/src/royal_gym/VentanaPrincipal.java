package royal_gym;

import presentacion.PanelListaDeClientes;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import presentacion.PanelCumpleaneros;
import presentacion.PanelRegistroClientes;
import presentacion.PanelRegistroPagos;
import static royal_gym.Conexion.resultado;


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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });
        jTabbedPane1.addTab("tab1", panelRegistroPagos1);
        jTabbedPane1.addTab("tab2", panelRegistroClientes1);
        jTabbedPane1.addTab("tab3", panelInventarioMaquinaria1);
        jTabbedPane1.addTab("tab4", panelCumpleaneros1);
        jTabbedPane1.addTab("tab5", panelGastos1);
        jTabbedPane1.addTab("tab6", panelUtilidad1);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Registrar Pago");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
       
    }//GEN-LAST:event_jTabbedPane1FocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private presentacion.PanelCumpleaneros panelCumpleaneros1;
    private presentacion.PanelGastos panelGastos1;
    private presentacion.PanelInventarioMaquinaria panelInventarioMaquinaria1;
    private presentacion.PanelRegistroClientes panelRegistroClientes1;
    private presentacion.PanelRegistroPagos panelRegistroPagos1;
    private presentacion.PanelUtilidad panelUtilidad1;
    // End of variables declaration//GEN-END:variables
}
