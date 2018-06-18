
package presentacion;

import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static presentacion.ListaClientes.RET_CANCEL;
import static presentacion.PanelRegistroClientes.tablaClientes;
import static presentacion.PanelRegistroPagos.jTextFieldNombreCliente;
import static presentacion.PanelRegistroPagos.tablaPagos;
import static presentacion.PanelVentas.jtablaProductosAVender;
import royal_gym.Conexion;
import royal_gym.Expediente;

/**
 *
 * @author Jazmin Vargas
 */
public class PanelExpediente extends javax.swing.JPanel {

    final Conexion con;
    Expediente expediente = new Expediente();

    public static String id;

    private final String[] columnasCambios = {
        "Peso",
        "Imc",
        "%Grasa",
        "%Musculo",
        "Calorias",
        "Edad/B",
        "Grasa Viceral"
    };

    public PanelExpediente() {
        initComponents();
        this.con = new Conexion();
        con.conectar();
        cargarExpediente(id);
     

      
    }
    
    
    
    public void cargarExpediente( String id){
         try {
           
            String consulta = "select cl.nombres ||' '||apellidos As nombreCompleto, "
                    + "cl.FechaNacimiento,cl.Altura,cl.Peso, \n"
                    + "cl.TelefonoTrabajo,cl.Direccion,cl.MejorHoraParaLlamar,cl.FechaDeInicio,\n"
                    + "cl.TelefonoCasa,cl.Celular,cl.Edad,cl.PesoIdeal,cl.PesoQuiereSubir,\n"
                    + "cl.PesoQuiereBajar,cl.PesoQuiereMantener, ps.Gastritis, ps.Colitis, \n"
                    + "ps.Estreñimiento, ps.Ulcera,ps.Cansancio, ps.Diabetes, ps.PresionAlta,\n"
                    + "ps.Colesterol, ps.Alergias,ps.Estres, ps.Dolordecabeza, ps.Dolordecuello,\n"
                    + "ps.Doloresdeespalda,ps.Artritis,ps.Ansiedad,ps.EmbarazoLactancia,\n"
                    + "ps.Retenciondeliquidos,ps.Malacirculacion,ps.Calambres,ps.Varices,ps.Doloresdehueso,\n"
                    + "ps.Anemia, ps.Celulitis,ps.Problemadevesicula,ps.Problemaderiñon,\n"
                    + "cp.fecha,cp.peso, cp.imc,cp.porcentajedegrasa, cp.porcentajedemusculo, cp.calorias,\n"
                    + "cp.edad, cp.grasaviceral\n"
                    + "from cliente cl \n"
                    + "left outer join problemasdesalud ps on ps.id_cliente = cl.idCliente \n"
                    + "left outer join cambioscorporales cp on ps.id_cliente=cp.id_cliente \n"
                    + "where cl.idCliente= ?";
            
           
            PreparedStatement statement = Conexion.getConexion().prepareStatement(consulta); // PrepareStatement se utiliza cuando se utilizan consultas que llevan signo de ?
            statement.setString(1, id); 
            ResultSet resultado = statement.executeQuery();

           
            Object[][] datosPago = null;
            ArrayList<Object[]> filas = new ArrayList<>();

            while (resultado.next()) {

                jTextFieldnombre.setText(resultado.getString("NombreCompleto"));
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
                //jCBoxanemia.setSelected(resultado.getBoolean("Anemia"));
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

                    filas.add(
                            new Object[]{
                                resultado.getString("fecha"),
                                resultado.getDouble("peso"),
                                resultado.getDouble("imc"),
                                resultado.getDouble("porcentajedegrasa"),
                                resultado.getDouble("porcentajedemusculo"),
                                resultado.getDouble("calorias"),
                                resultado.getInt("edad"),
                                resultado.getInt("grasaviceral"),});
                
                datosPago = new Object[filas.size()][];
                filas.toArray(datosPago);
            }

            DefaultTableModel modeloTablaPagos = new DefaultTableModel(datosPago, columnasCambios);
            tablacambioscorporales.setModel(modeloTablaPagos);

        } catch (Exception ex) {
            System.out.println("Datos del cliente:" + ex.getMessage());
        }

        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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
        jCBoxgastritis = new javax.swing.JCheckBox();
        jCBoxcolitis = new javax.swing.JCheckBox();
        jCBoxsubir = new javax.swing.JCheckBox();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacambioscorporales = new javax.swing.JTable();
        botoncancelarexpediente = new javax.swing.JButton();
        botonaceptarexpediente = new javax.swing.JButton();

        setBackground(new java.awt.Color(85, 96, 128));

        jPanel1.setBackground(new java.awt.Color(85, 96, 128));

        PanelDatosCliente.setBackground(new java.awt.Color(85, 96, 128));
        PanelDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

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
        jTextFieldnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldnombreActionPerformed(evt);
            }
        });
        jTextFieldnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldnombreKeyPressed(evt);
            }
        });

        jTextFielddireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFielddireccionActionPerformed(evt);
            }
        });
        jTextFielddireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFielddireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFielddireccionKeyTyped(evt);
            }
        });

        jTextFieldtelefonotrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldtelefonotrabActionPerformed(evt);
            }
        });
        jTextFieldtelefonotrab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldtelefonotrabKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldtelefonotrabKeyTyped(evt);
            }
        });

        jTextFieldtelefonocasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldtelefonocasaActionPerformed(evt);
            }
        });
        jTextFieldtelefonocasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldtelefonocasaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldtelefonocasaKeyTyped(evt);
            }
        });

        jTextFieldestatura.setEditable(false);
        jTextFieldestatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldestaturaActionPerformed(evt);
            }
        });
        jTextFieldestatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldestaturaKeyPressed(evt);
            }
        });

        jTextFieldfechanacimiento.setEditable(false);
        jTextFieldfechanacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldfechanacimientoActionPerformed(evt);
            }
        });
        jTextFieldfechanacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldfechanacimientoKeyPressed(evt);
            }
        });

        jTextFieldpeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldpesoActionPerformed(evt);
            }
        });
        jTextFieldpeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldpesoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldpesoKeyTyped(evt);
            }
        });

        jTextFieldedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldedadActionPerformed(evt);
            }
        });
        jTextFieldedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldedadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldedadKeyTyped(evt);
            }
        });

        jTextFieldpesoideal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldpesoidealActionPerformed(evt);
            }
        });
        jTextFieldpesoideal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldpesoidealKeyPressed(evt);
            }
        });

        jTextFieldcelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldcelularActionPerformed(evt);
            }
        });
        jTextFieldcelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldcelularKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldcelularKeyTyped(evt);
            }
        });

        jDateChooserFechaInicio.setDateFormatString("yyyy-MM-dd");
        jDateChooserFechaInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooserFechaInicioMouseClicked(evt);
            }
        });

        try {
            jFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##??")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout PanelDatosClienteLayout = new javax.swing.GroupLayout(PanelDatosCliente);
        PanelDatosCliente.setLayout(PanelDatosClienteLayout);
        PanelDatosClienteLayout.setHorizontalGroup(
            PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addComponent(labelestatura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldestatura, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(labelpeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldpeso, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                            .addComponent(labelhoraparallamar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jFormattedTextField))
                        .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                            .addComponent(labeldireccion)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFielddireccion))
                        .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                            .addComponent(labeltelefonotrabajo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldtelefonotrab))
                        .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                            .addComponent(labelnombre)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                                .addComponent(labeltelefonocasa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldtelefonocasa))
                            .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                                .addComponent(labelcelular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldcelular))
                            .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                                        .addComponent(labelfechanacimiento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldfechanacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                                        .addComponent(labelfechainicio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(labeledad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldedad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelpesoideal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldpesoideal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelDatosClienteLayout.setVerticalGroup(
            PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelnombre)
                        .addComponent(labelfechainicio)
                        .addComponent(jTextFieldnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeltelefonotrabajo)
                    .addComponent(labeltelefonocasa)
                    .addComponent(jTextFieldtelefonotrab, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldtelefonocasa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeldireccion)
                    .addComponent(labelcelular)
                    .addComponent(jTextFielddireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelhoraparallamar)
                        .addComponent(labelfechanacimiento)
                        .addComponent(jTextFieldfechanacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelestatura)
                    .addComponent(labelpeso)
                    .addComponent(labeledad)
                    .addComponent(labelpesoideal)
                    .addComponent(jTextFieldpeso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldedad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldpesoideal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldestatura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelProblemasdeSalud.setBackground(new java.awt.Color(85, 96, 128));
        PanelProblemasdeSalud.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Problemas de salud", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        labelpesosquiere.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelpesosquiere.setForeground(new java.awt.Color(255, 255, 255));
        labelpesosquiere.setText("Peso Quiere:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jCBoxgastritis.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxgastritis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxgastritis.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxgastritis.setText("Gastritis");
        jCBoxgastritis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxgastritisActionPerformed(evt);
            }
        });

        jCBoxcolitis.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcolitis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxcolitis.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcolitis.setText("Colitis");
        jCBoxcolitis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxcolitisActionPerformed(evt);
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

        jCBoxestrenimiento.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxestrenimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxestrenimiento.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxestrenimiento.setText("Estrenimiento");
        jCBoxestrenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxestrenimientoActionPerformed(evt);
            }
        });

        jCBoxcansancio.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcansancio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxcansancio.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcansancio.setText("Cansancio");

        jCBoxulcera.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxulcera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxulcera.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxulcera.setText("Ulcera");

        jCBoxdiabetes.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdiabetes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxdiabetes.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdiabetes.setText("Diabetes");

        jCBoxpresionalta.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxpresionalta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxpresionalta.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxpresionalta.setText("Presion Alta");

        jCBoxcolesterol.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcolesterol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxcolesterol.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcolesterol.setText("Colesterol");

        jCBoxalergias.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxalergias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxalergias.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxalergias.setText("Alergias");

        jCBoxestres.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxestres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxestres.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxestres.setText("Estres");

        jCBoxdolordecabeza.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdolordecabeza.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxdolordecabeza.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdolordecabeza.setText("Dolor de Cabeza");

        jCBoxdolordecuello.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdolordecuello.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxdolordecuello.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdolordecuello.setText("Dolor de Cuello");

        jCBoxdoloresdeespalda.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdoloresdeespalda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxdoloresdeespalda.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdoloresdeespalda.setText("Dolores de Espalda");
        jCBoxdoloresdeespalda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxdoloresdeespaldaActionPerformed(evt);
            }
        });

        jCBoxartritis.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxartritis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxartritis.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxartritis.setText("Artritis");
        jCBoxartritis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxartritisActionPerformed(evt);
            }
        });

        jCBoxansiedad.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxansiedad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxansiedad.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxansiedad.setText("Ansiedad");
        jCBoxansiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxansiedadActionPerformed(evt);
            }
        });

        jCBoxembarazo.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxembarazo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxembarazo.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxembarazo.setText("Embarazo/Lactancia");
        jCBoxembarazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxembarazoActionPerformed(evt);
            }
        });

        jCBoxretenciondeliquidos.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxretenciondeliquidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxretenciondeliquidos.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxretenciondeliquidos.setText("Retencion de Liquidos");

        jCBoxmalacirculacion.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxmalacirculacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxmalacirculacion.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxmalacirculacion.setText("Mala Circulacion");

        jCBoxcalambres.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcalambres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxcalambres.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcalambres.setText("Calambres");

        jCBoxvarices.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxvarices.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxvarices.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxvarices.setText("Varices");

        jCBoxdoloresdehueso.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdoloresdehueso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxdoloresdehueso.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdoloresdehueso.setText("Dolores de Hueso");
        jCBoxdoloresdehueso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxdoloresdehuesoActionPerformed(evt);
            }
        });

        jCBoxanemia.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxanemia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxanemia.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxanemia.setText("Anemia");

        jCBoxproblemasdevesicula.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxproblemasdevesicula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxproblemasdevesicula.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxproblemasdevesicula.setText("Problemas de Vesicula");

        jCBoxproblemasderinon.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxproblemasderinon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxproblemasderinon.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxproblemasderinon.setText("Problemas de Rinon");
        jCBoxproblemasderinon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxproblemasderinonActionPerformed(evt);
            }
        });

        jCBoxcelulitis.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcelulitis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBoxcelulitis.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcelulitis.setText("Celulitis");

        javax.swing.GroupLayout PanelProblemasdeSaludLayout = new javax.swing.GroupLayout(PanelProblemasdeSalud);
        PanelProblemasdeSalud.setLayout(PanelProblemasdeSaludLayout);
        PanelProblemasdeSaludLayout.setHorizontalGroup(
            PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProblemasdeSaludLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelpesosquiere)
                    .addComponent(jLabel2)
                    .addGroup(PanelProblemasdeSaludLayout.createSequentialGroup()
                        .addComponent(jCBoxsubir)
                        .addGap(20, 20, 20)
                        .addComponent(jCBoxBajar)
                        .addGap(20, 20, 20)
                        .addComponent(jCBoxmantener))
                    .addGroup(PanelProblemasdeSaludLayout.createSequentialGroup()
                        .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBoxestrenimiento, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCBoxgastritis)
                            .addComponent(jCBoxcolitis)
                            .addComponent(jCBoxulcera)
                            .addComponent(jCBoxdiabetes)
                            .addComponent(jCBoxcansancio)
                            .addComponent(jCBoxpresionalta))
                        .addGap(100, 100, 100)
                        .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBoxdolordecabeza)
                            .addComponent(jCBoxartritis)
                            .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCBoxdoloresdeespalda, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jCBoxdolordecuello))
                            .addComponent(jCBoxcolesterol)
                            .addComponent(jCBoxestres, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBoxalergias, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBoxvarices)
                            .addComponent(jCBoxretenciondeliquidos)
                            .addComponent(jCBoxmalacirculacion)
                            .addComponent(jCBoxembarazo)
                            .addComponent(jCBoxansiedad)
                            .addComponent(jCBoxdoloresdehueso)
                            .addComponent(jCBoxcalambres))))
                .addGap(100, 100, 100)
                .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBoxproblemasdevesicula)
                    .addComponent(jCBoxanemia)
                    .addComponent(jCBoxproblemasderinon)
                    .addComponent(jCBoxcelulitis))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelProblemasdeSaludLayout.setVerticalGroup(
            PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProblemasdeSaludLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelpesosquiere)
                .addGap(20, 20, 20)
                .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBoxBajar)
                    .addComponent(jCBoxmantener)
                    .addComponent(jCBoxsubir))
                .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelProblemasdeSaludLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBoxulcera)
                            .addComponent(jCBoxmalacirculacion)
                            .addComponent(jCBoxcelulitis))
                        .addGap(10, 10, 10)
                        .addComponent(jCBoxcansancio))
                    .addGroup(PanelProblemasdeSaludLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20)
                        .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBoxgastritis)
                            .addComponent(jCBoxcolesterol)
                            .addComponent(jCBoxansiedad)
                            .addComponent(jCBoxanemia))
                        .addGap(10, 10, 10)
                        .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBoxcolitis)
                            .addComponent(jCBoxalergias)
                            .addComponent(jCBoxembarazo)
                            .addComponent(jCBoxproblemasdevesicula))
                        .addGap(10, 10, 10)
                        .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBoxestrenimiento)
                            .addComponent(jCBoxestres)
                            .addComponent(jCBoxretenciondeliquidos)
                            .addComponent(jCBoxproblemasderinon))
                        .addGap(10, 10, 10)
                        .addComponent(jCBoxdolordecabeza)
                        .addGap(10, 10, 10)
                        .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBoxdolordecuello)
                            .addComponent(jCBoxcalambres))))
                .addGap(10, 10, 10)
                .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBoxdiabetes)
                    .addComponent(jCBoxdoloresdeespalda)
                    .addComponent(jCBoxvarices))
                .addGap(10, 10, 10)
                .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBoxpresionalta)
                    .addComponent(jCBoxartritis)
                    .addComponent(jCBoxdoloresdehueso))
                .addContainerGap())
        );

        PanelCambiosCorporales.setBackground(new java.awt.Color(85, 96, 128));
        PanelCambiosCorporales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cambios Corporales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Peso:");

        jtfpeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfpesoActionPerformed(evt);
            }
        });
        jtfpeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfpesoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("IMC:");

        jtfimc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfimcActionPerformed(evt);
            }
        });
        jtfimc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfimcKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("%Grasa:");

        jtfgrasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfgrasaKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("%Musculo:");

        jtfmusculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfmusculoActionPerformed(evt);
            }
        });
        jtfmusculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfmusculoKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Calorias:");

        jtfcalorias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfcaloriasKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Edad/B:");

        jtfedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfedadKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Grasa Viceral:");

        jtfgrasaviceral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfgrasaviceralKeyTyped(evt);
            }
        });

        tablacambioscorporales.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablacambioscorporales);

        javax.swing.GroupLayout PanelCambiosCorporalesLayout = new javax.swing.GroupLayout(PanelCambiosCorporales);
        PanelCambiosCorporales.setLayout(PanelCambiosCorporalesLayout);
        PanelCambiosCorporalesLayout.setHorizontalGroup(
            PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfmusculo))
                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfgrasa))
                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfimc))
                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfpeso, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfgrasaviceral)
                    .addComponent(jtfedad)
                    .addComponent(jtfcalorias, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        PanelCambiosCorporalesLayout.setVerticalGroup(
            PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfpeso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfcalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCambiosCorporalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)))
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfimc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfedad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(20, 20, 20)
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfgrasa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jtfgrasaviceral, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfmusculo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelCambiosCorporales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelDatosCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelProblemasdeSalud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PanelDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(PanelProblemasdeSalud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(PanelCambiosCorporales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        botoncancelarexpediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/iconos/Archivo_Salir.png"))); // NOI18N
        botoncancelarexpediente.setText("Salir");
        botoncancelarexpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncancelarexpedienteActionPerformed(evt);
            }
        });

        botonaceptarexpediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/iconos/btn_guardar.png"))); // NOI18N
        botonaceptarexpediente.setText("Guardar");
        botonaceptarexpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonaceptarexpedienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonaceptarexpediente)
                .addGap(47, 47, 47)
                .addComponent(botoncancelarexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botoncancelarexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonaceptarexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonaceptarexpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarexpedienteActionPerformed
 
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
        
        
        Calendar c = Calendar.getInstance();
        int d = c.get(Calendar.DATE);
        int m = 1 + (c.get(Calendar.MONTH));
        int a = c.get(Calendar.YEAR);

        String dia = Integer.toString(d);
        String mes = Integer.toString(m);
        String anio = Integer.toString(a);
        String fecha = (anio + "-" + mes + "-" + dia);
       

        expediente.insertarCambiosCorporales(
                jtfpeso.getText(),
                jtfimc.getText(),
                jtfgrasa.getText(),
                jtfmusculo.getText(),
                jtfcalorias.getText(),
                jtfedad.getText(),
                jtfgrasaviceral.getText(),
                id,
                fecha);

    }//GEN-LAST:event_botonaceptarexpedienteActionPerformed

    private void botoncancelarexpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncancelarexpedienteActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_botoncancelarexpedienteActionPerformed

    private void jtfmusculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfmusculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfmusculoActionPerformed

    private void jtfimcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfimcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfimcActionPerformed

    private void jtfpesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfpesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfpesoActionPerformed

    private void jCBoxproblemasderinonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxproblemasderinonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxproblemasderinonActionPerformed

    private void jCBoxdoloresdehuesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxdoloresdehuesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxdoloresdehuesoActionPerformed

    private void jCBoxembarazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxembarazoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxembarazoActionPerformed

    private void jCBoxansiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxansiedadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxansiedadActionPerformed

    private void jCBoxartritisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxartritisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxartritisActionPerformed

    private void jCBoxdoloresdeespaldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxdoloresdeespaldaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxdoloresdeespaldaActionPerformed

    private void jCBoxestrenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxestrenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxestrenimientoActionPerformed

    private void jCBoxsubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxsubirActionPerformed
        if(jCBoxsubir.isSelected()){
           jCBoxBajar.setSelected(false);
           jCBoxmantener.setSelected(false);
            
        }
    }//GEN-LAST:event_jCBoxsubirActionPerformed

    private void jCBoxcolitisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxcolitisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxcolitisActionPerformed

    private void jCBoxgastritisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxgastritisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxgastritisActionPerformed

    private void jCBoxmantenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxmantenerActionPerformed
                                                  
        if( jCBoxmantener.isSelected()){
           jCBoxsubir.setSelected(false);
           jCBoxBajar.setSelected(false);
            
        }
    }//GEN-LAST:event_jCBoxmantenerActionPerformed

    private void jCBoxBajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxBajarActionPerformed
        if(jCBoxBajar.isSelected()){
           jCBoxsubir.setSelected(false);
           jCBoxmantener.setSelected(false);
            
        }
    }//GEN-LAST:event_jCBoxBajarActionPerformed

    private void jTextFieldcelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldcelularKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldcelularKeyPressed

    private void jTextFieldcelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldcelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldcelularActionPerformed

    private void jTextFieldpesoidealKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldpesoidealKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldpesoidealKeyPressed

    private void jTextFieldpesoidealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldpesoidealActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldpesoidealActionPerformed

    private void jTextFieldedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldedadKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldedadKeyTyped

    private void jTextFieldedadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldedadKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldedadKeyPressed

    private void jTextFieldedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldedadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldedadActionPerformed

    private void jTextFieldpesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldpesoKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldpesoKeyPressed

    private void jTextFieldpesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldpesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldpesoActionPerformed

    private void jTextFieldfechanacimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldfechanacimientoKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldfechanacimientoKeyPressed

    private void jTextFieldfechanacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldfechanacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldfechanacimientoActionPerformed

    private void jTextFieldestaturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldestaturaKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldestaturaKeyPressed

    private void jTextFieldestaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldestaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldestaturaActionPerformed

    private void jTextFieldtelefonocasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldtelefonocasaKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
    }//GEN-LAST:event_jTextFieldtelefonocasaKeyTyped

    private void jTextFieldtelefonocasaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldtelefonocasaKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldtelefonocasaKeyPressed

    private void jTextFieldtelefonocasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldtelefonocasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldtelefonocasaActionPerformed

    private void jTextFieldtelefonotrabKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldtelefonotrabKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
    }//GEN-LAST:event_jTextFieldtelefonotrabKeyTyped

    private void jTextFieldtelefonotrabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldtelefonotrabKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldtelefonotrabKeyPressed

    private void jTextFieldtelefonotrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldtelefonotrabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldtelefonotrabActionPerformed

    private void jTextFielddireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielddireccionKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFielddireccionKeyPressed

    private void jTextFielddireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFielddireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFielddireccionActionPerformed

    private void jTextFieldnombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldnombreKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldnombreKeyPressed

    private void jTextFieldnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldnombreActionPerformed

    private void jTextFielddireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielddireccionKeyTyped
       
        Character s = evt.getKeyChar();
        
        if(!Character.isLetter(s) && s != KeyEvent.VK_SPACE){
            evt.consume();   
        }
        
    }//GEN-LAST:event_jTextFielddireccionKeyTyped

    private void jTextFieldpesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldpesoKeyTyped
         if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && jTextFieldpeso.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldpesoKeyTyped

    private void jDateChooserFechaInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooserFechaInicioMouseClicked
      
        
        
    }//GEN-LAST:event_jDateChooserFechaInicioMouseClicked

    private void jTextFieldcelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldcelularKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
    }//GEN-LAST:event_jTextFieldcelularKeyTyped

    private void jtfpesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfpesoKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
    }//GEN-LAST:event_jtfpesoKeyTyped

    private void jtfimcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfimcKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
    }//GEN-LAST:event_jtfimcKeyTyped

    private void jtfgrasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfgrasaKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
    }//GEN-LAST:event_jtfgrasaKeyTyped

    private void jtfmusculoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmusculoKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
    }//GEN-LAST:event_jtfmusculoKeyTyped

    private void jtfcaloriasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfcaloriasKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
    }//GEN-LAST:event_jtfcaloriasKeyTyped

    private void jtfedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfedadKeyTyped
       if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
    }//GEN-LAST:event_jtfedadKeyTyped

    private void jtfgrasaviceralKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfgrasaviceralKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
    }//GEN-LAST:event_jtfgrasaviceralKeyTyped

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();        
    }
    
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
    private javax.swing.JScrollPane jScrollPane1;
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

    private int returnStatus = RET_CANCEL;

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
