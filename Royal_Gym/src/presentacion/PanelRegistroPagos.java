/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import royal_gym.Conexion;
import royal_gym.FormatoTabla;
import royal_gym.Pagos;

/**
 *
 * @author alxcr
 */
public class PanelRegistroPagos extends javax.swing.JPanel {
    int filaseleccionadatablapagos;   
    final Conexion con;
    Pagos pagos = new Pagos();
    public  int d,m,a;
    int df,mf,af;
    public  int totalanio;
    public int totalmes;
  
    
    private static Statement statement;
    static ResultSet resultado;
   
    // columnas de la tabla pagos
    private final String[] columnasPagos = {
        "No.",
        "Cliente",
        "Monto",
        "Tiempo",
        "Tipo de Pago",
        "Tipo de Plan",
        "Fecha de Pago",
        "Fecha de Vencimiento",
       
    };
    
    public PanelRegistroPagos() {
        initComponents();
        this.con = new Conexion();
        con.conectar();
        
        DefaultTableModel modeloTablaPagos = new DefaultTableModel(pagos.getPago(), columnasPagos);
        tablaPagos.setModel(modeloTablaPagos);
        
        items();
        
        tablaPagos.setDefaultRenderer (Object.class, new FormatoTabla());
        
    }
    
     public void items(){
       //String nombre = jtfBuscarCliente.getText();
       TextAutoCompleter  textAutoCompleter = new  TextAutoCompleter(jtfBuscarCliente);
          
        try {
            String consulta = "Select nombres ||' '|| apellidos as nombreCompleto from cliente ORDER BY nombres ||' '|| apellidos ASC";
            statement = Conexion.getConexion().createStatement();
            resultado = statement.executeQuery(consulta);
           

        while (resultado.next()) {
                 textAutoCompleter.addItem(resultado.getString("nombreCompleto"));
                
            }
            
        } catch (Exception e) {
            System.out.println("buscar:" + e.getMessage());
        }
     }
     
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatosPago = new javax.swing.JPanel();
        jtfClienteAPagar = new javax.swing.JLabel();
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
        jtfBuscarCliente = new javax.swing.JTextField();
        PanelTablaPagos = new javax.swing.JPanel();
        jtfbuscarpago = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPagos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        combobuscarportipoplan = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(85, 96, 128));

        panelDatosPago.setBackground(new java.awt.Color(85, 96, 128));
        panelDatosPago.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar Pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        panelDatosPago.setPreferredSize(new java.awt.Dimension(344, 460));

        jtfClienteAPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfClienteAPagar.setForeground(new java.awt.Color(255, 255, 255));
        jtfClienteAPagar.setText("Cliente:");

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

        jcbTiempoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "Mes", "Año" }));
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

        jtfBuscarCliente.setMinimumSize(new java.awt.Dimension(6, 30));
        jtfBuscarCliente.setPreferredSize(new java.awt.Dimension(6, 30));
        jtfBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosPagoLayout = new javax.swing.GroupLayout(panelDatosPago);
        panelDatosPago.setLayout(panelDatosPagoLayout);
        panelDatosPagoLayout.setHorizontalGroup(
            panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosPagoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                                .addComponent(jlTiempoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90))
                            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                                .addComponent(jtfTiempoAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbTiempoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47))
                    .addGroup(panelDatosPagoLayout.createSequentialGroup()
                        .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelDatosPagoLayout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(20, 20, 20)
                                    .addComponent(jlRegistroClientes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jtfPagoTipodePlan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcbPagoPlan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosPagoLayout.createSequentialGroup()
                                    .addComponent(jbPagoAceptar)
                                    .addGap(46, 46, 46)
                                    .addComponent(jbPagoCancelar)))
                            .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jlMontoPagar, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addComponent(jtfClienteAPagar)
                                .addComponent(jtfBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfMontoAPagar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelDatosPagoLayout.setVerticalGroup(
            panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlRegistroClientes1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jtfClienteAPagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jlMontoPagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfMontoAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jlTiempoPago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbTiempoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTiempoAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jtfPagoTipodePlan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbPagoPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
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

        combobuscarportipoplan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Pareja", "Grupo", "Estudiante", "No aplica", "Todo" }));
        combobuscarportipoplan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobuscarportipoplanItemStateChanged(evt);
            }
        });
        combobuscarportipoplan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobuscarportipoplanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo de Plan:");

        javax.swing.GroupLayout PanelTablaPagosLayout = new javax.swing.GroupLayout(PanelTablaPagos);
        PanelTablaPagos.setLayout(PanelTablaPagosLayout);
        PanelTablaPagosLayout.setHorizontalGroup(
            PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaPagosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(PanelTablaPagosLayout.createSequentialGroup()
                        .addComponent(jtfbuscarpago, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(combobuscarportipoplan, 0, 112, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelTablaPagosLayout.setVerticalGroup(
            PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaPagosLayout.createSequentialGroup()
                .addGroup(PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTablaPagosLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jtfbuscarpago, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTablaPagosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelTablaPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobuscarportipoplan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelDatosPago, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelTablaPagos, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosPago, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addComponent(PanelTablaPagos, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

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
        try{
        
        Calendar c = Calendar.getInstance();
         d = c.get(Calendar.DATE);
         m = 1 + (c.get(Calendar.MONTH));
         a = c.get(Calendar.YEAR);

        String dia = Integer.toString(d);
        String mes = Integer.toString(m);
        String anio = Integer.toString(a);
        String fecha = (anio + "-" + mes + "-" + dia);
       
         String tiempo = jtfTiempoAPagar.getText();
         int mess = Integer.parseInt(tiempo);
         int diaa = Integer.parseInt(tiempo);
         int annio = Integer.parseInt(tiempo);
         
         int tm = 0;
         int an = 0;
         int me = 0;
         int td = 0;
         String fechaFinal = "";
         
         //sumar dias a la fecha
          if(jcbTiempoPago.getSelectedIndex() == 0)
          {
           int totaldia = d + diaa;
            
             if(totaldia >30){
             td = totaldia - 30;
             me = m + 1;
             
             String totald = Integer.toString(td);
             String mees = Integer.toString(me);
             fechaFinal = (anio+ "-" + mees + "-" + totald);
            }else{
            String totaldi = Integer.toString(totaldia);
            fechaFinal = (anio + "-" + mes + "-" +  totaldi);
             }   
          } 
         
         
         //Sumar meses a la fecha actual
         if(jcbTiempoPago.getSelectedIndex() == 1)
         {
            totalmes = m + mess;
            
             if(totalmes >12){
             tm = totalmes - 12;
             an = a + 1;
             
             String totalme = Integer.toString(tm);
             String anioo = Integer.toString(an);
             fechaFinal = (anioo+ "-" + totalme + "-" + dia);
            }else{
            String totalm = Integer.toString(totalmes);
            fechaFinal = (anio + "-" + totalm + "-" + dia);
            
            }   
        }    
         
         //sumar anio  a la fecha actual
         if(jcbTiempoPago.getSelectedIndex() == 2)
         {
            totalanio = a + annio;
            
             String totalan = Integer.toString( totalanio);
            fechaFinal = (totalan + "-" + mes + "-" + dia);
            }
         
         
         
         //validaciones para campos vacios
        if (jtfBuscarCliente.getText().equals("") && jtfMontoAPagar.getText().equals("") && jtfTiempoAPagar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese toda la informacion", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (jtfBuscarCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese toda la informacion", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfMontoAPagar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese toda la informacion", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jtfTiempoAPagar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese toda la informacion", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
      
            if (jcbPagoPlan.getSelectedItem() != null) {
                pagos.insertarPagos(jtfBuscarCliente.getText(), jtfMontoAPagar.getText(), jtfTiempoAPagar.getText(),
                    jcbTiempoPago.getSelectedItem().toString(), jcbPagoPlan.getSelectedItem().toString(), fecha,fechaFinal);
            } else {
                pagos.insertarPagos(jtfBuscarCliente.getText(), jtfMontoAPagar.getText(), jtfTiempoAPagar.getText(),
                    jcbTiempoPago.getSelectedItem().toString(), "No aplica", fecha,fechaFinal);
            }
        }
        
        
      
        jtfBuscarCliente.setText("");
        jtfMontoAPagar.setText("");
        jtfTiempoAPagar.setText("");
        jcbTiempoPago.setSelectedIndex(0);
        jcbPagoPlan.setSelectedIndex(0);

        DefaultTableModel modeloTablaPagos = new DefaultTableModel(pagos.getPago(),columnasPagos);
        tablaPagos.setModel(modeloTablaPagos);
        
        }catch(Exception ex){
            
        }
    }//GEN-LAST:event_jbPagoAceptarActionPerformed

    public void calcularFechaVencimiento(){
    
}
   
    
    
    
    private void jbPagoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagoCancelarActionPerformed
        jtfBuscarCliente.setText("");
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

        DefaultTableModel modeloTablaPagos = new DefaultTableModel(pagos.buscarPago(jtfbuscarpago.getText()), columnasPagos);
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
          if(evt.getClickCount()==2)
         {
        filaseleccionadatablapagos = tablaPagos.getSelectedRow();
        jtfBuscarCliente.setText(tablaPagos.getValueAt(filaseleccionadatablapagos, 1).toString());
        jtfMontoAPagar.setText(tablaPagos.getValueAt(filaseleccionadatablapagos, 2).toString());
        jtfTiempoAPagar.setText(tablaPagos.getValueAt(filaseleccionadatablapagos, 3).toString());
        jcbTiempoPago.setSelectedItem(tablaPagos.getValueAt(filaseleccionadatablapagos, 4));
        jcbPagoPlan.setSelectedItem(tablaPagos.getValueAt(filaseleccionadatablapagos, 5));
         }
          
          
          
    }//GEN-LAST:event_tablaPagosMouseClicked

    private void combobuscarportipoplanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobuscarportipoplanItemStateChanged
        // TODO add your handling code here:
        int tf = combobuscarportipoplan.getSelectedIndex();
				switch (tf) {
				
				case 0:
					//String idt = filtro.getText();
					DefaultTableModel modeloTablaPagos = new DefaultTableModel(pagos.getClienteTipoPlan(combobuscarportipoplan.getSelectedItem().toString()), columnasPagos);
                                        tablaPagos.setModel(modeloTablaPagos);
					break;
				case 1:
					 DefaultTableModel modeloTablaPagos1 = new DefaultTableModel(pagos.getClienteTipoPlan(combobuscarportipoplan.getSelectedItem().toString()), columnasPagos);
                                         tablaPagos.setModel(modeloTablaPagos1);
					break;
				case 2:
					
					 DefaultTableModel modeloTablaPagos2 = new DefaultTableModel(pagos.getClienteTipoPlan(combobuscarportipoplan.getSelectedItem().toString()), columnasPagos);
                                         tablaPagos.setModel(modeloTablaPagos2);
					break;
                                        
                                case 3:
                                    
                                        DefaultTableModel modeloTablaPagos3 = new DefaultTableModel(pagos.getClienteTipoPlan(combobuscarportipoplan.getSelectedItem().toString()), columnasPagos);
                                         tablaPagos.setModel(modeloTablaPagos3);
					break;
                                    
                                case 4:    
					
					 DefaultTableModel modeloTablaPagos4 = new DefaultTableModel(pagos.getClienteTipoPlan(combobuscarportipoplan.getSelectedItem().toString()), columnasPagos);
                                         tablaPagos.setModel(modeloTablaPagos4);
					break;  
                                        
                                        
                                case 5:    
					
					 DefaultTableModel modeloTablaPagos5 = new DefaultTableModel(pagos.getPago(), columnasPagos);
                                         tablaPagos.setModel(modeloTablaPagos5);
					break;          
					
				}
			
        
        
    }//GEN-LAST:event_combobuscarportipoplanItemStateChanged

    private void jtfBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarClienteActionPerformed

    private void combobuscarportipoplanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobuscarportipoplanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobuscarportipoplanActionPerformed

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
    private javax.swing.JPanel PanelTablaPagos;
    private javax.swing.JComboBox<String> combobuscarportipoplan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbPagoAceptar;
    private javax.swing.JButton jbPagoCancelar;
    private javax.swing.JComboBox<String> jcbPagoPlan;
    private javax.swing.JComboBox<String> jcbTiempoPago;
    private javax.swing.JLabel jlMontoPagar;
    private javax.swing.JLabel jlRegistroClientes1;
    private javax.swing.JLabel jlTiempoPago;
    private javax.swing.JTextField jtfBuscarCliente;
    private javax.swing.JLabel jtfClienteAPagar;
    private javax.swing.JTextField jtfMontoAPagar;
    private javax.swing.JLabel jtfPagoTipodePlan;
    private javax.swing.JTextField jtfTiempoAPagar;
    private javax.swing.JTextField jtfbuscarpago;
    private javax.swing.JPanel panelDatosPago;
    public static javax.swing.JTable tablaPagos;
    // End of variables declaration//GEN-END:variables
}
