package presentacion;

import java.awt.GraphicsEnvironment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import royal_gym.Conexion;
import royal_gym.Expediente2;

/**
 *
 * @author alxcr
 */
public class JDExpediente extends javax.swing.JDialog {

    java.util.Date date = new Date();
    java.sql.Date fechaActual = new java.sql.Date(date.getTime());

    public JDExpediente(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
        setLocationRelativeTo(null);
        cargarExpediente(PanelRegistroClientes.getIdCliente());
        btnAgregar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAgregar.setVerticalTextPosition(SwingConstants.BOTTOM);
        actualizarTablaCambios();
        ocultarColumna();
    }
    
     private void ocultarColumna() {
        tablacambioscorporales.getColumnModel().getColumn(0).setMaxWidth(0);
        tablacambioscorporales.getColumnModel().getColumn(0).setMinWidth(0);
        tablacambioscorporales.getColumnModel().getColumn(0).setPreferredWidth(0);
        tablacambioscorporales.getColumnModel().getColumn(1).setMaxWidth(1);
        tablacambioscorporales.getColumnModel().getColumn(1).setMinWidth(1);
        tablacambioscorporales.getColumnModel().getColumn(1).setPreferredWidth(1);
    }

    // limpia los textfield de cambios
    public void limpiarCambios() {
        jtfpeso.setText("");
        jtfimc.setText("");
        jtfgrasa.setText("");
        jtfmusculo.setText("");
        jtfcalorias.setText("");
        jtfedad.setText("");
        jtfgrasaviceral.setText("");
    }

    // llenar la tabla de cambios
    public void actualizarTablaCambios() {
        Expediente2 expediente = new Expediente2();
        String[] columnasCambios = {"idCliente", "id_Cambio", "Peso", "IMC", "Porcentaje de Grasa", "Porcentaje de Músculo", "Calorias", "Edad", "Grasa Viceral", "Fecha"};
        DefaultTableModel modeloTablaCambios = new DefaultTableModel(expediente.getCambiosCorporales(PanelRegistroClientes.getIdCliente()), columnasCambios);
        tablacambioscorporales.setModel(modeloTablaCambios);
    }

