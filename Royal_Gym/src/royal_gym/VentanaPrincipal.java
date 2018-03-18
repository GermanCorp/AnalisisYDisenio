package royal_gym;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author alxcr
 */


public class VentanaPrincipal extends javax.swing.JFrame {

    // variables
    Validaciones ValidarLetras = new Validaciones();
    Validaciones ValidarNumeros = new Validaciones();
    private final Conexion con;
    DefaultTableModel modeloTablaIngresos;
    DefaultTableModel modeloTablaGastos;
     DefaultTableModel modeloTablaUtilidad;
    
    

    int  filaseleccionadatablapagos;
        // columnas de la tabla pagos
        private final String[] columnasPagos = {
        "No.",
        "Cliente",
        "Monto",
        "Tiempo",
        "Tipo de Pago",
        "Tipo de Plan",
        "Fecha de Pago"
    };


    // columnas de la tabla Cliente
    private final String[] columnasClientes = {
        "No.",
        "Nombres",
        "Fecha Nac.",
        "Altura",
        "Peso",
        "Masa Corporal",
        "Clasificación"
    };
    
     // columnas de la tabla Inventario
    private final String[] columnasInventario = {
        "Nombres",
        "Cantidad",
        "Descripción"
    };
    
     private final String[] columnasUtilidad= {
            "No.",
            "Fecha ",
            "Ingresos",
            "Gastos"
           
     };
     
     private final String[] columnasIngresos= {
            "No.",
            "Fecha ",
            "Monto"
    };
     
     private final String[] columnasGastos= {
            "No.",
            "Fecha ",
            "Monto"
    };
    
    
    
    // Constructor
    public VentanaPrincipal() {
        initComponents();
        setTitle("Royal Gym");
        this.con = new Conexion();
        con.conectar();
        
        jScrollPane3.setVisible(false);
        jScrollPane4.setVisible(false);
       PaneltablaUtilidad.setVisible(false);
       Paneltotales.setVisible(false);
        
       

        ArrayList<String> lista =new ArrayList<String>();
            lista =  con.llenarCombo();
            for(int i = 0; i<lista.size(); i++){
                jcbClienteAPagar.addItem(lista.get(i));
            }

        // Modelo de la tabla de Clientes
        DefaultTableModel modeloTablaClientes = new DefaultTableModel(con.getCliente(),columnasClientes);
        tablaClientes.setModel(modeloTablaClientes);
        
        // Modelo de la tabla de Pagos
         DefaultTableModel modeloTablaPagos = new DefaultTableModel(con.getPago(),columnasPagos);
        tablaPagos.setModel(modeloTablaPagos);
        
        // Modelo de la tabla de Inventario
         DefaultTableModel modeloTablaInventario = new DefaultTableModel(con.getInventario(),columnasInventario);
        tablaInventarioEquipo.setModel(modeloTablaInventario);
        
      InputMap map2 = jtfMontoAPagar.getInputMap(jtfMontoAPagar.WHEN_FOCUSED);
      map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null"); 
    }
    

    // metodo para cambiar el acho de columnas
    private void setAnchoColumna(int[] ancho){
        int x = tablaClientes.getColumnCount()-1;
        int tamanio = tablaClientes.getWidth();
        for(int i = 0 ; i<=x; i++){
            TableColumn columnas = tablaClientes.getColumnModel().getColumn(i);
            columnas.setPreferredWidth(ancho[i]);
        }
    }
    
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelPagos = new javax.swing.JPanel();
        panelDatosPago = new javax.swing.JPanel();
        jtfClienteAPagar = new javax.swing.JLabel();
        jcbClienteAPagar = new javax.swing.JComboBox<>();
        jlMontoPagar = new javax.swing.JLabel();
        jtfMontoAPagar = new javax.swing.JTextField();
        jlTiempoPago = new javax.swing.JLabel();
        jtfTiempoAPagar = new javax.swing.JTextField();
        jcbPagoPlan = new javax.swing.JComboBox<>();
        jtfPagoTipodePlan = new javax.swing.JLabel();
        jbPagoAceptar = new javax.swing.JButton();
        jbPagoCancelar = new javax.swing.JButton();
        jcbTiempoPago = new javax.swing.JComboBox<>();
        jlRegistroClientes1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        PanelTablaPagos = new javax.swing.JPanel();
        jtfbuscarpago = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPagos = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        PanelClientes = new javax.swing.JPanel();
        panelDatosCliente = new javax.swing.JPanel();
        btnCancelarRegistroCliente = new javax.swing.JButton();
        jlRegistroClientes = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfNombreCliente = new javax.swing.JTextField();
        jtfApellidoCliente = new javax.swing.JTextField();
        jtfAltura = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAceptarRegistroCliente = new javax.swing.JButton();
        jtfPeso = new javax.swing.JTextField();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        PanelTabla = new javax.swing.JPanel();
        scrollTablaClientes = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jtfBuscarCliente = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        PanelInventario = new javax.swing.JPanel();
        PanelDatos = new javax.swing.JPanel();
        jlNombreEquipo = new javax.swing.JLabel();
        jtfNombreEquipo = new javax.swing.JTextField();
        jlCantidadEquipo = new javax.swing.JLabel();
        jtfCantidadEquipo = new javax.swing.JTextField();
        jlDescripcionEquipo = new javax.swing.JLabel();
        taDescripcionEquipo = new java.awt.TextArea();
        btnAceptarInventario = new javax.swing.JButton();
        btnCancelarInventario = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventarioEquipo = new javax.swing.JTable();
        PanelConfiguracion = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        PanelUtilidad = new javax.swing.JPanel();
        Panelfecha = new javax.swing.JPanel();
        jdcfechaInicio = new com.toedter.calendar.JDateChooser();
        jdcfechaFinal = new com.toedter.calendar.JDateChooser();
        tbingresos = new javax.swing.JToggleButton();
        tbgastos = new javax.swing.JToggleButton();
        tbtodo = new javax.swing.JToggleButton();
        PaneltablaUtilidad = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablautilidadingresos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablautilidadgastos = new javax.swing.JTable();
        Paneltotales = new javax.swing.JPanel();
        txttotalgastos = new javax.swing.JTextField();
        txttotalingresos = new javax.swing.JTextField();
        labeltotalingresos = new javax.swing.JLabel();
        labeltotalgastos = new javax.swing.JLabel();
        labelutilidad = new javax.swing.JLabel();
        txtutilidad = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        PanelPagos.setBackground(new java.awt.Color(85, 96, 128));
        PanelPagos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        panelDatosPago.setBackground(new java.awt.Color(85, 96, 128));
        panelDatosPago.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar Pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        panelDatosPago.setPreferredSize(new java.awt.Dimension(344, 460));

        jtfClienteAPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfClienteAPagar.setForeground(new java.awt.Color(255, 255, 255));
        jtfClienteAPagar.setText("Cliente:");

        jcbClienteAPagar.setPreferredSize(new java.awt.Dimension(6, 23));
        jcbClienteAPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbClienteAPagarMouseClicked(evt);
            }
        });
        jcbClienteAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClienteAPagarActionPerformed(evt);
            }
        });

        jlMontoPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlMontoPagar.setForeground(new java.awt.Color(255, 255, 255));
        jlMontoPagar.setText("Monto:");

        jtfMontoAPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfMontoAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMontoAPagarActionPerformed(evt);
            }
        });
        jtfMontoAPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfMontoAPagarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMontoAPagarKeyTyped(evt);
            }
        });

        jlTiempoPago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlTiempoPago.setForeground(new java.awt.Color(255, 255, 255));
        jlTiempoPago.setText("Tiempo:");

        jtfTiempoAPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfTiempoAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTiempoAPagarActionPerformed(evt);
            }
        });
        jtfTiempoAPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfTiempoAPagarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTiempoAPagarKeyTyped(evt);
            }
        });

        jcbPagoPlan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Pareja", "Grupo", "Estudiante" }));
        jcbPagoPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPagoPlanActionPerformed(evt);
            }
        });

        jtfPagoTipodePlan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfPagoTipodePlan.setForeground(new java.awt.Color(255, 255, 255));
        jtfPagoTipodePlan.setText("Tipo de Plan:");

        jbPagoAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Aceptar.png"))); // NOI18N
        jbPagoAceptar.setText("Aceptar");
        jbPagoAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagoAceptarActionPerformed(evt);
            }
        });

        jbPagoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cancelar.png"))); // NOI18N
        jbPagoCancelar.setText("Cancelar");
        jbPagoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagoCancelarActionPerformed(evt);
            }
        });

        jcbTiempoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "Semana", "Mes" }));
        jcbTiempoPago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTiempoPagoItemStateChanged(evt);
            }
        });
        jcbTiempoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTiempoPagoActionPerformed(evt);
            }
        });

        jlRegistroClientes1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jlRegistroClientes1.setForeground(new java.awt.Color(255, 255, 255));
        jlRegistroClientes1.setText("<html> <center>Registro de<center> <center> Pagos<center>");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistroNuevoPagos.png"))); // NOI18N

        javax.swing.GroupLayout panelDatosPagoLayout = new javax.swing.GroupLayout(panelDatosPago);
        panelDatosPago.setLayout(panelDatosPagoLayout);
        panelDatosPagoLayout.setHorizontalGroup(
            panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosPagoLayout.createSequentialGroup()
                        .addComponent(jcbClienteAPagar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addComponent(jlMontoPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDatosPagoLayout.createSequentialGroup()
                        .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                                .addComponent(jlTiempoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90))
                            .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jcbPagoPlan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfMontoAPagar, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelDatosPagoLayout.createSequentialGroup()
                                    .addComponent(jbPagoAceptar)
                                    .addGap(46, 46, 46)
                                    .addComponent(jbPagoCancelar)))
                            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                                .addComponent(jtfTiempoAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jcbTiempoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(panelDatosPagoLayout.createSequentialGroup()
                        .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(20, 20, 20)
                                .addComponent(jlRegistroClientes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfPagoTipodePlan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfClienteAPagar))
                        .addContainerGap())))
        );
        panelDatosPagoLayout.setVerticalGroup(
            panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlRegistroClientes1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jtfClienteAPagar)
                .addGap(0, 0, 0)
                .addComponent(jcbClienteAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jlMontoPagar)
                .addGap(0, 0, 0)
                .addComponent(jtfMontoAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jlTiempoPago)
                .addGap(0, 0, 0)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTiempoAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTiempoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jtfPagoTipodePlan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbPagoPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbPagoAceptar)
                    .addComponent(jbPagoCancelar))
                .addGap(20, 20, 20))
        );

        PanelTablaPagos.setBackground(new java.awt.Color(85, 96, 128));
        PanelTablaPagos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pagos Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        PanelTablaPagos.setPreferredSize(new java.awt.Dimension(1213, 830));

        jtfbuscarpago.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfbuscarpagoCaretUpdate(evt);
            }
        });
        jtfbuscarpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfbuscarpagoActionPerformed(evt);
            }
        });
        jtfbuscarpago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfbuscarpagoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfbuscarpagoKeyTyped(evt);
            }
        });

        tablaPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPagosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaPagos);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Buscar.png"))); // NOI18N

        javax.swing.GroupLayout PanelTablaPagosLayout = new javax.swing.GroupLayout(PanelTablaPagos);
        PanelTablaPagos.setLayout(PanelTablaPagosLayout);
        PanelTablaPagosLayout.setHorizontalGroup(
            PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaPagosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelTablaPagosLayout.createSequentialGroup()
                        .addComponent(jtfbuscarpago, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel15)))
                .addGap(20, 20, 20))
        );
        PanelTablaPagosLayout.setVerticalGroup(
            PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaPagosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfbuscarpago, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelPagosLayout = new javax.swing.GroupLayout(PanelPagos);
        PanelPagos.setLayout(PanelPagosLayout);
        PanelPagosLayout.setHorizontalGroup(
            PanelPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPagosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelDatosPago, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(PanelTablaPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
        );
        PanelPagosLayout.setVerticalGroup(
            PanelPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPagosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosPago, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
                    .addComponent(PanelTablaPagos, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistrarPago_3.png")), PanelPagos); // NOI18N

        PanelClientes.setBackground(new java.awt.Color(85, 96, 128));
        PanelClientes.setPreferredSize(new java.awt.Dimension(1257, 500));

        panelDatosCliente.setBackground(new java.awt.Color(85, 96, 128));
        panelDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        panelDatosCliente.setToolTipText("");
        panelDatosCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelDatosClienteFocusGained(evt);
            }
        });

        btnCancelarRegistroCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cancelar.png"))); // NOI18N
        btnCancelarRegistroCliente.setText("Cancelar");
        btnCancelarRegistroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRegistroClienteActionPerformed(evt);
            }
        });

        jlRegistroClientes.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jlRegistroClientes.setForeground(new java.awt.Color(255, 255, 255));
        jlRegistroClientes.setText("<html>\n<center>Registro de<center>\n<center> Clientes<center>");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombres:");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Apellidos:");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nacimiento:");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Altura:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Peso:");

        jtfNombreCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreClienteActionPerformed(evt);
            }
        });
        jtfNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNombreClienteKeyTyped(evt);
            }
        });

        jtfApellidoCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfApellidoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfApellidoClienteActionPerformed(evt);
            }
        });
        jtfApellidoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfApellidoClienteKeyTyped(evt);
            }
        });

        jtfAltura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfAltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAlturaActionPerformed(evt);
            }
        });
        jtfAltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAlturaKeyTyped(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mts");
        jLabel6.setPreferredSize(new java.awt.Dimension(30, 14));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kgs.");

        btnAceptarRegistroCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Aceptar.png"))); // NOI18N
        btnAceptarRegistroCliente.setText("Aceptar");
        btnAceptarRegistroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarRegistroClienteActionPerformed(evt);
            }
        });
        btnAceptarRegistroCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAceptarRegistroClienteKeyPressed(evt);
            }
        });

        jtfPeso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPesoActionPerformed(evt);
            }
        });
        jtfPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPesoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfPesoKeyTyped(evt);
            }
        });

        jdcFecha.setDateFormatString("dd-MM-yyyy");
        jdcFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jdcFecha.setInheritsPopupMenu(true);
        jdcFecha.setPreferredSize(new java.awt.Dimension(100, 100));
        jdcFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jdcFechaKeyTyped(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistroNuevoCliente.png"))); // NOI18N

        javax.swing.GroupLayout panelDatosClienteLayout = new javax.swing.GroupLayout(panelDatosCliente);
        panelDatosCliente.setLayout(panelDatosClienteLayout);
        panelDatosClienteLayout.setHorizontalGroup(
            panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addComponent(btnAceptarRegistroCliente)
                        .addGap(65, 65, 65)
                        .addComponent(btnCancelarRegistroCliente))
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(20, 20, 20)
                        .addComponent(jlRegistroClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelDatosClienteLayout.setVerticalGroup(
            panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jlRegistroClientes))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jtfNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jtfApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addGap(18, 464, Short.MAX_VALUE)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarRegistroCliente)
                    .addComponent(btnCancelarRegistroCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTabla.setBackground(new java.awt.Color(85, 96, 128));
        PanelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Clientes Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        tablaClientes.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaClientes.setAutoscrolls(true);
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        scrollTablaClientes.setViewportView(tablaClientes);

        jtfBuscarCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfBuscarCliente.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfBuscarClienteCaretUpdate(evt);
            }
        });
        jtfBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarClienteActionPerformed(evt);
            }
        });
        jtfBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfBuscarClienteKeyPressed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Buscar.png"))); // NOI18N

        javax.swing.GroupLayout PanelTablaLayout = new javax.swing.GroupLayout(PanelTabla);
        PanelTabla.setLayout(PanelTablaLayout);
        PanelTablaLayout.setHorizontalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTablaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelTablaLayout.createSequentialGroup()
                        .addComponent(jtfBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        PanelTablaLayout.setVerticalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfBuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTablaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout PanelClientesLayout = new javax.swing.GroupLayout(PanelClientes);
        PanelClientes.setLayout(PanelClientesLayout);
        PanelClientesLayout.setHorizontalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(PanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
        );
        PanelClientesLayout.setVerticalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("<html>\n<center>Registro<center>\n<center>Clientes<center>", new javax.swing.ImageIcon(getClass().getResource("/iconos/AgregarNuevo_2.png")), PanelClientes); // NOI18N

        PanelInventario.setBackground(new java.awt.Color(85, 96, 128));

        PanelDatos.setBackground(new java.awt.Color(85, 96, 128));

        jlNombreEquipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlNombreEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jlNombreEquipo.setText("Nombre");

        jtfNombreEquipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfNombreEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreEquipoActionPerformed(evt);
            }
        });
        jtfNombreEquipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNombreEquipoKeyTyped(evt);
            }
        });

        jlCantidadEquipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlCantidadEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jlCantidadEquipo.setText("Cantidad");

        jtfCantidadEquipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfCantidadEquipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantidadEquipoKeyTyped(evt);
            }
        });

        jlDescripcionEquipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlDescripcionEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jlDescripcionEquipo.setText("Descripcion");

        taDescripcionEquipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        taDescripcionEquipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                taDescripcionEquipoKeyTyped(evt);
            }
        });

        btnAceptarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Aceptar.png"))); // NOI18N
        btnAceptarInventario.setText("Aceptar");
        btnAceptarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarInventarioActionPerformed(evt);
            }
        });

        btnCancelarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cancelar.png"))); // NOI18N
        btnCancelarInventario.setText("Cancelar");
        btnCancelarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarInventarioActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistroNuevoInventario.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("<html> <center>Inventario de<center> <center> Equipo<center>");

        javax.swing.GroupLayout PanelDatosLayout = new javax.swing.GroupLayout(PanelDatos);
        PanelDatos.setLayout(PanelDatosLayout);
        PanelDatosLayout.setHorizontalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCantidadEquipo)
                    .addComponent(jlDescripcionEquipo)
                    .addComponent(jlNombreEquipo)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCantidadEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelDatosLayout.createSequentialGroup()
                            .addComponent(btnAceptarInventario)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelarInventario))
                        .addComponent(taDescripcionEquipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        PanelDatosLayout.setVerticalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jlNombreEquipo)
                .addGap(0, 0, 0)
                .addComponent(jtfNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jlCantidadEquipo)
                .addGap(0, 0, 0)
                .addComponent(jtfCantidadEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jlDescripcionEquipo)
                .addGap(0, 0, 0)
                .addComponent(taDescripcionEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarInventario)
                    .addComponent(btnCancelarInventario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtfNombreEquipo.getAccessibleContext().setAccessibleParent(jlNombreEquipo);
        jLabel10.getAccessibleContext().setAccessibleName("<html>\n<center>Inventario de<center>\n <center> Equipo<center>");

        tablaInventarioEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaInventarioEquipo);

        javax.swing.GroupLayout PanelInventarioLayout = new javax.swing.GroupLayout(PanelInventario);
        PanelInventario.setLayout(PanelInventarioLayout);
        PanelInventarioLayout.setHorizontalGroup(
            PanelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInventarioLayout.createSequentialGroup()
                .addComponent(PanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1)
                .addGap(20, 20, 20))
        );
        PanelInventarioLayout.setVerticalGroup(
            PanelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelInventarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1)
                .addGap(100, 100, 100))
        );

        jTabbedPane1.addTab("<html>\n<center>Inventario de<center>\n<center>Maquinaria<center>", new javax.swing.ImageIcon(getClass().getResource("/iconos/Inventario_2.png")), PanelInventario); // NOI18N

        jLabel8.setText("Edad Permitida para pago:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelConfiguracionLayout = new javax.swing.GroupLayout(PanelConfiguracion);
        PanelConfiguracion.setLayout(PanelConfiguracionLayout);
        PanelConfiguracionLayout.setHorizontalGroup(
            PanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelConfiguracionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1054, Short.MAX_VALUE))
        );
        PanelConfiguracionLayout.setVerticalGroup(
            PanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelConfiguracionLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(PanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(916, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Configuración", new javax.swing.ImageIcon(getClass().getResource("/iconos/Configuracion.png")), PanelConfiguracion); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1289, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 975, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Gastos", jPanel2);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Lista de cumpleañeros del mes");

        jButton3.setText("jButton3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jLabel13))
                .addContainerGap(1027, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel13)
                .addGap(38, 38, 38)
                .addComponent(jButton3)
                .addContainerGap(850, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cumpleañeros", jPanel3);

        PanelUtilidad.setBackground(new java.awt.Color(85, 96, 128));

        Panelfecha.setBackground(new java.awt.Color(85, 96, 128));
        Panelfecha.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Rangos De Fecha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jdcfechaInicio.setDateFormatString("yyyy-MM-dd");

        jdcfechaFinal.setDateFormatString("yyyy-MM-dd");

        tbingresos.setText("Ingresos");
        tbingresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbingresosActionPerformed(evt);
            }
        });

        tbgastos.setText("Gastos");
        tbgastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbgastosActionPerformed(evt);
            }
        });

        tbtodo.setText("Todo");
        tbtodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelfechaLayout = new javax.swing.GroupLayout(Panelfecha);
        Panelfecha.setLayout(PanelfechaLayout);
        PanelfechaLayout.setHorizontalGroup(
            PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelfechaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelfechaLayout.createSequentialGroup()
                        .addComponent(jdcfechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jdcfechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelfechaLayout.createSequentialGroup()
                        .addComponent(tbingresos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(tbgastos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbtodo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        PanelfechaLayout.setVerticalGroup(
            PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelfechaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdcfechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jdcfechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69)
                .addGroup(PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbgastos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbingresos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbtodo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );

        PaneltablaUtilidad.setBackground(new java.awt.Color(85, 96, 128));
        PaneltablaUtilidad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ingresos y Gastos Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        tablautilidadingresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablautilidadingresos);

        tablautilidadgastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tablautilidadgastos);

        javax.swing.GroupLayout PaneltablaUtilidadLayout = new javax.swing.GroupLayout(PaneltablaUtilidad);
        PaneltablaUtilidad.setLayout(PaneltablaUtilidadLayout);
        PaneltablaUtilidadLayout.setHorizontalGroup(
            PaneltablaUtilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneltablaUtilidadLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        PaneltablaUtilidadLayout.setVerticalGroup(
            PaneltablaUtilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneltablaUtilidadLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PaneltablaUtilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        Paneltotales.setBackground(new java.awt.Color(85, 96, 128));
        Paneltotales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Utilidad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        txttotalgastos.setEditable(false);
        txttotalgastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalgastosActionPerformed(evt);
            }
        });

        txttotalingresos.setEditable(false);
        txttotalingresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalingresosActionPerformed(evt);
            }
        });

        labeltotalingresos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labeltotalingresos.setForeground(new java.awt.Color(255, 255, 255));
        labeltotalingresos.setText("Total Ingresos:");

        labeltotalgastos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labeltotalgastos.setForeground(new java.awt.Color(255, 255, 255));
        labeltotalgastos.setText("Total Gastos:");

        labelutilidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelutilidad.setForeground(new java.awt.Color(255, 255, 255));
        labelutilidad.setText("Utilidad:");

        txtutilidad.setEditable(false);

        javax.swing.GroupLayout PaneltotalesLayout = new javax.swing.GroupLayout(Paneltotales);
        Paneltotales.setLayout(PaneltotalesLayout);
        PaneltotalesLayout.setHorizontalGroup(
            PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneltotalesLayout.createSequentialGroup()
                .addGroup(PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PaneltotalesLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(txttotalgastos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PaneltotalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labeltotalingresos)
                        .addGap(18, 18, 18)
                        .addComponent(txttotalingresos, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PaneltotalesLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addGroup(PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(labeltotalgastos)
                        .addComponent(labelutilidad))
                    .addGap(18, 18, 18)
                    .addComponent(txtutilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );
        PaneltotalesLayout.setVerticalGroup(
            PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneltotalesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labeltotalingresos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotalingresos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttotalgastos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PaneltotalesLayout.createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addComponent(labeltotalgastos)
                    .addGap(18, 18, 18)
                    .addGroup(PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelutilidad)
                        .addComponent(txtutilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(48, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PanelUtilidadLayout = new javax.swing.GroupLayout(PanelUtilidad);
        PanelUtilidad.setLayout(PanelUtilidadLayout);
        PanelUtilidadLayout.setHorizontalGroup(
            PanelUtilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUtilidadLayout.createSequentialGroup()
                .addGroup(PanelUtilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelUtilidadLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Panelfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PaneltablaUtilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelUtilidadLayout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(Paneltotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(250, Short.MAX_VALUE))
        );
        PanelUtilidadLayout.setVerticalGroup(
            PanelUtilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUtilidadLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelUtilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Panelfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PaneltablaUtilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(Paneltotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(415, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Utilidad", PanelUtilidad);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Registrar Pago");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreClienteActionPerformed

    private void jtfApellidoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfApellidoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfApellidoClienteActionPerformed

    private void jtfAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAlturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAlturaActionPerformed

    // método para obtener la fecha desde el jcalendar
    private Date fecha() {
        Date date = jdcFecha.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        return fecha;
    }

    // Evento del boton aceptar para guardar cliente en la base de datos
    private void btnAceptarRegistroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarRegistroClienteActionPerformed
        con.conectar();
        Calendar cal = Calendar.getInstance();
        int anio = cal.get(Calendar.YEAR);
        int anioPermitido = anio - 18;
        int anioViejo = anio - 100;

        if (jtfNombreCliente.getText().isEmpty()
                && jtfApellidoCliente.getText().isEmpty()
                && jdcFecha.getDate() == null
                && jtfAltura.getText().isEmpty()
                && jtfPeso.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ingrese Toda la Información", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfNombreCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el NOMBRE del Cliente", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfApellidoCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el APELLLIDO del Cliente", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jdcFecha.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccinar la FECHA de nacimiento", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jdcFecha.getCalendar().get(Calendar.YEAR) > anioPermitido) {
            JOptionPane.showMessageDialog(this, "El cliente debe ser mayor de 18 años", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jdcFecha.getCalendar().get(Calendar.YEAR) < anioViejo) {
            JOptionPane.showMessageDialog(this, "El cliente podría no estar apto para ejercitarse", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfAltura.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la altura del cliente", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfPeso.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el peso del cliente", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {

            con.insertarCliente(
                    jtfNombreCliente.getText(),
                    jtfApellidoCliente.getText(),
                    fecha().toString(),
                    jtfAltura.getText(),
                    jtfPeso.getText());

            jtfNombreCliente.setText("");
            jtfApellidoCliente.setText("");
            jdcFecha.setDate(null);
            jtfAltura.setText("");
            jtfPeso.setText("");
            
            DefaultTableModel modeloTablaClientes = new DefaultTableModel(con.getCliente(),columnasClientes);
            tablaClientes.setModel(modeloTablaClientes);
            JOptionPane.showMessageDialog(this, "Registro Exitoso", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnAceptarRegistroClienteActionPerformed

    private void jtfPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPesoActionPerformed

    private void btnCancelarRegistroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRegistroClienteActionPerformed
        jtfNombreCliente.setText("");
        jtfApellidoCliente.setText("");
        jdcFecha.setDate(null);
        jtfPeso.setText("");
        jtfAltura.setText("");

    }//GEN-LAST:event_btnCancelarRegistroClienteActionPerformed

    private void jtfNombreEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreEquipoActionPerformed

    private void jtfNombreEquipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreEquipoKeyTyped
        if (evt.isControlDown() && evt.isAltDown() && evt.isShiftDown()) {
            evt.consume();
        }

        ValidarLetras.soloLetras(evt);
        if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            evt.consume();

            jtfNombreEquipo.setCursor(null);
        }
    }//GEN-LAST:event_jtfNombreEquipoKeyTyped

    private void jtfCantidadEquipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadEquipoKeyTyped
        if (evt.isControlDown() && evt.isAltDown() && evt.isShiftDown()) {
            evt.consume();
        }

        int limit = 4;
        if (jtfCantidadEquipo.getText().length() == limit) {
            evt.consume();

        }

        ValidarNumeros.soloNumeros(evt);

        if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            evt.consume();

            jtfCantidadEquipo.setCursor(null);
        }
    }//GEN-LAST:event_jtfCantidadEquipoKeyTyped

    // Evento del boton aceptar para guardar inventario en la base de datos
    private void btnAceptarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarInventarioActionPerformed
        con.conectar();
        //validaciones para los JTextField 1,2 y textArea1 para campos vacios
        if (jtfNombreEquipo.getText().equals("") && jtfCantidadEquipo.getText().equals("") && taDescripcionEquipo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (jtfNombreEquipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el nombre del Equipo", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfCantidadEquipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar la cantidad de Equipo", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (taDescripcionEquipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar la descripcion del Equipo", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            //metodogo getText para cada los JTextField 1,2 y textArea1 y asi obtener el texto
            con.insertarInventario(
                    jtfNombreEquipo.getText(),
                    jtfCantidadEquipo.getText(),
                    taDescripcionEquipo.getText());
            
        DefaultTableModel modeloTablaInventario = new DefaultTableModel(con.getInventario(),columnasInventario);
        tablaInventarioEquipo.setModel(modeloTablaInventario);
        
            jtfNombreEquipo.setText("");
            jtfCantidadEquipo.setText("");
            taDescripcionEquipo.setText("");   
        }
    }//GEN-LAST:event_btnAceptarInventarioActionPerformed

    private void btnCancelarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarInventarioActionPerformed
         jtfNombreEquipo.setText("");
            jtfCantidadEquipo.setText("");
            taDescripcionEquipo.setText("");
    }//GEN-LAST:event_btnCancelarInventarioActionPerformed

    private void taDescripcionEquipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taDescripcionEquipoKeyTyped
        if (evt.isControlDown() && evt.isAltDown() && evt.isShiftDown()) {
            evt.consume();
        }
        if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            evt.consume();

            taDescripcionEquipo.setCursor(null);
        }
    }//GEN-LAST:event_taDescripcionEquipoKeyTyped

    private void jcbPagoPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPagoPlanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbPagoPlanActionPerformed

    private void jbPagoAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagoAceptarActionPerformed
        Calendar c;
        c = Calendar.getInstance();
        int d = c.get(Calendar.DATE), m = 1 + (c.get(Calendar.MONTH)), a = c.get(Calendar.YEAR);

        String dia = Integer.toString(d);
        String mes = Integer.toString(m);
        String anio = Integer.toString(a);
        String fecha = (anio + "-" + mes + "-" + dia);

        if (validarInformacion() == true) {

            if (jcbPagoPlan.getSelectedItem() != null) {
                con.insertarPagos(jcbClienteAPagar.getSelectedItem().toString(), jtfMontoAPagar.getText(), jtfTiempoAPagar.getText(),
                        jcbTiempoPago.getSelectedItem().toString(), jcbPagoPlan.getSelectedItem().toString(), fecha);
            } else {
                con.insertarPagos(jcbClienteAPagar.getSelectedItem().toString(), jtfMontoAPagar.getText(), jtfTiempoAPagar.getText(),
                        jcbTiempoPago.getSelectedItem().toString(), "No aplica", fecha);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Ingrese toda la informacion");
        }

        jcbClienteAPagar.setSelectedIndex(0);
        jtfMontoAPagar.setText("");
        jtfTiempoAPagar.setText("");
        jcbTiempoPago.setSelectedIndex(0);
        jcbPagoPlan.setSelectedIndex(0);

       DefaultTableModel modeloTablaPagos = new DefaultTableModel(con.getPago(),columnasPagos);
       tablaPagos.setModel(modeloTablaPagos);

    }//GEN-LAST:event_jbPagoAceptarActionPerformed

    boolean validarInformacion() {
        int errores = 0;
        String m = jtfMontoAPagar.getText(),
                t = jtfTiempoAPagar.getText();

        if (m.equals("")) {
            errores++;
        }

        if (t.equals("")) {
            errores++;
        }

        return errores == 0;
    }

    private void jbPagoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagoCancelarActionPerformed
        jcbClienteAPagar.setSelectedIndex(0);
        jtfMontoAPagar.setText("");
        jtfTiempoAPagar.setText("");
        jcbTiempoPago.setSelectedIndex(0);
        jcbPagoPlan.setSelectedIndex(0);
    }//GEN-LAST:event_jbPagoCancelarActionPerformed

    private void jcbClienteAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClienteAPagarActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_jcbClienteAPagarActionPerformed

    private void jcbClienteAPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbClienteAPagarMouseClicked
        jcbClienteAPagar.removeAllItems();
        ArrayList<String> lista =new ArrayList<String>();
            lista =  con.llenarCombo();
            for(int i = 0; i<lista.size(); i++){
                jcbClienteAPagar.addItem(lista.get(i));
            }
    }//GEN-LAST:event_jcbClienteAPagarMouseClicked

    private void jtfAlturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAlturaKeyTyped
        
          char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
             btnAceptarRegistroCliente.doClick();
      }
        if(!Character.isDigit(evt.getKeyChar())&&evt.getKeyChar()!='.'){
            evt.consume();  
        }
         if(evt.getKeyChar()== '.'&&jtfAltura.getText().contains(".")){
            evt.consume();  
        }
    }//GEN-LAST:event_jtfAlturaKeyTyped

    private void jtfPesoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesoKeyReleased
        if(!Character.isDigit(evt.getKeyChar())&&evt.getKeyChar()!='.'){
            evt.consume();  
        }
         if(evt.getKeyChar()== '.'&&jtfAltura.getText().contains(".")){
            evt.consume();  
        }
    }//GEN-LAST:event_jtfPesoKeyReleased

    private void jtfTiempoAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTiempoAPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTiempoAPagarActionPerformed

    private void jtfTiempoAPagarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTiempoAPagarKeyTyped
        Number n = evt.getKeyCode();
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
        
        int limit = 2;
        if (jtfTiempoAPagar.getText().length() == limit) {
            evt.consume();

        }
    }//GEN-LAST:event_jtfTiempoAPagarKeyTyped

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void jtfMontoAPagarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMontoAPagarKeyTyped
        Number n = evt.getKeyCode();
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
            
        } 
        
        int limit = 4;
        if (jtfMontoAPagar.getText().length() == limit) {
            evt.consume();

        }
    }//GEN-LAST:event_jtfMontoAPagarKeyTyped

    private void btnAceptarRegistroClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarRegistroClienteKeyPressed

    }//GEN-LAST:event_btnAceptarRegistroClienteKeyPressed

    private void panelDatosClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelDatosClienteFocusGained

    }//GEN-LAST:event_panelDatosClienteFocusGained

    private void jtfNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreClienteKeyTyped
       char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
             btnAceptarRegistroCliente.doClick();
      }
    }//GEN-LAST:event_jtfNombreClienteKeyTyped

    private void jtfApellidoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoClienteKeyTyped
        
         char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
             btnAceptarRegistroCliente.doClick();
      }
    }//GEN-LAST:event_jtfApellidoClienteKeyTyped

    private void jdcFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcFechaKeyTyped
         char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
             btnAceptarRegistroCliente.doClick();
      }
    }//GEN-LAST:event_jdcFechaKeyTyped

    private void jtfPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesoKeyTyped
          char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
             btnAceptarRegistroCliente.doClick();
      }
    }//GEN-LAST:event_jtfPesoKeyTyped

    private void jcbTiempoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTiempoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTiempoPagoActionPerformed

    private void jcbTiempoPagoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTiempoPagoItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            if(this.jcbTiempoPago.getSelectedIndex()>0)
            {
                this.jcbPagoPlan.setModel(new DefaultComboBoxModel
                (this.getTipoTiempo(this.jcbTiempoPago.getSelectedItem().toString())));
            }
        }
    }//GEN-LAST:event_jcbTiempoPagoItemStateChanged

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jtfBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarClienteActionPerformed

    private void jtfBuscarClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarClienteKeyPressed

        
    }//GEN-LAST:event_jtfBuscarClienteKeyPressed

    private void jtfBuscarClienteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfBuscarClienteCaretUpdate
        DefaultTableModel modeloTablaBuscarClientes = new DefaultTableModel(con.buscarCliente(jtfBuscarCliente.getText(), jtfBuscarCliente.getText()),columnasClientes);
    tablaClientes.setModel(modeloTablaBuscarClientes);
    }//GEN-LAST:event_jtfBuscarClienteCaretUpdate

    // Buscar pagos
    private void jtfbuscarpagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfbuscarpagoKeyPressed

        if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }

    }//GEN-LAST:event_jtfbuscarpagoKeyPressed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void jtfbuscarpagoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfbuscarpagoCaretUpdate
        // TODO add your handling code here:
        
        
    
        
        DefaultTableModel modeloTablaPagos = new DefaultTableModel(con.buscarPago(jtfbuscarpago.getText()), columnasPagos);
            tablaPagos.setModel(modeloTablaPagos);
            
            
        
        
    }//GEN-LAST:event_jtfbuscarpagoCaretUpdate

    private void tablaPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPagosMouseClicked
        // TODO add your handling code here:
        filaseleccionadatablapagos = tablaPagos.getSelectedRow();
     
      jcbClienteAPagar.setSelectedItem(tablaPagos.getValueAt(filaseleccionadatablapagos, 1));
      jtfMontoAPagar.setText(tablaPagos.getValueAt(filaseleccionadatablapagos, 2).toString());
      jtfTiempoAPagar.setText(tablaPagos.getValueAt(filaseleccionadatablapagos, 3).toString());
      jcbTiempoPago.setSelectedItem(tablaPagos.getValueAt(filaseleccionadatablapagos, 4));
      jcbPagoPlan.setSelectedItem(tablaPagos.getValueAt(filaseleccionadatablapagos, 5));

    }//GEN-LAST:event_tablaPagosMouseClicked

    private void jtfMontoAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMontoAPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMontoAPagarActionPerformed

    private void jtfMontoAPagarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMontoAPagarKeyPressed
        // TODO add your handling code here:
        if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jtfMontoAPagarKeyPressed

    private void jtfTiempoAPagarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTiempoAPagarKeyPressed
        // TODO add your handling code here:
        if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jtfTiempoAPagarKeyPressed

    private void txttotalingresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalingresosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalingresosActionPerformed

    private void txttotalgastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalgastosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalgastosActionPerformed

    private void jtfbuscarpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfbuscarpagoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jtfbuscarpagoActionPerformed

    private void jtfbuscarpagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfbuscarpagoKeyTyped
        // TODO add your handling code here:
        Character s = evt.getKeyChar();
        
        if(!Character.isLetter(s) && s != KeyEvent.VK_SPACE){
            evt.consume();   
        }
        
        
        int limit = 10;
        if (jtfbuscarpago.getText().length() == limit) {
            evt.consume();

        }
        
    }//GEN-LAST:event_jtfbuscarpagoKeyTyped

    private void tbingresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbingresosActionPerformed
        // TODO add your handling code here:
        
        PaneltablaUtilidad.setVisible(true);
        jScrollPane3.setVisible(true);
        Paneltotales.setVisible(true);
        jScrollPane4.setVisible(false);
           
        String dia = Integer.toString(jdcfechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(jdcfechaInicio.getCalendar().get(Calendar.MONTH)+1);
        String anio = Integer.toString(jdcfechaInicio.getCalendar().get(Calendar.YEAR));
        String fechaInicio = (anio+ "-" + mes + "-" + dia);
        
        String d = Integer.toString(jdcfechaFinal.getCalendar().get(Calendar.DAY_OF_MONTH));
        String m = Integer.toString(jdcfechaFinal.getCalendar().get(Calendar.MONTH)+1);
        String a = Integer.toString(jdcfechaFinal.getCalendar().get(Calendar.YEAR));
        String fechaFin = (a + "-" + m + "-" + d);
        
        
        modeloTablaIngresos = new DefaultTableModel(con.getIngresos( fechaInicio,fechaFin),columnasIngresos);
        tablautilidadingresos.setModel(modeloTablaIngresos);
        
        double totali = con.totalIngresos;
        String totalIngresoss = Double.toString(totali);
        txttotalingresos.setText(totalIngresoss);
        
        txttotalgastos.setText("");
        txtutilidad.setText("");
        
           
    }//GEN-LAST:event_tbingresosActionPerformed

    private void tbgastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbgastosActionPerformed
        // TODO add your handling code here:
        
        PaneltablaUtilidad.setVisible(true);
         jScrollPane3.setVisible(true);
         Paneltotales.setVisible(true);
         jScrollPane4.setVisible(false);
         
        String dia = Integer.toString(jdcfechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(jdcfechaInicio.getCalendar().get(Calendar.MONTH)+1);
        String anio = Integer.toString(jdcfechaInicio.getCalendar().get(Calendar.YEAR));
        String fechaInicio = (anio+ "-" + mes + "-" + dia);
        
        String d = Integer.toString(jdcfechaFinal.getCalendar().get(Calendar.DAY_OF_MONTH));
        String m = Integer.toString(jdcfechaFinal.getCalendar().get(Calendar.MONTH)+1);
        String a = Integer.toString(jdcfechaFinal.getCalendar().get(Calendar.YEAR));
        String fechaFin = (anio + "-" + m + "-" + d);
        
        
         modeloTablaGastos = new DefaultTableModel(con.getGastos( fechaInicio,fechaFin),columnasGastos);
         tablautilidadingresos.setModel(modeloTablaGastos);
        
        double totalg = con.totalGastos;
        String totalGastoss = Double.toString(totalg);
        txttotalgastos.setText(totalGastoss);
        
        txttotalingresos.setText("");
        txtutilidad.setText("");
        
    }//GEN-LAST:event_tbgastosActionPerformed

    private void tbtodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtodoActionPerformed
        // TODO add your handling code here:
        
      
        PaneltablaUtilidad.setVisible(true);
         jScrollPane3.setVisible(true);
         jScrollPane4.setVisible(true);
         Paneltotales.setVisible(true);
        
        String dia = Integer.toString(jdcfechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(jdcfechaInicio.getCalendar().get(Calendar.MONTH)+1);
        String anio = Integer.toString(jdcfechaInicio.getCalendar().get(Calendar.YEAR));
        String fechaInicio = (anio+ "-" + mes + "-" + dia);
        
        String d = Integer.toString(jdcfechaFinal.getCalendar().get(Calendar.DAY_OF_MONTH));
        String m = Integer.toString(jdcfechaFinal.getCalendar().get(Calendar.MONTH)+1);
        String a = Integer.toString(jdcfechaFinal.getCalendar().get(Calendar.YEAR));
        String fechaFin = (a + "-" + m + "-" + d);
        
        
        modeloTablaUtilidad = new DefaultTableModel(con.getIngresos(fechaInicio,fechaFin),columnasIngresos);
        tablautilidadingresos.setModel(modeloTablaUtilidad);
         
        modeloTablaUtilidad = new DefaultTableModel(con.getGastos(fechaInicio,fechaFin),columnasGastos);
        tablautilidadgastos.setModel(modeloTablaUtilidad);
         
        
        double totalu = con.totalIngresos - con.totalGastos;
        String totalUtilidad = Double.toString( totalu);
        txtutilidad.setText(totalUtilidad);
        
         double totalg = con.totalGastos;
        String totalGastoss = Double.toString(totalg);
        txttotalgastos.setText(totalGastoss);
        
        double totali = con.totalIngresos;
        String totalIngresoss = Double.toString(totali);
        txttotalingresos.setText(totalIngresoss);
             
    }//GEN-LAST:event_tbtodoActionPerformed

    public class PresionarTecla extends KeyAdapter {
      @Override
      public void keyPressed(KeyEvent ke) {
          if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
             btnAceptarRegistroCliente.doClick();
          }
      }
}
    
    public String[] getTipoTiempo(String tiempo) {
        String[] plan = new String[4];
        if (tiempo.equalsIgnoreCase("Mes")) {
            plan[0] = "Individual";
            plan[1] = "Pareja";
            plan[2] = "Grupo";
            plan[3] = "Estudiante";
        }
        return plan;	
    }
		 

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelClientes;
    private javax.swing.JPanel PanelConfiguracion;
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JPanel PanelInventario;
    private javax.swing.JPanel PanelPagos;
    private javax.swing.JPanel PanelTabla;
    private javax.swing.JPanel PanelTablaPagos;
    private javax.swing.JPanel PanelUtilidad;
    private javax.swing.JPanel Panelfecha;
    private javax.swing.JPanel PaneltablaUtilidad;
    private javax.swing.JPanel Paneltotales;
    private javax.swing.JButton btnAceptarInventario;
    private javax.swing.JButton btnAceptarRegistroCliente;
    private javax.swing.JButton btnCancelarInventario;
    private javax.swing.JButton btnCancelarRegistroCliente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbPagoAceptar;
    private javax.swing.JButton jbPagoCancelar;
    private javax.swing.JComboBox<String> jcbClienteAPagar;
    private javax.swing.JComboBox<String> jcbPagoPlan;
    private javax.swing.JComboBox<String> jcbTiempoPago;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private com.toedter.calendar.JDateChooser jdcfechaFinal;
    private com.toedter.calendar.JDateChooser jdcfechaInicio;
    private javax.swing.JLabel jlCantidadEquipo;
    private javax.swing.JLabel jlDescripcionEquipo;
    private javax.swing.JLabel jlMontoPagar;
    private javax.swing.JLabel jlNombreEquipo;
    private javax.swing.JLabel jlRegistroClientes;
    private javax.swing.JLabel jlRegistroClientes1;
    private javax.swing.JLabel jlTiempoPago;
    private javax.swing.JTextField jtfAltura;
    private javax.swing.JTextField jtfApellidoCliente;
    private javax.swing.JTextField jtfBuscarCliente;
    private javax.swing.JTextField jtfCantidadEquipo;
    private javax.swing.JLabel jtfClienteAPagar;
    private javax.swing.JTextField jtfMontoAPagar;
    private javax.swing.JTextField jtfNombreCliente;
    private javax.swing.JTextField jtfNombreEquipo;
    private javax.swing.JLabel jtfPagoTipodePlan;
    private javax.swing.JTextField jtfPeso;
    private javax.swing.JTextField jtfTiempoAPagar;
    private javax.swing.JTextField jtfbuscarpago;
    private javax.swing.JLabel labeltotalgastos;
    private javax.swing.JLabel labeltotalingresos;
    private javax.swing.JLabel labelutilidad;
    private javax.swing.JPanel panelDatosCliente;
    private javax.swing.JPanel panelDatosPago;
    private javax.swing.JScrollPane scrollTablaClientes;
    private java.awt.TextArea taDescripcionEquipo;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaInventarioEquipo;
    private javax.swing.JTable tablaPagos;
    private javax.swing.JTable tablautilidadgastos;
    private javax.swing.JTable tablautilidadingresos;
    private javax.swing.JToggleButton tbgastos;
    private javax.swing.JToggleButton tbingresos;
    private javax.swing.JToggleButton tbtodo;
    private javax.swing.JTextField txttotalgastos;
    private javax.swing.JTextField txttotalingresos;
    private javax.swing.JTextField txtutilidad;
    // End of variables declaration//GEN-END:variables
}
