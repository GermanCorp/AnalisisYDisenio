package presentacion;

import com.toedter.calendar.JDateChooser;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import royal_gym.Conexion;
import royal_gym.Expediente2;
import royal_gym.FormatoTablaCambios;

/**
 *
 * @author alxcr
 */
public class JDExpediente extends javax.swing.JDialog {

    java.util.Date date = new Date();
    java.sql.Date fechaActual = new java.sql.Date(date.getTime());
    boolean debeGuardar = false;
    boolean debeInsertar = false;

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

    private boolean hayProblemasDeSalud() {
        boolean res = false;
        try {
            String SSQL = "SELECT * FROM problemasdesalud WHERE id_cliente = ? ";
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SSQL);
            pst.setString(1, PanelRegistroClientes.getIdCliente());
            ResultSet resultado = pst.executeQuery();

            if (resultado.next()) {
                res = true;
            } else {
                res = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
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
        tablacambioscorporales.setDefaultRenderer(Object.class, new FormatoTablaCambios());
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

            String sQLEdad = "select (julianday('now') - julianday(c.FechaNacimiento))/365 as edad from cliente as c where idCliente = ?";
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sQLEdad);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            int edad = rs.getInt("edad");
            //double pesoIdeal = (resultado.getDouble("Altura") - 100) + ((edad/10)*0.9);

            while (resultado.next()) {
                jTextFieldnombre.setText(resultado.getString("Nombres") + " " + resultado.getString("Apellidos"));
                jTextFieldfechanacimiento.setText(resultado.getString("FechaNacimiento"));
                jtfTelefonoTrabajo.setText(resultado.getString("TelefonoTrabajo"));
                jtfCelular.setText(resultado.getString("Celular"));
                jtfDireccion.setText(resultado.getString("Direccion"));
                jTextFieldedad.setText(String.valueOf(edad) + " años");
                jTextFieldestatura.setText(resultado.getString("Altura") + " metros");
                jTextFieldpeso.setText(resultado.getString("Peso") + " kg");
                jtfMejorHora.setText(resultado.getString("MejorHoraParaLlamar"));
                jtfFechaInicio.setText(resultado.getString("FechaDeInicio"));
                jtfTelefonoCasas.setText(resultado.getString("TelefonoCasa"));
                double altura = resultado.getDouble("Altura") * 100;
                double pesoIdeal = altura - 100 - ((altura / 150) / 4);
                DecimalFormat df = new DecimalFormat("##.##");
                jTextFieldpesoideal.setText(df.format(pesoIdeal) + " kg");

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
            //JOptionPane.showMessageDialog(null, "El cliente tiene datos que no han sido actualizados en el expediente");
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
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
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
        jtfDireccion = new javax.swing.JTextField();
        jtfTelefonoTrabajo = new javax.swing.JTextField();
        jtfTelefonoCasas = new javax.swing.JTextField();
        jTextFieldestatura = new javax.swing.JTextField();
        jTextFieldfechanacimiento = new javax.swing.JTextField();
        jTextFieldpeso = new javax.swing.JTextField();
        jTextFieldedad = new javax.swing.JTextField();
        jTextFieldpesoideal = new javax.swing.JTextField();
        jtfCelular = new javax.swing.JTextField();
        jtfMejorHora = new javax.swing.JFormattedTextField();
        jtfFechaInicio = new javax.swing.JTextField();
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

        jtfpeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfpesoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfpesoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("IMC:");

        jtfimc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfimcKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfimcKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("%Grasa:");

        jtfgrasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfgrasaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfgrasaKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("%Musculo:");

        jtfmusculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfmusculoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfmusculoKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Calorias:");

        jtfcalorias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfcaloriasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfcaloriasKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Edad/B:");

        jtfedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfedadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfedadKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Grasa Viceral:");

        jtfgrasaviceral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfgrasaviceralKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfgrasaviceralKeyTyped(evt);
            }
        });

        tablacambioscorporales.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablacambioscorporales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha", "Peso", "IMC", "% Grasa", "% Músculo", "Calorías", "Edad", "Grasa Viceral"
            }
        ));
        jScrollPane2.setViewportView(tablacambioscorporales);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(224, 67, 54));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Aumentó");

        jPanel6.setBackground(new java.awt.Color(151, 201, 65));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Disminuyó");

        javax.swing.GroupLayout PanelCambiosCorporalesLayout = new javax.swing.GroupLayout(PanelCambiosCorporales);
        PanelCambiosCorporales.setLayout(PanelCambiosCorporalesLayout);
        PanelCambiosCorporalesLayout.setHorizontalGroup(
            PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
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
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))))
                .addGap(20, 20, 20))
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
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel9)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel10)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1.setBackground(new java.awt.Color(85, 96, 128));

        jTabbedPane1.setBackground(new java.awt.Color(85, 96, 128));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        PanelDatosCliente.setBackground(new java.awt.Color(85, 96, 128));
        PanelDatosCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelDatosClienteMouseClicked(evt);
            }
        });

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

        jtfDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDireccionKeyTyped(evt);
            }
        });

        jtfTelefonoTrabajo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfTelefonoTrabajo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfTelefonoTrabajoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTelefonoTrabajoKeyTyped(evt);
            }
        });

        jtfTelefonoCasas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfTelefonoCasas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfTelefonoCasasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTelefonoCasasKeyTyped(evt);
            }
        });

        jTextFieldestatura.setEditable(false);
        jTextFieldestatura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldfechanacimiento.setEditable(false);
        jTextFieldfechanacimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldpeso.setEditable(false);
        jTextFieldpeso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldedad.setEditable(false);
        jTextFieldedad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldedadKeyTyped(evt);
            }
        });

        jTextFieldpesoideal.setEditable(false);
        jTextFieldpesoideal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtfCelular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfCelularKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCelularKeyTyped(evt);
            }
        });

        try {
            jtfMejorHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##??")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfMejorHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfMejorHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMejorHoraKeyTyped(evt);
            }
        });

        jtfFechaInicio.setEditable(false);
        jtfFechaInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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
                            .addComponent(jtfTelefonoTrabajo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfDireccion)
                            .addComponent(jTextFieldnombre, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelhoraparallamar)
                            .addComponent(labelestatura))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                                .addComponent(jTextFieldestatura, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addGap(24, 24, 24)
                                .addComponent(labelpeso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldpeso, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                            .addComponent(jtfMejorHora))))
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
                        .addComponent(jTextFieldedad, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelpesoideal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldpesoideal, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                    .addComponent(jtfTelefonoCasas)
                    .addComponent(jTextFieldfechanacimiento)
                    .addComponent(jtfCelular)
                    .addComponent(jtfFechaInicio))
                .addGap(10, 10, 10))
        );
        PanelDatosClienteLayout.setVerticalGroup(
            PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jTextFieldnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelfechainicio)
                            .addComponent(labelnombre)
                            .addComponent(jtfFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labeltelefonocasa)
                            .addComponent(jtfTelefonoCasas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelcelular)
                            .addComponent(jtfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jtfTelefonoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labeldireccion))
                        .addGap(5, 5, 5)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelhoraparallamar)
                            .addComponent(jtfMejorHora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jCBoxgastritis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxgastritisActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxgastritis);

        jCBoxcolitis.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcolitis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxcolitis.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcolitis.setText("Colitis");
        jCBoxcolitis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxcolitisActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxcolitis);

        jCBoxestrenimiento.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxestrenimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxestrenimiento.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxestrenimiento.setText("Estrenimiento");
        jCBoxestrenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxestrenimientoActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxestrenimiento);

        jCBoxcansancio.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcansancio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxcansancio.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcansancio.setText("Cansancio");
        jCBoxcansancio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxcansancioActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxcansancio);

        jCBoxulcera.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxulcera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxulcera.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxulcera.setText("Ulcera");
        jCBoxulcera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxulceraActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxulcera);

        jCBoxdiabetes.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdiabetes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxdiabetes.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdiabetes.setText("Diabetes");
        jCBoxdiabetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxdiabetesActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxdiabetes);

        jCBoxpresionalta.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxpresionalta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxpresionalta.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxpresionalta.setText("Presion Alta");
        jCBoxpresionalta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxpresionaltaActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxpresionalta);

        jCBoxcolesterol.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcolesterol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxcolesterol.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcolesterol.setText("Colesterol");
        jCBoxcolesterol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxcolesterolActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxcolesterol);

        jCBoxalergias.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxalergias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxalergias.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxalergias.setText("Alergias");
        jCBoxalergias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxalergiasActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxalergias);

        jCBoxestres.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxestres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxestres.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxestres.setText("Estres");
        jCBoxestres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxestresActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxestres);

        jCBoxdolordecabeza.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdolordecabeza.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxdolordecabeza.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdolordecabeza.setText("Dolor de Cabeza");
        jCBoxdolordecabeza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxdolordecabezaActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxdolordecabeza);

        jCBoxdolordecuello.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdolordecuello.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxdolordecuello.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdolordecuello.setText("Dolor de Cuello");
        jCBoxdolordecuello.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxdolordecuelloActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxdolordecuello);

        jCBoxdoloresdeespalda.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdoloresdeespalda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxdoloresdeespalda.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdoloresdeespalda.setText("Dolores de Espalda");
        jCBoxdoloresdeespalda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxdoloresdeespaldaActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxdoloresdeespalda);

        jCBoxartritis.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxartritis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxartritis.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxartritis.setText("Artritis");
        jCBoxartritis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxartritisActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxartritis);

        jCBoxansiedad.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxansiedad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxansiedad.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxansiedad.setText("Ansiedad");
        jCBoxansiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxansiedadActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxansiedad);

        jCBoxembarazo.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxembarazo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxembarazo.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxembarazo.setText("Embarazo/Lactancia");
        jCBoxembarazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxembarazoActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxembarazo);

        jCBoxretenciondeliquidos.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxretenciondeliquidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxretenciondeliquidos.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxretenciondeliquidos.setText("Retencion de Liquidos");
        jCBoxretenciondeliquidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxretenciondeliquidosActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxretenciondeliquidos);

        jCBoxmalacirculacion.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxmalacirculacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxmalacirculacion.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxmalacirculacion.setText("Mala Circulacion");
        jCBoxmalacirculacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxmalacirculacionActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxmalacirculacion);

        jCBoxcalambres.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcalambres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxcalambres.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcalambres.setText("Calambres");
        jCBoxcalambres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxcalambresActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxcalambres);

        jCBoxvarices.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxvarices.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxvarices.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxvarices.setText("Varices");
        jCBoxvarices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxvaricesActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxvarices);

        jCBoxdoloresdehueso.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdoloresdehueso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxdoloresdehueso.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdoloresdehueso.setText("Dolores de Hueso");
        jCBoxdoloresdehueso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxdoloresdehuesoActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxdoloresdehueso);

        jCBoxanemia.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxanemia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxanemia.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxanemia.setText("Anemia");
        jCBoxanemia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxanemiaActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxanemia);

        jCBoxproblemasdevesicula.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxproblemasdevesicula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxproblemasdevesicula.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxproblemasdevesicula.setText("Problemas de Vesicula");
        jCBoxproblemasdevesicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxproblemasdevesiculaActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxproblemasdevesicula);

        jCBoxproblemasderinon.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxproblemasderinon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxproblemasderinon.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxproblemasderinon.setText("Problemas de Rinon");
        jCBoxproblemasderinon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxproblemasderinonActionPerformed(evt);
            }
        });
        jPanel2.add(jCBoxproblemasderinon);

        jCBoxcelulitis.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcelulitis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxcelulitis.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcelulitis.setText("Celulitis");
        jCBoxcelulitis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxcelulitisActionPerformed(evt);
            }
        });
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 899, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
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
        if (debeGuardar) {
            int mjs = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea salir sin guardar?");
            if (mjs == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else {
            dispose();
        }


    }//GEN-LAST:event_botoncancelarexpedienteActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (jtfpeso.getText().equals("") || jtfimc.getText().equals("")
                || jtfgrasa.getText().equals("")
                || jtfmusculo.getText().equals("")
                || jtfcalorias.getText().equals("")
                || jtfedad.getText().equals("")
                || jtfgrasaviceral.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Toda la información de cambios corporales es requerida");
        } else {
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
                    "");

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
            debeInsertar = false;
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jlFotoPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlFotoPerfilMouseClicked
        if (evt.getClickCount() == 2) {
            new OpcionFotoPefil(new javax.swing.JDialog(), true).setVisible(true);
        }
    }//GEN-LAST:event_jlFotoPerfilMouseClicked

    private void botonaceptarexpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarexpedienteActionPerformed
        Expediente2 expediente = new Expediente2();
        debeGuardar = false;
        expediente.actualizarTablaClientes(jtfTelefonoTrabajo.getText(),
                jtfDireccion.getText().trim(),
                jtfMejorHora.getText(),
                jtfTelefonoCasas.getText(),
                jtfCelular.getText(),
                jtfedad.getText(),
                jTextFieldpesoideal.getText(),
                jCBoxsubir.isSelected(),
                jCBoxmantener.isSelected(),
                jCBoxBajar.isSelected(),                
                PanelRegistroClientes.getIdCliente());

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
        boolean anemia = jCBoxanemia.isSelected();
        boolean problemadevesicula = jCBoxproblemasdevesicula.isSelected();
        boolean problemaderiñon = jCBoxproblemasderinon.isSelected();
        boolean celulitis = jCBoxcelulitis.isSelected();

        if (hayProblemasDeSalud()) {
            expediente.actualizarProblemasDeSalud(
                    PanelRegistroClientes.getIdCliente(), gastritis, colitis, estreñimiento, ulcera, cansancio,
                    diabetes, presionAlta, colesterol, alergias, estres, dolordecabeza, dolordecuello, doloresdeespalda,
                    artritis, ansiedad, embarazo, retencionliquidos, malacirculacion, calambres, varices, doloresdehueso,
                    anemia, problemadevesicula, problemaderiñon, celulitis);

        } else {
            expediente.insertarProblemasdeSalud(PanelRegistroClientes.getIdCliente(), gastritis, colitis, estreñimiento, ulcera, cansancio, diabetes,
                    presionAlta, colesterol, alergias, estres, dolordecabeza, dolordecuello, doloresdeespalda, artritis,
                    ansiedad, embarazo, retencionliquidos, malacirculacion, calambres, varices, doloresdehueso, anemia,
                    problemadevesicula, problemaderiñon, celulitis);
        }
        botonaceptarexpediente.setText("Guardado");
        botonaceptarexpediente.setIcon(new ImageIcon(Class.class.getResource("/iconos/Aceptar.png")));
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                botonaceptarexpediente.setText("Guardar");
                botonaceptarexpediente.setIcon(new ImageIcon(Class.class.getResource("/iconos/btn_guardar_2.png")));
            } catch (InterruptedException ex) {
            }
        }).start();

    }//GEN-LAST:event_botonaceptarexpedienteActionPerformed

    private void jCBoxsubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxsubirActionPerformed
        if (jCBoxsubir.isSelected()) {
            jCBoxBajar.setSelected(false);
            jCBoxmantener.setSelected(false);

        }
        debeGuardar = true;
    }//GEN-LAST:event_jCBoxsubirActionPerformed

    private void jCBoxBajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxBajarActionPerformed
        if (jCBoxBajar.isSelected()) {
            jCBoxsubir.setSelected(false);
            jCBoxmantener.setSelected(false);

        }
        debeGuardar = true;
    }//GEN-LAST:event_jCBoxBajarActionPerformed

    private void jCBoxmantenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxmantenerActionPerformed
        if (jCBoxmantener.isSelected()) {
            jCBoxsubir.setSelected(false);
            jCBoxBajar.setSelected(false);

        }
        debeGuardar = true;
    }//GEN-LAST:event_jCBoxmantenerActionPerformed

    private void jtfTelefonoTrabajoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelefonoTrabajoKeyTyped
        

        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
        debeGuardar = true;
    }//GEN-LAST:event_jtfTelefonoTrabajoKeyTyped

    private void jtfTelefonoCasasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelefonoCasasKeyTyped
        

        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
        debeGuardar = true;
    }//GEN-LAST:event_jtfTelefonoCasasKeyTyped

    private void jtfCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCelularKeyTyped
        

        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
        debeGuardar = true;
    }//GEN-LAST:event_jtfCelularKeyTyped

    private void jTextFieldedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldedadKeyTyped
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }

        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
    }//GEN-LAST:event_jTextFieldedadKeyTyped

    private void jtfDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDireccionKeyTyped
        
        debeGuardar = true;
    }//GEN-LAST:event_jtfDireccionKeyTyped

    private void jtfMejorHoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMejorHoraKeyTyped
        debeGuardar = true;
    }//GEN-LAST:event_jtfMejorHoraKeyTyped

    private void PanelDatosClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelDatosClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelDatosClienteMouseClicked

    private void jCBoxgastritisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxgastritisActionPerformed
        // TODO add your handling code here:
        debeGuardar = true;
    }//GEN-LAST:event_jCBoxgastritisActionPerformed

    private void jCBoxdiabetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxdiabetesActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxdiabetesActionPerformed

    private void jCBoxdolordecabezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxdolordecabezaActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxdolordecabezaActionPerformed

    private void jCBoxembarazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxembarazoActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxembarazoActionPerformed

    private void jCBoxdoloresdehuesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxdoloresdehuesoActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxdoloresdehuesoActionPerformed

    private void jCBoxcolitisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxcolitisActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxcolitisActionPerformed

    private void jCBoxpresionaltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxpresionaltaActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxpresionaltaActionPerformed

    private void jCBoxdolordecuelloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxdolordecuelloActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxdolordecuelloActionPerformed

    private void jCBoxretenciondeliquidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxretenciondeliquidosActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxretenciondeliquidosActionPerformed

    private void jCBoxanemiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxanemiaActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxanemiaActionPerformed

    private void jCBoxestrenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxestrenimientoActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxestrenimientoActionPerformed

    private void jCBoxcolesterolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxcolesterolActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxcolesterolActionPerformed

    private void jCBoxdoloresdeespaldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxdoloresdeespaldaActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxdoloresdeespaldaActionPerformed

    private void jCBoxmalacirculacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxmalacirculacionActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxmalacirculacionActionPerformed

    private void jCBoxproblemasdevesiculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxproblemasdevesiculaActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxproblemasdevesiculaActionPerformed

    private void jCBoxcansancioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxcansancioActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxcansancioActionPerformed

    private void jCBoxalergiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxalergiasActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxalergiasActionPerformed

    private void jCBoxartritisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxartritisActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxartritisActionPerformed

    private void jCBoxcalambresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxcalambresActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxcalambresActionPerformed

    private void jCBoxproblemasderinonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxproblemasderinonActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxproblemasderinonActionPerformed

    private void jCBoxulceraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxulceraActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxulceraActionPerformed

    private void jCBoxestresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxestresActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxestresActionPerformed

    private void jCBoxansiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxansiedadActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxansiedadActionPerformed

    private void jCBoxvaricesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxvaricesActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxvaricesActionPerformed

    private void jCBoxcelulitisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxcelulitisActionPerformed
        debeGuardar = true;        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxcelulitisActionPerformed

    private void jtfpesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfpesoKeyTyped

        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && jtfpeso.getText().contains(".")) {
            evt.consume();
        }
        debeInsertar = true;
    }//GEN-LAST:event_jtfpesoKeyTyped

    private void jtfimcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfimcKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && jtfimc.getText().contains(".")) {
            evt.consume();
        }
        debeInsertar = true;
    }//GEN-LAST:event_jtfimcKeyTyped

    private void jtfgrasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfgrasaKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && jtfgrasa.getText().contains(".")) {
            evt.consume();
        }
        debeInsertar = true;
    }//GEN-LAST:event_jtfgrasaKeyTyped

    private void jtfmusculoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmusculoKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && jtfmusculo.getText().contains(".")) {
            evt.consume();
        }
        debeInsertar = true;
    }//GEN-LAST:event_jtfmusculoKeyTyped

    private void jtfcaloriasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfcaloriasKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && jtfcalorias.getText().contains(".")) {
            evt.consume();
        }
        debeInsertar = true;
    }//GEN-LAST:event_jtfcaloriasKeyTyped

    private void jtfedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfedadKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && jtfedad.getText().contains(".")) {
            evt.consume();
        }
        debeInsertar = true;
    }//GEN-LAST:event_jtfedadKeyTyped

    private void jtfgrasaviceralKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfgrasaviceralKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && jtfgrasaviceral.getText().contains(".")) {
            evt.consume();
        }
        debeInsertar = true;
    }//GEN-LAST:event_jtfgrasaviceralKeyTyped

    private void jtfTelefonoTrabajoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelefonoTrabajoKeyPressed
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfTelefonoTrabajoKeyPressed

    private void jtfTelefonoCasasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelefonoCasasKeyPressed
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfTelefonoCasasKeyPressed

    private void jtfCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCelularKeyPressed
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfCelularKeyPressed

    private void jtfpesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfpesoKeyPressed
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfpesoKeyPressed

    private void jtfimcKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfimcKeyPressed
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfimcKeyPressed

    private void jtfgrasaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfgrasaKeyPressed
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfgrasaKeyPressed

    private void jtfmusculoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmusculoKeyPressed
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfmusculoKeyPressed

    private void jtfcaloriasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfcaloriasKeyPressed
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfcaloriasKeyPressed

    private void jtfedadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfedadKeyPressed
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfedadKeyPressed

    private void jtfgrasaviceralKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfgrasaviceralKeyPressed
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfgrasaviceralKeyPressed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldedad;
    private javax.swing.JTextField jTextFieldestatura;
    private javax.swing.JTextField jTextFieldfechanacimiento;
    public static javax.swing.JTextField jTextFieldnombre;
    private javax.swing.JTextField jTextFieldpeso;
    private javax.swing.JTextField jTextFieldpesoideal;
    public static javax.swing.JLabel jlFotoPerfil;
    private javax.swing.JTextField jtfCelular;
    private javax.swing.JTextField jtfDireccion;
    private javax.swing.JTextField jtfFechaInicio;
    private javax.swing.JFormattedTextField jtfMejorHora;
    private javax.swing.JTextField jtfTelefonoCasas;
    private javax.swing.JTextField jtfTelefonoTrabajo;
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
