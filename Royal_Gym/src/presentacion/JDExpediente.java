package presentacion;

import com.toedter.calendar.JDateChooser;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import static presentacion.PanelExpediente.id;
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
        getImagenPerfil();
    }

    private void ocultarColumna() {
        tablacambioscorporales.getColumnModel().getColumn(0).setMaxWidth(0);
        tablacambioscorporales.getColumnModel().getColumn(0).setMinWidth(0);
        tablacambioscorporales.getColumnModel().getColumn(0).setPreferredWidth(0);
        tablacambioscorporales.getColumnModel().getColumn(1).setMaxWidth(1);
        tablacambioscorporales.getColumnModel().getColumn(1).setMinWidth(1);
        tablacambioscorporales.getColumnModel().getColumn(1).setPreferredWidth(1);
    }

    public void getImagenPerfil() {
        try {
            String consulta = "select foto from cliente where idCliente = ?";
            PreparedStatement pst = Conexion.getConexion().prepareStatement(consulta);
            pst.setString(1, PanelRegistroClientes.getIdCliente());
            ResultSet st = pst.executeQuery();

            while (st.next()) {
                byte[] imagen = st.getBytes("foto");
                //jlFotoPerfil.setIcon(new ImageIcon(imagen));

                ImageIcon fot = new ImageIcon(imagen);
                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(275, jlFotoPerfil.getHeight(), Image.SCALE_DEFAULT));
                jlFotoPerfil.setIcon(icono);
                this.repaint();
            }
        } catch (Exception ex) {
            jlFotoPerfil.setIcon(new ImageIcon(Class.class.getResource("/iconos/sinFoto.png")));
        }
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
        jlFotoPerfil = new javax.swing.JLabel();

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
        botonaceptarexpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonaceptarexpedienteActionPerformed(evt);
            }
        });

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
        jTextFielddireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFielddireccionKeyTyped(evt);
            }
        });

        jTextFieldtelefonotrab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldtelefonotrab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldtelefonotrabKeyTyped(evt);
            }
        });

        jTextFieldtelefonocasa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldtelefonocasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldtelefonocasaKeyTyped(evt);
            }
        });

        jTextFieldestatura.setEditable(false);
        jTextFieldestatura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldfechanacimiento.setEditable(false);
        jTextFieldfechanacimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldpeso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldedad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldedadKeyTyped(evt);
            }
        });

        jTextFieldpesoideal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldcelular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldcelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldcelularKeyTyped(evt);
            }
        });

        jDateChooserFechaInicio.setDateFormatString("yyyy-MM-dd");
        jDateChooserFechaInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            jFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##??")));
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
                                .addComponent(jTextFieldestatura, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addGap(24, 24, 24)
                                .addComponent(labelpeso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldpeso, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
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
        jCBoxBajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxBajarActionPerformed(evt);
            }
        });

        jCBoxmantener.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxmantener.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxmantener.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxmantener.setText("Mantener");
        jCBoxmantener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxmantenerActionPerformed(evt);
            }
        });

        jCBoxsubir.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxsubir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxsubir.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxsubir.setText("Subir");
        jCBoxsubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxsubirActionPerformed(evt);
            }
        });

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

        jlFotoPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFotoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/sinFoto.png"))); // NOI18N
        jlFotoPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jlFotoPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlFotoPerfilMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jlFotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 904, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlFotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jlFotoPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlFotoPerfilMouseClicked
        if (evt.getClickCount() == 2) { 
        new OpcionFotoPefil(new javax.swing.JDialog(), true).setVisible(true);
        }
    }//GEN-LAST:event_jlFotoPerfilMouseClicked

    private void botonaceptarexpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarexpedienteActionPerformed
        
        
        Expediente2 expediente = new Expediente2();
        if(String.valueOf(jTextFielddireccion.getText().charAt(1)).equals(" ")){
            JOptionPane.showMessageDialog(null,"Los primeros digitos en la Direccion es un espacio en blanco");
        expediente.actualizarTablaClientes(
                
                jTextFieldtelefonotrab.getText(),
                jTextFielddireccion.getText().trim(),
                jFormattedTextField.getText(),
                fechaJCalendar(jDateChooserFechaInicio).toString(),
                jTextFieldtelefonocasa.getText(),
                jTextFieldcelular.getText(),
                jtfedad.getText(),
                jTextFieldpesoideal.getText(),
                jCBoxsubir.isSelected(),
                jCBoxBajar.isSelected(),
                jCBoxmantener.isSelected(),
                id);   
                         
        }else{    
        boolean gastritis = jCBoxgastritis.isSelected();
        boolean colitis = jCBoxcolitis.isSelected();
        boolean estreñimiento = jCBoxestrenimiento.isSelected();
        boolean ulcera = jCBoxulcera.isSelected();
        boolean cansancio = jCBoxcansancio.isSelected();
        boolean diabetes = jCBoxdiabetes.isSelected();
        boolean presionAlta = jCBoxpresionalta.isSelected();
        boolean colesterol = jCBoxcolesterol.isSelected();
        boolean alergias = jCBoxalergias.isSelected();
        boolean estres = jCBoxestres.isSelected();
        boolean dolordecabeza = jCBoxdolordecabeza.isSelected();
        boolean dolordecuello = jCBoxdolordecuello.isSelected();
        boolean doloresdeespalda = jCBoxdoloresdeespalda.isSelected();
        boolean artritis = jCBoxartritis.isSelected();
        boolean ansiedad = jCBoxansiedad.isSelected();
        boolean embarazo = jCBoxembarazo.isSelected();
        boolean retencionliquidos = jCBoxretenciondeliquidos.isSelected();
        boolean malacirculacion = jCBoxmalacirculacion.isSelected();
        boolean calambres = jCBoxcalambres.isSelected();
        boolean varices = jCBoxvarices.isSelected();
        boolean doloresdehueso = jCBoxdoloresdehueso.isSelected();
        //boolean anemia = jCBoxanemia.isSelected();
        boolean problemadevesicula = jCBoxproblemasdevesicula.isSelected();
        boolean problemaderiñon = jCBoxproblemasderinon.isSelected();
        boolean celulitis = jCBoxcelulitis.isSelected();
        
        
              
        if(jCBoxgastritis.isSelected()== false
            && jCBoxcolitis.isSelected()== false
            && jCBoxestrenimiento.isSelected() == false
            && jCBoxulcera.isSelected()== false
            && jCBoxcansancio.isSelected()== false
            && jCBoxdiabetes.isSelected()== false
            && jCBoxpresionalta.isSelected()== false
            && jCBoxcolesterol.isSelected()== false
            && jCBoxalergias.isSelected()== false
            && jCBoxestres.isSelected()== false
            && jCBoxdolordecabeza.isSelected()== false
            && jCBoxdolordecuello.isSelected()== false
            && jCBoxdoloresdeespalda.isSelected()== false
            && jCBoxartritis.isSelected()== false
            && jCBoxansiedad.isSelected()== false
            && jCBoxembarazo.isSelected()== false
            && jCBoxretenciondeliquidos.isSelected()== false
            && jCBoxmalacirculacion.isSelected()== false
            && jCBoxcalambres.isSelected()== false
            && jCBoxvarices.isSelected()== false
            && jCBoxdoloresdehueso.isSelected()== false
            && jCBoxanemia.isSelected()== false
            && jCBoxproblemasdevesicula.isSelected()== false
            && jCBoxproblemasderinon.isSelected()== false
            && jCBoxcelulitis.isSelected()== false
            ){
            
            expediente.insertarProblemasdeSalud(id, gastritis, colitis, estreñimiento, ulcera, cansancio, diabetes,
                    presionAlta, colesterol, alergias, estres, dolordecabeza, dolordecuello, doloresdeespalda, artritis,
                    ansiedad, embarazo, retencionliquidos, malacirculacion, calambres, varices, doloresdehueso, alergias,
                    problemadevesicula, problemaderiñon, celulitis);
        }else{
            
            
            expediente.actualizarProblemasDeSalud(id, gastritis, colitis, estreñimiento, ulcera, cansancio, diabetes, presionAlta,
                colesterol, alergias, estres, dolordecabeza, dolordecuello, doloresdeespalda, artritis, ansiedad, embarazo,
                retencionliquidos, malacirculacion, calambres, varices, doloresdehueso,problemadevesicula,
                problemaderiñon, celulitis);
            
        }
            
        }
    }//GEN-LAST:event_botonaceptarexpedienteActionPerformed

    private void jCBoxsubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxsubirActionPerformed
         if(jCBoxsubir.isSelected()){
           jCBoxBajar.setSelected(false);
           jCBoxmantener.setSelected(false);
            
        }
    }//GEN-LAST:event_jCBoxsubirActionPerformed

    private void jCBoxBajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxBajarActionPerformed
        if(jCBoxBajar.isSelected()){
           jCBoxsubir.setSelected(false);
           jCBoxmantener.setSelected(false);
            
        }
    }//GEN-LAST:event_jCBoxBajarActionPerformed

    private void jCBoxmantenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxmantenerActionPerformed
        if( jCBoxmantener.isSelected()){
           jCBoxsubir.setSelected(false);
           jCBoxBajar.setSelected(false);
            
        }
    }//GEN-LAST:event_jCBoxmantenerActionPerformed

    private void jTextFieldtelefonotrabKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldtelefonotrabKeyTyped
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
        
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
    }//GEN-LAST:event_jTextFieldtelefonotrabKeyTyped

    private void jTextFieldtelefonocasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldtelefonocasaKeyTyped
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
        
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
    }//GEN-LAST:event_jTextFieldtelefonocasaKeyTyped

    private void jTextFieldcelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldcelularKeyTyped
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
        
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
    }//GEN-LAST:event_jTextFieldcelularKeyTyped

    private void jTextFieldedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldedadKeyTyped
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
        
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
    }//GEN-LAST:event_jTextFieldedadKeyTyped

    private void jTextFielddireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielddireccionKeyTyped
        if (evt.isControlDown() && evt.isAltDown() && evt.isShiftDown()) {
            evt.consume();
        }
        
        
        Character s = evt.getKeyChar();
        
        if(!Character.isLetter(s) && s != KeyEvent.VK_SPACE){
            evt.consume();   
        }
    }//GEN-LAST:event_jTextFielddireccionKeyTyped

     private Date fechaJCalendar(JDateChooser calendario) {
    
        Date date = calendario.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        return fecha;
        
        
    }
    
    
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
    public static javax.swing.JLabel jlFotoPerfil;
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