    // obtienen los datos del expediente
    public void cargarExpediente(String id) {
        try {
            String consulta = "SELECT * FROM cliente AS cl "
                    + "LEFT OUTER JOIN problemasdesalud AS ps "
                    + "ON cl.idcliente = ps.id_Cliente "
                    + "WHERE cl.idCliente = ?";

            PreparedStatement statement = Conexion.getConexion().prepareStatement(consulta);
            statement.setString(1, id);
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                jTextFieldnombre.setText(resultado.getString("Nombres") + " " + resultado.getString("Apellidos"));
                jTextFieldfechanacimiento.setText(resultado.getString("FechaNacimiento"));
                jTextFieldtelefonotrab.setText(resultado.getString("TelefonoTrabajo"));
                jTextFieldcelular.setText(resultado.getString("Celular"));
                jTextFielddireccion.setText(resultado.getString("Direccion"));
                jTextFieldedad.setText(resultado.getString("Edad"));
                jTextFieldestatura.setText(resultado.getString("Altura"));
                jTextFieldpeso.setText(resultado.getString("Peso"));
                jFormattedTextField.setText(resultado.getString("MejorHoraParaLlamar"));

                String fecha = resultado.getString("FechaDeInicio");
                java.util.Date date2 = null;
                date2 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
                jDateChooserFechaInicio.setDate(date2);

                jTextFieldtelefonocasa.setText(resultado.getString("TelefonoCasa"));
                jTextFieldpesoideal.setText(resultado.getString("PesoIdeal"));

                jCBoxBajar.setSelected(resultado.getBoolean("PesoQuiereBajar"));
                jCBoxsubir.setSelected(resultado.getBoolean("PesoQuiereSubir"));
                jCBoxmantener.setSelected(resultado.getBoolean("PesoQuiereMantener"));
                jCBoxalergias.setSelected(resultado.getBoolean("Alergias"));
                jCBoxanemia.setSelected(resultado.getBoolean("Anemia"));
                jCBoxansiedad.setSelected(resultado.getBoolean("Ansiedad"));
                jCBoxartritis.setSelected(resultado.getBoolean("Artritis"));
                jCBoxcalambres.setSelected(resultado.getBoolean("Calambres"));
                jCBoxcansancio.setSelected(resultado.getBoolean("Cansancio"));
                jCBoxcelulitis.setSelected(resultado.getBoolean("Celulitis"));
                jCBoxcolesterol.setSelected(resultado.getBoolean("Colesterol"));
                jCBoxcolitis.setSelected(resultado.getBoolean("Colitis"));
                jCBoxdiabetes.setSelected(resultado.getBoolean("Diabetes"));
                jCBoxdolordecabeza.setSelected(resultado.getBoolean("Dolordecabeza"));
                jCBoxdolordecuello.setSelected(resultado.getBoolean("Dolordecuello"));
                jCBoxdoloresdeespalda.setSelected(resultado.getBoolean("Doloresdeespalda"));
                jCBoxdoloresdehueso.setSelected(resultado.getBoolean("Doloresdehueso"));
                jCBoxembarazo.setSelected(resultado.getBoolean("EmbarazoLactancia"));
                jCBoxestrenimiento.setSelected(resultado.getBoolean("Estreñimiento"));
                jCBoxestres.setSelected(resultado.getBoolean("Estres"));
                jCBoxgastritis.setSelected(resultado.getBoolean("Gastritis"));
                jCBoxmalacirculacion.setSelected(resultado.getBoolean("Malacirculacion"));
                jCBoxpresionalta.setSelected(resultado.getBoolean("PresionAlta"));
                jCBoxproblemasderinon.setSelected(resultado.getBoolean("Problemaderiñon"));
                jCBoxproblemasdevesicula.setSelected(resultado.getBoolean("Problemadevesicula"));
                jCBoxretenciondeliquidos.setSelected(resultado.getBoolean("Retenciondeliquidos"));
                jCBoxulcera.setSelected(resultado.getBoolean("Ulcera"));
                jCBoxvarices.setSelected(resultado.getBoolean("Varices"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "El cliente tiene datos que no han sido actualizados en el expediente");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        botoncancelarexpediente = new javax.swing.JButton();
        botonaceptarexpediente = new javax.swing.JButton();
        PanelCambiosCorporales = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfpeso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfimc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfgrasa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfmusculo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfcalorias = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfedad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfgrasaviceral = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablacambioscorporales = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelDatosCliente = new javax.swing.JPanel();
        labelnombre = new javax.swing.JLabel();
        labeltelefonotrabajo = new javax.swing.JLabel();
        labeldireccion = new javax.swing.JLabel();
        labelhoraparallamar = new javax.swing.JLabel();
        labelestatura = new javax.swing.JLabel();
        labelfechainicio = new javax.swing.JLabel();
        labeltelefonocasa = new javax.swing.JLabel();
        labelcelular = new javax.swing.JLabel();
        labelfechanacimiento = new javax.swing.JLabel();
        labelpeso = new javax.swing.JLabel();
        labeledad = new javax.swing.JLabel();
        labelpesoideal = new javax.swing.JLabel();
        jTextFieldnombre = new javax.swing.JTextField();
        jTextFielddireccion = new javax.swing.JTextField();
        jTextFieldtelefonotrab = new javax.swing.JTextField();
        jTextFieldtelefonocasa = new javax.swing.JTextField();
        jTextFieldestatura = new javax.swing.JTextField();
        jTextFieldfechanacimiento = new javax.swing.JTextField();
        jTextFieldpeso = new javax.swing.JTextField();
        jTextFieldedad = new javax.swing.JTextField();
        jTextFieldpesoideal = new javax.swing.JTextField();
        jTextFieldcelular = new javax.swing.JTextField();
        jDateChooserFechaInicio = new com.toedter.calendar.JDateChooser();
        jFormattedTextField = new javax.swing.JFormattedTextField();
        PanelProblemasdeSalud = new javax.swing.JPanel();
        labelpesosquiere = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCBoxBajar = new javax.swing.JCheckBox();
        jCBoxmantener = new javax.swing.JCheckBox();
        jCBoxsubir = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jCBoxgastritis = new javax.swing.JCheckBox();
        jCBoxcolitis = new javax.swing.JCheckBox();
        jCBoxestrenimiento = new javax.swing.JCheckBox();
        jCBoxcansancio = new javax.swing.JCheckBox();
        jCBoxulcera = new javax.swing.JCheckBox();
        jCBoxdiabetes = new javax.swing.JCheckBox();
        jCBoxpresionalta = new javax.swing.JCheckBox();
        jCBoxcolesterol = new javax.swing.JCheckBox();
        jCBoxalergias = new javax.swing.JCheckBox();
        jCBoxestres = new javax.swing.JCheckBox();
        jCBoxdolordecabeza = new javax.swing.JCheckBox();
        jCBoxdolordecuello = new javax.swing.JCheckBox();
        jCBoxdoloresdeespalda = new javax.swing.JCheckBox();
        jCBoxartritis = new javax.swing.JCheckBox();
        jCBoxansiedad = new javax.swing.JCheckBox();
        jCBoxembarazo = new javax.swing.JCheckBox();
        jCBoxretenciondeliquidos = new javax.swing.JCheckBox();
        jCBoxmalacirculacion = new javax.swing.JCheckBox();
        jCBoxcalambres = new javax.swing.JCheckBox();
        jCBoxvarices = new javax.swing.JCheckBox();
        jCBoxdoloresdehueso = new javax.swing.JCheckBox();
        jCBoxanemia = new javax.swing.JCheckBox();
        jCBoxproblemasdevesicula = new javax.swing.JCheckBox();
        jCBoxproblemasderinon = new javax.swing.JCheckBox();
        jCBoxcelulitis = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Expediente");
        setSize(new java.awt.Dimension(100, 100));

        jPanel3.setBackground(new java.awt.Color(85, 96, 128));

        jPanel4.setBackground(new java.awt.Color(85, 96, 128));

        botoncancelarexpediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Eliminar_fila.png"))); // NOI18N
        botoncancelarexpediente.setText("Salir");
        botoncancelarexpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncancelarexpedienteActionPerformed(evt);
            }
        });

        botonaceptarexpediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btn_guardar_2.png"))); // NOI18N
        botonaceptarexpediente.setText("Guardar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonaceptarexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(botoncancelarexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botoncancelarexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonaceptarexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        PanelCambiosCorporales.setBackground(new java.awt.Color(85, 96, 128));
        PanelCambiosCorporales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cambios Corporales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Peso:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("IMC:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("%Grasa:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("%Musculo:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Calorias:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Edad/B:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Grasa Viceral:");

        tablacambioscorporales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha", "Peso", "IMC", "% Grasa", "% Músculo", "Calorías", "Edad", "Grasa Viceral"
            }
        ));
        jScrollPane2.setViewportView(tablacambioscorporales);

        btnAgregar.setIcon(new javax.swing.ImageIcon("C:\\Users\\alxcr\\Documents\\GitHub\\AnalisisYDisenio\\Royal_Gym\\src\\iconos\\agregar.png")); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCambiosCorporalesLayout = new javax.swing.GroupLayout(PanelCambiosCorporales);
        PanelCambiosCorporales.setLayout(PanelCambiosCorporalesLayout);
        PanelCambiosCorporalesLayout.setHorizontalGroup(
            PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfimc, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jtfpeso, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfmusculo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jtfgrasa, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfedad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfcalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfgrasaviceral, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 221, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelCambiosCorporalesLayout.setVerticalGroup(
            PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jtfpeso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jtfgrasa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jtfcalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jtfgrasaviceral, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(jtfimc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jtfmusculo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jtfedad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        jPanel1.setBackground(new java.awt.Color(85, 96, 128));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/sinFoto.png"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(85, 96, 128));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        PanelDatosCliente.setBackground(new java.awt.Color(85, 96, 128));

        labelnombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelnombre.setForeground(new java.awt.Color(255, 255, 255));
        labelnombre.setText("Nombre:");

        labeltelefonotrabajo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labeltelefonotrabajo.setForeground(new java.awt.Color(255, 255, 255));
        labeltelefonotrabajo.setText("Telefono Trabajo:");

        labeldireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labeldireccion.setForeground(new java.awt.Color(255, 255, 255));
        labeldireccion.setText("Direccion:");

        labelhoraparallamar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelhoraparallamar.setForeground(new java.awt.Color(255, 255, 255));
        labelhoraparallamar.setText("Mejor hora para llamar:");

        labelestatura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelestatura.setForeground(new java.awt.Color(255, 255, 255));
        labelestatura.setText("Estatura:");

        labelfechainicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelfechainicio.setForeground(new java.awt.Color(255, 255, 255));
        labelfechainicio.setText("Fecha de Inicio:");

        labeltelefonocasa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labeltelefonocasa.setForeground(new java.awt.Color(255, 255, 255));
        labeltelefonocasa.setText("Telefono casa:");

        labelcelular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelcelular.setForeground(new java.awt.Color(255, 255, 255));
        labelcelular.setText("Celular:");

        labelfechanacimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelfechanacimiento.setForeground(new java.awt.Color(255, 255, 255));
        labelfechanacimiento.setText("Fecha de nacimiento:");

        labelpeso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelpeso.setForeground(new java.awt.Color(255, 255, 255));
        labelpeso.setText("Peso:");

        labeledad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labeledad.setForeground(new java.awt.Color(255, 255, 255));
        labeledad.setText("Edad:");

        labelpesoideal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelpesoideal.setForeground(new java.awt.Color(255, 255, 255));
        labelpesoideal.setText("Peso Ideal:");

        jTextFieldnombre.setEditable(false);
        jTextFieldnombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFielddireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldtelefonotrab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldtelefonocasa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldestatura.setEditable(false);
        jTextFieldestatura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldfechanacimiento.setEditable(false);
        jTextFieldfechanacimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldpeso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldedad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldpesoideal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldcelular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooserFechaInicio.setDateFormatString("yyyy-MM-dd");
        jDateChooserFechaInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            jFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout PanelDatosClienteLayout = new javax.swing.GroupLayout(PanelDatosCliente);
        PanelDatosCliente.setLayout(PanelDatosClienteLayout);
        PanelDatosClienteLayout.setHorizontalGroup(
            PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labeldireccion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelnombre)
                                    .addComponent(labeltelefonotrabajo))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldtelefonotrab, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFielddireccion)
                            .addComponent(jTextFieldnombre, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelhoraparallamar)
                            .addComponent(labelestatura))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                                .addComponent(jTextFieldestatura, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addGap(24, 24, 24)
                                .addComponent(labelpeso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldpeso, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                            .addComponent(jFormattedTextField))))
                .addGap(28, 28, 28)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelfechanacimiento)
                    .addComponent(labelfechainicio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labeltelefonocasa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelcelular, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labeledad, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addComponent(jTextFieldedad, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelpesoideal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldpesoideal, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                    .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldtelefonocasa)
                    .addComponent(jTextFieldfechanacimiento)
                    .addComponent(jTextFieldcelular))
                .addGap(10, 10, 10))
        );
        PanelDatosClienteLayout.setVerticalGroup(
            PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelfechainicio)
                            .addComponent(labelnombre))
                        .addGap(5, 5, 5)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labeltelefonocasa)
                            .addComponent(jTextFieldtelefonocasa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelcelular)
                            .addComponent(jTextFieldcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelfechanacimiento)
                            .addComponent(jTextFieldfechanacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldpesoideal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelpesoideal))
                            .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(labeledad)
                                .addComponent(jTextFieldedad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labeltelefonotrabajo)
                            .addComponent(jTextFieldtelefonotrab, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFielddireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labeldireccion))
                        .addGap(5, 5, 5)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelhoraparallamar)
                            .addComponent(jFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelestatura)
                            .addComponent(jTextFieldestatura, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, PanelDatosClienteLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldpeso, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelpeso, javax.swing.GroupLayout.Alignment.CENTER))))
                .addGap(10, 10, 10))
        );

        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/DatosGenerales.png")), PanelDatosCliente); // NOI18N

        PanelProblemasdeSalud.setBackground(new java.awt.Color(85, 96, 128));

        labelpesosquiere.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        labelpesosquiere.setForeground(new java.awt.Color(255, 255, 255));
        labelpesosquiere.setText("Peso Quiere:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Problemas de salud:");

        jCBoxBajar.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxBajar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxBajar.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxBajar.setText("Bajar");

        jCBoxmantener.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxmantener.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxmantener.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxmantener.setText("Mantener");

        jCBoxsubir.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxsubir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxsubir.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxsubir.setText("Subir");

        jPanel2.setBackground(new java.awt.Color(85, 96, 128));
        jPanel2.setLayout(new java.awt.GridLayout(5, 0));

        jCBoxgastritis.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxgastritis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxgastritis.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxgastritis.setText("Gastritis");
        jPanel2.add(jCBoxgastritis);

        jCBoxcolitis.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcolitis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxcolitis.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcolitis.setText("Colitis");
        jPanel2.add(jCBoxcolitis);

        jCBoxestrenimiento.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxestrenimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxestrenimiento.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxestrenimiento.setText("Estrenimiento");
        jPanel2.add(jCBoxestrenimiento);

        jCBoxcansancio.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcansancio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxcansancio.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcansancio.setText("Cansancio");
        jPanel2.add(jCBoxcansancio);

        jCBoxulcera.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxulcera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxulcera.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxulcera.setText("Ulcera");
        jPanel2.add(jCBoxulcera);

        jCBoxdiabetes.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdiabetes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxdiabetes.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdiabetes.setText("Diabetes");
        jPanel2.add(jCBoxdiabetes);

        jCBoxpresionalta.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxpresionalta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxpresionalta.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxpresionalta.setText("Presion Alta");
        jPanel2.add(jCBoxpresionalta);

        jCBoxcolesterol.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcolesterol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxcolesterol.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcolesterol.setText("Colesterol");
        jPanel2.add(jCBoxcolesterol);

        jCBoxalergias.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxalergias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxalergias.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxalergias.setText("Alergias");
        jPanel2.add(jCBoxalergias);

        jCBoxestres.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxestres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxestres.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxestres.setText("Estres");
        jPanel2.add(jCBoxestres);

        jCBoxdolordecabeza.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdolordecabeza.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxdolordecabeza.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdolordecabeza.setText("Dolor de Cabeza");
        jPanel2.add(jCBoxdolordecabeza);

        jCBoxdolordecuello.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdolordecuello.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxdolordecuello.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdolordecuello.setText("Dolor de Cuello");
        jPanel2.add(jCBoxdolordecuello);

        jCBoxdoloresdeespalda.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdoloresdeespalda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxdoloresdeespalda.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdoloresdeespalda.setText("Dolores de Espalda");
        jPanel2.add(jCBoxdoloresdeespalda);

        jCBoxartritis.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxartritis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxartritis.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxartritis.setText("Artritis");
        jPanel2.add(jCBoxartritis);

        jCBoxansiedad.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxansiedad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxansiedad.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxansiedad.setText("Ansiedad");
        jPanel2.add(jCBoxansiedad);

        jCBoxembarazo.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxembarazo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxembarazo.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxembarazo.setText("Embarazo/Lactancia");
        jPanel2.add(jCBoxembarazo);

        jCBoxretenciondeliquidos.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxretenciondeliquidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxretenciondeliquidos.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxretenciondeliquidos.setText("Retencion de Liquidos");
        jPanel2.add(jCBoxretenciondeliquidos);

        jCBoxmalacirculacion.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxmalacirculacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxmalacirculacion.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxmalacirculacion.setText("Mala Circulacion");
        jPanel2.add(jCBoxmalacirculacion);

        jCBoxcalambres.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcalambres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxcalambres.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcalambres.setText("Calambres");
        jPanel2.add(jCBoxcalambres);

        jCBoxvarices.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxvarices.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxvarices.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxvarices.setText("Varices");
        jPanel2.add(jCBoxvarices);

        jCBoxdoloresdehueso.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdoloresdehueso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxdoloresdehueso.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdoloresdehueso.setText("Dolores de Hueso");
        jPanel2.add(jCBoxdoloresdehueso);

        jCBoxanemia.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxanemia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxanemia.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxanemia.setText("Anemia");
        jPanel2.add(jCBoxanemia);

        jCBoxproblemasdevesicula.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxproblemasdevesicula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxproblemasdevesicula.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxproblemasdevesicula.setText("Problemas de Vesicula");
        jPanel2.add(jCBoxproblemasdevesicula);

        jCBoxproblemasderinon.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxproblemasderinon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxproblemasderinon.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxproblemasderinon.setText("Problemas de Rinon");
        jPanel2.add(jCBoxproblemasderinon);

        jCBoxcelulitis.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcelulitis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxcelulitis.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcelulitis.setText("Celulitis");
        jPanel2.add(jCBoxcelulitis);

        javax.swing.GroupLayout PanelProblemasdeSaludLayout = new javax.swing.GroupLayout(PanelProblemasdeSalud);
        PanelProblemasdeSalud.setLayout(PanelProblemasdeSaludLayout);
        PanelProblemasdeSaludLayout.setHorizontalGroup(
            PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProblemasdeSaludLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelProblemasdeSaludLayout.createSequentialGroup()
                        .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelpesosquiere)
                            .addComponent(jLabel2)
                            .addGroup(PanelProblemasdeSaludLayout.createSequentialGroup()
                                .addComponent(jCBoxsubir)
                                .addGap(20, 20, 20)
                                .addComponent(jCBoxBajar)
                                .addGap(20, 20, 20)
                                .addComponent(jCBoxmantener)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        PanelProblemasdeSaludLayout.setVerticalGroup(
            PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProblemasdeSaludLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelpesosquiere)
                .addGap(5, 5, 5)
                .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBoxBajar)
                    .addComponent(jCBoxmantener)
                    .addComponent(jCBoxsubir))
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/iconos/problemasDeSAlud.png")), PanelProblemasdeSalud); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanelCambiosCorporales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PanelCambiosCorporales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botoncancelarexpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncancelarexpedienteActionPerformed
        dispose();
    }//GEN-LAST:event_botoncancelarexpedienteActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        JOptionPane.showMessageDialog(null, "Toma fotografia");
        SwingUtilities.invokeLater(new WebCamView());
    }//GEN-LAST:event_jLabel9MouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Expediente2 expediente = new Expediente2();
        expediente.insertarCambiosCorporales(
                jtfpeso.getText(),
                jtfimc.getText(),
                jtfgrasa.getText(),
                jtfmusculo.getText(),
                jtfcalorias.getText(),
                jtfedad.getText(),
                jtfgrasaviceral.getText(),
                PanelRegistroClientes.getIdCliente(),
                String.valueOf(fechaActual));
        
        expediente.insertarTotal(
                jtfpeso.getText(),
                jtfimc.getText(),
                jtfgrasa.getText(),
                jtfmusculo.getText(),
                jtfcalorias.getText(),
                jtfedad.getText(),
                jtfgrasaviceral.getText(),
                PanelRegistroClientes.getIdCliente(),
                String.valueOf(fechaActual));
        limpiarCambios();
        actualizarTablaCambios();
        ocultarColumna();
    }//GEN-LAST:event_btnAgregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCambiosCorporales;
    private javax.swing.JPanel PanelDatosCliente;
    private javax.swing.JPanel PanelProblemasdeSalud;
    private javax.swing.JButton botonaceptarexpediente;
    private javax.swing.JButton botoncancelarexpediente;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JCheckBox jCBoxBajar;
    private javax.swing.JCheckBox jCBoxalergias;
    private javax.swing.JCheckBox jCBoxanemia;
    private javax.swing.JCheckBox jCBoxansiedad;
    private javax.swing.JCheckBox jCBoxartritis;
    private javax.swing.JCheckBox jCBoxcalambres;
    private javax.swing.JCheckBox jCBoxcansancio;
    private javax.swing.JCheckBox jCBoxcelulitis;
    private javax.swing.JCheckBox jCBoxcolesterol;
    private javax.swing.JCheckBox jCBoxcolitis;
    private javax.swing.JCheckBox jCBoxdiabetes;
    private javax.swing.JCheckBox jCBoxdolordecabeza;
    private javax.swing.JCheckBox jCBoxdolordecuello;
    private javax.swing.JCheckBox jCBoxdoloresdeespalda;
    private javax.swing.JCheckBox jCBoxdoloresdehueso;
    private javax.swing.JCheckBox jCBoxembarazo;
    private javax.swing.JCheckBox jCBoxestrenimiento;
    private javax.swing.JCheckBox jCBoxestres;
    private javax.swing.JCheckBox jCBoxgastritis;
    private javax.swing.JCheckBox jCBoxmalacirculacion;
    private javax.swing.JCheckBox jCBoxmantener;
    private javax.swing.JCheckBox jCBoxpresionalta;
    private javax.swing.JCheckBox jCBoxproblemasderinon;
    private javax.swing.JCheckBox jCBoxproblemasdevesicula;
    private javax.swing.JCheckBox jCBoxretenciondeliquidos;
    private javax.swing.JCheckBox jCBoxsubir;
    private javax.swing.JCheckBox jCBoxulcera;
    private javax.swing.JCheckBox jCBoxvarices;
    private com.toedter.calendar.JDateChooser jDateChooserFechaInicio;
    private javax.swing.JFormattedTextField jFormattedTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldcelular;
    private javax.swing.JTextField jTextFielddireccion;
    private javax.swing.JTextField jTextFieldedad;
    private javax.swing.JTextField jTextFieldestatura;
    private javax.swing.JTextField jTextFieldfechanacimiento;
    public static javax.swing.JTextField jTextFieldnombre;
    private javax.swing.JTextField jTextFieldpeso;
    private javax.swing.JTextField jTextFieldpesoideal;
    private javax.swing.JTextField jTextFieldtelefonocasa;
    private javax.swing.JTextField jTextFieldtelefonotrab;
    private javax.swing.JTextField jtfcalorias;
    private javax.swing.JTextField jtfedad;
    private javax.swing.JTextField jtfgrasa;
    private javax.swing.JTextField jtfgrasaviceral;
    private javax.swing.JTextField jtfimc;
    private javax.swing.JTextField jtfmusculo;
    private javax.swing.JTextField jtfpeso;
    private javax.swing.JLabel labelcelular;
    private javax.swing.JLabel labeldireccion;
    private javax.swing.JLabel labeledad;
    private javax.swing.JLabel labelestatura;
    private javax.swing.JLabel labelfechainicio;
    private javax.swing.JLabel labelfechanacimiento;
    private javax.swing.JLabel labelhoraparallamar;
    private javax.swing.JLabel labelnombre;
    private javax.swing.JLabel labelpeso;
    private javax.swing.JLabel labelpesoideal;
    private javax.swing.JLabel labelpesosquiere;
    private javax.swing.JLabel labeltelefonocasa;
    private javax.swing.JLabel labeltelefonotrabajo;
    private javax.swing.JTable tablacambioscorporales;
    // End of variables declaration//GEN-END:variables

}
