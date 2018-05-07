/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import javax.swing.table.DefaultTableModel;
import royal_gym.Conexion;
import royal_gym.Expediente;

/**
 *
 * @author Jazmin Vargas
 */
public class PanelExpediente extends javax.swing.JPanel {

    final Conexion con;
    Expediente expediente= new Expediente();
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    
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
        
        DefaultTableModel modeloTablaPagos = new DefaultTableModel(expediente.getCambios(),columnasCambios);
        tablacambioscorporales.setModel(modeloTablaPagos);    
    }
   
   
    public void setNombreCliente(){
        jTextFieldnombre.setText(getNombre());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
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
        jTextFieldmejorhoralla = new javax.swing.JTextField();
        jTextFieldtelefonotrab = new javax.swing.JTextField();
        jTextFieldtelefonocasa = new javax.swing.JTextField();
        jTextFieldfechainicio = new javax.swing.JTextField();
        jTextFieldestatura = new javax.swing.JTextField();
        jTextFieldfechanacimiento = new javax.swing.JTextField();
        jTextFieldpeso = new javax.swing.JTextField();
        jTextFieldedad = new javax.swing.JTextField();
        jTextFieldpesoideal = new javax.swing.JTextField();
        jTextFieldcelular = new javax.swing.JTextField();
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
        jCheckBox28 = new javax.swing.JCheckBox();
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

        labelnombre.setForeground(new java.awt.Color(255, 255, 255));
        labelnombre.setText("Nombre:");

        labeltelefonotrabajo.setForeground(new java.awt.Color(255, 255, 255));
        labeltelefonotrabajo.setText("Telefono Trabajo:");

        labeldireccion.setForeground(new java.awt.Color(255, 255, 255));
        labeldireccion.setText("Direccion:");

        labelhoraparallamar.setForeground(new java.awt.Color(255, 255, 255));
        labelhoraparallamar.setText("Mejor hora para llamar:");

        labelestatura.setForeground(new java.awt.Color(255, 255, 255));
        labelestatura.setText("Estatura:");

        labelfechainicio.setForeground(new java.awt.Color(255, 255, 255));
        labelfechainicio.setText("Fecha de Inicio:");

        labeltelefonocasa.setForeground(new java.awt.Color(255, 255, 255));
        labeltelefonocasa.setText("Telefono casa:");

        labelcelular.setForeground(new java.awt.Color(255, 255, 255));
        labelcelular.setText("Celular:");

        labelfechanacimiento.setForeground(new java.awt.Color(255, 255, 255));
        labelfechanacimiento.setText("Fecha de nacimiento:");

        labelpeso.setForeground(new java.awt.Color(255, 255, 255));
        labelpeso.setText("Peso:");

        labeledad.setForeground(new java.awt.Color(255, 255, 255));
        labeledad.setText("Edad:");

        labelpesoideal.setForeground(new java.awt.Color(255, 255, 255));
        labelpesoideal.setText("Peso Ideal:");

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
        });

        jTextFieldmejorhoralla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldmejorhorallaActionPerformed(evt);
            }
        });
        jTextFieldmejorhoralla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldmejorhorallaKeyPressed(evt);
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

        jTextFieldfechainicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldfechainicioActionPerformed(evt);
            }
        });
        jTextFieldfechainicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldfechainicioKeyPressed(evt);
            }
        });

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
        });

        javax.swing.GroupLayout PanelDatosClienteLayout = new javax.swing.GroupLayout(PanelDatosCliente);
        PanelDatosCliente.setLayout(PanelDatosClienteLayout);
        PanelDatosClienteLayout.setHorizontalGroup(
            PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosClienteLayout.createSequentialGroup()
                                .addComponent(labelhoraparallamar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldmejorhoralla))
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
                                .addComponent(jTextFieldnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addComponent(labelestatura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldestatura, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(labelpeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldpeso, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(labeledad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addComponent(labelfechainicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldfechainicio))
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addComponent(labeltelefonocasa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldtelefonocasa))
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addComponent(labelcelular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldcelular))
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addComponent(jTextFieldedad, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(labelpesoideal, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldpesoideal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addComponent(labelfechanacimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldfechanacimiento)))
                .addContainerGap())
        );
        PanelDatosClienteLayout.setVerticalGroup(
            PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelnombre)
                    .addComponent(labelfechainicio)
                    .addComponent(jTextFieldnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldfechainicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeltelefonotrabajo)
                    .addComponent(labeltelefonocasa)
                    .addComponent(jTextFieldtelefonotrab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldtelefonocasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeldireccion)
                    .addComponent(labelcelular)
                    .addComponent(jTextFielddireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelhoraparallamar)
                    .addComponent(labelfechanacimiento)
                    .addComponent(jTextFieldmejorhoralla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldfechanacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelestatura)
                    .addComponent(labelpeso)
                    .addComponent(labeledad)
                    .addComponent(labelpesoideal)
                    .addComponent(jTextFieldpeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldpesoideal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldestatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelProblemasdeSalud.setBackground(new java.awt.Color(85, 96, 128));
        PanelProblemasdeSalud.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Problemas de salud", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        labelpesosquiere.setForeground(new java.awt.Color(255, 255, 255));
        labelpesosquiere.setText("Peso Quiere:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Problemas de salud:");

        jCBoxBajar.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxBajar.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxBajar.setText("Bajar");
        jCBoxBajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxBajarActionPerformed(evt);
            }
        });

        jCBoxmantener.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxmantener.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxmantener.setText("Mantener");
        jCBoxmantener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxmantenerActionPerformed(evt);
            }
        });

        jCBoxgastritis.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxgastritis.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxgastritis.setText("Gastritis");
        jCBoxgastritis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxgastritisActionPerformed(evt);
            }
        });

        jCBoxcolitis.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcolitis.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcolitis.setText("Colitis");
        jCBoxcolitis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxcolitisActionPerformed(evt);
            }
        });

        jCBoxsubir.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxsubir.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxsubir.setText("Subir");
        jCBoxsubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxsubirActionPerformed(evt);
            }
        });

        jCBoxestrenimiento.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxestrenimiento.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxestrenimiento.setText("Estrenimiento");
        jCBoxestrenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxestrenimientoActionPerformed(evt);
            }
        });

        jCBoxcansancio.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcansancio.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcansancio.setText("Cansancio");

        jCBoxulcera.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxulcera.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxulcera.setText("Ulcera");

        jCBoxdiabetes.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdiabetes.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdiabetes.setText("Diabetes");

        jCBoxpresionalta.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxpresionalta.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxpresionalta.setText("Presion Alta");

        jCBoxcolesterol.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcolesterol.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcolesterol.setText("Colesterol");

        jCBoxalergias.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxalergias.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxalergias.setText("Alergias");

        jCBoxestres.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxestres.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxestres.setText("Estres");

        jCBoxdolordecabeza.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdolordecabeza.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdolordecabeza.setText("Dolor de Cabeza");

        jCBoxdolordecuello.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdolordecuello.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdolordecuello.setText("Dolor de Cuello");

        jCBoxdoloresdeespalda.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdoloresdeespalda.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdoloresdeespalda.setText("Dolores de Espalda");
        jCBoxdoloresdeespalda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxdoloresdeespaldaActionPerformed(evt);
            }
        });

        jCBoxartritis.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxartritis.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxartritis.setText("Artritis");
        jCBoxartritis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxartritisActionPerformed(evt);
            }
        });

        jCBoxansiedad.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxansiedad.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxansiedad.setText("Ansiedad");
        jCBoxansiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxansiedadActionPerformed(evt);
            }
        });

        jCBoxembarazo.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxembarazo.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxembarazo.setText("Embarazo/Lactancia");
        jCBoxembarazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxembarazoActionPerformed(evt);
            }
        });

        jCBoxretenciondeliquidos.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxretenciondeliquidos.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxretenciondeliquidos.setText("Retencion de Liquidos");

        jCBoxmalacirculacion.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxmalacirculacion.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxmalacirculacion.setText("Mala Circulacion");

        jCBoxcalambres.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxcalambres.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxcalambres.setText("Calambres");

        jCBoxvarices.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxvarices.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxvarices.setText("Varices");

        jCBoxdoloresdehueso.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxdoloresdehueso.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxdoloresdehueso.setText("Dolores de Hueso");
        jCBoxdoloresdehueso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxdoloresdehuesoActionPerformed(evt);
            }
        });

        jCBoxanemia.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxanemia.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxanemia.setText("Anemia");

        jCBoxproblemasdevesicula.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxproblemasdevesicula.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxproblemasdevesicula.setText("Problemas de Vesicula");

        jCBoxproblemasderinon.setBackground(new java.awt.Color(85, 96, 128));
        jCBoxproblemasderinon.setForeground(new java.awt.Color(255, 255, 255));
        jCBoxproblemasderinon.setText("Problemas de Rinon");
        jCBoxproblemasderinon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxproblemasderinonActionPerformed(evt);
            }
        });

        jCheckBox28.setBackground(new java.awt.Color(85, 96, 128));
        jCheckBox28.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox28.setText("Celulitis");
        jCheckBox28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox28ActionPerformed(evt);
            }
        });

        jCBoxcelulitis.setBackground(new java.awt.Color(85, 96, 128));
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
                        .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelProblemasdeSaludLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCBoxestres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCBoxdolordecabeza, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jCBoxartritis)
                                    .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCBoxdoloresdeespalda, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jCBoxdolordecuello))
                                    .addComponent(jCBoxcolesterol))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProblemasdeSaludLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCBoxalergias, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)))
                        .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBoxvarices)
                            .addComponent(jCBoxretenciondeliquidos)
                            .addComponent(jCBoxmalacirculacion)
                            .addComponent(jCBoxembarazo)
                            .addComponent(jCBoxansiedad)
                            .addComponent(jCBoxdoloresdehueso)
                            .addComponent(jCBoxcalambres))))
                .addGap(20, 20, 20)
                .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox28)
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
                        .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelProblemasdeSaludLayout.createSequentialGroup()
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
                                .addComponent(jCBoxdolordecabeza))
                            .addGroup(PanelProblemasdeSaludLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox28)))
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

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Peso:");

        jtfpeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfpesoActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("IMC:");

        jtfimc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfimcActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("%Grasa:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("%Musculo:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Calorias:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Edad/B:");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Grasa Viceral:");

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
                        .addComponent(jtfpeso, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfgrasaviceral)
                    .addComponent(jtfedad)
                    .addComponent(jtfcalorias, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
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
                            .addComponent(jtfpeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfcalorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCambiosCorporalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)))
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfimc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(20, 20, 20)
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfgrasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jtfgrasaviceral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfmusculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PanelDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PanelProblemasdeSalud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(PanelCambiosCorporales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(PanelProblemasdeSalud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(PanelCambiosCorporales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel1);

        botoncancelarexpediente.setText("Salir");

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
                .addComponent(botonaceptarexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botoncancelarexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonaceptarexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botoncancelarexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1044, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldnombreActionPerformed

    private void jTextFielddireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFielddireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFielddireccionActionPerformed

    private void jTextFieldmejorhorallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldmejorhorallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldmejorhorallaActionPerformed

    private void jTextFieldtelefonotrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldtelefonotrabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldtelefonotrabActionPerformed

    private void jTextFieldtelefonocasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldtelefonocasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldtelefonocasaActionPerformed

    private void jTextFieldfechainicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldfechainicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldfechainicioActionPerformed

    private void jTextFieldestaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldestaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldestaturaActionPerformed

    private void jTextFieldfechanacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldfechanacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldfechanacimientoActionPerformed

    private void jTextFieldpesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldpesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldpesoActionPerformed

    private void jTextFieldedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldedadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldedadActionPerformed

    private void jTextFieldpesoidealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldpesoidealActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldpesoidealActionPerformed

    private void jTextFieldcelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldcelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldcelularActionPerformed

    private void jtfpesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfpesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfpesoActionPerformed

    private void jtfimcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfimcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfimcActionPerformed

    private void botonaceptarexpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarexpedienteActionPerformed
        
        expediente.insertarCambiosCorporales(
        jtfpeso.getText(),
        jtfimc.getText(),
        jtfgrasa.getText(),
        jtfmusculo.getText(),
        jtfcalorias.getText(),
        jtfedad.getText(),
        jtfgrasaviceral.getText());
       
        DefaultTableModel modeloTablaPagos = new DefaultTableModel(expediente.getCambios(),columnasCambios);
        tablacambioscorporales.setModel(modeloTablaPagos);
        
        
        
        boolean gastritis = jCBoxgastritis.isSelected()  ;
        System.out.println(gastritis);
        boolean colitis = jCBoxcolitis.isSelected() ;
        boolean estreñimiento = jCBoxestrenimiento.isSelected() ;
        boolean ulcera = jCBoxulcera.isSelected() ;
        boolean cansancio = jCBoxcansancio.isSelected() ;
        boolean diabetes = jCBoxdiabetes.isSelected() ;
        boolean presionAlta = jCBoxpresionalta.isSelected() ;
        boolean colesterol = jCBoxcolesterol.isSelected() ;
        boolean alergias = jCBoxalergias.isSelected() ;
        boolean estres = jCBoxestres.isSelected() ;
        boolean dolordecabeza = jCBoxdolordecabeza.isSelected() ;
        boolean dolordecuello = jCBoxdolordecuello.isSelected() ;
        boolean doloresdeespalda = jCBoxdoloresdeespalda.isSelected() ;
        boolean artritis = jCBoxartritis.isSelected() ;
        boolean ansiedad = jCBoxansiedad.isSelected() ;
        boolean embarazo = jCBoxembarazo.isSelected() ;
        boolean retencionliquidos = jCBoxretenciondeliquidos.isSelected() ;
        boolean malacirculacion = jCBoxmalacirculacion.isSelected() ;
        boolean calambres = jCBoxcalambres.isSelected() ;
        boolean varices = jCBoxvarices.isSelected() ;
        boolean doloresdehueso = jCBoxdoloresdehueso.isSelected() ;
        boolean anemia = jCBoxanemia.isSelected() ;
        boolean problemadevesicula = jCBoxproblemasdevesicula.isSelected() ;
        boolean problemaderiñon = jCBoxproblemasderinon.isSelected() ;
        boolean celulitis= jCBoxcelulitis.isSelected();
        
        expediente.insertarProblemasdeSalud(gastritis, colitis, estreñimiento, ulcera, cansancio, diabetes, presionAlta, 
                colesterol, alergias, estres, dolordecabeza, dolordecuello, doloresdeespalda, artritis, ansiedad, embarazo, 
                retencionliquidos, malacirculacion, calambres, varices, doloresdehueso, anemia, problemadevesicula, 
                problemaderiñon, celulitis);
        
    }//GEN-LAST:event_botonaceptarexpedienteActionPerformed

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
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxsubirActionPerformed

    private void jCBoxcolitisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxcolitisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxcolitisActionPerformed

    private void jCBoxgastritisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxgastritisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxgastritisActionPerformed

    private void jCBoxmantenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxmantenerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxmantenerActionPerformed

    private void jCBoxBajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxBajarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxBajarActionPerformed

    private void jTextFieldnombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldnombreKeyPressed
        // TODO add your handling code here:
         if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldnombreKeyPressed

    private void jTextFieldtelefonotrabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldtelefonotrabKeyPressed
        // TODO add your handling code here:
         if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldtelefonotrabKeyPressed

    private void jTextFielddireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielddireccionKeyPressed
        // TODO add your handling code here:
         if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFielddireccionKeyPressed

    private void jTextFieldmejorhorallaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldmejorhorallaKeyPressed
        // TODO add your handling code here:
         if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldmejorhorallaKeyPressed

    private void jTextFieldestaturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldestaturaKeyPressed
        // TODO add your handling code here:
         if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldestaturaKeyPressed

    private void jTextFieldpesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldpesoKeyPressed
        // TODO add your handling code here:
         if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldpesoKeyPressed

    private void jTextFieldedadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldedadKeyPressed
        // TODO add your handling code here:
         if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldedadKeyPressed

    private void jTextFieldpesoidealKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldpesoidealKeyPressed
        // TODO add your handling code here:
         if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldpesoidealKeyPressed

    private void jTextFieldfechainicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldfechainicioKeyPressed
        // TODO add your handling code here:
         if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldfechainicioKeyPressed

    private void jTextFieldtelefonocasaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldtelefonocasaKeyPressed
        // TODO add your handling code here:
         if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldtelefonocasaKeyPressed

    private void jTextFieldcelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldcelularKeyPressed
        // TODO add your handling code here:
         if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldcelularKeyPressed

    private void jTextFieldfechanacimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldfechanacimientoKeyPressed
        // TODO add your handling code here:
         if(evt.isControlDown() || evt.isAltDown() || evt.isShiftDown()){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldfechanacimientoKeyPressed

    private void jTextFieldtelefonotrabKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldtelefonotrabKeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();

        }
    }//GEN-LAST:event_jTextFieldtelefonotrabKeyTyped

    private void jCheckBox28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox28ActionPerformed

    private void jTextFieldtelefonocasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldtelefonocasaKeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();

        }
    }//GEN-LAST:event_jTextFieldtelefonocasaKeyTyped

    private void jTextFieldedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldedadKeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldedadKeyTyped

    private void jCBoxproblemasderinonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxproblemasderinonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxproblemasderinonActionPerformed
     
  
    
    
   

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
    private javax.swing.JCheckBox jCheckBox28;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldcelular;
    private javax.swing.JTextField jTextFielddireccion;
    private javax.swing.JTextField jTextFieldedad;
    private javax.swing.JTextField jTextFieldestatura;
    private javax.swing.JTextField jTextFieldfechainicio;
    private javax.swing.JTextField jTextFieldfechanacimiento;
    private javax.swing.JTextField jTextFieldmejorhoralla;
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
