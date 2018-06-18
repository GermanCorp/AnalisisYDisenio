package presentacion;

import com.toedter.calendar.JDateChooser;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import royal_gym.Clientes;
import royal_gym.Conexion;
import royal_gym.LoginEntrar;

public class PanelRegistroClientes extends javax.swing.JPanel {

    private static Statement statement;
    static ResultSet resultado;
    Clientes clientes = new Clientes();
    private String idCliente;

    //Columnas de la tabla Clientes
    private final String[] columnasClientes = {"Id", "Nombres", "Apellidos", "Fecha de Nacimiento", "Altura", "Peso", "Masa Corporal", "Clasificación"};

    //Constructor
    public PanelRegistroClientes() {
        initComponents();
        clientes.modeloTablaCliente(columnasClientes, tablaInventarioEquipo);
        ocultarColumna();
        if(LoginEntrar.esAdministrador(PanelLogin.nUsuario) == 0){
            btnEliminarCliente.setVisible(false);
            jMenuItemEliminar.setVisible(false);
        }
    }

    // Devuelve la edad permitida
    public static int edadMinima() {
        int edadM = 0;
        try {
            String consulta = "SELECT valor FROM configuracion where descripConfig = 'edadMinima'";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);

            while (resultado.next()) {
                edadM = resultado.getInt("valor");
            }
        } catch (Exception e) {
            System.out.println("error edadMinima" + e.getMessage());
        }
        return edadM;
    }

    public static int edadMaxima() {
        int edadM = 0;
        try {
            String consulta = "SELECT valor FROM configuracion where descripConfig = 'edadMaxima'";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);

            while (resultado.next()) {
                edadM = resultado.getInt("valor");
            }
        } catch (Exception e) {
            System.out.println("error edadMinima" + e.getMessage());
        }
        return edadM;
    }

    private Date fechaJCalendar(JDateChooser calendario) {
        Date date = calendario.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        return fecha;
    }

    private void ocultarColumna() {
        tablaInventarioEquipo.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaInventarioEquipo.getColumnModel().getColumn(0).setMinWidth(0);
        tablaInventarioEquipo.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItemModificar = new javax.swing.JMenuItem();
        jMenuItemEliminar = new javax.swing.JMenuItem();
        jMenuItemExpediente = new javax.swing.JMenuItem();
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
        tablaInventarioEquipo = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jtfBuscarCliente = new javax.swing.JTextField();
        btnEliminarCliente = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnExpediente = new javax.swing.JButton();

        jMenuItemModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/jpop_modificar.png"))); // NOI18N
        jMenuItemModificar.setText("Modificar");
        jMenuItemModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemModificarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemModificarMousePressed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemModificar);

        jMenuItemEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/jpop_eliminar.png"))); // NOI18N
        jMenuItemEliminar.setText("Eliminar");
        jMenuItemEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemEliminarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemEliminarMousePressed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemEliminar);

        jMenuItemExpediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/jpop_expediente.png"))); // NOI18N
        jMenuItemExpediente.setText("Mostrar Expediente");
        jMenuItemExpediente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemExpedienteMousePressed(evt);
            }
        });
        jMenuItemExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExpedienteActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemExpediente);

        setBackground(new java.awt.Color(85, 96, 128));

        panelDatosCliente.setBackground(new java.awt.Color(85, 96, 128));
        panelDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        panelDatosCliente.setToolTipText("");
        panelDatosCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelDatosClienteFocusGained(evt);
            }
        });

        btnCancelarRegistroCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btn_limpiar_02.png"))); // NOI18N
        btnCancelarRegistroCliente.setText("Limpiar");
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

        btnAceptarRegistroCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btn_guardar_2.png"))); // NOI18N
        btnAceptarRegistroCliente.setText("Guardar");
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
        jdcFecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addComponent(btnAceptarRegistroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelarRegistroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(20, 20, 20)
                        .addComponent(jlRegistroClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addGap(20, 20, 20))
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
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
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
                        .addContainerGap(131, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosClienteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelarRegistroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAceptarRegistroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );

        PanelTabla.setBackground(new java.awt.Color(85, 96, 128));
        PanelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Clientes Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        tablaInventarioEquipo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
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
        tablaInventarioEquipo.setAutoscrolls(true);
        tablaInventarioEquipo.setComponentPopupMenu(jPopupMenu1);
        tablaInventarioEquipo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaInventarioEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaClientesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaClientesMouseReleased(evt);
            }
        });
        scrollTablaClientes.setViewportView(tablaInventarioEquipo);

        jtfBuscarCliente.setToolTipText("");
        jtfBuscarCliente.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfBuscarClienteCaretUpdate(evt);
            }
        });
        jtfBuscarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfBuscarClienteMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtfBuscarClienteMousePressed(evt);
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

        btnEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btn_eliminar.png"))); // NOI18N
        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Buscar Cliente:");

        btnExpediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/expediente.png"))); // NOI18N
        btnExpediente.setText("Expediente");
        btnExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpedienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTablaLayout = new javax.swing.GroupLayout(PanelTabla);
        PanelTabla.setLayout(PanelTablaLayout);
        PanelTablaLayout.setHorizontalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTablaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addGroup(PanelTablaLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfBuscarCliente))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTablaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        PanelTablaLayout.setVerticalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTablaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addGroup(PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(PanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarRegistroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRegistroClienteActionPerformed
        btnEliminarCliente.setEnabled(true);
        jtfNombreCliente.setText("");
        jtfApellidoCliente.setText("");
        jdcFecha.setDate(null);
        jtfPeso.setText("");
        jtfAltura.setText("");
        btnAceptarRegistroCliente.setText("Guardar");
        btnAceptarRegistroCliente.setIcon(new ImageIcon(Class.class.getResource("/iconos/btn_guardar_2.png")));
        btnCancelarRegistroCliente.setText("Limpiar");
        btnCancelarRegistroCliente.setIcon(new ImageIcon(Class.class.getResource("/iconos/btn_limpiar_02.png")));
    }//GEN-LAST:event_btnCancelarRegistroClienteActionPerformed

    private void jtfNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreClienteActionPerformed

    private void jtfNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreClienteKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnAceptarRegistroCliente.doClick();
        }
    }//GEN-LAST:event_jtfNombreClienteKeyTyped

    private void jtfApellidoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfApellidoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfApellidoClienteActionPerformed

    private void jtfApellidoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoClienteKeyTyped

        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnAceptarRegistroCliente.doClick();
        }
    }//GEN-LAST:event_jtfApellidoClienteKeyTyped

    private void jtfAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAlturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAlturaActionPerformed

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


    private void btnAceptarRegistroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarRegistroClienteActionPerformed

        Calendar cal = Calendar.getInstance();
        int anioActual = cal.get(Calendar.YEAR);
        int menorEdadPermitida = anioActual - edadMinima();
        int mayorEdadPermitida = anioActual - edadMaxima();

        //if (evt.getActionCommand().equals("Guardar")){
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
            JOptionPane.showMessageDialog(this, "El cliente debe ser mayor de " + edadMinima() + " años", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jdcFecha.getCalendar().get(Calendar.YEAR) < mayorEdadPermitida) {
            JOptionPane.showMessageDialog(this, "El cliente podría no estar apto para ejercitarse.\nUna persona mayor de " + edadMaxima() + " años no puede realizar pagos.\n¡Valla a configuración y cambie la edad maxima permitida!", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfAltura.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la altura del cliente", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfPeso.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el peso del cliente", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {

            if (evt.getActionCommand().equals("Guardar")) {
                clientes.insertarCliente(jtfNombreCliente.getText(),
                        jtfApellidoCliente.getText(),
                        fechaJCalendar(jdcFecha).toString(),
                        jtfAltura.getText(),
                        jtfPeso.getText());

                jtfNombreCliente.setText("");
                jtfApellidoCliente.setText("");
                jdcFecha.setDate(null);
                jtfAltura.setText("");
                jtfPeso.setText("");

                JOptionPane.showMessageDialog(this, "Registro Exitoso", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                clientes.modeloTablaCliente(columnasClientes, tablaInventarioEquipo);
                ocultarColumna();

            } else if (evt.getActionCommand().equals("Modificar")) {

                btnEliminarCliente.setEnabled(true);
                clientes.modificarClientes(
                        idCliente,
                        jtfNombreCliente.getText(),
                        jtfApellidoCliente.getText(),
                        fechaJCalendar(jdcFecha).toString(),
                        jtfAltura.getText(),
                        jtfPeso.getText());

                jtfNombreCliente.setText("");
                jtfApellidoCliente.setText("");
                jdcFecha.setDate(null);
                jtfAltura.setText("");
                jtfPeso.setText("");

                btnAceptarRegistroCliente.setText("Guardar");
                btnAceptarRegistroCliente.setIcon(new ImageIcon(Class.class.getResource("/iconos/btn_guardar_2.png")));
                btnCancelarRegistroCliente.setText("Limpiar");
                btnCancelarRegistroCliente.setIcon(new ImageIcon(Class.class.getResource("/iconos/btn_limpiar_02.png")));
                //JOptionPane.showMessageDialog(this, "Modificacion Exitosa", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                royal_gym.VP.jlMensajes.setText("Cliente editado exitosamente");
                clientes.modeloTablaCliente(columnasClientes, tablaInventarioEquipo);
                ocultarColumna();

            }

        }

    }//GEN-LAST:event_btnAceptarRegistroClienteActionPerformed

    private void btnAceptarRegistroClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarRegistroClienteKeyPressed

    }//GEN-LAST:event_btnAceptarRegistroClienteKeyPressed

    private void jtfPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPesoActionPerformed

    private void jtfPesoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesoKeyReleased
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && jtfAltura.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfPesoKeyReleased

    private void jtfPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesoKeyTyped

        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnAceptarRegistroCliente.doClick();
        }
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && jtfPeso.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfPesoKeyTyped

    private void jdcFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcFechaKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnAceptarRegistroCliente.doClick();
        }

    }//GEN-LAST:event_jdcFechaKeyTyped

    private void panelDatosClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelDatosClienteFocusGained

    }//GEN-LAST:event_panelDatosClienteFocusGained

    private void jtfBuscarClienteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfBuscarClienteCaretUpdate
        DefaultTableModel modeloTablaBuscarClientes = new DefaultTableModel(clientes.buscarCliente(jtfBuscarCliente.getText(), jtfBuscarCliente.getText()), columnasClientes);
        tablaInventarioEquipo.setModel(modeloTablaBuscarClientes);
        ocultarColumna();
    }//GEN-LAST:event_jtfBuscarClienteCaretUpdate

    private void jtfBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarClienteActionPerformed

    private void jtfBuscarClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarClienteKeyPressed

    }//GEN-LAST:event_jtfBuscarClienteKeyPressed

    private void tablaClientesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseReleased

    }//GEN-LAST:event_tablaClientesMouseReleased

    private void tablaClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMousePressed
        Point point = evt.getPoint();
        int currentRow = tablaInventarioEquipo.rowAtPoint(point);
        tablaInventarioEquipo.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tablaClientesMousePressed

    private void jMenuItemModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemModificarMouseClicked

    }//GEN-LAST:event_jMenuItemModificarMouseClicked

    private void jMenuItemEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemEliminarMouseClicked

    }//GEN-LAST:event_jMenuItemEliminarMouseClicked

    private void jMenuItemModificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemModificarMousePressed
        // TODO add your handling code here:

        btnEliminarCliente.setEnabled(false);
        btnAceptarRegistroCliente.setText("Modificar");
        btnAceptarRegistroCliente.setIcon(new ImageIcon(Class.class.getResource("/iconos/btn_modificar.png")));
        btnCancelarRegistroCliente.setText("Cancelar");
        btnCancelarRegistroCliente.setIcon(new ImageIcon(Class.class.getResource("/iconos/Cancelar.png")));

        int filaseleccionada = tablaInventarioEquipo.getSelectedRow();
        idCliente = (tablaInventarioEquipo.getValueAt(filaseleccionada, 0).toString());

        jtfNombreCliente.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 1).toString());
        jtfApellidoCliente.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 2).toString());
        String date = tablaInventarioEquipo.getValueAt(filaseleccionada, 3).toString();
        java.util.Date date2 = null;
        try {
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(PanelRegistroClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        jdcFecha.setDate(date2);
        jtfAltura.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 4).toString());
        jtfPeso.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 5).toString());

    }//GEN-LAST:event_jMenuItemModificarMousePressed

    private void jMenuItemEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemEliminarMousePressed
        // TODO add your handling code here:
        jPopupMenu1.setVisible(false);
        int filaSeleccionada = tablaInventarioEquipo.getSelectedRow();
        String nombreCliente = tablaInventarioEquipo.getValueAt(filaSeleccionada, 1).toString();
        String apellidos = tablaInventarioEquipo.getValueAt(filaSeleccionada, 2).toString();
        String nacimiento = tablaInventarioEquipo.getValueAt(filaSeleccionada, 3).toString();
        int mjs = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar a " + nombreCliente + " ?");
        if (mjs == JOptionPane.YES_OPTION) {
            clientes.eliminarCliente(nombreCliente, apellidos, nacimiento);
            clientes.modeloTablaCliente(columnasClientes, tablaInventarioEquipo);
            JOptionPane.showMessageDialog(this, "Cliente eliminado exitosamente");
        }
    }//GEN-LAST:event_jMenuItemEliminarMousePressed

    private void jMenuItemExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExpedienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemExpedienteActionPerformed

    private void jMenuItemExpedienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemExpedienteMousePressed

        int filaSeleccionada = tablaInventarioEquipo.getSelectedRow();
        PanelExpediente rc = new PanelExpediente();
        rc.id = tablaInventarioEquipo.getValueAt(filaSeleccionada, 0).toString();

        jPopupMenu1.setVisible(false);
        new Expediente(new javax.swing.JDialog(), true).setVisible(true);
    }//GEN-LAST:event_jMenuItemExpedienteMousePressed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        int filaSeleccionada = tablaInventarioEquipo.getSelectedRow();

        if (filaSeleccionada == -1) {
            //JOptionPane.showMessageDialog(null, "Seleccione un cliente", "Advertencia", JOptionPane.WARNING_MESSAGE);
            royal_gym.VP.jlMensajes.setText("Seleccione un cliente");
        } else {

            String nombres = tablaInventarioEquipo.getValueAt(filaSeleccionada, 1).toString();
            String apellidos = tablaInventarioEquipo.getValueAt(filaSeleccionada, 2).toString();
            String nacimiento = tablaInventarioEquipo.getValueAt(filaSeleccionada, 3).toString();
            int mjs = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar a " + nombres + " ?");
            if (mjs == JOptionPane.YES_OPTION) {
                clientes.eliminarCliente(nombres, apellidos, nacimiento);
                clientes.modeloTablaCliente(columnasClientes, tablaInventarioEquipo);
                ocultarColumna();
                //JOptionPane.showMessageDialog(this, "Cliente eliminado exitosamente");
                royal_gym.VP.jlMensajes.setText("Cliente eliminado exitosamente");
            }
        }

    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void jtfBuscarClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfBuscarClienteMousePressed

    }//GEN-LAST:event_jtfBuscarClienteMousePressed

    private void jtfBuscarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfBuscarClienteMouseClicked

    }//GEN-LAST:event_jtfBuscarClienteMouseClicked

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        // TODO add your handling code here:
        royal_gym.VP.jlMensajes.setText("");
        if (evt.getClickCount() == 2) {

            btnEliminarCliente.setEnabled(false);
            btnAceptarRegistroCliente.setText("Modificar");
            btnAceptarRegistroCliente.setIcon(new ImageIcon(Class.class.getResource("/iconos/btn_modificar.png")));
            btnCancelarRegistroCliente.setText("Cancelar");
            btnCancelarRegistroCliente.setIcon(new ImageIcon(Class.class.getResource("/iconos/Cancelar.png")));

            int filaseleccionada = tablaInventarioEquipo.getSelectedRow();
            idCliente = (tablaInventarioEquipo.getValueAt(filaseleccionada, 0).toString());

            jtfNombreCliente.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 1).toString());
            jtfApellidoCliente.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 2).toString());
            String date = tablaInventarioEquipo.getValueAt(filaseleccionada, 3).toString();
            java.util.Date date2 = null;
            try {
                date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            } catch (ParseException ex) {
                Logger.getLogger(PanelRegistroClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            jdcFecha.setDate(date2);
            jtfAltura.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 4).toString());
            jtfPeso.setText(tablaInventarioEquipo.getValueAt(filaseleccionada, 5).toString());

        }
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void btnExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpedienteActionPerformed

    }//GEN-LAST:event_btnExpedienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTabla;
    private javax.swing.JButton btnAceptarRegistroCliente;
    private javax.swing.JButton btnCancelarRegistroCliente;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnExpediente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItemEliminar;
    private javax.swing.JMenuItem jMenuItemExpediente;
    private javax.swing.JMenuItem jMenuItemModificar;
    private javax.swing.JPopupMenu jPopupMenu1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JLabel jlRegistroClientes;
    private javax.swing.JTextField jtfAltura;
    private javax.swing.JTextField jtfApellidoCliente;
    private javax.swing.JTextField jtfBuscarCliente;
    private javax.swing.JTextField jtfNombreCliente;
    private javax.swing.JTextField jtfPeso;
    private javax.swing.JPanel panelDatosCliente;
    private javax.swing.JScrollPane scrollTablaClientes;
    public static javax.swing.JTable tablaInventarioEquipo;
    // End of variables declaration//GEN-END:variables
}
