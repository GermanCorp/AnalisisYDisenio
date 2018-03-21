package royal_gym;

import presentacion.PanelGastos;
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

/**
 *
 * @author alxcr
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    // variables
    Validaciones ValidarLetras = new Validaciones();
    Validaciones ValidarNumeros = new Validaciones();
    private final Conexion con;
    
<<<<<<< HEAD


    int  filaseleccionadatablapagos;
        // columnas de la tabla pagos
        private final String[] columnasPagos = {

=======
>>>>>>> 7c2798caca974fcdccfe6f493d2e1bf21ac105d5
    int filaseleccionadatablapagos;
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
        "Fecha de Nacimiento",
        "Altura",
        "Peso",
        "Masa Corporal",
        "Clasificación"
    };

    // columnas de la tabla Inventario
    private final String[] columnasInventario = {
        "N°",
        "Nombres",
        "Cantidad",
        "Descripción"
    };

    // columnas de la tabla Gastos
    private final String[] columnasGastos = {
        "N°",
        "Descripcion",
        "Monto",
        "Fecha"
    };

    // columnas de la tabla Cumpleaneros
    private final String[] columnasCumpleaneros = {
        "No.",
        "Nombre",
        "Fecha de Nacimiento",
        "Edad a Cumplir"
    };

    private final String[] columnasUtilidad = {
        "No.",
        "Fecha ",
        "Descripción ",
        "Monto"
    };

    private static DefaultTableCellRenderer tcr;

// Constructor
    public VentanaPrincipal() {
        initComponents();
        setTitle("Royal Gym");
        this.con = new Conexion();
        con.conectar();
        jdcFechaGasto.setEnabled(false);
        
        PanelRegistroPagos panelPagos = new PanelRegistroPagos();
        PanelRegistroClientes panelClientes = new PanelRegistroClientes();
        
        jScrollPane5.setVisible(false);
        jScrollPane6.setVisible(false);
        PaneltablaUtilidad.setVisible(false);
        Paneltotales.setVisible(false);
        
        PanelGastos panelG = new PanelGastos();
        jTabbedPane1.add("Gastos", panelG);

        // alinear columnas a la derecha
        tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT); //CENTER o LEFT        

        //llenar combobox
        ArrayList<String> lista = new ArrayList<String>();
        lista = con.llenarCombo();
        for (int i = 0; i < lista.size(); i++) {
            jcbClienteAPagar.addItem(lista.get(i));
        }

        // Modelo de la tabla de Pagos
        DefaultTableModel modeloTablaPagos = new DefaultTableModel(con.getPago(), columnasPagos);
        tablaPagos.setModel(modeloTablaPagos);

        // Modelo de la tabla de Clientes
        DefaultTableModel modeloTablaClientes = new DefaultTableModel(con.getCliente(), columnasClientes);
        tablaClientes.setModel(modeloTablaClientes);
        int aligTablaClientes[] = {3, 4, 5, 6};
        alinearColumnaDerecha(tablaClientes, aligTablaClientes);

        // Modelo de la tabla de Inventario
        DefaultTableModel modeloTablaInventario = new DefaultTableModel(con.getInventario(), columnasInventario);
        tablaInventarioEquipo.setModel(modeloTablaInventario);

        // Modelo de la tabla de cumpleaneros
        DefaultTableModel modeloTablaCumpleaneros = new DefaultTableModel(con.getEdadClientes(), columnasCumpleaneros);
        tablaDeCumpleaneros.setModel(modeloTablaCumpleaneros);

        // Modelo de la tabla de Gastos
        DefaultTableModel modeloTablaGastos = new DefaultTableModel(con.getGasto(), columnasGastos);
        tablaGastos.setModel(modeloTablaGastos);
        int aligTablaGastos[] = {2, 3};
        alinearColumnaDerecha(tablaGastos, aligTablaGastos);
    }

    // obtienene la hora actual del sistema
    public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format(ahora);
    }

    // metodo para cambiar el acho de columnas
    private void setAnchoColumna(int[] ancho) {
        int x = tablaClientes.getColumnCount() - 1;
        int tamanio = tablaClientes.getWidth();
        for (int i = 0; i <= x; i++) {
            TableColumn columnas = tablaClientes.getColumnModel().getColumn(i);
            columnas.setPreferredWidth(ancho[i]);
        }
    }

    // método para alinear las columnas a la derecha
    private void alinearColumnaDerecha(JTable tabla, int[] columnas) {
        tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        for (int i = 0; i < columnas.length; i++) {
            tabla.getColumnModel().getColumn(columnas[i]).setCellRenderer(tcr);
        }
    }

        // método para obtener la fecha desde el jcalendar
    private Date fechaJCalendar(JDateChooser calendario) {
        Date date = calendario.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        return fecha;
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
        jtfSelccionarCliente = new javax.swing.JTextField();
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
        tablaPagos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jLabel16 = new javax.swing.JLabel();
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
        tablaClientes = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jtfBuscarCliente = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        PanelInventario = new javax.swing.JPanel();
        PanelDatos = new javax.swing.JPanel();
        jlNombreEquipo = new javax.swing.JLabel();
        jtfNombreEquipo = new javax.swing.JTextField();
        jlCantidadEquipo = new javax.swing.JLabel();
        jtfCantidadEquipo = new javax.swing.JTextField();
        jlDescripcionEquipo = new javax.swing.JLabel();
        btnAceptarInventario = new javax.swing.JButton();
        btnCancelarInventario = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taDescripcionEquipo = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventarioEquipo = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jLabel15 = new javax.swing.JLabel();
        jtfBuscarInventario = new javax.swing.JTextField();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        panelGastos = new javax.swing.JPanel();
        panelDatosGasto = new javax.swing.JPanel();
        btnCancelarRegistroGasto = new javax.swing.JButton();
        jlDescripcionGAsto = new javax.swing.JLabel();
        jlmontoGasto = new javax.swing.JLabel();
        jlFechaGasto = new javax.swing.JLabel();
        jtfDescripcionGasto = new javax.swing.JTextField();
        jtfMontoGasto = new javax.swing.JTextField();
        btnAceptarRegistroGasto = new javax.swing.JButton();
        jdcFechaGasto = new com.toedter.calendar.JDateChooser();
        jlIconoGasto = new javax.swing.JLabel();
        jcbPersonalizarFechaGasto = new javax.swing.JCheckBox();
        PanelTablaGastos = new javax.swing.JPanel();
        scrollTablaClientes1 = new javax.swing.JScrollPane();
        tablaGastos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jtfBuscarGasto = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        panelCumpleaneros = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDeCumpleaneros = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        PanelUtilidad = new javax.swing.JPanel();
        Panelfecha = new javax.swing.JPanel();
        jdcfechaInicio = new com.toedter.calendar.JDateChooser();
        jdcfechaFinal = new com.toedter.calendar.JDateChooser();
        tbingresos = new javax.swing.JToggleButton();
        tbgastos = new javax.swing.JToggleButton();
        tbtodo = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        PaneltablaUtilidad = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablautilidadingresos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jScrollPane6 = new javax.swing.JScrollPane();
        tablautilidadgastos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        Paneltotales = new javax.swing.JPanel();
        labeltotalingresos = new javax.swing.JLabel();
        labeltotalgastos = new javax.swing.JLabel();
        labelutilidad = new javax.swing.JLabel();
        jlTotalIngresos = new javax.swing.JLabel();
        jlTotalUtilidad = new javax.swing.JLabel();
        jlTotalGastos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelRegistroClientes1 = new presentacion.PanelRegistroClientes();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        PanelPagos.setBackground(new java.awt.Color(85, 96, 128));

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

        jtfSelccionarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfSelccionarClienteMouseClicked(evt);
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
                        .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(20, 20, 20)
                                .addComponent(jlRegistroClientes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfPagoTipodePlan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                                .addComponent(jtfClienteAPagar)
                                .addGap(18, 18, 18)
                                .addComponent(jcbClienteAPagar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(22, 22, 22))
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
                                    .addComponent(jbPagoCancelar))
                                .addComponent(jlMontoPagar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                                .addComponent(jtfTiempoAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jcbTiempoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfSelccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 18, Short.MAX_VALUE))))
        );
        panelDatosPagoLayout.setVerticalGroup(
            panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlRegistroClientes1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosPagoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jtfClienteAPagar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosPagoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbClienteAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jtfSelccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlMontoPagar)
                .addGap(3, 3, 3)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbPagoAceptar)
                    .addComponent(jbPagoCancelar))
                .addContainerGap(19, Short.MAX_VALUE))
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

        tablaPagos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Buscar.png"))); // NOI18N

        javax.swing.GroupLayout PanelTablaPagosLayout = new javax.swing.GroupLayout(PanelTablaPagos);
        PanelTablaPagos.setLayout(PanelTablaPagosLayout);
        PanelTablaPagosLayout.setHorizontalGroup(
            PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaPagosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                    .addGroup(PanelTablaPagosLayout.createSequentialGroup()
                        .addComponent(jtfbuscarpago, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel16)))
                .addGap(20, 20, 20))
        );
        PanelTablaPagosLayout.setVerticalGroup(
            PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaPagosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfbuscarpago, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout PanelPagosLayout = new javax.swing.GroupLayout(PanelPagos);
        PanelPagos.setLayout(PanelPagosLayout);
        PanelPagosLayout.setHorizontalGroup(
            PanelPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPagosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelDatosPago, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelTablaPagos, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        PanelPagosLayout.setVerticalGroup(
            PanelPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPagosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosPago, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addComponent(PanelTablaPagos, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("<html> <center>Registro<center> <center>Pagos<center>", new javax.swing.ImageIcon(getClass().getResource("/iconos/RegistrarPago_3.png")), PanelPagos); // NOI18N

        PanelClientes.setBackground(new java.awt.Color(85, 96, 128));
        PanelClientes.setPreferredSize(new java.awt.Dimension(1257, 500));

        panelDatosCliente.setBackground(new java.awt.Color(85, 96, 128));
        panelDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
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
                .addGap(18, 43, Short.MAX_VALUE)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarRegistroCliente)
                    .addComponent(btnCancelarRegistroCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTabla.setBackground(new java.awt.Color(85, 96, 128));
        PanelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Clientes Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        tablaClientes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
                    .addGroup(PanelTablaLayout.createSequentialGroup()
                        .addComponent(jtfBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14))
                    .addComponent(scrollTablaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        PanelTablaLayout.setVerticalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfBuscarCliente)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTablaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout PanelClientesLayout = new javax.swing.GroupLayout(PanelClientes);
        PanelClientes.setLayout(PanelClientesLayout);
        PanelClientesLayout.setHorizontalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(PanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
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

        taDescripcionEquipo.setColumns(20);
        taDescripcionEquipo.setRows(5);
        jScrollPane4.setViewportView(taDescripcionEquipo);

        javax.swing.GroupLayout PanelDatosLayout = new javax.swing.GroupLayout(PanelDatos);
        PanelDatos.setLayout(PanelDatosLayout);
        PanelDatosLayout.setHorizontalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlCantidadEquipo)
                    .addComponent(jlDescripcionEquipo)
                    .addComponent(jlNombreEquipo)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfNombreEquipo)
                    .addComponent(jtfCantidadEquipo)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addComponent(btnAceptarInventario)
                        .addGap(66, 66, 66)
                        .addComponent(btnCancelarInventario))
                    .addComponent(jScrollPane4))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarInventario)
                    .addComponent(btnCancelarInventario))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jtfNombreEquipo.getAccessibleContext().setAccessibleParent(jlNombreEquipo);
        jLabel10.getAccessibleContext().setAccessibleName("<html>\n<center>Inventario de<center>\n <center> Equipo<center>");

        jPanel4.setBackground(new java.awt.Color(85, 96, 126));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Inventario Registrado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N

        tablaInventarioEquipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        tablaInventarioEquipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaInventarioEquipoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tablaInventarioEquipoFocusLost(evt);
            }
        });
        tablaInventarioEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaInventarioEquipoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaInventarioEquipo);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Buscar.png"))); // NOI18N

        jtfBuscarInventario.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfBuscarInventarioCaretUpdate(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jtfBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addGap(84, 84, 84)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout PanelInventarioLayout = new javax.swing.GroupLayout(PanelInventario);
        PanelInventario.setLayout(PanelInventarioLayout);
        PanelInventarioLayout.setHorizontalGroup(
            PanelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInventarioLayout.createSequentialGroup()
                .addComponent(PanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        PanelInventarioLayout.setVerticalGroup(
            PanelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelInventarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("<html>\n<center>Inventario de<center>\n<center>Maquinaria<center>", new javax.swing.ImageIcon(getClass().getResource("/iconos/Inventario_2.png")), PanelInventario); // NOI18N

        panelGastos.setBackground(new java.awt.Color(85, 96, 128));

        panelDatosGasto.setBackground(new java.awt.Color(85, 96, 128));
        panelDatosGasto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Registro de Gastos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        panelDatosGasto.setToolTipText("");
        panelDatosGasto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelDatosGastoFocusGained(evt);
            }
        });

        btnCancelarRegistroGasto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cancelar.png"))); // NOI18N
        btnCancelarRegistroGasto.setText("Cancelar");
        btnCancelarRegistroGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRegistroGastoActionPerformed(evt);
            }
        });

        jlDescripcionGAsto.setBackground(new java.awt.Color(255, 255, 255));
        jlDescripcionGAsto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlDescripcionGAsto.setForeground(new java.awt.Color(255, 255, 255));
        jlDescripcionGAsto.setText("Descripción:");

        jlmontoGasto.setBackground(new java.awt.Color(255, 255, 255));
        jlmontoGasto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlmontoGasto.setForeground(new java.awt.Color(255, 255, 255));
        jlmontoGasto.setText("Monto:");

        jlFechaGasto.setBackground(new java.awt.Color(255, 255, 255));
        jlFechaGasto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlFechaGasto.setForeground(new java.awt.Color(255, 255, 255));
        jlFechaGasto.setText("Fecha:");

        jtfDescripcionGasto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfDescripcionGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescripcionGastoActionPerformed(evt);
            }
        });
        jtfDescripcionGasto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDescripcionGastoKeyTyped(evt);
            }
        });

        jtfMontoGasto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfMontoGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMontoGastoActionPerformed(evt);
            }
        });
        jtfMontoGasto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMontoGastoKeyTyped(evt);
            }
        });

        btnAceptarRegistroGasto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Aceptar.png"))); // NOI18N
        btnAceptarRegistroGasto.setText("Aceptar");
        btnAceptarRegistroGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarRegistroGastoActionPerformed(evt);
            }
        });
        btnAceptarRegistroGasto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAceptarRegistroGastoKeyPressed(evt);
            }
        });

        jdcFechaGasto.setDateFormatString("dd-MM-yyyy");
        jdcFechaGasto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jdcFechaGasto.setInheritsPopupMenu(true);
        jdcFechaGasto.setPreferredSize(new java.awt.Dimension(100, 100));
        jdcFechaGasto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jdcFechaGastoKeyTyped(evt);
            }
        });

        jlIconoGasto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Gasto.png"))); // NOI18N

        jcbPersonalizarFechaGasto.setBackground(new java.awt.Color(85, 96, 128));
        jcbPersonalizarFechaGasto.setForeground(new java.awt.Color(255, 255, 255));
        jcbPersonalizarFechaGasto.setText("Personalizar");
        jcbPersonalizarFechaGasto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbPersonalizarFechaGastoItemStateChanged(evt);
            }
        });
        jcbPersonalizarFechaGasto.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jcbPersonalizarFechaGastoStateChanged(evt);
            }
        });
        jcbPersonalizarFechaGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPersonalizarFechaGastoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosGastoLayout = new javax.swing.GroupLayout(panelDatosGasto);
        panelDatosGasto.setLayout(panelDatosGastoLayout);
        panelDatosGastoLayout.setHorizontalGroup(
            panelDatosGastoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosGastoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelDatosGastoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfDescripcionGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlmontoGasto)
                    .addComponent(jtfMontoGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlFechaGasto)
                    .addGroup(panelDatosGastoLayout.createSequentialGroup()
                        .addComponent(btnAceptarRegistroGasto)
                        .addGap(65, 65, 65)
                        .addComponent(btnCancelarRegistroGasto))
                    .addComponent(jlDescripcionGAsto)
                    .addGroup(panelDatosGastoLayout.createSequentialGroup()
                        .addComponent(jdcFechaGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbPersonalizarFechaGasto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosGastoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlIconoGasto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosGastoLayout.setVerticalGroup(
            panelDatosGastoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosGastoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlIconoGasto)
                .addGap(31, 31, 31)
                .addComponent(jlDescripcionGAsto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jtfDescripcionGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jlmontoGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jtfMontoGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jlFechaGasto)
                .addGap(0, 0, 0)
                .addGroup(panelDatosGastoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbPersonalizarFechaGasto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcFechaGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(panelDatosGastoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarRegistroGasto)
                    .addComponent(btnCancelarRegistroGasto))
                .addGap(13, 13, 13))
        );

        jdcFechaGasto.getAccessibleContext().setAccessibleName("");

        PanelTablaGastos.setBackground(new java.awt.Color(85, 96, 128));
        PanelTablaGastos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Gastos Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        tablaGastos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaGastos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaGastos.setAutoscrolls(true);
        tablaGastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaGastosMouseClicked(evt);
            }
        });
        scrollTablaClientes1.setViewportView(tablaGastos);

        jtfBuscarGasto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfBuscarGasto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfBuscarGastoCaretUpdate(evt);
            }
        });
        jtfBuscarGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarGastoActionPerformed(evt);
            }
        });
        jtfBuscarGasto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfBuscarGastoKeyPressed(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Buscar.png"))); // NOI18N

        javax.swing.GroupLayout PanelTablaGastosLayout = new javax.swing.GroupLayout(PanelTablaGastos);
        PanelTablaGastos.setLayout(PanelTablaGastosLayout);
        PanelTablaGastosLayout.setHorizontalGroup(
            PanelTablaGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaGastosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTablaGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTablaGastosLayout.createSequentialGroup()
                        .addComponent(jtfBuscarGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18))
                    .addComponent(scrollTablaClientes1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        PanelTablaGastosLayout.setVerticalGroup(
            PanelTablaGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaGastosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTablaGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfBuscarGasto)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTablaClientes1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout panelGastosLayout = new javax.swing.GroupLayout(panelGastos);
        panelGastos.setLayout(panelGastosLayout);
        panelGastosLayout.setHorizontalGroup(
            panelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGastosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelDatosGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(PanelTablaGastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        panelGastosLayout.setVerticalGroup(
            panelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGastosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelTablaGastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDatosGasto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Gastos", new javax.swing.ImageIcon(getClass().getResource("/iconos/Registro_Gasto.png")), panelGastos); // NOI18N

        panelCumpleaneros.setBackground(new java.awt.Color(85, 96, 128));

        jPanel6.setBackground(new java.awt.Color(85, 96, 128));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Cumpleaneros Del Mes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        tablaDeCumpleaneros.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaDeCumpleaneros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablaDeCumpleaneros);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout panelCumpleanerosLayout = new javax.swing.GroupLayout(panelCumpleaneros);
        panelCumpleaneros.setLayout(panelCumpleanerosLayout);
        panelCumpleanerosLayout.setHorizontalGroup(
            panelCumpleanerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCumpleanerosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        panelCumpleanerosLayout.setVerticalGroup(
            panelCumpleanerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCumpleanerosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cumpleañeros", new javax.swing.ImageIcon(getClass().getResource("/iconos/Cumpleaneros.png")), panelCumpleaneros); // NOI18N

        PanelUtilidad.setBackground(new java.awt.Color(85, 96, 128));

        Panelfecha.setBackground(new java.awt.Color(85, 96, 128));
        Panelfecha.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Rangos De Fecha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jdcfechaInicio.setDateFormatString("yyyy-MM-dd");

        jdcfechaFinal.setDateFormatString("yyyy-MM-dd");

        buttonGroup1.add(tbingresos);
        tbingresos.setText("Ingresos");
        tbingresos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbingresos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tbingresosItemStateChanged(evt);
            }
        });
        tbingresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbingresosActionPerformed(evt);
            }
        });

        buttonGroup1.add(tbgastos);
        tbgastos.setText("Gastos");
        tbgastos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tbgastosItemStateChanged(evt);
            }
        });
        tbgastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbgastosActionPerformed(evt);
            }
        });

        buttonGroup1.add(tbtodo);
        tbtodo.setText("Ingresso y Gastos");
        tbtodo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tbtodoItemStateChanged(evt);
            }
        });
        tbtodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtodoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Desde:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Hasta:");

        javax.swing.GroupLayout PanelfechaLayout = new javax.swing.GroupLayout(Panelfecha);
        Panelfecha.setLayout(PanelfechaLayout);
        PanelfechaLayout.setHorizontalGroup(
            PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelfechaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelfechaLayout.createSequentialGroup()
                        .addComponent(tbingresos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(tbgastos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbtodo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelfechaLayout.createSequentialGroup()
                        .addGroup(PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcfechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jdcfechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        PanelfechaLayout.setVerticalGroup(
            PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelfechaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdcfechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcfechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(PanelfechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbgastos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbingresos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbtodo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        PaneltablaUtilidad.setBackground(new java.awt.Color(85, 96, 128));
        PaneltablaUtilidad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Ingresos y Gastos Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        tablautilidadingresos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablautilidadingresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tablautilidadingresos);

        tablautilidadgastos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablautilidadgastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tablautilidadgastos);

        javax.swing.GroupLayout PaneltablaUtilidadLayout = new javax.swing.GroupLayout(PaneltablaUtilidad);
        PaneltablaUtilidad.setLayout(PaneltablaUtilidadLayout);
        PaneltablaUtilidadLayout.setHorizontalGroup(
            PaneltablaUtilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneltablaUtilidadLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        PaneltablaUtilidadLayout.setVerticalGroup(
            PaneltablaUtilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneltablaUtilidadLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PaneltablaUtilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addGap(20, 20, 20))
        );

        Paneltotales.setBackground(new java.awt.Color(85, 96, 128));
        Paneltotales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        labeltotalingresos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labeltotalingresos.setForeground(new java.awt.Color(255, 255, 255));
        labeltotalingresos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labeltotalingresos.setText("Total Ingresos:");

        labeltotalgastos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labeltotalgastos.setForeground(new java.awt.Color(255, 255, 255));
        labeltotalgastos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labeltotalgastos.setText("Total Gastos:");

        labelutilidad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelutilidad.setForeground(new java.awt.Color(255, 255, 255));
        labelutilidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelutilidad.setText("Utilidad:");

        jlTotalIngresos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlTotalIngresos.setForeground(new java.awt.Color(255, 255, 255));
        jlTotalIngresos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlTotalIngresos.setText("L. 0.00");

        jlTotalUtilidad.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlTotalUtilidad.setForeground(new java.awt.Color(255, 255, 255));
        jlTotalUtilidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlTotalUtilidad.setText("L. 0.00");

        jlTotalGastos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlTotalGastos.setForeground(new java.awt.Color(255, 255, 255));
        jlTotalGastos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlTotalGastos.setText("L. 0.00");

        javax.swing.GroupLayout PaneltotalesLayout = new javax.swing.GroupLayout(Paneltotales);
        Paneltotales.setLayout(PaneltotalesLayout);
        PaneltotalesLayout.setHorizontalGroup(
            PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneltotalesLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labeltotalgastos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labeltotalingresos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelutilidad, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(61, 61, 61)
                .addGroup(PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(jlTotalUtilidad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlTotalGastos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlTotalIngresos, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18))
        );
        PaneltotalesLayout.setVerticalGroup(
            PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneltotalesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labeltotalingresos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlTotalIngresos, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(15, 15, 15)
                .addGroup(PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labeltotalgastos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlTotalGastos, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(PaneltotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelutilidad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlTotalUtilidad, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout PanelUtilidadLayout = new javax.swing.GroupLayout(PanelUtilidad);
        PanelUtilidad.setLayout(PanelUtilidadLayout);
        PanelUtilidadLayout.setHorizontalGroup(
            PanelUtilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUtilidadLayout.createSequentialGroup()
                .addGroup(PanelUtilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelUtilidadLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Panelfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelUtilidadLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Paneltotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(PaneltablaUtilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        PanelUtilidadLayout.setVerticalGroup(
            PanelUtilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUtilidadLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelUtilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelUtilidadLayout.createSequentialGroup()
                        .addComponent(Panelfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Paneltotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PaneltablaUtilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Utilidad", new javax.swing.ImageIcon(getClass().getResource("/iconos/Utilidad.png")), PanelUtilidad); // NOI18N
        jTabbedPane1.addTab("<html> <center>Registro<center> <center>Clientes<center>", new javax.swing.ImageIcon(getClass().getResource("/iconos/AgregarNuevo_2.png")), panelRegistroClientes1); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Aceptar.png"))); // NOI18N
        jMenu1.setText("Archivo");

        jMenuItem1.setText("Cerrar Sesión");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Salir");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Configuración");
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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Registrar Pago");

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

            DefaultTableModel modeloTablaInventario = new DefaultTableModel(con.getInventario(), columnasInventario);
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

<<<<<<< HEAD
<<<<<<< HEAD
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

    private void jcbPagoPlanActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jbPagoAceptarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        Calendar c;
        c = Calendar.getInstance();
        int d = c.get(Calendar.DATE), m = 1 + (c.get(Calendar.MONTH)), a = c.get(Calendar.YEAR);

        String dia = Integer.toString(d);
        String mes = Integer.toString(m);
        String anio = Integer.toString(a);
        String fecha = (dia + "-" + mes + "-" + anio);

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

    }                                             

=======
>>>>>>> German
=======
>>>>>>> 7c2798caca974fcdccfe6f493d2e1bf21ac105d5
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

<<<<<<< HEAD
<<<<<<< HEAD
    private void jbPagoCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        jcbClienteAPagar.setSelectedIndex(0);
        jtfMontoAPagar.setText("");
        jtfTiempoAPagar.setText("");
        jcbTiempoPago.setSelectedIndex(0);
        jcbPagoPlan.setSelectedIndex(0);
    }                                              

    private void jcbClienteAPagarActionPerformed(java.awt.event.ActionEvent evt) {                                                 
            // TODO add your handling code here:
    }                                                

    private void jcbClienteAPagarMouseClicked(java.awt.event.MouseEvent evt) {                                              
        jcbClienteAPagar.removeAllItems();
        ArrayList<String> lista =new ArrayList<String>();
            lista =  con.llenarCombo();
            for(int i = 0; i<lista.size(); i++){
                jcbClienteAPagar.addItem(lista.get(i));
            }
    }                                             

=======
>>>>>>> German
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

<<<<<<< HEAD
    private void jtfTiempoAPagarActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jtfTiempoAPagarKeyTyped(java.awt.event.KeyEvent evt) {                                         
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
        
        else
            if((int)evt.getKeyChar()>=32 && (int)evt.getKeyChar()<=47 ||
               (int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64 ||
               (int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=255)
            {
                getToolkit().beep();
                evt.consume();
            }
               jtfTiempoAPagar.setCursor(null);
    }                                        

=======
>>>>>>> German
=======
>>>>>>> 7c2798caca974fcdccfe6f493d2e1bf21ac105d5
    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1FocusGained

<<<<<<< HEAD
<<<<<<< HEAD
    private void jtfMontoAPagarKeyTyped(java.awt.event.KeyEvent evt) {                                        
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
        
        else
            if((int)evt.getKeyChar()>=32 && (int)evt.getKeyChar()<=47 ||
               (int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64 ||
               (int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=255)
            {
                getToolkit().beep();
                evt.consume();
            }
               jtfMontoAPagar.setCursor(null);        
    }                                       

=======
>>>>>>> German
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

<<<<<<< HEAD
    private void jcbTiempoPagoActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jcbTiempoPagoItemStateChanged(java.awt.event.ItemEvent evt) {                                               
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            if(this.jcbTiempoPago.getSelectedIndex()>0)
            {
                this.jcbPagoPlan.setModel(new DefaultComboBoxModel
                (this.getTipoTiempo(this.jcbTiempoPago.getSelectedItem().toString())));
            }
        }
    }                                              

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

=======
>>>>>>> German
    private void jtfBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarClienteActionPerformed

    private void jtfBuscarClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarClienteKeyPressed

        
    }//GEN-LAST:event_jtfBuscarClienteKeyPressed

    private void jtfBuscarClienteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfBuscarClienteCaretUpdate
        DefaultTableModel modeloTablaBuscarClientes = new DefaultTableModel(con.buscarCliente(jtfBuscarCliente.getText(), jtfBuscarCliente.getText()),columnasClientes);
    tablaClientes.setModel(modeloTablaBuscarClientes);
    }//GEN-LAST:event_jtfBuscarClienteCaretUpdate

<<<<<<< HEAD
    private void tablaPagosMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
       filaseleccionadatablapagos = tablaPagos.getSelectedRow();
     
      jcbClienteAPagar.setSelectedItem(tablaPagos.getValueAt(filaseleccionadatablapagos, 0));
      jtfMontoAPagar.setText(tablaPagos.getValueAt(filaseleccionadatablapagos, 1).toString());
      jtfTiempoAPagar.setText(tablaPagos.getValueAt(filaseleccionadatablapagos, 2).toString());
      jcbTiempoPago.setSelectedItem(tablaPagos.getValueAt(filaseleccionadatablapagos, 3));
      jcbPagoPlan.setSelectedItem(tablaPagos.getValueAt(filaseleccionadatablapagos, 4));
      
    }                                       

    // Buscar pagos
    private void jtfbuscarpagoKeyPressed(java.awt.event.KeyEvent evt) {                                         
        // TODO add your handling code here:
        if (jtfbuscarpago.getText().isEmpty()) { //si el filtro esta vacio
            DefaultTableModel modeloTablaPagos = new DefaultTableModel(con.getPago(), columnasPagos);
            tablaPagos.setModel(modeloTablaPagos);
        } else {
            //String idt = filtro.getText();
            DefaultTableModel modeloTablaPagos = new DefaultTableModel(con.getNombreCliente(jtfbuscarpago.getText()), columnasPagos);
            tablaPagos.setModel(modeloTablaPagos);
        }
    }                                        

=======
>>>>>>> German
    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        
    }//GEN-LAST:event_tablaClientesMouseClicked

=======
>>>>>>> 7c2798caca974fcdccfe6f493d2e1bf21ac105d5
    private void btnCancelarRegistroGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRegistroGastoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarRegistroGastoActionPerformed

    private void jtfDescripcionGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescripcionGastoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescripcionGastoActionPerformed

    private void jtfDescripcionGastoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescripcionGastoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescripcionGastoKeyTyped

    private void jtfMontoGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMontoGastoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMontoGastoActionPerformed

    private void jtfMontoGastoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMontoGastoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMontoGastoKeyTyped

    private void btnAceptarRegistroGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarRegistroGastoActionPerformed

        if (jtfDescripcionGasto.getText().isEmpty()
                && jtfMontoGasto.getText().isEmpty()
                && jdcFecha.getDate() == null) {
            JOptionPane.showMessageDialog(this, "ingrese Toda la Información", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfDescripcionGasto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar la descripcion del gasto", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfMontoGasto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el monto gastado", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jcbPersonalizarFechaGasto.isSelected()) {
            if (jdcFechaGasto.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Seleccione una fecha", "Error!", JOptionPane.ERROR_MESSAGE);
            } else {
                con.insertarGasto(jtfDescripcionGasto.getText(),
                        jtfMontoGasto.getText(),
                        fechaJCalendar(jdcFechaGasto).toString());

                jtfDescripcionGasto.setText("");
                jtfMontoGasto.setText("");
                jdcFechaGasto.setDate(null);
                jcbPersonalizarFechaGasto.setSelected(false);

                DefaultTableModel modeloTablaGastos = new DefaultTableModel(con.getGasto(), columnasGastos);
                tablaGastos.setModel(modeloTablaGastos);
                int aligTablaGastos[] = {2, 3};
                alinearColumnaDerecha(tablaGastos, aligTablaGastos);
                JOptionPane.showMessageDialog(this, "Registro Exitoso", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            con.insertarGasto(
                    jtfDescripcionGasto.getText(),
                    jtfMontoGasto.getText(),
                    getFechaActual());

            jtfDescripcionGasto.setText("");
            jtfMontoGasto.setText("");
            jdcFecha.setDate(null);

            DefaultTableModel modeloTablaGastos = new DefaultTableModel(con.getGasto(), columnasGastos);
            tablaGastos.setModel(modeloTablaGastos);
            int aligTablaGastos[] = {2, 3};
            alinearColumnaDerecha(tablaGastos, aligTablaGastos);
            JOptionPane.showMessageDialog(this, "Registro Exitoso", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarRegistroGastoActionPerformed

    private void btnAceptarRegistroGastoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarRegistroGastoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarRegistroGastoKeyPressed

    private void jdcFechaGastoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcFechaGastoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jdcFechaGastoKeyTyped

    private void panelDatosGastoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelDatosGastoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_panelDatosGastoFocusGained

    private void jcbPersonalizarFechaGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPersonalizarFechaGastoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbPersonalizarFechaGastoActionPerformed

    private void tablaGastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGastosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaGastosMouseClicked

    private void jtfBuscarGastoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfBuscarGastoCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarGastoCaretUpdate

    private void jtfBuscarGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarGastoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarGastoActionPerformed

    private void jtfBuscarGastoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarGastoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarGastoKeyPressed

    private void jcbPersonalizarFechaGastoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jcbPersonalizarFechaGastoStateChanged

    }//GEN-LAST:event_jcbPersonalizarFechaGastoStateChanged

    private void jcbPersonalizarFechaGastoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbPersonalizarFechaGastoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            jdcFechaGasto.setEnabled(true);
        } else {
            jdcFechaGasto.setEnabled(false);
        }
    }//GEN-LAST:event_jcbPersonalizarFechaGastoItemStateChanged

    private void tablaInventarioEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaInventarioEquipoMouseClicked
        // TODO add your handling code here:
        int filaseleccionada = tablaInventarioEquipo.getSelectedRow();
        jtfNombreEquipo.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 1).toString());
        jtfCantidadEquipo.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 2).toString());
        taDescripcionEquipo.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 3).toString());
    }//GEN-LAST:event_tablaInventarioEquipoMouseClicked

    private void jtfBuscarInventarioCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfBuscarInventarioCaretUpdate
        // TODO add your handling code here:
        DefaultTableModel modeloTablaBuscarInventario = new DefaultTableModel(con.buscarInventario(jtfBuscarInventario.getText()), columnasInventario);
        tablaInventarioEquipo.setModel(modeloTablaBuscarInventario);
    }//GEN-LAST:event_jtfBuscarInventarioCaretUpdate

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        // TODO add your handling code here:
        int filaSelect = tablaInventarioEquipo.getSelectedRow();

        if (filaSelect == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un articulo", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            con.ModificarInventario(jtfNombreEquipo.getText(), jtfCantidadEquipo.getText(), taDescripcionEquipo.getText(), jtfNombreEquipo.getText());
            DefaultTableModel modeloTablaInventario = new DefaultTableModel(con.getInventario(), columnasInventario);
            tablaInventarioEquipo.setModel(modeloTablaInventario);
            jtfNombreEquipo.setText("");
            jtfCantidadEquipo.setText("");
            taDescripcionEquipo.setText("");
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
        int r = tablaInventarioEquipo.getSelectedRow();

        if (r == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            String nombremaquina = tablaInventarioEquipo.getValueAt(r, 1).toString();
            con.eliminarInventario(nombremaquina);
            DefaultTableModel modeloTablaInventario = new DefaultTableModel(con.getInventario(), columnasInventario);
            tablaInventarioEquipo.setModel(modeloTablaInventario);

        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void tbingresosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tbingresosItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            PaneltablaUtilidad.setVisible(true);
            jScrollPane5.setVisible(true);
            Paneltotales.setVisible(true);
            TitledBorder t = (TitledBorder )PaneltablaUtilidad.getBorder();
            t.setTitle("Ingresos");

            DefaultTableModel modeloTablaUtilidadIngresos = new DefaultTableModel(con.getIngresosSeleccinados(fechaJCalendar(jdcfechaInicio).toString(), fechaJCalendar(jdcfechaFinal).toString()), columnasUtilidad);
            tablautilidadingresos.setModel(modeloTablaUtilidadIngresos);

            double totali = con.totalIngresos;
            jlTotalIngresos.setText("L. "+con.formatearNumero(totali));
            jlTotalGastos.setText("L. 0.00");
            jlTotalUtilidad.setText("L. 0.00");

        } else {
            PaneltablaUtilidad.setVisible(false);
            jScrollPane5.setVisible(false);
            Paneltotales.setVisible(false);

        }

    }//GEN-LAST:event_tbingresosItemStateChanged

    private void tbingresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbingresosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbingresosActionPerformed

    private void tbgastosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tbgastosItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            PaneltablaUtilidad.setVisible(true);
            jScrollPane5.setVisible(true);
            Paneltotales.setVisible(true);
            TitledBorder t = (TitledBorder )PaneltablaUtilidad.getBorder();
            t.setTitle("Gastos");

            DefaultTableModel modeloTablaUtilidadGastos = new DefaultTableModel(con.getGastosSeleccionados(fechaJCalendar(jdcfechaInicio).toString(), fechaJCalendar(jdcfechaFinal).toString()), columnasUtilidad);
            tablautilidadingresos.setModel(modeloTablaUtilidadGastos);

           double totalg = con.totalGastos;
            jlTotalGastos.setText("L. "+con.formatearNumero(totalg));
            jlTotalIngresos.setText("L. 0.00");
            jlTotalUtilidad.setText("L. 0.00");

        } else {
            PaneltablaUtilidad.setVisible(false);
            jScrollPane5.setVisible(false);
            Paneltotales.setVisible(false);

        }
    }//GEN-LAST:event_tbgastosItemStateChanged

    private void tbgastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbgastosActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_tbgastosActionPerformed

    private void tbtodoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tbtodoItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            PaneltablaUtilidad.setVisible(true);
            jScrollPane5.setVisible(true);
            jScrollPane6.setVisible(true);
            Paneltotales.setVisible(true);
            TitledBorder t = (TitledBorder )PaneltablaUtilidad.getBorder();
            t.setTitle("Ingresos y Gastos");

            DefaultTableModel modeloTablaUtilidadIngresos = new DefaultTableModel(con.getIngresosSeleccinados(fechaJCalendar(jdcfechaInicio).toString(), fechaJCalendar(jdcfechaFinal).toString()), columnasUtilidad);
            tablautilidadingresos.setModel(modeloTablaUtilidadIngresos);

            DefaultTableModel modeloTablaUtilidadGastos = new DefaultTableModel(con.getGastosSeleccionados(fechaJCalendar(jdcfechaInicio).toString(), fechaJCalendar(jdcfechaFinal).toString()), columnasUtilidad);
            tablautilidadgastos.setModel(modeloTablaUtilidadGastos);

           double totalg = con.totalGastos;
            jlTotalGastos.setText("L. "+con.formatearNumero(totalg));

            double totali = con.totalIngresos;
            jlTotalIngresos.setText("L. "+con.formatearNumero(totali));
            
            double totalu = con.totalIngresos - con.totalGastos;
            jlTotalUtilidad.setText("L. "+con.formatearNumero(totalu));
            
        } else {
            PaneltablaUtilidad.setVisible(false);
            jScrollPane5.setVisible(false);
            jScrollPane6.setVisible(false);
            Paneltotales.setVisible(false);

        }
    }//GEN-LAST:event_tbtodoItemStateChanged

    private void tbtodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtodoActionPerformed

    private void tablaInventarioEquipoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaInventarioEquipoFocusGained
       
    }//GEN-LAST:event_tablaInventarioEquipoFocusGained

    private void tablaInventarioEquipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaInventarioEquipoFocusLost

    }//GEN-LAST:event_tablaInventarioEquipoFocusLost

    private void jtfMontoAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMontoAPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMontoAPagarActionPerformed

    private void jtfMontoAPagarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMontoAPagarKeyPressed
        // TODO add your handling code here:
        if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jtfMontoAPagarKeyPressed

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

    private void jtfTiempoAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTiempoAPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTiempoAPagarActionPerformed

    private void jtfTiempoAPagarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTiempoAPagarKeyPressed
        // TODO add your handling code here:
        if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jtfTiempoAPagarKeyPressed

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

    private void jbPagoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagoCancelarActionPerformed
        jcbClienteAPagar.setSelectedIndex(0);
        jtfMontoAPagar.setText("");
        jtfTiempoAPagar.setText("");
        jcbTiempoPago.setSelectedIndex(0);
        jcbPagoPlan.setSelectedIndex(0);
    }//GEN-LAST:event_jbPagoCancelarActionPerformed

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

    private void jcbTiempoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTiempoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTiempoPagoActionPerformed

    private void jtfbuscarpagoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfbuscarpagoCaretUpdate
        // TODO add your handling code here:

        DefaultTableModel modeloTablaPagos = new DefaultTableModel(con.buscarPago(jtfbuscarpago.getText()), columnasPagos);
        tablaPagos.setModel(modeloTablaPagos);

    }//GEN-LAST:event_jtfbuscarpagoCaretUpdate

    private void jtfbuscarpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfbuscarpagoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jtfbuscarpagoActionPerformed

    private void jtfbuscarpagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfbuscarpagoKeyPressed

        if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jtfbuscarpagoKeyPressed

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

    private void tablaPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPagosMouseClicked
        // TODO add your handling code here:
        filaseleccionadatablapagos = tablaPagos.getSelectedRow();
        jcbClienteAPagar.setSelectedItem(tablaPagos.getValueAt(filaseleccionadatablapagos, 1));
        jtfMontoAPagar.setText(tablaPagos.getValueAt(filaseleccionadatablapagos, 2).toString());
        jtfTiempoAPagar.setText(tablaPagos.getValueAt(filaseleccionadatablapagos, 3).toString());
        jcbTiempoPago.setSelectedItem(tablaPagos.getValueAt(filaseleccionadatablapagos, 4));
        jcbPagoPlan.setSelectedItem(tablaPagos.getValueAt(filaseleccionadatablapagos, 5));
    }//GEN-LAST:event_tablaPagosMouseClicked

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

    private void jtfSelccionarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfSelccionarClienteMouseClicked
        PanelListaDeClientes ventanaCliente = new PanelListaDeClientes();
        ventanaCliente.setVisible(true);
    }//GEN-LAST:event_jtfSelccionarClienteMouseClicked

    private void jtfBuscarClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarClienteKeyPressed

    }//GEN-LAST:event_jtfBuscarClienteKeyPressed

    private void jtfBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarClienteActionPerformed

    private void jtfBuscarClienteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfBuscarClienteCaretUpdate
        DefaultTableModel modeloTablaBuscarClientes = new DefaultTableModel(con.buscarCliente(jtfBuscarCliente.getText(), jtfBuscarCliente.getText()), columnasClientes);
        tablaClientes.setModel(modeloTablaBuscarClientes);
    }//GEN-LAST:event_jtfBuscarClienteCaretUpdate

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked

    }//GEN-LAST:event_tablaClientesMouseClicked

    private void panelDatosClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelDatosClienteFocusGained

    }//GEN-LAST:event_panelDatosClienteFocusGained

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

    private void jtfPesoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesoKeyReleased
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && jtfAltura.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfPesoKeyReleased

    private void jtfPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPesoActionPerformed

    private void btnAceptarRegistroClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarRegistroClienteKeyPressed

    }//GEN-LAST:event_btnAceptarRegistroClienteKeyPressed

    private void btnAceptarRegistroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarRegistroClienteActionPerformed
        Calendar cal = Calendar.getInstance();
        int anioActual = cal.get(Calendar.YEAR);
        int menorEdadPermitida = anioActual - 18;
        int mayorEdadPermitida = anioActual - 100;

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
        } else if (jdcFecha.getCalendar().get(Calendar.YEAR) > menorEdadPermitida) {
            JOptionPane.showMessageDialog(this, "El cliente debe ser mayor de 18 años", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jdcFecha.getCalendar().get(Calendar.YEAR) < mayorEdadPermitida) {
            JOptionPane.showMessageDialog(this, "El cliente podría no estar apto para ejercitarse", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfAltura.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la altura del cliente", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfPeso.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el peso del cliente", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {

            con.insertarCliente(jtfNombreCliente.getText(),
                jtfApellidoCliente.getText(),
                fechaJCalendar(jdcFecha).toString(),
                jtfAltura.getText(),
                jtfPeso.getText());

            jtfNombreCliente.setText("");
            jtfApellidoCliente.setText("");
            jdcFecha.setDate(null);
            jtfAltura.setText("");
            jtfPeso.setText("");

            DefaultTableModel modeloTablaClientes = new DefaultTableModel(con.getCliente(), columnasClientes);
            tablaClientes.setModel(modeloTablaClientes);
            JOptionPane.showMessageDialog(this, "Registro Exitoso", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarRegistroClienteActionPerformed

    private void jtfAlturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAlturaKeyTyped

        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnAceptarRegistroCliente.doClick();
        }
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && jtfAltura.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfAlturaKeyTyped

    private void jtfAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAlturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAlturaActionPerformed

    private void jtfApellidoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoClienteKeyTyped

        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnAceptarRegistroCliente.doClick();
        }
    }//GEN-LAST:event_jtfApellidoClienteKeyTyped

    private void jtfApellidoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfApellidoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfApellidoClienteActionPerformed

    private void jtfNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreClienteKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnAceptarRegistroCliente.doClick();
        }
    }//GEN-LAST:event_jtfNombreClienteKeyTyped

    private void jtfNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreClienteActionPerformed

    private void btnCancelarRegistroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRegistroClienteActionPerformed
        jtfNombreCliente.setText("");
        jtfApellidoCliente.setText("");
        jdcFecha.setDate(null);
        jtfPeso.setText("");
        jtfAltura.setText("");
    }//GEN-LAST:event_btnCancelarRegistroClienteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JPanel PanelInventario;
    private javax.swing.JPanel PanelPagos;
    private javax.swing.JPanel PanelTabla;
    private javax.swing.JPanel PanelTablaGastos;
    private javax.swing.JPanel PanelTablaPagos;
    private javax.swing.JPanel PanelUtilidad;
    private javax.swing.JPanel Panelfecha;
    private javax.swing.JPanel PaneltablaUtilidad;
    private javax.swing.JPanel Paneltotales;
    private javax.swing.JButton btnAceptarInventario;
    private javax.swing.JButton btnAceptarRegistroCliente;
    private javax.swing.JButton btnAceptarRegistroGasto;
    private javax.swing.JButton btnCancelarInventario;
    private javax.swing.JButton btnCancelarRegistroCliente;
    private javax.swing.JButton btnCancelarRegistroGasto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbPagoAceptar;
    private javax.swing.JButton jbPagoCancelar;
    private javax.swing.JComboBox<String> jcbClienteAPagar;
    private javax.swing.JComboBox<String> jcbPagoPlan;
    private javax.swing.JCheckBox jcbPersonalizarFechaGasto;
    private javax.swing.JComboBox<String> jcbTiempoPago;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private com.toedter.calendar.JDateChooser jdcFechaGasto;
    private com.toedter.calendar.JDateChooser jdcfechaFinal;
    private com.toedter.calendar.JDateChooser jdcfechaInicio;
    private javax.swing.JLabel jlCantidadEquipo;
    private javax.swing.JLabel jlDescripcionEquipo;
    private javax.swing.JLabel jlDescripcionGAsto;
    private javax.swing.JLabel jlFechaGasto;
    private javax.swing.JLabel jlIconoGasto;
    private javax.swing.JLabel jlMontoPagar;
    private javax.swing.JLabel jlNombreEquipo;
    private javax.swing.JLabel jlRegistroClientes;
    private javax.swing.JLabel jlRegistroClientes1;
    private javax.swing.JLabel jlTiempoPago;
    private javax.swing.JLabel jlTotalGastos;
    private javax.swing.JLabel jlTotalIngresos;
    private javax.swing.JLabel jlTotalUtilidad;
    private javax.swing.JLabel jlmontoGasto;
    private javax.swing.JTextField jtfAltura;
    private javax.swing.JTextField jtfApellidoCliente;
    private javax.swing.JTextField jtfBuscarCliente;
    private javax.swing.JTextField jtfBuscarGasto;
    private javax.swing.JTextField jtfBuscarInventario;
    private javax.swing.JTextField jtfCantidadEquipo;
    private javax.swing.JLabel jtfClienteAPagar;
    private javax.swing.JTextField jtfDescripcionGasto;
    private javax.swing.JTextField jtfMontoAPagar;
    private javax.swing.JTextField jtfMontoGasto;
    private javax.swing.JTextField jtfNombreCliente;
    private javax.swing.JTextField jtfNombreEquipo;
    private javax.swing.JLabel jtfPagoTipodePlan;
    private javax.swing.JTextField jtfPeso;
    public javax.swing.JTextField jtfSelccionarCliente;
    private javax.swing.JTextField jtfTiempoAPagar;
    private javax.swing.JTextField jtfbuscarpago;
    private javax.swing.JLabel labeltotalgastos;
    private javax.swing.JLabel labeltotalingresos;
    private javax.swing.JLabel labelutilidad;
    private javax.swing.JPanel panelCumpleaneros;
    private javax.swing.JPanel panelDatosCliente;
    private javax.swing.JPanel panelDatosGasto;
    private javax.swing.JPanel panelDatosPago;
    private javax.swing.JPanel panelGastos;
    private presentacion.PanelRegistroClientes panelRegistroClientes1;
    private javax.swing.JScrollPane scrollTablaClientes;
    private javax.swing.JScrollPane scrollTablaClientes1;
    private javax.swing.JTextArea taDescripcionEquipo;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaDeCumpleaneros;
    private javax.swing.JTable tablaGastos;
    private javax.swing.JTable tablaInventarioEquipo;
    private javax.swing.JTable tablaPagos;
    private javax.swing.JTable tablautilidadgastos;
    private javax.swing.JTable tablautilidadingresos;
    private javax.swing.JToggleButton tbgastos;
    private javax.swing.JToggleButton tbingresos;
    private javax.swing.JToggleButton tbtodo;
    // End of variables declaration//GEN-END:variables
}
