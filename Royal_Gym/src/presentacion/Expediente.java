package presentacion;
/**
 *
 * @author alxcr
 */
public class Expediente extends javax.swing.JDialog {

    public Expediente(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        botoncancelarexpediente = new javax.swing.JButton();
        botonaceptarexpediente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Expediente");
        setSize(new java.awt.Dimension(100, 100));

        jPanel4.setBackground(new java.awt.Color(85, 96, 128));

        botoncancelarexpediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Eliminar_fila.png"))); // NOI18N
        botoncancelarexpediente.setText("Salir");

        botonaceptarexpediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btn_guardar_2.png"))); // NOI18N
        botonaceptarexpediente.setText("Guardar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonaceptarexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(botoncancelarexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botoncancelarexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonaceptarexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setVerifyInputWhenFocusTarget(false);

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

        jTextFieldestatura.setEditable(false);

        jTextFieldfechanacimiento.setEditable(false);

        jDateChooserFechaInicio.setDateFormatString("yyyy-MM-dd");

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
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addComponent(labeltelefonotrabajo))
                                .addComponent(labeldireccion, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(labelnombre, javax.swing.GroupLayout.Alignment.TRAILING))
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
                                .addComponent(jTextFieldestatura)
                                .addGap(24, 24, 24)
                                .addComponent(labelpeso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldpeso))
                            .addComponent(jFormattedTextField))))
                .addGap(50, 50, 50)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelfechanacimiento)
                    .addComponent(labelfechainicio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labeltelefonocasa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelcelular, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labeledad, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosClienteLayout.createSequentialGroup()
                        .addComponent(jTextFieldedad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelpesoideal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldpesoideal))
                    .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldtelefonocasa)
                    .addComponent(jTextFieldfechanacimiento)
                    .addComponent(jTextFieldcelular))
                .addGap(20, 20, 20))
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
                            .addComponent(labeldireccion))
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
                        .addGroup(PanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelnombre)
                            .addComponent(jTextFielddireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(20, 20, 20))
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
                .addGap(20, 20, 20)
                .addGroup(PanelProblemasdeSaludLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelpesosquiere)
                    .addComponent(jLabel2)
                    .addGroup(PanelProblemasdeSaludLayout.createSequentialGroup()
                        .addComponent(jCBoxsubir)
                        .addGap(20, 20, 20)
                        .addComponent(jCBoxBajar)
                        .addGap(20, 20, 20)
                        .addComponent(jCBoxmantener))))
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
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablacambioscorporales);

        javax.swing.GroupLayout PanelCambiosCorporalesLayout = new javax.swing.GroupLayout(PanelCambiosCorporales);
        PanelCambiosCorporales.setLayout(PanelCambiosCorporalesLayout);
        PanelCambiosCorporalesLayout.setHorizontalGroup(
            PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfmusculo))
                            .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfgrasa)
                                    .addComponent(jtfimc)
                                    .addComponent(jtfpeso))))
                        .addGap(194, 194, 194)
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfedad)
                            .addComponent(jtfgrasaviceral)
                            .addComponent(jtfcalorias))))
                .addGap(20, 20, 20))
        );
        PanelCambiosCorporalesLayout.setVerticalGroup(
            PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(jLabel1)
                                            .addComponent(jtfpeso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel3)))
                                .addGap(11, 11, 11)
                                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel4)
                                    .addComponent(jtfgrasa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(jLabel6)
                                            .addComponent(jtfcalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(5, 5, 5)
                                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(jLabel7)
                                            .addComponent(jtfedad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(jLabel8)
                                            .addComponent(jtfgrasaviceral, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCambiosCorporalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(jtfmusculo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelCambiosCorporalesLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jtfimc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelProblemasdeSalud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCambiosCorporales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(PanelDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelProblemasdeSalud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelCambiosCorporales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
